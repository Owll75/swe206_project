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
import Classes.Interview;
import Classes.Interviewer;
import Classes.Job;
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
        for(int i = 0; i<interviewerList.size(); i++){
            interviewerNameList.add(interviewerList.get(i).getName());
        }

        jobBands band = new jobBands("project management", 1, jobList);
        applicantList.add(new Applicant(16, 4, band));
        for (int i = 0; i < 15; i++){
            applicantList.add(new Applicant(i, (int)(Math.random()*10), band));
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
        eror.setFont(Font.font("Arial",14));
        singBox.setPadding(new Insets(15, 15, 15, 15));
        singBox.getChildren().addAll(usernamefield, passwordfield,eror, singinButton);
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
        Button ApplicantsButton = new Button("Applicants");
        ApplicantsButton.setMaxSize(409, 64);
        Button DepartmentsButton = new Button("Unit");
        DepartmentsButton.setMaxSize(409, 64);
        Scene scene2 = new Scene(employerPane, 1024, 640);
        emploerBox.getChildren().addAll(EmploerText, ApplicantsButton, bandsButton, DepartmentsButton);
        emploerBox.setAlignment(Pos.CENTER);
        employerPane.setPadding(new Insets(15, 15, 15, 15));
        employerPane.setCenter(emploerBox);
        singinButton.setOnAction(new EventHandler<ActionEvent>() {		// this button link you to viewCourse screen
        @Override
        public void handle(ActionEvent g) {
            if(usernamefield.getText().equals(passwordfield.getText())) {primaryStage.setScene(scene2);}
            else {eror.setText("Wrong user name or password");}
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
        bandsPane.setTop(backButton);
        bandsButton.setOnAction(e -> primaryStage.setScene(scene3));

        //Add band
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
        bandIDfield1.setMaxSize(409, 64);
        bandIDfield1.setPromptText("Enter Band ID");
        Scene scene8 = new Scene(addBandPane, 1024, 640);
        addBandBox.setAlignment(Pos.CENTER);
        addBandPane.setPadding(new Insets(15, 15, 15, 15));
        addBandPane.setCenter(addBandBox);
        Button backButto7 = new Button("Back");
        addBandBox.getChildren().addAll(addBandText,bandIDfield1,bandNamefield1,bandAddButton);
        backButto7.setOnAction(e -> primaryStage.setScene(scene3));
        addBandPane.setTop(backButto7);
        addBandButton.setOnAction(e -> primaryStage.setScene(scene8));

        //delete band
        BorderPane deleteBandPane = new BorderPane();
        VBox deleteBandBox = new VBox(20);
        Text deleteBandText = new Text("Delete Band");
        deleteBandText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        ComboBox<jobBands> bandsComboBox = new ComboBox<>();
        Button bandDeleteButton = new Button("Delete");
        deleteBandBox.getChildren().addAll(deleteBandText,bandsComboBox,bandDeleteButton);
        bandDeleteButton.setMaxSize(409, 64);
        bandsComboBox.setMaxSize(409, 64);
        Scene scene6 = new Scene(deleteBandPane, 1024, 640);
        deleteBandBox.setAlignment(Pos.CENTER);
        deleteBandPane.setPadding(new Insets(15, 15, 15, 15));
        deleteBandPane.setCenter(deleteBandBox);
        Button backButto5 = new Button("Back");
        backButto5.setOnAction(e -> primaryStage.setScene(scene3));
        deleteBandPane.setTop(backButto5);
        deleteBandButton.setOnAction(e -> primaryStage.setScene(scene6));
        //modify band
        BorderPane modifyBandPane = new BorderPane();
        VBox modifyBandBox = new VBox(20);
        Text modifyBandText = new Text("Modify Band");
        modifyBandText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button bandModifyButton = new Button("confirm");
        bandDeleteButton.setMaxSize(409, 64);
        TextField bandNamefield = new TextField();
        bandNamefield.setMaxSize(409, 64);
        ComboBox<jobBands> bandsComboBox2 = new ComboBox<>();
        bandsComboBox2.setMaxSize(409, 64);
        TextField bandIDfield = new TextField();
        bandIDfield.setMaxSize(409, 64);
        Scene scene7 = new Scene(modifyBandPane, 1024, 640);
        modifyBandBox.setAlignment(Pos.CENTER);
        modifyBandPane.setPadding(new Insets(15, 15, 15, 15));
        modifyBandPane.setCenter(modifyBandBox);
        Button backButto6 = new Button("Back");
        modifyBandBox.getChildren().addAll(modifyBandText,bandsComboBox2,bandIDfield,bandNamefield,bandModifyButton);
        backButto6.setOnAction(e -> primaryStage.setScene(scene3));
        modifyBandPane.setTop(backButto6);
        modifyBandButton.setOnAction(e -> primaryStage.setScene(scene7));
        //assign band
        BorderPane assignBandPane = new BorderPane();
        VBox assignBandBox = new VBox(20);
        Text assignBandText = new Text("Assign Band");
        assignBandText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        ComboBox<jobBands> bandsComboBox3 = new ComboBox<>();
        ComboBox<Job>jobComboBox = new ComboBox<>();
        Button bandAssignButton = new Button("Assign");
        bandAssignButton.setMaxSize(409, 64);
        bandsComboBox3.setMaxSize(409, 64);
        jobComboBox.setMaxSize(409, 64);
        assignBandBox.getChildren().addAll(assignBandText,bandsComboBox3,jobComboBox,bandAssignButton);
        Scene scene9 = new Scene(assignBandPane, 1024, 640);
        assignBandBox.setAlignment(Pos.CENTER);
        assignBandPane.setPadding(new Insets(15, 15, 15, 15));
        assignBandPane.setCenter(assignBandBox);
        Button backButto8 = new Button("Back");
        backButto8.setOnAction(e -> primaryStage.setScene(scene3));
        assignBandPane.setTop(backButto8);
        AssignBandButton.setOnAction(e -> primaryStage.setScene(scene9));


        // department page
        BorderPane DepartmentsPane = new BorderPane();
        VBox DepartmentsBox = new VBox(20);
        Text DepartmentsText = new Text("Departments");
        DepartmentsText.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        Button addDepartButton = new Button("Add department");
        addDepartButton.setMaxSize(409, 64);
        // VBox.setMargin(addDepartButton, new Insets(15, 15, 15, 15));
        Button deleteDepartButton = new Button("delete department");
        deleteDepartButton.setMaxSize(409, 64);
        // VBox.setMargin(deleteDepartButton, new Insets(15, 15, 15, 15));
        Button modifyDepartButton = new Button("modify department");
        modifyDepartButton.setMaxSize(409, 64);
        // VBox.setMargin(modifyDepartButton, new Insets(15, 15, 15, 15));
        Button viewDepartButton = new Button("view department details");
        viewDepartButton.setMaxSize(409, 64);
        // VBox.setMargin(viewDepartButton, new Insets(15, 15, 15, 15));
        Scene scene4 = new Scene(DepartmentsPane, 1024, 640);
        DepartmentsBox.getChildren().addAll(DepartmentsText, addDepartButton, deleteDepartButton, modifyDepartButton,viewDepartButton);
        DepartmentsBox.setAlignment(Pos.CENTER);
        DepartmentsPane.setPadding(new Insets(15, 15, 15, 15));
        DepartmentsPane.setCenter(DepartmentsBox);

        Button backButto1 = new Button("Back");
        backButto1.setOnAction(e -> primaryStage.setScene(scene2));

        DepartmentsPane.setTop(backButto1);
        DepartmentsButton.setOnAction(e -> primaryStage.setScene(scene4));

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
        ApplicantsBox.getChildren().addAll(ApplicantsText, createJobButton, makeInterviewButton, moveApplicantsButton,reportApplicantButton, reviewApplicantButton, viewWhoPassButton, ReviewInterviewResultsButton);
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
        viewDepartButton.setMaxSize(409, 64);
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
        Text createMassage= new Text("");
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
        jobOfferBox.getChildren().addAll(createJobOfferText,chooseIDLabel,applicantComboBox,  showJobOfferButton, viewSalaries);
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
                        if (divisionRadioButton.isSelected()){
                            applicantList.get(i).setPosition(divisionRadioButton.getText());
                            createMassage.setText("Job offer has been done successfully");
                        }
                        if (directorateRadioButton.isSelected()){
                            applicantList.get(i).setPosition(directorateRadioButton.getText());
                            createMassage.setText("Job offer has been done successfully");
                        }
                        if (noneRadioButton.isSelected()){
                            applicantList.get(i).setPosition(noneRadioButton.getText());
                            createMassage.setText("Job offer has been done successfully");
                        }

                        ArrayList<Double> salaries = applicantList.get(i).createJobOffer();
                        validLabel.setText("Salaries: ");
                        minSalary.setText("Minimum salary is " + salaries.get(1));
                        expectedSalary.setText("Expected salary is " + salaries.get(0));
                        maxSalary.setText("maximum salary is " + salaries.get(2));
                        result.getChildren().addAll(validLabel, minSalary, maxSalary, expectedSalary,createMassage);
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
            else
            showJobOfferButton.setText("Confirm");

        });

        Button backButton4 = new Button("Back");
        backButton4.setOnAction(e -> primaryStage.setScene(scene5));

        jobOfferPane.setTop(backButton4);

        createJobButton.setOnAction(e -> primaryStage.setScene(jobOfferScene));

        //Applicant: Make interview appointment
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
        Button reserveInterviewButton = new Button("reserve") ;
        Label makeInterviewOutcome = new Label();

        makeInterviewBox.getChildren().addAll(makeInterviewAppointment,chooseIDLabel5, applicantComboBox5, pickDateLabel, datePicker, chooseInterviewer, interviewerComboBox, reserveInterviewButton, makeInterviewOutcome);
        makeInterviewPane.setCenter(makeInterviewBox);
        reserveInterviewButton.setMaxSize(409, 64);
        makeInterviewBox.setAlignment(Pos.CENTER);
        makeInterviewPane.setPadding(new Insets(15, 15, 15, 15));
        Scene makeInterviewScene = new Scene(makeInterviewPane, 1024, 640);

        reserveInterviewButton.setOnAction(ActionEvent -> {

            int interviewsNumber = 0;
            for (int i = 0; i < applicantList.size(); i++) {
                if (applicantComboBox5.getSelectionModel().getSelectedItem() == applicantList.get(i).getID()) {

                    //checks that the applicant does not have more than 3 interviews
                    for (int j = 0; j < interviewList.size(); j++){
                        if(applicantList.get(i).equals(interviewList.get(j).getApplicant()))
                            interviewsNumber = interviewsNumber + 1;
                    }
                    if(interviewsNumber >= 3){
                        makeInterviewOutcome.setText("applicant reached maximum interviews");
                        break;
                    }

                    for (int j = 0; j < interviewerList.size(); j++) {
                        if (interviewerComboBox.getSelectionModel().getSelectedItem().equals(interviewerList.get(j).getName())) {

                            interviewList.add(new Interview(interviewList.size(), datePicker.getValue().format(DateTimeFormatter.ofPattern("MMM-dd-yyyy")), applicantList.get(i), interviewerList.get(j)));
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

        //Applicant: Move applicant to offering page
        Text moveApplicantToOfferingPage = new Text("Move Applicant to Offering Page");
        moveApplicantToOfferingPage.setFont(Font.font("Inter", FontWeight.BOLD, 42));
        BorderPane moveToOfferingPane = new BorderPane();
        VBox moveToOfferingBox = new VBox(20);
        ComboBox<Integer> applicantComboBox2 = new ComboBox<>(FXCollections.observableArrayList(IDList));
        applicantComboBox2.setMaxSize(409, 64);
        Label chooseIDLabel2 = new Label("Choose Applicant ID");
        Label outcome = new Label();
        Button moveToOfferingButton = new Button("Move to offering");
        moveToOfferingBox.getChildren().addAll(moveApplicantToOfferingPage,chooseIDLabel2,applicantComboBox2, moveToOfferingButton, outcome);
        moveToOfferingPane.setCenter(moveToOfferingBox);
        moveToOfferingButton.setMaxSize(409, 64);
        moveToOfferingBox.setAlignment(Pos.CENTER);
        moveToOfferingPane.setPadding(new Insets(15, 15, 15, 15));
        Scene moveToOfferingScene = new Scene(moveToOfferingPane, 1024, 640);

        moveApplicantsButton.setOnAction(e -> primaryStage.setScene(moveToOfferingScene));
        moveToOfferingButton.setOnAction(ActionEvent -> {


            for (int i = 0; i < applicantList.size(); i++) {
                if (applicantComboBox2.getSelectionModel().getSelectedItem() == applicantList.get(i).getID()) {
                    if(!applicantList.get(i).passedApplication()) {
                        applicantList.get(i).setPassed(true);
                        outcome.setText("Applicant moved to offering");
                    }
                    else{
                        outcome.setText("Applicant already moved");
                    }

                }
            }
        });

        Button backButton5 = new Button("Back");
        backButton5.setOnAction(e -> primaryStage.setScene(scene5));
        moveToOfferingPane.setTop(backButton5);

        //Applicant: Report applicant
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
        reportApplicantBox.getChildren().addAll(reportApplicant,chooseIDLabel4,applicantComboBox4, reportTF,reportButton, removeOfferButton, reportOutcome);
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
                    if(applicantList.get(i).passedApplication()) {
                        applicantList.get(i).setPassed(false);
                        reportOutcome.setText("offer removed");
                    }
                    else{
                        reportOutcome.setText("applicant does not have offer");
                    }

                }
            }
        });

        reportApplicantButton.setOnAction(e -> primaryStage.setScene(reportApplicantScene));

        Button backButton8 = new Button("Back");
        backButton8.setOnAction(e -> primaryStage.setScene(scene5));
        reportApplicantPane.setTop(backButton8);

        //Applicant: review applicant page
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
        reviewApplicantBox.getChildren().addAll(reviewApplicant,chooseIDLabel3,applicantComboBox3, showInfoButton, applicantLabel, applicantIDLabel, applicantYearsLabel, applicantJobBandLabel, applicantPassedLabel, applicantReportLabel);
        reviewApplicantBox.setAlignment(Pos.CENTER);
        reviewApplicantPane.setPadding(new Insets(15, 15, 15, 15));
        reviewApplicantPane.setCenter(reviewApplicantBox);
        Scene reviewApplicantScene = new Scene(reviewApplicantPane, 1024, 640);

        showInfoButton.setOnAction(ActionEvent ->{

            for (int i = 0; i < applicantList.size(); i++) {
                if (applicantComboBox3.getSelectionModel().getSelectedItem() == applicantList.get(i).getID()) {

                    applicantLabel.setText("Applicant info: ");
                    applicantIDLabel.setText("Applicant ID: " + applicantList.get(i).getID());
                    applicantYearsLabel.setText("Years of experience: " + applicantList.get(i).getYearsOfExperience());
                    applicantJobBandLabel.setText("JobBand: " + applicantList.get(i).getBandName());
                    applicantPassedLabel.setText("Passed Job Offering: " + applicantList.get(i).passedApplication());
                    if(!applicantList.get(i).getReport().equals(""))
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

        //Applicant: Review who pass
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
        viewWhoPassBox.getChildren().addAll(ReviewWhoPass,showWhoPassedButtons, passedApplicantsLabel, applicantsWhoPassedListView);
        viewWhoPassPane.setCenter(viewWhoPassBox);
        Scene viewWhoPassScene = new Scene(viewWhoPassPane, 1024, 640);
        showWhoPassedButtons.setMaxSize(409, 64);
        viewWhoPassBox.setAlignment(Pos.CENTER);
        viewWhoPassPane.setPadding(new Insets(15, 15, 15, 15));


        showWhoPassedButtons.setOnAction(ActionEvent -> {
            applicantsWhoPassedListView.getItems().clear();
            passedApplicantsLabel.setText("Applicants who passed: ");
            for(int i = 0; i<applicantList.size(); i++){
                if(applicantList.get(i).passedApplication())
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