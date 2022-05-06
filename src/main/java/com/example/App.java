package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 * FD
 */

public class App extends Application {

    public void start(Stage primaryStage) {

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
        Button DepartmentsButton = new Button("Departments");
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

    }

    public static void main(String[] args) {
        launch();
    }

}