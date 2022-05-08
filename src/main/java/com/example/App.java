package com.example;

import Classes.Applicant;
import Classes.Job;
import Classes.jobBands;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {
    int applicantSelection;

    public void start(Stage primaryStage) {

        // Used for test purposes
        ArrayList<Applicant> applicantList = new ArrayList<Applicant>();
        ArrayList<Job> jobList = new ArrayList<Job>();
        jobList.add(new Job("Program Manager", 1));
        jobList.add(new Job("Product Manager", 1));
        // for (int i = 0; i < 15; i++){
        // applicantList.add(new Applicant(i));
        // }
        jobBands band = new jobBands("project management", 1, jobList);
        applicantList.add(new Applicant(16, 4, band));

        // sign in page
        BorderPane mainPane = new BorderPane();
        VBox singBox = new VBox();
        Button singinButton = new Button("Sign in");
        singinButton.setMaxSize(409, 64);
        VBox.setMargin(singinButton, new Insets(15, 15, 15, 15));
        TextField usernamefield = new TextField();
        usernamefield.setMaxSize(409, 64);
        VBox.setMargin(usernamefield, new Insets(15, 15, 15, 15));
        TextField passwordfield = new TextField();
        passwordfield.setMaxSize(409, 64);
        VBox.setMargin(passwordfield, new Insets(15, 15, 15, 15));
        singBox.getChildren().addAll(usernamefield, passwordfield, singinButton);
        mainPane.setCenter(singBox);
        primaryStage.setScene(new Scene(mainPane, 1024, 640));
        primaryStage.show();

        // employer page
        BorderPane employerPane = new BorderPane();
        VBox emploerBox = new VBox();
        Text EmploerText = new Text("Emploer Page");
        Button bandsButton = new Button("Bands");
        bandsButton.setMaxSize(409, 64);
        VBox.setMargin(bandsButton, new Insets(15, 15, 15, 15));
        Button ApplicantsButton = new Button("Applicants");
        ApplicantsButton.setMaxSize(409, 64);
        VBox.setMargin(ApplicantsButton, new Insets(15, 15, 15, 15));
        Button DepartmentsButton = new Button("Unit");
        DepartmentsButton.setMaxSize(409, 64);
        VBox.setMargin(DepartmentsButton, new Insets(15, 15, 15, 15));
        Scene scene2 = new Scene(employerPane, 1024, 640);
        emploerBox.getChildren().addAll(EmploerText, ApplicantsButton, bandsButton, DepartmentsButton);
        employerPane.setCenter(emploerBox);
        singinButton.setOnAction(e -> primaryStage.setScene(scene2));

        // back to employer page button
        // Button backButton = new Button("Back");
        // backButton.setOnAction(e -> primaryStage.setScene(scene2));

        // bands page
        BorderPane bandsPane = new BorderPane();
        VBox bandsBox = new VBox();
        Text bandsText = new Text("Bands");
        Button addBandButton = new Button("Add band");
        addBandButton.setMaxSize(409, 64);
        VBox.setMargin(addBandButton, new Insets(15, 15, 15, 15));
        Button AssignBandButton = new Button("Assign band");
        AssignBandButton.setMaxSize(409, 64);
        VBox.setMargin(AssignBandButton, new Insets(15, 15, 15, 15));
        Button deleteBandButton = new Button("Delete band");
        deleteBandButton.setMaxSize(409, 64);
        VBox.setMargin(deleteBandButton, new Insets(15, 15, 15, 15));
        Button modifyBandButton = new Button("modify band");
        modifyBandButton.setMaxSize(409, 64);
        VBox.setMargin(modifyBandButton, new Insets(15, 15, 15, 15));
        Scene scene3 = new Scene(bandsPane, 1024, 640);
        bandsBox.getChildren().addAll(bandsText, addBandButton, AssignBandButton, deleteBandButton, modifyBandButton);
        bandsPane.setCenter(bandsBox);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(scene2));

        bandsPane.setTop(backButton);
        bandsButton.setOnAction(e -> primaryStage.setScene(scene3));

        // department page
        BorderPane DepartmentsPane = new BorderPane();
        VBox DepartmentsBox = new VBox();
        Text DepartmentsText = new Text("Departments");
        Button addDepartButton = new Button("Add department");
        addDepartButton.setMaxSize(409, 64);
        VBox.setMargin(addDepartButton, new Insets(15, 15, 15, 15));
        Button deleteDepartButton = new Button("delete department");
        deleteDepartButton.setMaxSize(409, 64);
        VBox.setMargin(deleteDepartButton, new Insets(15, 15, 15, 15));
        Button modifyDepartButton = new Button("modify department");
        modifyDepartButton.setMaxSize(409, 64);
        VBox.setMargin(modifyDepartButton, new Insets(15, 15, 15, 15));
        Button viewDepartButton = new Button("view department details");
        viewDepartButton.setMaxSize(409, 64);
        VBox.setMargin(viewDepartButton, new Insets(15, 15, 15, 15));
        Scene scene4 = new Scene(DepartmentsPane, 1024, 640);
        DepartmentsBox.getChildren().addAll(DepartmentsText, addDepartButton, deleteDepartButton, modifyDepartButton,
                viewDepartButton);
        DepartmentsPane.setCenter(DepartmentsBox);

        Button backButto1 = new Button("Back");
        backButto1.setOnAction(e -> primaryStage.setScene(scene2));

        DepartmentsPane.setTop(backButto1);
        DepartmentsButton.setOnAction(e -> primaryStage.setScene(scene4));

        // Applicants
        BorderPane ApplicantsPane = new BorderPane();
        VBox ApplicantsBox = new VBox();
        Text ApplicantsText = new Text("Applicants");
        Button createJobButton = new Button("Create Job offer");
        createJobButton.setMaxSize(409, 64);
        VBox.setMargin(createJobButton, new Insets(15, 15, 15, 15));
        Button makeInterviewButton = new Button("Make interview appointment");
        makeInterviewButton.setMaxSize(409, 64);
        VBox.setMargin(makeInterviewButton, new Insets(15, 15, 15, 15));
        Button moveApplicantsButton = new Button("Move applicant to offring");
        moveApplicantsButton.setMaxSize(409, 64);
        VBox.setMargin(moveApplicantsButton, new Insets(15, 15, 15, 15));
        Button reportApplicantButton = new Button("Report applicant");
        reportApplicantButton.setMaxSize(409, 64);
        VBox.setMargin(reportApplicantButton, new Insets(15, 15, 15, 15));
        Button reviewApplicantButton = new Button("review applicant");
        reviewApplicantButton.setMaxSize(409, 64);
        VBox.setMargin(reviewApplicantButton, new Insets(15, 15, 15, 15));
        Button viewWhoPassButton = new Button("Review who pass");
        viewWhoPassButton.setMaxSize(409, 64);
        VBox.setMargin(viewWhoPassButton, new Insets(15, 15, 15, 15));
        Button ReviewInterviewResultsButton = new Button("Review interview results");
        ReviewInterviewResultsButton.setMaxSize(409, 64);
        VBox.setMargin(ReviewInterviewResultsButton, new Insets(15, 15, 15, 15));
        Scene scene5 = new Scene(ApplicantsPane, 1024, 640);
        ApplicantsBox.getChildren().addAll(ApplicantsText, createJobButton, makeInterviewButton, moveApplicantsButton,
                reportApplicantButton, reviewApplicantButton, viewWhoPassButton, ReviewInterviewResultsButton);
        ApplicantsPane.setCenter(ApplicantsBox);

        Button backButto2 = new Button("Back");
        backButto2.setOnAction(e -> primaryStage.setScene(scene2));

        ApplicantsPane.setTop(backButto2);
        ApplicantsButton.setOnAction(e -> primaryStage.setScene(scene5));

        // Applicant: Create Job Offer
        BorderPane jobOfferPane = new BorderPane();
        VBox jobOfferBox = new VBox();

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

    }

    public static void main(String[] args) {
        launch();
    }

}