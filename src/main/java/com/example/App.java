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

    public void start(Stage primaryStage) {

        // Used for test purposes
        ArrayList<Applicant> applicantList = new ArrayList<Applicant>();
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
            applicantList.add(new Applicant(i, (int) Math.random() * 10, band));
        }
        // sign in page
        Text eror = new Text("Enter your username and your password");
        eror.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        BorderPane mainPane = new BorderPane();
        VBox singBox = new VBox(8);
        singBox.setAlignment(Pos.CENTER);
        Button singinButton = new Button("Sign in");
        singinButton.setMaxSize(409, 64);
        // VBox.setMargin(singinButton, new Insets(15, 15, 15, 15));
        TextField usernamefield = new TextField();
        usernamefield.setMaxSize(409, 64);
        usernamefield.setPromptText("Enter your Username");
        // VBox.setMargin(usernamefield, new Insets(15, 15, 15, 15));
        TextField passwordfield = new TextField();
        passwordfield.setMaxSize(409, 64);
        passwordfield.setPromptText("Enter your Password");
        // VBox.setMargin(passwordfield, new Insets(15, 15, 15, 15));
        singBox.setPadding(new Insets(15, 15, 15, 15));
        singBox.getChildren().addAll(eror, usernamefield, passwordfield, singinButton);
        mainPane.setPadding(new Insets(15, 15, 15, 15));
        mainPane.setCenter(singBox);
        primaryStage.setScene(new Scene(mainPane, 1024, 640));
        primaryStage.show();

        // employer page
        BorderPane employerPane = new BorderPane();
        VBox emploerBox = new VBox(20);
        Text EmploerText = new Text("Emploer Page");
        EmploerText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button bandsButton = new Button("Bands");
        bandsButton.setMaxSize(409, 64);
        // VBox.setMargin(bandsButton, new Insets(15, 15, 15, 15));
        Button ApplicantsButton = new Button("Applicants");
        ApplicantsButton.setMaxSize(409, 64);
        // VBox.setMargin(ApplicantsButton, new Insets(15, 15, 15, 15));
        Button DepartmentsButton = new Button("Units");
        DepartmentsButton.setMaxSize(409, 64);
        // VBox.setMargin(DepartmentsButton, new Insets(15, 15, 15, 15));
        Scene scene2 = new Scene(employerPane, 1024, 640);
        emploerBox.getChildren().addAll(EmploerText, ApplicantsButton, bandsButton, DepartmentsButton);
        emploerBox.setAlignment(Pos.CENTER);
        employerPane.setPadding(new Insets(15, 15, 15, 15));
        employerPane.setCenter(emploerBox);
        singinButton.setOnAction(new EventHandler<ActionEvent>() { // this button link you to viewCourse screen
            @Override
            public void handle(ActionEvent g) {
                if (usernamefield.getText().equals(passwordfield.getText())) {
                    primaryStage.setScene(scene2);
                } else {
                    eror.setText("Wrong user name or password");
                }
            }
        });

        // back to employer page button
        // Button backButton = new Button("Back");
        // backButton.setOnAction(e -> primaryStage.setScene(scene2));

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

        bandsPane.setBottom(backButton);
        bandsButton.setOnAction(e -> primaryStage.setScene(scene3));

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
        directorateText.setFont(Font.font("Inter", FontWeight.BOLD, 48));
        TextField divNameField = new TextField();
        divNameField.setMaxSize(409, 64);
        divNameField.setPromptText("Enter Division Name");
        TextField divIDField = new TextField();
        divIDField.setPromptText("Enter ID");
        divIDField.setMaxSize(409, 64);
        Button addDivSave = new Button("Save and Return");
        addDivSave.setMaxSize(409, 64);

        Scene diVAddScene = new Scene(AddDivPane, 1024, 640);
        AddDivBox.getChildren().addAll(divName, divNameField, divIDField, addDivSave);
        AddDivBox.setAlignment(Pos.CENTER);
        AddDivPane.setPadding(new Insets(15, 15, 15, 15));
        AddDivPane.setCenter(AddDivBox);
        addDivision.setOnAction(e -> primaryStage.setScene(diVAddScene));
        Button addDivBack = new Button("Back");
        AddDivPane.setBottom(addDivBack);
        addDivBack.setOnAction(e -> primaryStage.setScene(unitScene));

        // Applicants
        BorderPane ApplicantsPane = new BorderPane();
        VBox ApplicantsBox = new VBox(20);
        Text ApplicantsText = new Text("Applicants");
        ApplicantsText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button createJobButton = new Button("Create Job offer");
        createJobButton.setMaxSize(409, 64);
        // VBox.setMargin(createJobButton, new Insets(15, 15, 15, 15));
        Button makeInterviewButton = new Button("Make interview appointment");
        makeInterviewButton.setMaxSize(409, 64);
        // VBox.setMargin(makeInterviewButton, new Insets(15, 15, 15, 15));
        Button moveApplicantsButton = new Button("Move applicant to offring");
        moveApplicantsButton.setMaxSize(409, 64);
        // VBox.setMargin(moveApplicantsButton, new Insets(15, 15, 15, 15));
        Button reportApplicantButton = new Button("Report applicant");
        reportApplicantButton.setMaxSize(409, 64);
        // VBox.setMargin(reportApplicantButton, new Insets(15, 15, 15, 15));
        Button reviewApplicantButton = new Button("review applicant");
        reviewApplicantButton.setMaxSize(409, 64);
        // VBox.setMargin(reviewApplicantButton, new Insets(15, 15, 15, 15));
        Button viewWhoPassButton = new Button("Review who pass");
        viewWhoPassButton.setMaxSize(409, 64);
        // VBox.setMargin(viewWhoPassButton, new Insets(15, 15, 15, 15));
        Button ReviewInterviewResultsButton = new Button("Review interview results");
        ReviewInterviewResultsButton.setMaxSize(409, 64);
        // VBox.setMargin(ReviewInterviewResultsButton, new Insets(15, 15, 15, 15));
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
        BorderPane jobOfferPane = new BorderPane();
        VBox jobOfferBox = new VBox(20);

        ArrayList<Integer> IDList = new ArrayList<>();
        for (int i = 0; i < applicantList.size(); i++) {
            IDList.add(applicantList.get(i).getID());
        }

        // intialize variables
        ComboBox<Integer> applicantComboBox = new ComboBox<>(FXCollections.observableArrayList(IDList));
        Button showJobOfferButton = new Button("Show job offer");
        Label chooseIDLabel = new Label("Choose Applicant ID");
        HBox viewSalaries = new HBox();
        VBox result = new VBox();
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
        jobOfferBox.getChildren().addAll(applicantComboBox, chooseIDLabel, showJobOfferButton, viewSalaries);
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
                        if (divisionRadioButton.isSelected())
                            applicantList.get(i).setPosition(divisionRadioButton.getText());

                        if (directorateRadioButton.isSelected())
                            applicantList.get(i).setPosition(directorateRadioButton.getText());

                        if (noneRadioButton.isSelected())
                            applicantList.get(i).setPosition(noneRadioButton.getText());

                        ArrayList<Double> salaries = applicantList.get(i).createJobOffer();
                        validLabel.setText("Salaries: ");
                        minSalary.setText("Minimum salary is " + salaries.get(1));
                        expectedSalary.setText("Expected salary is " + salaries.get(0));
                        maxSalary.setText("maximum salary is " + salaries.get(2));
                        result.getChildren().addAll(validLabel, minSalary, maxSalary, expectedSalary);
                        viewSalaries.getChildren().clear();
                        viewSalaries.getChildren().addAll(result, r);

                    }

                }

            }
            if (!valid) {
                result.getChildren().clear();
                validLabel.setText("Is not valid for a job offer");
                result.getChildren().add(validLabel);

            }

        });

        Button backButton4 = new Button("Back");
        backButton4.setOnAction(e -> primaryStage.setScene(scene5));

        jobOfferPane.setTop(backButton4);

        createJobButton.setOnAction(e -> primaryStage.setScene(jobOfferScene));

        // Applicant: Make interview appointment
        BorderPane makeInterviewPane = new BorderPane();
        VBox makeInterviewBox = new VBox();
        ComboBox<Integer> applicantComboBox5 = new ComboBox<>(FXCollections.observableArrayList(IDList));
        Label chooseIDLabel5 = new Label("Choose Applicant ID");
        DatePicker datePicker = new DatePicker();
        Label pickDateLabel = new Label("Choose a date");
        ComboBox<String> interviewerComboBox = new ComboBox<>(FXCollections.observableArrayList(interviewerNameList));
        Label chooseInterviewer = new Label("Choose interviewer");
        Button reserveInterviewButton = new Button("reserve");
        Label makeInterviewOutcome = new Label();

        makeInterviewBox.getChildren().addAll(chooseIDLabel5, applicantComboBox5, pickDateLabel, datePicker,
                chooseInterviewer, interviewerComboBox, reserveInterviewButton, makeInterviewOutcome);
        makeInterviewPane.setCenter(makeInterviewBox);
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
        BorderPane moveToOfferingPane = new BorderPane();
        VBox moveToOfferingBox = new VBox();
        ComboBox<Integer> applicantComboBox2 = new ComboBox<>(FXCollections.observableArrayList(IDList));
        Label chooseIDLabel2 = new Label("Choose Applicant ID");
        Label outcome = new Label();
        Button moveToOfferingButton = new Button("Move to offering");
        moveToOfferingBox.getChildren().addAll(applicantComboBox2, chooseIDLabel2, moveToOfferingButton, outcome);
        moveToOfferingPane.setCenter(moveToOfferingBox);
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
        BorderPane reportApplicantPane = new BorderPane();
        VBox reportApplicantBox = new VBox();
        ComboBox<Integer> applicantComboBox4 = new ComboBox<>(FXCollections.observableArrayList(IDList));
        Label chooseIDLabel4 = new Label("Choose Applicant ID");
        Label writeReportLabel = new Label();
        Label reportOutcome = new Label();
        TextField reportTF = new TextField();
        reportTF.setMaxSize(409, 9999);
        Button reportButton = new Button("Send report");
        Button removeOfferButton = new Button("Remove offer");
        Scene reportApplicantScene = new Scene(reportApplicantPane, 1024, 640);

        reportApplicantBox.getChildren().addAll(applicantComboBox4, chooseIDLabel4, writeReportLabel, reportTF,
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
        BorderPane reviewApplicantPane = new BorderPane();
        VBox reviewApplicantBox = new VBox();
        ComboBox<Integer> applicantComboBox3 = new ComboBox<>(FXCollections.observableArrayList(IDList));
        Label chooseIDLabel3 = new Label("Choose Applicant ID");
        Label applicantLabel = new Label();
        Label applicantIDLabel = new Label();
        Label applicantYearsLabel = new Label();
        Label applicantJobBandLabel = new Label();
        Label applicantPassedLabel = new Label();
        Label applicantReportLabel = new Label();
        Button showInfoButton = new Button("show applicant information");
        reviewApplicantBox.getChildren().addAll(applicantComboBox3, chooseIDLabel3, showInfoButton, applicantLabel,
                applicantIDLabel, applicantYearsLabel, applicantJobBandLabel, applicantPassedLabel,
                applicantReportLabel);

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
        BorderPane viewWhoPassPane = new BorderPane();
        VBox viewWhoPassBox = new VBox();
        Label passedApplicantsLabel = new Label();
        Button showWhoPassedButtons = new Button("Show who passed");
        ListView<Integer> applicantsWhoPassedListView = new ListView();
        viewWhoPassBox.getChildren().addAll(showWhoPassedButtons, passedApplicantsLabel, applicantsWhoPassedListView);
        viewWhoPassPane.setCenter(viewWhoPassBox);
        Scene viewWhoPassScene = new Scene(viewWhoPassPane, 1024, 640);

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
    }

    public static void main(String[] args) {
        launch();
    }

}