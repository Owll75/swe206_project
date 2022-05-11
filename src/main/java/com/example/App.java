package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Classes.Applicant;
import Classes.Department;
import Classes.Directorate;
import Classes.Interview;
import Classes.Interviewer;
import Classes.Job;
import Classes.division;
import Classes.jobBands;

/**
 * JavaFX App
 */
public class App extends Application {
    int applicantSelection;

    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {

        // Used for test purposes
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("data.dat"));
        ArrayList<Applicant> applicantList = (ArrayList<Applicant>) input.readObject();
        // ArrayList<Applicant> applicantList = new ArrayList<>();
        ArrayList<Job> jobList = new ArrayList<Job>();
        ArrayList<Interviewer> interviewerList = new ArrayList<Interviewer>();
        ArrayList<Interview> interviewList = new ArrayList<Interview>();
        jobList.add(new Job("Program Manager", 1));
        jobList.add(new Job("Product Manager", 1));

        interviewerList.add(new Interviewer("Jonathan"));
        interviewerList.add(new Interviewer("Joseph"));
        interviewerList.add(new Interviewer("Jotaro"));

        ArrayList<String> interviewerNameList = new ArrayList<String>();
        for (int i = 0; i < interviewerList.size(); i++) {
            interviewerNameList.add(interviewerList.get(i).getName());
        }

        jobBands band = new jobBands("project management", 1, jobList);
        applicantList.add(new Applicant(16, 4, band));
        for (int i = 0; i < 15; i++) {
            applicantList.add(new Applicant(i, (int) (Math.random() * 10), band));
        }
        // sign in page
        BorderPane mainPane = new BorderPane();
        VBox singBox = new VBox(8);
        singBox.setAlignment(Pos.CENTER);
        Button singinButton = new Button("Sign in");
        singinButton.setMaxSize(409, 64);
        TextField usernamefield = new TextField();

        usernamefield.setMaxSize(409, 64);
        usernamefield.setPromptText("Enter your Username");
        TextField passwordfield = new TextField();
        passwordfield.setMaxSize(409, 64);
        passwordfield.setPromptText("Enter your Password");
        Text eror = new Text("");
        eror.setFont(Font.font("Arial", 14));
        singBox.setPadding(new Insets(15, 15, 15, 15));
        singBox.getChildren().addAll(usernamefield, passwordfield, eror, singinButton);
        mainPane.setPadding(new Insets(15, 15, 15, 15));
        mainPane.setCenter(singBox);
        Scene scene1 = new Scene(mainPane, 1024, 640);
        primaryStage.setScene(scene1);
        primaryStage.show();

        // employer page
        BorderPane employerPane = new BorderPane();
        VBox emploerBox = new VBox(20);
        Text EmploerText = new Text("Employer Page");
        EmploerText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button bandsButton = new Button("Bands");
        bandsButton.setMaxSize(409, 64);
        Button ApplicantsButton = new Button("Applicants");
        ApplicantsButton.setMaxSize(409, 64);
        Button DepartmentsButton = new Button("Unit");
        DepartmentsButton.setMaxSize(409, 64);
        Button logOutButton = new Button("Log out");
        Scene scene2 = new Scene(employerPane, 1024, 640);
        emploerBox.getChildren().addAll(EmploerText, ApplicantsButton, bandsButton, DepartmentsButton);
        emploerBox.setAlignment(Pos.CENTER);
        employerPane.setPadding(new Insets(15, 15, 15, 15));
        employerPane.setCenter(emploerBox);
        employerPane.setTop(logOutButton);
        logOutButton.setOnAction(ActionEvent -> {
            primaryStage.setScene(scene1);
            // Save feature test
            FileOutputStream fileOut = null;
            try {
                fileOut = new FileOutputStream("data.dat");
                ObjectOutputStream output = new ObjectOutputStream(fileOut);
                output.writeObject(applicantList);
                output.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        // bands page
        BorderPane bandsPane = new BorderPane();
        VBox bandsBox = new VBox(20);
        Text bandsText = new Text("Bands");
        bandsText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button addBandButton = new Button("Add band");
        addBandButton.setMaxSize(409, 64);
        // VBox.setMargin(addBandButton, new Insets(15, 15, 15, 15));
        Button AssignBandButton = new Button("Assign band");
        AssignBandButton.setMaxSize(409, 64);
        // VBox.setMargin(AssignBandButton, new Insets(15, 15, 15, 15));
        Button deleteBandButton = new Button("Delete band");
        deleteBandButton.setMaxSize(409, 64);
        // VBox.setMargin(deleteBandButton, new Insets(15, 15, 15, 15));
        Button modifyBandButton = new Button("modify band");
        modifyBandButton.setMaxSize(409, 64);
        // VBox.setMargin(modifyBandButton, new Insets(15, 15, 15, 15));
        Scene scene3 = new Scene(bandsPane, 1024, 640);
        bandsBox.getChildren().addAll(bandsText, addBandButton, AssignBandButton, deleteBandButton, modifyBandButton);
        bandsBox.setAlignment(Pos.CENTER);
        bandsPane.setPadding(new Insets(15, 15, 15, 15));
        bandsPane.setCenter(bandsBox);
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(scene2));
        bandsPane.setTop(backButton);
        bandsButton.setOnAction(e -> primaryStage.setScene(scene3));

        ArrayList<jobBands> bandsList = new ArrayList<jobBands>();
        bandsList.add(new jobBands("dd", 3444, new ArrayList<>()));
        ArrayList<String> bandsNamesList = new ArrayList<>();
        for (int i = 0; i < bandsList.size(); i++) {
            bandsNamesList.add(bandsList.get(i).getBandName());
        }
        // Add band
        BorderPane addBandPane = new BorderPane();
        VBox addBandBox = new VBox(20);
        Text addBandText = new Text("Add Band");
        addBandText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button bandAddButton = new Button("confirm");
        bandAddButton.setMaxSize(409, 64);
        TextField bandNamefield1 = new TextField();
        bandNamefield1.setMaxSize(409, 64);
        bandNamefield1.setPromptText("Enter Band Name");
        TextField bandIDfield1 = new TextField();
        Text massage3 = new Text("");
        bandIDfield1.setMaxSize(409, 64);
        bandIDfield1.setPromptText("Enter Band ID");
        Scene scene8 = new Scene(addBandPane, 1024, 640);
        addBandBox.setAlignment(Pos.CENTER);
        addBandPane.setPadding(new Insets(15, 15, 15, 15));
        addBandPane.setCenter(addBandBox);
        Button backButto7 = new Button("Back");
        addBandBox.getChildren().addAll(addBandText, bandIDfield1, bandNamefield1, bandAddButton, massage3);
        backButto7.setOnAction(e -> primaryStage.setScene(scene3));
        addBandPane.setTop(backButto7);
        addBandButton.setOnAction(e -> primaryStage.setScene(scene8));
        bandAddButton.setOnAction(ActionEvent -> {
            bandsList.add(new jobBands(bandNamefield1.getText(), Integer.valueOf(bandIDfield1.getText()),
                    new ArrayList<Job>()));
            bandsNamesList.add(bandNamefield1.getText());
            massage3.setText("Bnad added secssfuly");
        });
        // delete band
        BorderPane deleteBandPane = new BorderPane();
        VBox deleteBandBox = new VBox(20);
        Text deleteBandText = new Text("Delete Band");
        deleteBandText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        ComboBox<String> bandsComboBox = new ComboBox<>(FXCollections.observableArrayList(bandsNamesList));
        Button bandDeleteButton = new Button("Delete");
        deleteBandBox.getChildren().addAll(deleteBandText, bandsComboBox, bandDeleteButton);
        bandDeleteButton.setMaxSize(409, 64);
        bandsComboBox.setMaxSize(409, 64);
        Scene scene6 = new Scene(deleteBandPane, 1024, 640);
        deleteBandBox.setAlignment(Pos.CENTER);
        deleteBandPane.setPadding(new Insets(15, 15, 15, 15));
        deleteBandPane.setCenter(deleteBandBox);
        Button backButto5 = new Button("Back");
        backButto5.setOnAction(e -> primaryStage.setScene(scene3));
        deleteBandPane.setTop(backButto5);
        deleteBandButton.setOnAction(ActionEvent -> {
            primaryStage.setScene(scene6);
        });
        // modify band
        BorderPane modifyBandPane = new BorderPane();
        VBox modifyBandBox = new VBox(20);
        Text modifyBandText = new Text("Modify Band");
        modifyBandText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button bandModifyButton = new Button("confirm");
        bandDeleteButton.setMaxSize(409, 64);
        TextField bandNamefield = new TextField();
        bandNamefield.setMaxSize(409, 64);
        ComboBox<String> bandsComboBox2 = new ComboBox<>(FXCollections.observableArrayList(bandsNamesList));
        bandsComboBox2.setMaxSize(409, 64);
        TextField bandIDfield = new TextField();
        bandIDfield.setMaxSize(409, 64);
        Scene scene7 = new Scene(modifyBandPane, 1024, 640);
        modifyBandBox.setAlignment(Pos.CENTER);
        modifyBandPane.setPadding(new Insets(15, 15, 15, 15));
        modifyBandPane.setCenter(modifyBandBox);
        Button backButto6 = new Button("Back");
        modifyBandBox.getChildren().addAll(modifyBandText, bandsComboBox2, bandIDfield, bandNamefield,
                bandModifyButton);
        backButto6.setOnAction(e -> primaryStage.setScene(scene3));
        modifyBandPane.setTop(backButto6);
        modifyBandButton.setOnAction(e -> primaryStage.setScene(scene7));

        //
        // assign band
        BorderPane assignBandPane = new BorderPane();
        VBox assignBandBox = new VBox(20);
        Text assignBandText = new Text("Assign Band");
        assignBandText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        ComboBox<String> bandsComboBox3 = new ComboBox<>(FXCollections.observableArrayList(bandsNamesList));
        ComboBox<String> jobComboBox = new ComboBox<>();
        Button bandAssignButton = new Button("Assign");
        bandAssignButton.setMaxSize(409, 64);
        bandsComboBox3.setMaxSize(409, 64);
        jobComboBox.setMaxSize(409, 64);
        assignBandBox.getChildren().addAll(assignBandText, bandsComboBox3, jobComboBox, bandAssignButton);
        Scene scene9 = new Scene(assignBandPane, 1024, 640);
        assignBandBox.setAlignment(Pos.CENTER);
        assignBandPane.setPadding(new Insets(15, 15, 15, 15));
        assignBandPane.setCenter(assignBandBox);
        Button backButto8 = new Button("Back");
        backButto8.setOnAction(e -> primaryStage.setScene(scene3));
        assignBandPane.setTop(backButto8);
        AssignBandButton.setOnAction(e -> primaryStage.setScene(scene9));

        // used for unit

        ArrayList<division> divisionsList = new ArrayList<division>();
        ArrayList<Directorate> directoratesList = new ArrayList<Directorate>();
        ArrayList<Department> departmentsList = new ArrayList<Department>();

        // units page
        BorderPane DepartmentsPane = new BorderPane();
        VBox DepartmentsBox = new VBox(20);
        Text DepartmentsText = new Text("Units");
        DepartmentsText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button divsButton = new Button("Division");

        divsButton.setMaxSize(409, 64);
        // VBox.setMargin(addDepartButton, new Insets(15, 15, 15, 15));
        Button direcButton = new Button("Directorate");
        direcButton.setMaxSize(409, 64);
        Button addDivision = new Button("Add Division");
        addDivision.setMaxSize(409, 64);
        Button modifyDivision = new Button("Modify Division");
        modifyDivision.setMaxSize(409, 64);
        Button deleteDivision = new Button("Delete Division");
        deleteDivision.setMaxSize(409, 64);
        Button listOfDivisions = new Button("List of Divisions");
        listOfDivisions.setMaxSize(409, 64);

        Scene unitScene = new Scene(DepartmentsPane, 1024, 640);
        DepartmentsBox.getChildren().addAll(DepartmentsText, divsButton, direcButton, addDivision, modifyDivision,
                deleteDivision, listOfDivisions);
        DepartmentsBox.setAlignment(Pos.CENTER);
        DepartmentsPane.setPadding(new Insets(15, 15, 15, 15));
        DepartmentsPane.setCenter(DepartmentsBox);

        Button unitBackButton = new Button("Back");
        unitBackButton.setOnAction(e -> primaryStage.setScene(scene2));

        DepartmentsPane.setBottom(unitBackButton);
        DepartmentsButton.setOnAction(e -> primaryStage.setScene(unitScene));

        // Division page

        BorderPane DivisionPane = new BorderPane();
        VBox DivisionBox = new VBox(20);
        Text divisionText = new Text("Division");
        divisionText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button addDirectorate = new Button("Add Directorate");
        addDirectorate.setMaxSize(409, 64);
        Button modifyDirectorate = new Button("Modify Directorate");
        modifyDirectorate.setMaxSize(409, 64);
        Button deleteDirectorate = new Button("Delete Directorate");
        deleteDirectorate.setMaxSize(409, 64);
        Button viewListOfDirectorate = new Button("View List of Directorates");
        viewListOfDirectorate.setMaxSize(409, 64);

        Scene divisionScene = new Scene(DivisionPane, 1024, 640);
        DivisionBox.getChildren().addAll(divisionText, addDirectorate, modifyDirectorate, deleteDirectorate,
                viewListOfDirectorate);
        DivisionBox.setAlignment(Pos.CENTER);
        DivisionPane.setPadding(new Insets(15, 15, 15, 15));
        DivisionPane.setCenter(DivisionBox);

        Button divisionBackButon = new Button("Back");
        DivisionPane.setBottom(divisionBackButon);
        divsButton.setOnAction(e -> primaryStage.setScene(divisionScene));
        divisionBackButon.setOnAction(e -> primaryStage.setScene(unitScene));

        // Directorate page

        BorderPane DirectoratePane = new BorderPane();
        VBox DirectorateBox = new VBox(20);
        Text directorateText = new Text("Directorate");
        directorateText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button addDepartment = new Button("Add Department");
        addDepartment.setMaxSize(409, 64);
        Button modifyDepartment = new Button("Modify Department");
        modifyDirectorate.setMaxSize(409, 64);
        Button deleteDepartment = new Button("Delete Department");
        deleteDirectorate.setMaxSize(409, 64);
        Button viewListOfDepartment = new Button("View List of Directorate");
        viewListOfDirectorate.setMaxSize(409, 64);

        Scene directorateScene = new Scene(DirectoratePane, 1024, 640);
        DirectorateBox.getChildren().addAll(directorateText, addDepartment, modifyDepartment, deleteDepartment,
                viewListOfDepartment);
        DirectorateBox.setAlignment(Pos.CENTER);
        DirectoratePane.setPadding(new Insets(15, 15, 15, 15));
        DirectoratePane.setCenter(DirectorateBox);

        direcButton.setOnAction(e -> primaryStage.setScene(directorateScene));
        Button direBackButton = new Button("Back");
        DirectoratePane.setBottom(direBackButton);
        direBackButton.setOnAction(e -> primaryStage.setScene(unitScene));

        // Add division scene

        BorderPane AddDivPane = new BorderPane();
        VBox AddDivBox = new VBox(20);
        Text divName = new Text("Enter Name and ID to add new division");
        divName.setFont(Font.font("Inter", FontWeight.BOLD, 48));
        TextField divNameField = new TextField();
        divNameField.setMaxSize(409, 64);
        divNameField.setPromptText("Enter Division Name");
        NumberTextField divIDField = new NumberTextField();
        divIDField.setPromptText("Enter ID");
        divIDField.setMaxSize(409, 64);
        Button addDivSave = new Button("Save");
        addDivSave.setMaxSize(409, 64);
        Label addDivChecking = new Label("");
        addDivChecking.setFont(Font.font("Inter", FontWeight.BOLD, 36));

        Scene diVAddScene = new Scene(AddDivPane, 1024, 640);
        AddDivBox.getChildren().addAll(divName, divNameField, divIDField, addDivSave, addDivChecking);
        AddDivBox.setAlignment(Pos.CENTER);
        AddDivPane.setPadding(new Insets(15, 15, 15, 15));
        AddDivPane.setCenter(AddDivBox);
        addDivision.setOnAction(e -> primaryStage.setScene(diVAddScene));
        Button addDivBack = new Button("Back");
        AddDivPane.setBottom(addDivBack);
        addDivBack.setOnAction(e -> primaryStage.setScene(unitScene));

        // modify division scene
        BorderPane modifyDivPane = new BorderPane();
        VBox modifyDivBox = new VBox(20);
        Text modifyDivText = new Text("Modify Division");
        modifyDivText.setFont(Font.font("Inter", FontWeight.BOLD, 48));
        NumberTextField modifyDivNameSer = new NumberTextField();
        modifyDivNameSer.setMaxSize(409, 64);
        modifyDivNameSer.setPromptText("Enter ID");
        Button modifySerButton = new Button("Search");
        modifySerButton.setMaxSize(409, 64);
        TextField modifyDivFi = new TextField();
        modifyDivFi.setMaxSize(409, 64);
        modifyDivFi.setVisible(false);
        NumberTextField modifyDivIDFi = new NumberTextField();
        modifyDivIDFi.setMaxSize(409, 64);
        modifyDivIDFi.setVisible(false);
        Button modifyDivButton = new Button("Save");
        modifyDivButton.setMaxSize(409, 64);
        modifyDivButton.setVisible(false);
        Button modifyDivReturn = new Button("Return");

        Scene modifydivScene = new Scene(modifyDivPane, 1024, 640);
        modifyDivBox.getChildren().addAll(modifyDivText, modifyDivNameSer, modifySerButton, modifyDivFi, modifyDivIDFi,
                modifyDivButton);
        modifyDivBox.setAlignment(Pos.CENTER);
        modifyDivPane.setPadding(new Insets(15, 15, 15, 15));
        modifyDivPane.setCenter(modifyDivBox);
        modifyDivision.setOnAction(e -> primaryStage.setScene(modifydivScene));

        modifyDivPane.setBottom(modifyDivReturn);
        modifyDivReturn.setOnAction(e -> primaryStage.setScene(unitScene));

        // Delete Division scene
        BorderPane delDivPane = new BorderPane();
        VBox delDivBox = new VBox(20);
        Text delDivText = new Text("Delete Division");
        modifyDivText.setFont(Font.font("Inter", FontWeight.BOLD, 48));
        NumberTextField delDivNameSer = new NumberTextField();
        delDivNameSer.setMaxSize(409, 64);
        delDivNameSer.setPromptText("Enter ID");
        Button delSerButton = new Button("Search");
        delSerButton.setMaxSize(409, 64);
        Text delDivResult = new Text();
        delDivResult.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button delDivButton = new Button("Save");
        delDivButton.setVisible(false);
        delDivButton.setMaxSize(409, 64);
        Button delDivReturn = new Button("Return");

        Scene deldivScene = new Scene(delDivPane, 1024, 640);
        delDivBox.getChildren().addAll(delDivText, delDivNameSer, delSerButton, delDivResult, delDivButton);
        delDivBox.setAlignment(Pos.CENTER);
        delDivPane.setPadding(new Insets(15, 15, 15, 15));
        delDivPane.setCenter(delDivBox);
        deleteDivision.setOnAction(e -> primaryStage.setScene(deldivScene));

        delDivPane.setBottom(delDivReturn);
        delDivReturn.setOnAction(e -> primaryStage.setScene(unitScene));

        // List of divisions scene
        BorderPane listDivPane = new BorderPane();
        VBox listDivBox = new VBox(20);
        Text listDivText = new Text("List of Divisions:");
        listDivText.setFont(Font.font("Inter", FontWeight.BOLD, 48));

        Button listDivReturn = new Button("Return");

        Scene listdivScene = new Scene(listDivPane, 1024, 640);
        listDivBox.getChildren().addAll(listDivText);
        listDivBox.setAlignment(Pos.CENTER);
        listDivPane.setPadding(new Insets(15, 15, 15, 15));
        listDivPane.setCenter(listDivBox);

        listOfDivisions.setOnAction(e -> {
            primaryStage.setScene(listdivScene);

            System.out.println(divisionsList.get(0).getID() + "before");
            for (int i = 0; i < divisionsList.size(); i++) {
                String list = "\nName:" + divisionsList.get(i).getName() + "                  ID:   "
                        + divisionsList.get(i).getID();
                // list.setFont(Font.font("Inter", FontWeight.BOLD, 42));

                listDivBox.getChildren().add(new Text(list));
                System.out.println(divisionsList.get(0).getID() + "after");

            }

        });

        listDivPane.setBottom(delDivReturn);
        listDivReturn.setOnAction(e -> primaryStage.setScene(unitScene));

        addDivSave.setOnAction(e -> {

            if (divNameField.getText().equals("")) {
                addDivChecking.setText("Division name missing, please enter a name");

            } else if (divIDField.getText().equals("")) {
                addDivChecking.setText("Division ID missing, Please enter an ID");

            } else {
                division addDivdision = new division(divNameField.getText(), divIDField.getText());
                divisionsList.add(addDivdision);
                divNameField.clear();
                divIDField.clear();
                primaryStage.setScene(unitScene);
            }
        });

        // Applicants
        BorderPane ApplicantsPane = new BorderPane();
        VBox ApplicantsBox = new VBox(20);
        Text ApplicantsText = new Text("Applicants");
        ApplicantsText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button createJobButton = new Button("Create Job offer");
        createJobButton.setMaxSize(409, 64);
        Button makeInterviewButton = new Button("Make interview appointment");
        makeInterviewButton.setMaxSize(409, 64);
        Button moveApplicantsButton = new Button("Move applicant to offring");
        moveApplicantsButton.setMaxSize(409, 64);
        Button reportApplicantButton = new Button("Report applicant");
        reportApplicantButton.setMaxSize(409, 64);
        Button reviewApplicantButton = new Button("review applicant");
        reviewApplicantButton.setMaxSize(409, 64);
        Button viewWhoPassButton = new Button("Review who pass");
        viewWhoPassButton.setMaxSize(409, 64);
        Button ReviewInterviewResultsButton = new Button("Review interview results");
        ReviewInterviewResultsButton.setMaxSize(409, 64);
        Scene scene5 = new Scene(ApplicantsPane, 1024, 640);
        ApplicantsBox.getChildren().addAll(ApplicantsText, createJobButton, makeInterviewButton, moveApplicantsButton,
                reportApplicantButton, reviewApplicantButton, viewWhoPassButton, ReviewInterviewResultsButton);
        ApplicantsBox.setAlignment(Pos.CENTER);
        ApplicantsPane.setPadding(new Insets(15, 15, 15, 15));
        ApplicantsPane.setCenter(ApplicantsBox);

        Button backButto2 = new Button("Back");
        backButto2.setOnAction(e -> primaryStage.setScene(scene2));

        ApplicantsPane.setTop(backButto2);
        ApplicantsButton.setOnAction(e -> primaryStage.setScene(scene5));

        // Applicant: Create Job Offer
        Text createJobOfferText = new Text("Create Job Offer");
        createJobOfferText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        BorderPane jobOfferPane = new BorderPane();
        VBox jobOfferBox = new VBox(20);
        // viewDepartButton.setMaxSize(409, 64);
        jobOfferBox.setAlignment(Pos.CENTER);
        jobOfferPane.setPadding(new Insets(15, 15, 15, 15));
        jobOfferPane.setCenter(jobOfferBox);

        ArrayList<Integer> IDList = new ArrayList<>();
        for (int i = 0; i < applicantList.size(); i++) {
            IDList.add(applicantList.get(i).getID());
        }

        // intialize variables
        ComboBox<Integer> applicantComboBox = new ComboBox<>(FXCollections.observableArrayList(IDList));
        applicantComboBox.setMaxSize(409, 64);
        Button showJobOfferButton = new Button("Show job offer");
        showJobOfferButton.setMaxSize(409, 64);
        Label chooseIDLabel = new Label("Choose Applicant ID: ");
        HBox viewSalaries = new HBox();
        viewSalaries.setAlignment(Pos.CENTER);
        Text createMassage = new Text("");
        createMassage.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        VBox result = new VBox(10);
        Label validLabel = new Label();
        Label minSalary = new Label();
        Label expectedSalary = new Label();
        Label maxSalary = new Label();
        ToggleGroup tg = new ToggleGroup();

        RadioButton divisionRadioButton = new RadioButton("Divison Level");
        RadioButton directorateRadioButton = new RadioButton("Directorate Level");
        RadioButton noneRadioButton = new RadioButton("none");

        TilePane r = new TilePane();
        divisionRadioButton.setToggleGroup(tg);
        directorateRadioButton.setToggleGroup(tg);
        noneRadioButton.setToggleGroup(tg);

        r.getChildren().addAll(divisionRadioButton, directorateRadioButton, noneRadioButton);
        viewSalaries.getChildren().addAll(result);
        result.getChildren().add(validLabel);
        jobOfferBox.getChildren().addAll(createJobOfferText, chooseIDLabel, applicantComboBox, showJobOfferButton,
                viewSalaries);
        jobOfferPane.setCenter(jobOfferBox);
        Scene jobOfferScene = new Scene(jobOfferPane, 1024, 640);

        showJobOfferButton.setOnAction(ActionEvent -> {
            boolean valid = false;
            for (int i = 0; i < applicantList.size(); i++) {
                if (applicantComboBox.getSelectionModel().getSelectedItem() == applicantList.get(i).getID()) {

                    validLabel.setText("");
                    if (applicantList.get(i).passedApplication()) {
                        valid = true;
                        applicantSelection = i;
                        result.getChildren().clear();
                        // checks if a radio button is chosen
                        if (divisionRadioButton.isSelected()) {
                            applicantList.get(i).setPosition(divisionRadioButton.getText());
                            createMassage.setText("Job offer has been done successfully");
                        }
                        if (directorateRadioButton.isSelected()) {
                            applicantList.get(i).setPosition(directorateRadioButton.getText());
                            createMassage.setText("Job offer has been done successfully");
                        }
                        if (noneRadioButton.isSelected()) {
                            applicantList.get(i).setPosition(noneRadioButton.getText());
                            createMassage.setText("Job offer has been done successfully");
                        }

                        ArrayList<Double> salaries = applicantList.get(i).createJobOffer();
                        validLabel.setText("Salaries: ");
                        minSalary.setText("Minimum salary is " + salaries.get(1));
                        expectedSalary.setText("Expected salary is " + salaries.get(0));
                        maxSalary.setText("maximum salary is " + salaries.get(2));
                        result.getChildren().addAll(validLabel, minSalary, maxSalary, expectedSalary, createMassage);
                        viewSalaries.getChildren().clear();
                        viewSalaries.getChildren().addAll(result, r);
                    }

                }

            }
            if (!valid) {
                result.getChildren().clear();
                validLabel.setText("Is not valid for a job offer");
                result.getChildren().add(validLabel);
            } else
                showJobOfferButton.setText("Confirm");

        });

        Button backButton4 = new Button("Back");
        backButton4.setOnAction(e -> primaryStage.setScene(scene5));

        jobOfferPane.setTop(backButton4);

        createJobButton.setOnAction(e -> primaryStage.setScene(jobOfferScene));

        // Applicant: Make interview appointment
        Text makeInterviewAppointment = new Text("Make Interview Appointment");
        makeInterviewAppointment.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        BorderPane makeInterviewPane = new BorderPane();
        VBox makeInterviewBox = new VBox(20);
        ComboBox<Integer> applicantComboBox5 = new ComboBox<>(FXCollections.observableArrayList(IDList));
        applicantComboBox5.setMaxSize(409, 64);
        Label chooseIDLabel5 = new Label("Choose Applicant ID:");
        DatePicker datePicker = new DatePicker();
        datePicker.setMaxSize(409, 64);
        Label pickDateLabel = new Label("Choose a date:");
        ComboBox<String> interviewerComboBox = new ComboBox<>(FXCollections.observableArrayList(interviewerNameList));
        interviewerComboBox.setMaxSize(409, 64);
        Label chooseInterviewer = new Label("Choose interviewer:");
        Button reserveInterviewButton = new Button("reserve");
        Label makeInterviewOutcome = new Label();

        makeInterviewBox.getChildren().addAll(makeInterviewAppointment, chooseIDLabel5, applicantComboBox5,
                pickDateLabel, datePicker, chooseInterviewer, interviewerComboBox, reserveInterviewButton,
                makeInterviewOutcome);
        makeInterviewPane.setCenter(makeInterviewBox);
        reserveInterviewButton.setMaxSize(409, 64);
        makeInterviewBox.setAlignment(Pos.CENTER);
        makeInterviewPane.setPadding(new Insets(15, 15, 15, 15));
        Scene makeInterviewScene = new Scene(makeInterviewPane, 1024, 640);

        reserveInterviewButton.setOnAction(ActionEvent -> {

            int interviewsNumber = 0;
            for (int i = 0; i < applicantList.size(); i++) {
                if (applicantComboBox5.getSelectionModel().getSelectedItem() == applicantList.get(i).getID()) {

                    // checks that the applicant does not have more than 3 interviews
                    for (int j = 0; j < interviewList.size(); j++) {
                        if (applicantList.get(i).equals(interviewList.get(j).getApplicant()))
                            interviewsNumber = interviewsNumber + 1;
                    }
                    if (interviewsNumber >= 3) {
                        makeInterviewOutcome.setText("applicant reached maximum interviews");
                        break;
                    }

                    for (int j = 0; j < interviewerList.size(); j++) {
                        if (interviewerComboBox.getSelectionModel().getSelectedItem()
                                .equals(interviewerList.get(j).getName())) {

                            interviewList.add(new Interview(interviewList.size(),
                                    datePicker.getValue().format(DateTimeFormatter.ofPattern("MMM-dd-yyyy")),
                                    applicantList.get(i), interviewerList.get(j)));
                            makeInterviewOutcome.setText("interview added");
                        }
                    }
                }
            }
        });

        makeInterviewButton.setOnAction(e -> primaryStage.setScene(makeInterviewScene));

        Button backButton9 = new Button("Back");
        backButton9.setOnAction(e -> primaryStage.setScene(scene5));
        makeInterviewPane.setTop(backButton9);

        // Applicant: Move applicant to offering page
        Text moveApplicantToOfferingPage = new Text("Move Applicant to Offering Page");
        moveApplicantToOfferingPage.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        BorderPane moveToOfferingPane = new BorderPane();
        VBox moveToOfferingBox = new VBox(20);
        ComboBox<Integer> applicantComboBox2 = new ComboBox<>(FXCollections.observableArrayList(IDList));
        applicantComboBox2.setMaxSize(409, 64);
        Label chooseIDLabel2 = new Label("Choose Applicant ID");
        Label outcome = new Label();
        Button moveToOfferingButton = new Button("Move to offering");
        moveToOfferingBox.getChildren().addAll(moveApplicantToOfferingPage, chooseIDLabel2, applicantComboBox2,
                moveToOfferingButton, outcome);
        moveToOfferingPane.setCenter(moveToOfferingBox);
        moveToOfferingButton.setMaxSize(409, 64);
        moveToOfferingBox.setAlignment(Pos.CENTER);
        moveToOfferingPane.setPadding(new Insets(15, 15, 15, 15));
        Scene moveToOfferingScene = new Scene(moveToOfferingPane, 1024, 640);

        moveApplicantsButton.setOnAction(e -> primaryStage.setScene(moveToOfferingScene));
        moveToOfferingButton.setOnAction(ActionEvent -> {

            for (int i = 0; i < applicantList.size(); i++) {
                if (applicantComboBox2.getSelectionModel().getSelectedItem() == applicantList.get(i).getID()) {
                    if (!applicantList.get(i).passedApplication()) {
                        applicantList.get(i).setPassed(true);
                        outcome.setText("Applicant moved to offering");
                    } else {
                        outcome.setText("Applicant already moved");
                    }

                }
            }
        });

        Button backButton5 = new Button("Back");
        backButton5.setOnAction(e -> primaryStage.setScene(scene5));
        moveToOfferingPane.setTop(backButton5);

        // Applicant: Report applicant
        Text reportApplicant = new Text("Report Applicant");
        reportApplicant.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        BorderPane reportApplicantPane = new BorderPane();
        VBox reportApplicantBox = new VBox(20);
        ComboBox<Integer> applicantComboBox4 = new ComboBox<>(FXCollections.observableArrayList(IDList));
        applicantComboBox4.setMaxSize(409, 64);
        Label chooseIDLabel4 = new Label("Choose Applicant ID");
        Label reportOutcome = new Label();
        TextField reportTF = new TextField();
        reportTF.setMaxSize(409, 64);
        reportTF.setMinWidth(64);
        reportTF.setMinHeight(100);
        Button reportButton = new Button("Send report");
        reportButton.setMaxSize(409, 64);
        Button removeOfferButton = new Button("Remove offer");
        Scene reportApplicantScene = new Scene(reportApplicantPane, 1024, 640);
        removeOfferButton.setMaxSize(409, 64);
        reportApplicantBox.setAlignment(Pos.CENTER);
        reportApplicantPane.setPadding(new Insets(15, 15, 15, 15));
        reportApplicantBox.getChildren().addAll(reportApplicant, chooseIDLabel4, applicantComboBox4, reportTF,
                reportButton, removeOfferButton, reportOutcome);
        reportApplicantPane.setCenter(reportApplicantBox);

        reportButton.setOnAction(ActionEvent -> {
            for (int i = 0; i < applicantList.size(); i++) {
                if (applicantComboBox4.getSelectionModel().getSelectedItem() == applicantList.get(i).getID()) {
                    applicantList.get(i).setReport(reportTF.getText());
                    reportOutcome.setText("Report added to applicant");
                }
            }
        });

        removeOfferButton.setOnAction(ActionEvent -> {
            for (int i = 0; i < applicantList.size(); i++) {
                if (applicantComboBox4.getSelectionModel().getSelectedItem() == applicantList.get(i).getID()) {
                    if (applicantList.get(i).passedApplication()) {
                        applicantList.get(i).setPassed(false);
                        reportOutcome.setText("offer removed");
                    } else {
                        reportOutcome.setText("applicant does not have offer");
                    }

                }
            }
        });

        reportApplicantButton.setOnAction(e -> primaryStage.setScene(reportApplicantScene));

        Button backButton8 = new Button("Back");
        backButton8.setOnAction(e -> primaryStage.setScene(scene5));
        reportApplicantPane.setTop(backButton8);

        // Applicant: review applicant page
        Text reviewApplicant = new Text("Review Applicant");
        reviewApplicant.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        BorderPane reviewApplicantPane = new BorderPane();
        VBox reviewApplicantBox = new VBox(20);
        ComboBox<Integer> applicantComboBox3 = new ComboBox<>(FXCollections.observableArrayList(IDList));
        applicantComboBox3.setMaxSize(409, 64);
        Label chooseIDLabel3 = new Label("Choose Applicant ID");
        Label applicantLabel = new Label();
        Label applicantIDLabel = new Label();
        Label applicantYearsLabel = new Label();
        Label applicantJobBandLabel = new Label();
        Label applicantPassedLabel = new Label();
        Label applicantReportLabel = new Label();
        Button showInfoButton = new Button("show applicant information");
        showInfoButton.setMaxSize(409, 64);
        reviewApplicantBox.getChildren().addAll(reviewApplicant, chooseIDLabel3, applicantComboBox3, showInfoButton,
                applicantLabel, applicantIDLabel, applicantYearsLabel, applicantJobBandLabel, applicantPassedLabel,
                applicantReportLabel);
        reviewApplicantBox.setAlignment(Pos.CENTER);
        reviewApplicantPane.setPadding(new Insets(15, 15, 15, 15));
        reviewApplicantPane.setCenter(reviewApplicantBox);
        Scene reviewApplicantScene = new Scene(reviewApplicantPane, 1024, 640);

        showInfoButton.setOnAction(ActionEvent -> {

            for (int i = 0; i < applicantList.size(); i++) {
                if (applicantComboBox3.getSelectionModel().getSelectedItem() == applicantList.get(i).getID()) {

                    applicantLabel.setText("Applicant info: ");
                    applicantIDLabel.setText("Applicant ID: " + applicantList.get(i).getID());
                    applicantYearsLabel.setText("Years of experience: " + applicantList.get(i).getYearsOfExperience());
                    applicantJobBandLabel.setText("JobBand: " + applicantList.get(i).getBandName());
                    applicantPassedLabel.setText("Passed Job Offering: " + applicantList.get(i).passedApplication());
                    if (!applicantList.get(i).getReport().equals(""))
                        applicantReportLabel.setText("Report found: " + applicantList.get(i).getReport());
                    else
                        applicantReportLabel.setText("");

                }
            }
        });

        reviewApplicantButton.setOnAction(e -> primaryStage.setScene(reviewApplicantScene));
        Button backButton6 = new Button("Back");
        backButton6.setOnAction(e -> primaryStage.setScene(scene5));
        reviewApplicantPane.setTop(backButton6);

        // Applicant: Review who pass
        Text ReviewWhoPass = new Text("Review Who Pass");
        ReviewWhoPass.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        BorderPane viewWhoPassPane = new BorderPane();
        VBox viewWhoPassBox = new VBox();
        Label passedApplicantsLabel = new Label();
        Button showWhoPassedButtons = new Button("Show who passed");
        ListView<Integer> applicantsWhoPassedListView = new ListView();
        applicantsWhoPassedListView.setMaxSize(409, 64);
        applicantsWhoPassedListView.setMinWidth(64);
        applicantsWhoPassedListView.setMinHeight(300);
        viewWhoPassBox.getChildren().addAll(ReviewWhoPass, showWhoPassedButtons, passedApplicantsLabel,
                applicantsWhoPassedListView);
        viewWhoPassPane.setCenter(viewWhoPassBox);
        Scene viewWhoPassScene = new Scene(viewWhoPassPane, 1024, 640);
        showWhoPassedButtons.setMaxSize(409, 64);
        viewWhoPassBox.setAlignment(Pos.CENTER);
        viewWhoPassPane.setPadding(new Insets(15, 15, 15, 15));

        showWhoPassedButtons.setOnAction(ActionEvent -> {
            applicantsWhoPassedListView.getItems().clear();
            passedApplicantsLabel.setText("Applicants who passed: ");
            for (int i = 0; i < applicantList.size(); i++) {
                if (applicantList.get(i).passedApplication())
                    applicantsWhoPassedListView.getItems().add(applicantList.get(i).getID());
            }
        });

        viewWhoPassButton.setOnAction(e -> primaryStage.setScene(viewWhoPassScene));

        Button backButton7 = new Button("Back");
        backButton7.setOnAction(e -> primaryStage.setScene(scene5));
        viewWhoPassPane.setTop(backButton7);

        // View Interview Results
        Interviewer example = new Interviewer("example");
        BorderPane viewerResultPane = new BorderPane();
        viewerResultPane.setPadding(new Insets(15, 15, 15, 15));
        Text viewerResultText = new Text("View Interview Results");
        viewerResultText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        VBox viewerResulBox = new VBox(20);
        viewerResulBox.setAlignment(Pos.CENTER);
        Button backInterview = new Button("Back");
        ListView<String> listView = new ListView<String>();
        listView.setMaxSize(409, 64);
        // for (int i = 0; i < example.getlistOfJobs().size(); i++) {
        // listView.getItems().add("The result of interview number " +
        // example.getlistOfJobs().get(i).getID()+ " at "
        // +example.getlistOfJobs().get(i).getDate()+" is " +
        // example.getlistOfJobs().get(i).getResult());
        // }
        viewerResulBox.getChildren().addAll(viewerResultText, listView);

        viewerResultPane.setTop(backInterview);
        viewerResultPane.setCenter(viewerResulBox);
        Scene sceneview = new Scene(viewerResultPane, 1024, 640);

        // Log Interview Results
        BorderPane logResultPane = new BorderPane();
        logResultPane.setPadding(new Insets(15, 15, 15, 15));
        Text logResultText = new Text("Log Interview Results");
        logResultText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        VBox logResulBox = new VBox(20);
        logResulBox.setAlignment(Pos.CENTER);
        Button backInterview2 = new Button("Back");
        Button set = new Button("set");
        ComboBox<Interview> listComboBox = new ComboBox<>(FXCollections.observableArrayList(interviewList));
        listComboBox.setMaxSize(409, 64);
        ArrayList<String> statusList = new ArrayList<String>();
        statusList.add("Passed");
        statusList.add("Failed");
        statusList.add("TBA");
        ComboBox<String> statusComboBox = new ComboBox<>(FXCollections.observableArrayList(statusList));

        logResulBox.getChildren().addAll(logResultText, listComboBox, statusComboBox, set);
        logResultPane.setTop(backInterview2);
        logResultPane.setCenter(logResulBox);

        set.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent g) {
                example.setResult(listComboBox.getSelectionModel().getSelectedItem().getID(),
                        statusComboBox.getSelectionModel().getSelectedItem());
                System.out.println(listComboBox.getSelectionModel().getSelectedItem().getID());
                System.out.println(statusComboBox.getSelectionModel().getSelectedItem());
            }
        });
        Scene scenelog = new Scene(logResultPane, 1024, 640);

        // Interviewer page
        BorderPane interviewerPane = new BorderPane();
        VBox interviewerBox = new VBox(20);
        Text interviewerText = new Text("Interviewer page");
        interviewerText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button viewInterviewResultsButton = new Button("View Interview Results");
        viewInterviewResultsButton.setMaxSize(409, 64);
        viewInterviewResultsButton.setOnAction(e -> primaryStage.setScene(sceneview));
        Button logInterviewResultsButton = new Button("Log Interview Results");
        logInterviewResultsButton.setMaxSize(409, 64);
        logInterviewResultsButton.setOnAction(e -> primaryStage.setScene(scenelog));
        Scene scene10 = new Scene(interviewerPane, 1024, 640);
        interviewerBox.getChildren().addAll(interviewerText, viewInterviewResultsButton, logInterviewResultsButton);
        interviewerBox.setAlignment(Pos.CENTER);
        interviewerPane.setPadding(new Insets(15, 15, 15, 15));
        interviewerPane.setCenter(interviewerBox);
        Button logOutButton10 = new Button("Log out");
        logOutButton10.setOnAction(e -> primaryStage.setScene(scene1));
        interviewerPane.setTop(logOutButton10);
        backInterview.setOnAction(e -> primaryStage.setScene(scene10));
        backInterview2.setOnAction(e -> primaryStage.setScene(scene10));

        // sign in button
        singinButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent g) {
                if (usernamefield.getText().equals("") || passwordfield.getText().equals("")) {
                    eror.setText("username or password is not entered");
                } else if (usernamefield.getText().equals(passwordfield.getText())) {
                    if (usernamefield.getText().substring(0, 4).equals("1000")) {
                        primaryStage.setScene(scene2);
                    } else {
                        primaryStage.setScene(scene10);
                    }
                } else {
                    eror.setText("Wrong username or password");
                }
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }

    public class NumberTextField extends TextField {

        @Override
        public void replaceText(int start, int end, String text) {
            if (validate(text)) {
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String text) {
            if (validate(text)) {
                super.replaceSelection(text);
            }
        }

        private boolean validate(String text) {
            return text.matches("[0-9]*");
        }
    }
}