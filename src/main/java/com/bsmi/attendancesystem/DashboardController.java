package com.bsmi.attendancesystem;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.stream.Stream;

public class DashboardController implements Initializable {
    @FXML
    private Button addStudent_btn;

    @FXML
    private DatePicker addStudent_birthDate;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_birthDate;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_course;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_firstName;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_gender;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_lastName;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_semester;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_status;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_studentNum;

    @FXML
    private TextField addStudent_firstName;

    @FXML
    private AnchorPane addStudent_form;

    @FXML
    private ComboBox<String> addStudent_course;

    @FXML
    private ComboBox<String> addStudent_gender;

    @FXML
    private ImageView addStudent_imageView;

    @FXML
    private TextField addStudent_lastName;

    @FXML
    private TextField addStudent_search;

    @FXML
    private ComboBox<String> addStudent_semester;

    @FXML
    private ComboBox<String> addStudent_status;

    @FXML
    private TextField addStudent_studentNum;

    @FXML
    private TableView<StudentData> addStudent_tableView;

    @FXML
    private Button availableCourse_addBtn;

    @FXML
    private Button availableCourse_clearBtn;

    @FXML
    private TableColumn<CourseData, String> availableCourse_col_course;

    @FXML
    private TableColumn<CourseData, String> availableCourse_col_degree;

    @FXML
    private TableColumn<CourseData, String> availableCourse_col_description;

    @FXML
    private TextField availableCourse_course;

    @FXML
    private TextField availableCourse_degree;

    @FXML
    private Button availableCourse_deleteBtn;

    @FXML
    private TextField availableCourse_description;

    @FXML
    private AnchorPane availableCourse_form;

    @FXML
    private TableView<CourseData> availableCourse_tableView;

    @FXML
    private Button availableCourse_updateBtn;

    @FXML
    private Button availableCourses_btn;

    @FXML
    private Button close_btn;

    @FXML
    private Label home_absentToday;

    @FXML
    private LineChart<String, Integer> home_absentTodayChart;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_presentToday;

    @FXML
    private LineChart<String, Integer> home_presentTodayChart;

    @FXML
    private Label home_totalEnrolled;

    @FXML
    private BarChart<?, ?> home_totalEnrolledChart;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize_btn;

    @FXML
    private Button studentAttendance_btn;

    @FXML
    private Button studentAttendance_clearBtn;

    @FXML
    private TableColumn<StudentAttendanceData, String> studentAttendance_col_course;

    @FXML
    private TableColumn<StudentAttendanceData, String> studentAttendance_col_subject;

    @FXML
    private TableColumn<StudentAttendanceData, String> studentAttendance_col_date;

    @FXML
    private TableColumn<StudentAttendanceData, String> studentAttendance_col_status;

    @FXML
    private TableColumn<StudentAttendanceData, String> studentAttendance_col_studentNum;

    @FXML
    private TableColumn<StudentAttendanceData, String> studentAttendance_col_semester;

    @FXML
    private ComboBox<String> studentAttendance_course;

    @FXML
    private ComboBox<String> studentAttendance_subject;

    @FXML
    private AnchorPane studentAttendance_form;

    @FXML
    private Button studentAttendance_markEntryBtn;

    @FXML
    private Button studentAttendance_markExitBtn;

    @FXML
    private TextField studentAttendance_search;

    @FXML
    private ComboBox<String> studentAttendance_semester;

    @FXML
    private ComboBox<String> studentAttendance_studentNum;

    @FXML
    private TableView<StudentAttendanceData> studentAttendance_tableView;

    @FXML
    private Button userManagement_addBtn;

    @FXML
    private Button userManagement_btn;

    @FXML
    private Button userManagement_clearBtn;

    @FXML
    private TableColumn<UserData, Integer> userManagement_col_serialNum;

    @FXML
    private TableColumn<UserData, String> userManagement_col_userRole;

    @FXML
    private TableColumn<UserData, String> userManagement_col_username;

    @FXML
    private TextField userManagement_confirmPassword;

    @FXML
    private Button userManagement_deleteBtn;

    @FXML
    private AnchorPane userManagement_form;

    @FXML
    private TextField userManagement_id;

    @FXML
    private Label userManagement_id_label;

    @FXML
    private TextField userManagement_password;

    @FXML
    private TableView<UserData> userManagement_tableView;

    @FXML
    private Button userManagement_updateBtn;

    @FXML
    private ComboBox<String> userManagement_userRole;

    @FXML
    private TextField userManagement_username;

    @FXML
    private Label username;

    @FXML
    private Button manageSubjects_btn;

    @FXML
    private AnchorPane manageSubjects_form;

    @FXML
    private TextField manageSubjects_subjectName;

    @FXML
    private TextField manageSubjects_description;

    @FXML
    private ComboBox<String> manageSubjects_course;

    @FXML
    private ComboBox<String> manageSubjects_semester;

    @FXML
    private TableColumn<SubjectData, String> manageSubjects_col_semester;

    @FXML
    private ComboBox<String> manageSubjects_teacherUsername;

    @FXML
    private Button manageSubjects_addBtn;

    @FXML
    private Button manageSubjects_updateBtn;

    @FXML
    private Button manageSubjects_deleteBtn;

    @FXML
    private Button manageSubjects_clearBtn;

    @FXML
    private TableView<SubjectData> manageSubjects_tableView;

    @FXML
    private TableColumn<SubjectData, String> manageSubjects_col_subjectName;

    @FXML
    private TableColumn<SubjectData, String> manageSubjects_col_course;

    @FXML
    private TableColumn<SubjectData, String> manageSubjects_col_teacher;

    @FXML
    private TableColumn<SubjectData, String> manageSubjects_col_description;

    private double xOffset = 0;
    private double yOffset = 0;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;
    private final String[] semesterList = {"1st Sem", "2nd Sem", "3rd Sem", "4th Sem", "5th Sem", "6th Sem", "7th Sem", "8th Sem", "Graduated"};
    private final String[] genderList = {"Male", "Female"};
    private final String[] statusList = {"Enrolled", "Graduated", "Dropped Out"};
    private final String[] userRoleList = {"Admin", "Teacher"};

    public void roleChecker() {
        String userRole = GetData.userRole;

        // Only Admin can see User Management button
        userManagement_btn.setVisible(Objects.equals(userRole, "Admin"));

        manageSubjects_btn.setVisible(Objects.equals(userRole, "Admin"));

        // Only Admin can add/edit/delete courses
        if (!Objects.equals(userRole, "Admin")) {
            availableCourse_addBtn.setDisable(true);
            availableCourse_updateBtn.setDisable(true);
            availableCourse_deleteBtn.setDisable(true);

            // Teachers can view courses but not modify
            availableCourse_course.setEditable(false);
            availableCourse_description.setEditable(false);
            availableCourse_degree.setEditable(false);
        }

        // Teachers CAN do these (so we don't disable them):
        // - Mark attendance
        // - View students
        // - Add students
        // - View dashboard
    }

//    START CODE FOR MINIMIZE BUTTON
    @FXML
    public void closeBtnOnAction() {
        System.exit(0);
    }
//    END CODE FOR MINIMIZE BUTTON

//    START CODE FOR MINIMIZE BUTTON
    @FXML
    public void minimizeBtnOnAction() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }
//    END CODE FOR MINIMIZE BUTTON

//    START CODE FOR USERNAME DISPLAY
    public void displayUsername () {
        username.setText(GetData.username);
    }
//    END CODE FOR USERNAME DISPLAY

//    START CODE FOR DEFAULT NAVIGATION
    public void defaultNav () {
        home_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
    }
//    END CODE FOR DEFAULT NAVIGATION

//    START CODE FOR FORM SWITCHING
    public void switchFormOnAction(ActionEvent event){
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            addStudent_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentAttendance_form.setVisible(false);
            userManagement_form.setVisible(false);
            manageSubjects_form.setVisible(false);

            home_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            addStudent_btn.setStyle("-fx-background-color: transparent");
            availableCourses_btn.setStyle("-fx-background-color: transparent");
            studentAttendance_btn.setStyle("-fx-background-color: transparent");
            userManagement_btn.setStyle("-fx-background-color: transparent");

            homeDisplayTotalEnrolledStudents();
            homeDisplayPresentToday();
            homeDisplayAbsentToday();

            homeDisplayTotalEnrolledChart();
            homeDisplayPresentTodayChart();
            homeDisplayAbsentTodayChart();
        } else if (event.getSource() == addStudent_btn) {
            home_form.setVisible(false);
            addStudent_form.setVisible(true);
            availableCourse_form.setVisible(false);
            studentAttendance_form.setVisible(false);
            userManagement_form.setVisible(false);
            manageSubjects_form.setVisible(false);

            home_btn.setStyle("-fx-background-color: transparent");
            addStudent_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            availableCourses_btn.setStyle("-fx-background-color: transparent");
            studentAttendance_btn.setStyle("-fx-background-color: transparent");
            userManagement_btn.setStyle("-fx-background-color: transparent");
            //  TO DISPLAY DATA FROM STUDENT TABLE WHEN ADD STUDENT BUTTON IS CLICKED
            addStudentShowListData();
            addStudent_semesterList();
            addStudent_genderList();
            addStudent_statusList();
            setAddStudent_courseList();
            addStudent_search_onKeyTyped();
        } else if (event.getSource() == availableCourses_btn) {
            home_form.setVisible(false);
            addStudent_form.setVisible(false);
            availableCourse_form.setVisible(true);
            studentAttendance_form.setVisible(false);
            userManagement_form.setVisible(false);
            manageSubjects_form.setVisible(false);

            home_btn.setStyle("-fx-background-color: transparent");
            addStudent_btn.setStyle("-fx-background-color: transparent");
            availableCourses_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            studentAttendance_btn.setStyle("-fx-background-color: transparent");
            userManagement_btn.setStyle("-fx-background-color: transparent");

            availableCourseShowListData();
        } else if (event.getSource() == studentAttendance_btn) {
            home_form.setVisible(false);
            addStudent_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentAttendance_form.setVisible(true);
            userManagement_form.setVisible(false);
            manageSubjects_form.setVisible(false);

            home_btn.setStyle("-fx-background-color: transparent");
            addStudent_btn.setStyle("-fx-background-color: transparent");
            availableCourses_btn.setStyle("-fx-background-color: transparent");
            studentAttendance_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            userManagement_btn.setStyle("-fx-background-color: transparent");

            studentAttendanceShowListData();
            studentAttendanceSemesterList();
            studentAttendanceCourseList();
            studentAttendanceStudentNumList();
            studentAttendanceSearchOnKeyTyped();
        } else if (event.getSource() == userManagement_btn) {
            home_form.setVisible(false);
            addStudent_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentAttendance_form.setVisible(false);
            userManagement_form.setVisible(true);
            manageSubjects_form.setVisible(false);

            home_btn.setStyle("-fx-background-color: transparent");
            addStudent_btn.setStyle("-fx-background-color: transparent");
            availableCourses_btn.setStyle("-fx-background-color: transparent");
            studentAttendance_btn.setStyle("-fx-background-color: transparent");
            userManagement_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");

            userManagementShowListData();
            userManagement_userRoleList();
        }
        else if (event.getSource() == manageSubjects_btn) {
            home_form.setVisible(false);
            addStudent_form.setVisible(false);
            availableCourse_form.setVisible(false);
            studentAttendance_form.setVisible(false);
            userManagement_form.setVisible(false);
            manageSubjects_form.setVisible(true);

            home_btn.setStyle("-fx-background-color: transparent");
            addStudent_btn.setStyle("-fx-background-color: transparent");
            availableCourses_btn.setStyle("-fx-background-color: transparent");
            studentAttendance_btn.setStyle("-fx-background-color: transparent");
            userManagement_btn.setStyle("-fx-background-color: transparent");
            manageSubjects_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d);");

            manageSubjectsShowListData();
            manageSubjects_courseList();
            manageSubjects_teacherList();
        }
    }
//    END CODE FOR FORM SWITCHING

//    START CODE FOR LOGOUT BUTTON
    @FXML
    public void logoutBtnOnAction () {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<javafx.scene.control.ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                logout_btn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("fxml/login-view.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setTitle("Login | Student Management System");
                // Make the window draggable
                root.setOnMousePressed((MouseEvent event) -> {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                });
                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                    stage.setOpacity(.6);
                });

                // Reset opacity on mouse release
                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            }else return;

        }catch (Exception e) {e.printStackTrace();}
    }
//    END CODE FOR LOGOUT BUTTON

//COMBOBOX SET_PROMPT_TEXT ACTIONS ->

    // Method to initialize ComboBoxes with prompt text "Choose" for specific ComboBoxes
    @SafeVarargs
    private void initializeComboBoxes(ComboBox<String>... comboBoxesToSetPrompt) {
        for (ComboBox<String> comboBox : comboBoxesToSetPrompt) {
            setComboBoxPromptText(comboBox);
        }
    }

    // Create a method to set the prompt text for a ComboBox to "Choose"
    private void setComboBoxPromptText(ComboBox<String> comboBox) {
        comboBox.setPromptText("Choose");
        comboBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText("Choose");
                } else {
                    setText(item);
                }
            }
        });
    }

//    START CODE FOR HOME FORM
public void homeDisplayTotalEnrolledStudents() {
    String query;

    if ("Admin".equals(GetData.userRole)) {
        // Admin sees ALL enrolled students
        query = "SELECT COUNT(DISTINCT studentNum) AS enrolledCount FROM student WHERE status = 'Enrolled'";
    } else {
        // Teachers see only students enrolled in THEIR subjects via junction table
        query = "SELECT COUNT(DISTINCT s.studentNum) AS enrolledCount " +
                "FROM student s " +
                "INNER JOIN student_subject_enrollment sse ON s.id = sse.student_id " +
                "INNER JOIN subject sub ON sse.subject_id = sub.id " +
                "WHERE s.status = 'Enrolled' AND sub.teacher_username = ?";
    }

    connect = DatabaseConnection.connectDb();
    try {
        int countEnrolled = 0;
        prepare = connect.prepareStatement(query);

        if (!"Admin".equals(GetData.userRole)) {
            prepare.setString(1, GetData.username);
        }

        result = prepare.executeQuery();
        if (result.next()){
            countEnrolled = result.getInt("enrolledCount");
        }
        home_totalEnrolled.setText(String.valueOf(countEnrolled));

        System.out.println("DEBUG: Enrolled count for " + GetData.username + " = " + countEnrolled); // DEBUG

        result.close();
        prepare.close();
        connect.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void homeDisplayPresentToday() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());

        String query;

        if ("Admin".equals(GetData.userRole)) {
            query = "SELECT COUNT(*) AS presentCount " +
                    "FROM student_attendance " +
                    "WHERE status = 'Present' AND attendance_date = ?";
        } else {
            query = "SELECT COUNT(*) AS presentCount " +
                    "FROM student_attendance sa " +
                    "INNER JOIN subject sub ON sa.subject_id = sub.id " +
                    "WHERE sa.status = 'Present' AND sa.attendance_date = ? AND sub.teacher_username = ?";
        }

        connect = DatabaseConnection.connectDb();
        try {
            int countPresentToday = 0;
            prepare = connect.prepareStatement(query);
            prepare.setString(1, currentDate);

            if (!"Admin".equals(GetData.userRole)) {
                prepare.setString(2, GetData.username);
            }

            result = prepare.executeQuery();
            if (result.next()) {
                countPresentToday = result.getInt("presentCount");
            }
            home_presentToday.setText(String.valueOf(countPresentToday));
            result.close();
            prepare.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void homeDisplayAbsentToday() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());

        String query;

        if ("Admin".equals(GetData.userRole)) {
            query = "SELECT COUNT(*) AS absentCount " +
                    "FROM student_attendance sa " +
                    "INNER JOIN student s ON sa.student_id = s.id " +
                    "WHERE sa.status = 'Absent' AND sa.attendance_date = ? AND s.status = 'Enrolled'";
        } else {
            query = "SELECT COUNT(*) AS absentCount " +
                    "FROM student_attendance sa " +
                    "INNER JOIN student s ON sa.student_id = s.id " +
                    "INNER JOIN subject sub ON sa.subject_id = sub.id " +
                    "WHERE sa.status = 'Absent' AND sa.attendance_date = ? AND sub.teacher_username = ? AND s.status = 'Enrolled'";
        }

        connect = DatabaseConnection.connectDb();
        try {
            int countAbsentToday = 0;
            prepare = connect.prepareStatement(query);
            prepare.setString(1, currentDate);

            if (!"Admin".equals(GetData.userRole)) {
                prepare.setString(2, GetData.username);
            }

            result = prepare.executeQuery();
            if (result.next()) {
                countAbsentToday = result.getInt("absentCount");
            }
            home_absentToday.setText(String.valueOf(countAbsentToday));
            result.close();
            prepare.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void homeDisplayTotalEnrolledChart() {
        home_totalEnrolledChart.getData().clear();

        String query;

        if ("Admin".equals(GetData.userRole)) {
            query = "SELECT DATE(added_on) as enrollment_date, COUNT(DISTINCT studentNum) as count " +
                    "FROM student " +
                    "WHERE status = 'Enrolled' AND added_on IS NOT NULL " +
                    "GROUP BY DATE(added_on) " +
                    "ORDER BY DATE(added_on) DESC " +
                    "LIMIT 7";
        } else {
            // Teachers see only students in THEIR subjects via junction table
            query = "SELECT DATE(s.added_on) as enrollment_date, COUNT(DISTINCT s.studentNum) as count " +
                    "FROM student s " +
                    "INNER JOIN student_subject_enrollment sse ON s.id = sse.student_id " +
                    "INNER JOIN subject sub ON sse.subject_id = sub.id " +
                    "WHERE s.status = 'Enrolled' AND sub.teacher_username = ? AND s.added_on IS NOT NULL " +
                    "GROUP BY DATE(s.added_on) " +
                    "ORDER BY DATE(s.added_on) DESC " +
                    "LIMIT 7";
        }

        connect = DatabaseConnection.connectDb();
        try {
            XYChart.Series chart = new XYChart.Series();
            chart.setName("Enrolled Students");
            prepare = connect.prepareStatement(query);

            if (!"Admin".equals(GetData.userRole)) {
                prepare.setString(1, GetData.username);
            }

            result = prepare.executeQuery();

            boolean hasData = false;
            while (result.next()) {
                hasData = true;
                String date = result.getString("enrollment_date");
                int count = result.getInt("count");
                chart.getData().add(new XYChart.Data(date, count));
                System.out.println("Enrolled Chart - Date: " + date + ", Count: " + count); // DEBUG
            }

            if (hasData) {
                home_totalEnrolledChart.getData().add(chart);
                home_totalEnrolledChart.setLegendVisible(false);
            } else {
                System.out.println("No enrolled student data found for chart - showing zero");
                chart.getData().add(new XYChart.Data(new SimpleDateFormat("yyyy-MM-dd").format(new Date()), 0));
                home_totalEnrolledChart.getData().add(chart);
            }

            result.close();
            prepare.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void homeDisplayPresentTodayChart() {
        home_presentTodayChart.getData().clear();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());

        String sql;

        if ("Admin".equals(GetData.userRole)) {
            // Admin sees all present students
            sql = "SELECT attendance_date, COUNT(DISTINCT student_id) as count " +
                    "FROM student_attendance " +
                    "WHERE attendance_date = CURRENT_DATE AND status = 'Present' " +
                    "GROUP BY attendance_date";
        } else {
            // Teachers see only their subject students
            sql = "SELECT sa.attendance_date, COUNT(DISTINCT sa.student_id) as count " +
                    "FROM student_attendance sa " +
                    "INNER JOIN subject sub ON sa.subject_id = sub.id " +
                    "WHERE sa.attendance_date = CURRENT_DATE AND sa.status = 'Present' AND sub.teacher_username = ? " +
                    "GROUP BY sa.attendance_date";
        }

        connect = DatabaseConnection.connectDb();

        try {
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName("Present Today");

            prepare = connect.prepareStatement(sql);

            if (!"Admin".equals(GetData.userRole)) {
                prepare.setString(1, GetData.username);
            }

            result = prepare.executeQuery();

            boolean hasData = false;
            while (result.next()) {
                hasData = true;
                String date = result.getString("attendance_date");
                int count = result.getInt("count");
                series.getData().add(new XYChart.Data<>(date, count));
                System.out.println("Present Chart - Date: " + date + ", Count: " + count);
            }

            if (!hasData) {
                series.getData().add(new XYChart.Data<>(currentDate, 0));
                System.out.println("Present Chart - No data, showing 0 for today");
            }

            home_presentTodayChart.getData().add(series);
            result.close();
            prepare.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void homeDisplayAbsentTodayChart() {
        home_absentTodayChart.getData().clear();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());

        String sql;

        if ("Admin".equals(GetData.userRole)) {
            sql = "SELECT attendance_date, COUNT(DISTINCT student_id) as count " +
                    "FROM student_attendance " +
                    "WHERE attendance_date = CURRENT_DATE AND status = 'Absent' " +
                    "GROUP BY attendance_date";
        } else {
            sql = "SELECT sa.attendance_date, COUNT(DISTINCT sa.student_id) as count " +
                    "FROM student_attendance sa " +
                    "INNER JOIN subject sub ON sa.subject_id = sub.id " +
                    "WHERE sa.attendance_date = CURRENT_DATE AND sa.status = 'Absent' AND sub.teacher_username = ? " +
                    "GROUP BY sa.attendance_date";
        }

        connect = DatabaseConnection.connectDb();

        try {
            XYChart.Series<String, Integer> absentSeries = new XYChart.Series<>();
            absentSeries.setName("Absent Today");

            prepare = connect.prepareStatement(sql);

            if (!"Admin".equals(GetData.userRole)) {
                prepare.setString(1, GetData.username);
            }

            result = prepare.executeQuery();

            int absentCount = 0;
            if (result.next()) {
                absentCount = result.getInt("count");
            }

            absentSeries.getData().add(new XYChart.Data<>(currentDate, absentCount));
            System.out.println("Absent Chart - Date: " + currentDate + ", Count: " + absentCount);

            home_absentTodayChart.getData().add(absentSeries);

            result.close();
            prepare.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    END CODE FOR HOME FORM

//    START CODE FOR ADD STUDENT FORM
public ObservableList<StudentData> addStudentListData () {
    ObservableList<StudentData> listStudents = FXCollections.observableArrayList();

    String sql;
    if ("Admin".equals(GetData.userRole)) {
        sql = "SELECT * FROM student ORDER BY studentNum";
    } else {
        sql = "SELECT DISTINCT s.* FROM student s " +
                "INNER JOIN student_subject_enrollment sse ON s.id = sse.student_id " +
                "INNER JOIN subject sub ON sse.subject_id = sub.id " +
                "WHERE sub.teacher_username = ? ORDER BY s.studentNum";
    }

    connect = DatabaseConnection.connectDb();
    try {
        StudentData studentD;
        prepare = connect.prepareStatement(sql);

        if (!"Admin".equals(GetData.userRole)) {
            prepare.setString(1, GetData.username);
        }

        result = prepare.executeQuery();
        while (result.next()) {
            studentD = new StudentData(result.getInt("studentNum"),
                    result.getString("semester"),
                    result.getString("course"),
                    result.getString("firstName"),
                    result.getString("lastName"),
                    result.getString("gender"),
                    result.getDate("birthDate"),
                    result.getString("status"),
                    result.getString("image"));
            listStudents.add(studentD);
        }
        result.close();
        prepare.close();
        connect.close();
    }catch (Exception e) {e.printStackTrace();}
    return listStudents;
}
    private ObservableList <StudentData> addStudentListD;
    public void addStudentShowListData () {
        addStudentListD = addStudentListData();

        addStudent_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        addStudent_col_semester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        addStudent_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addStudent_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addStudent_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addStudent_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addStudent_col_birthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        addStudent_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addStudent_tableView.setItems(addStudentListD);
    }
    @FXML
    public void addStudentSelect() {
        StudentData studentD = addStudent_tableView.getSelectionModel().getSelectedItem();
        if (studentD == null) return;

        // Fill text fields immediately (fast)
        addStudent_studentNum.setText(String.valueOf(studentD.getStudentNum()));
        addStudent_firstName.setText(studentD.getFirstName());
        addStudent_lastName.setText(studentD.getLastName());
        addStudent_birthDate.setValue(studentD.getBirthDate().toLocalDate());
        addStudent_semester.getSelectionModel().select(studentD.getSemester());
        addStudent_course.getSelectionModel().select(studentD.getCourse());
        addStudent_gender.getSelectionModel().select(studentD.getGender());
        addStudent_status.getSelectionModel().select(studentD.getStatus());

        // Load image ASYNCHRONOUSLY in background to avoid UI freeze
        String imagePath = studentD.getImage();
        if (imagePath != null && !imagePath.isEmpty()) {
            GetData.path = imagePath;

            // Use JavaFX Platform.runLater for simple async image loading
            new Thread(() -> {
                try {
                    // Load image in background thread
                    Image loadedImage = new Image("file:" + imagePath, 120, 170, false, true);

                    // Update UI on JavaFX thread
                    javafx.application.Platform.runLater(() -> {
                        addStudent_imageView.setImage(loadedImage);
                    });
                } catch (Exception e) {
                    // If image fails to load, just skip it
                    System.err.println("Failed to load image: " + imagePath);
                }
            }).start();
        } else {
            GetData.path = "";
            addStudent_imageView.setImage(null);
        }
    }
    @FXML
    public void addStudent_semesterList() {
        List<String> semesterL = new ArrayList<>();
        for (String data: semesterList) {
            semesterL.add(data);
        }
        ObservableList ObList = FXCollections.observableArrayList(semesterL);
        addStudent_semester.setItems(ObList);
    }
    @FXML
    public void addStudent_genderList(){
        List <String> genderL = new ArrayList<>();
        for (String data: genderList) {
            genderL.add(data);
        }
        ObservableList ObList = FXCollections.observableArrayList(genderL);
        addStudent_gender.setItems(ObList);
    }
    @FXML
    public void addStudent_statusList(){
        List <String> statusL = new ArrayList<>();
        for (String data: statusList) {
            statusL.add(data);
        }
        ObservableList ObList = FXCollections.observableArrayList(statusL);
        addStudent_status.setItems(ObList);
    }
    @FXML
    public void setAddStudent_courseList() {
        String listCourse;

        if ("Admin".equals(GetData.userRole)) {
            // Admin sees ALL courses from the course table
            listCourse = "SELECT DISTINCT course FROM course ORDER BY course";
        } else {
            // Teachers see only courses where they teach subjects
            listCourse = "SELECT DISTINCT course FROM subject WHERE teacher_username = ? ORDER BY course";
        }

        connect = DatabaseConnection.connectDb();
        try {
            ObservableList<String> listC = FXCollections.observableArrayList();
            prepare = connect.prepareStatement(listCourse);

            if (!"Admin".equals(GetData.userRole)) {
                prepare.setString(1, GetData.username);
            }

            result = prepare.executeQuery();
            while (result.next()){
                listC.add(result.getString("course"));
            }
            addStudent_course.setItems(listC);

            System.out.println("Loaded " + listC.size() + " courses for Add Student"); // DEBUG

            result.close();
            prepare.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addStudent_insertBtn_onAction(){
        FileChooser open = new FileChooser();
        open.setTitle("Select Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*jpg", "*png"));
        File file = open.showOpenDialog(main_form.getScene().getWindow());
        if (file != null) {
            image = new Image(file.toURI().toString(), 120, 170, false, true);
            addStudent_imageView.setImage(image);
            GetData.path = file.getAbsolutePath();
        }
    }
    @FXML
    public void addStudent_addBtn_onAction(){
        String insertData = "INSERT INTO student "
                + "(studentNum, semester, course, firstName, lastName, gender, birthDate, status, image, added_on) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if (addStudent_studentNum.getText().isEmpty()
                    || addStudent_semester.getSelectionModel().getSelectedItem() == null
                    || addStudent_course.getSelectionModel().getSelectedItem() == null
                    || addStudent_firstName.getText().isEmpty()
                    || addStudent_lastName.getText().isEmpty()
                    || addStudent_gender.getSelectionModel().getSelectedItem() == null
                    || addStudent_birthDate.getValue() == null
                    || addStudent_status.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Fields cannot be empty");
                alert.showAndWait();
            } else {
                String checkData = "SELECT studentNum FROM student WHERE studentNum = '" + addStudent_studentNum.getText() + "'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);
                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student #" + addStudent_studentNum.getText() + " already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, addStudent_studentNum.getText());
                    prepare.setString(2, (String) addStudent_semester.getSelectionModel().getSelectedItem());
                    prepare.setString(3, (String) addStudent_course.getSelectionModel().getSelectedItem());
                    prepare.setString(4, addStudent_firstName.getText());
                    prepare.setString(5, addStudent_lastName.getText());

                    String selectedGender = (String) addStudent_gender.getSelectionModel().getSelectedItem();
                    prepare.setString(6, selectedGender);
                    prepare.setString(7, String.valueOf(addStudent_birthDate.getValue()));
                    prepare.setString(8, (String) addStudent_status.getSelectionModel().getSelectedItem());

                    String uri = GetData.path;
                    if (uri == null || uri.isEmpty()) {
                        if ("Male".equalsIgnoreCase(selectedGender)) {
                            uri = "src/main/resources/images/avatar-male.png";
                        } else if ("Female".equalsIgnoreCase(selectedGender)) {
                            uri = "src/main/resources/images/avatar-female.png";
                        } else {
                            uri = "src/main/resources/images/avatar-male.png";
                        }
                    }
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(9, uri);

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(10, String.valueOf(sqlDate));
                    prepare.executeUpdate();

                    // Auto-enroll student in all subjects of their course
                    int studentId = -1;
                    String getIdQuery = "SELECT id FROM student WHERE studentNum = ?";
                    PreparedStatement getIdStmt = connect.prepareStatement(getIdQuery);
                    getIdStmt.setString(1, addStudent_studentNum.getText());
                    ResultSet idResult = getIdStmt.executeQuery();
                    if (idResult.next()) {
                        studentId = idResult.getInt("id");
                    }
                    idResult.close();
                    getIdStmt.close();

                    if (studentId != -1) {
                        String enrollQuery = "INSERT INTO student_subject_enrollment (student_id, subject_id) " +
                                "SELECT ?, id FROM subject WHERE course = ?";
                        PreparedStatement enrollStmt = connect.prepareStatement(enrollQuery);
                        enrollStmt.setInt(1, studentId);
                        enrollStmt.setString(2, (String) addStudent_course.getSelectionModel().getSelectedItem());
                        enrollStmt.executeUpdate();
                        enrollStmt.close();
                    }

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added and enrolled in all subjects!");
                    alert.showAndWait();

                    addStudentShowListData();
                    addStudent_clearBtn_onAction();

                    homeDisplayTotalEnrolledStudents();
                    homeDisplayTotalEnrolledChart();
                }
                prepare.close();
                result.close();
                statement.close();
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Error: " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    public void addStudent_updateBtn_onAction() {
        String selectedGender = (String) addStudent_gender.getSelectionModel().getSelectedItem();
        String uri = GetData.path;

        if (uri == null || uri.isEmpty()) {
            if ("Male".equalsIgnoreCase(selectedGender)) {
                uri = "src/main/resources/images/avatar-male.png";
            } else if ("Female".equalsIgnoreCase(selectedGender)) {
                uri = "src/main/resources/images/avatar-female.png";
            } else {
                uri = "src/main/resources/images/avatar-male.png";
            }
        }
        uri = uri.replace("\\", "\\\\");

        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if (addStudent_studentNum.getText().isEmpty()
                    || addStudent_semester.getSelectionModel().getSelectedItem() == null
                    || addStudent_course.getSelectionModel().getSelectedItem() == null
                    || addStudent_firstName.getText().isEmpty()
                    || addStudent_lastName.getText().isEmpty()
                    || addStudent_gender.getSelectionModel().getSelectedItem() == null
                    || addStudent_birthDate.getValue() == null
                    || addStudent_status.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Fields cannot be empty");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to update Student #: " + addStudent_studentNum.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    // Get student ID first
                    int studentId = -1;
                    String getIdQuery = "SELECT id FROM student WHERE studentNum = ?";
                    PreparedStatement getIdStmt = connect.prepareStatement(getIdQuery);
                    getIdStmt.setString(1, addStudent_studentNum.getText());
                    ResultSet idResult = getIdStmt.executeQuery();
                    if (idResult.next()) {
                        studentId = idResult.getInt("id");
                    }
                    idResult.close();
                    getIdStmt.close();

                    // Update student data
                    String updateData = "UPDATE student SET "
                            + "semester = ?, course = ?, firstName = ?, lastName = ?, "
                            + "gender = ?, birthDate = ?, status = ?, image = ? "
                            + "WHERE studentNum = ?";

                    prepare = connect.prepareStatement(updateData);
                    prepare.setString(1, addStudent_semester.getSelectionModel().getSelectedItem());
                    prepare.setString(2, addStudent_course.getSelectionModel().getSelectedItem());
                    prepare.setString(3, addStudent_firstName.getText());
                    prepare.setString(4, addStudent_lastName.getText());
                    prepare.setString(5, selectedGender);
                    prepare.setString(6, String.valueOf(addStudent_birthDate.getValue()));
                    prepare.setString(7, addStudent_status.getSelectionModel().getSelectedItem());
                    prepare.setString(8, uri);
                    prepare.setString(9, addStudent_studentNum.getText());
                    prepare.executeUpdate();
                    prepare.close();

                    // 🔥 FIX: ALWAYS re-enroll in ALL subjects for the new semester/course
                    if (studentId != -1) {
                        // Delete ALL old enrollments
                        String deleteOldEnrollments = "DELETE FROM student_subject_enrollment WHERE student_id = ?";
                        PreparedStatement deleteStmt = connect.prepareStatement(deleteOldEnrollments);
                        deleteStmt.setInt(1, studentId);
                        deleteStmt.executeUpdate();
                        deleteStmt.close();

                        // Re-enroll in ALL subjects matching the new semester AND course
                        String enrollQuery = "INSERT INTO student_subject_enrollment (student_id, subject_id) " +
                                "SELECT ?, id FROM subject WHERE course = ? AND semester = ?";
                        PreparedStatement enrollStmt = connect.prepareStatement(enrollQuery);
                        enrollStmt.setInt(1, studentId);
                        enrollStmt.setString(2, addStudent_course.getSelectionModel().getSelectedItem());
                        enrollStmt.setString(3, addStudent_semester.getSelectionModel().getSelectedItem());
                        enrollStmt.executeUpdate();
                        enrollStmt.close();
                    }

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated and Re-enrolled in ALL subjects!");
                    alert.showAndWait();

                    addStudentShowListData();
                    addStudent_clearBtn_onAction();

                    homeDisplayTotalEnrolledStudents();
                    homeDisplayTotalEnrolledChart();
                } else return;
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Error: " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    public void addStudent_deleteBtn_onAction () {
        String deleteData = "DELETE FROM student WHERE studentNum = '" + addStudent_studentNum.getText() + "'";
        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if (addStudent_studentNum.getText().isEmpty()
                    || addStudent_semester.getSelectionModel().getSelectedItem() == null
                    || addStudent_course.getSelectionModel().getSelectedItem() == null
                    || addStudent_firstName.getText().isEmpty()
                    || addStudent_lastName.getText().isEmpty()
                    || addStudent_gender.getSelectionModel().getSelectedItem() == null
                    || addStudent_birthDate.getValue() == null
                    || addStudent_status.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Fields cannot be empty");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete Student #: " + addStudent_studentNum.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    addStudentShowListData();
                    addStudent_clearBtn_onAction();

                    homeDisplayTotalEnrolledStudents();
                    homeDisplayTotalEnrolledChart();
                } else return;
                statement.close();
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Error: " + e.getMessage());
            errorAlert.showAndWait();
        }
    }



    @FXML
    public void addStudent_clearBtn_onAction () {
        addStudent_studentNum.setText("");
        addStudent_semester.getSelectionModel().clearSelection();
        addStudent_course.getSelectionModel().clearSelection();
        addStudent_firstName.setText("");
        addStudent_lastName.setText("");
        addStudent_gender.getSelectionModel().clearSelection();
        addStudent_birthDate.setValue(null);
        addStudent_status.getSelectionModel().clearSelection();
        addStudent_imageView.setImage(null);
        GetData.path = "";
        initializeComboBoxes(addStudent_semester, addStudent_course, addStudent_gender, addStudent_status);
    }
    @FXML
    public void addStudent_search_onKeyTyped() {
        // Assuming addStudentListD is a properly populated ObservableList<StudentData>
        FilteredList<StudentData> filter = new FilteredList<>(addStudentListD, e -> true);

        // Assuming addStudent_search is your TextField for searching
        addStudent_search.textProperty().addListener((Observable, oldValue, newValue) -> {
            filter.setPredicate(predicateStudentData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                // You can simplify the conditions using a stream and anyMatch
                return Stream.of(
                        predicateStudentData.getStudentNum().toString(),
                        predicateStudentData.getSemester(),
                        predicateStudentData.getCourse(),
                        predicateStudentData.getFirstName(),
                        predicateStudentData.getLastName(),
                        predicateStudentData.getGender(),
                        predicateStudentData.getBirthDate().toString(),
                        predicateStudentData.getStatus()
                ).anyMatch(data -> data.toLowerCase().contains(searchKey));
            });
        });

        SortedList<StudentData> sortList = new SortedList<>(filter);

        // Assuming addStudent_tableView is your TableView
        sortList.comparatorProperty().bind(addStudent_tableView.comparatorProperty());
        addStudent_tableView.setItems(sortList);
    }
//    END CODE FOR ADD STUDENT FORM

//    START CODE FOR AVAILABLE COURSES FORM
    public ObservableList <CourseData> availableCourseListData(){
        ObservableList <CourseData> listCourses = FXCollections.observableArrayList();
        String sql = "SELECT * FROM course";
        try {
            CourseData courseD;
            connect = DatabaseConnection.connectDb();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()){
                courseD = new CourseData(result.getString("course"),
                        result.getString("description"),
                        result.getString("degree"));
                listCourses.add(courseD);
            }
            result.close();
            prepare.close();
            connect.close();
        }catch (Exception e) {e.printStackTrace();}
        return listCourses;
    }
    private ObservableList <CourseData> availableCourseList;
    public void availableCourseShowListData () {
        availableCourseList = availableCourseListData();

        availableCourse_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        availableCourse_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        availableCourse_col_degree.setCellValueFactory(new PropertyValueFactory<>("degree"));

        availableCourse_tableView.setItems(availableCourseList);
    }
    @FXML
    public void availableCourseSelect () {
        CourseData courseD = availableCourse_tableView.getSelectionModel().getSelectedItem();
        int num = availableCourse_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1 ) < - 1) {return;}
        availableCourse_course.setText(courseD.getCourse());
        availableCourse_description.setText(courseD.getDescription());
        availableCourse_degree.setText(courseD.getDegree());
    }
    @FXML
    public void availableCourse_addBtn_onAction () {
        String insertData = "INSERT INTO course (course, description, degree) VALUES (?, ?, ?)";
        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if (availableCourse_course.getText().isEmpty() || availableCourse_description.getText().isEmpty() || availableCourse_degree.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Fields cannot be empty");
                alert.showAndWait();
            } else {
                String checkData = "SELECT course FROM course WHERE course = '" + availableCourse_course.getText() + "'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);
                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Course: " + availableCourse_course.getText() + " already exists!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, availableCourse_course.getText());
                    prepare.setString(2, availableCourse_description.getText());
                    prepare.setString(3, availableCourse_degree.getText());
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    //  TO LOAD THE UPDATED TABLE AFTER OPERATION
                    availableCourseShowListData();
                    //  TO CLEAR THE TEXT FIELDS
                    availableCourse_clearBtn_onAction();
                }
                prepare.close();
                result.close();
                statement.close();
            }
            connect.close();
        }catch (Exception e) {e.printStackTrace();}
    }
    @FXML
    public void availableCourse_updateBtn_onAction () {
        String updateData = "UPDATE course SET description = '"
                + availableCourse_description.getText() + "', degree = '"
                + availableCourse_degree.getText() + "' WHERE course = '"
                + availableCourse_course.getText() + "'";
        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if (availableCourse_course.getText().isEmpty() || availableCourse_description.getText().isEmpty() || availableCourse_degree.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Fields cannot be empty");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to update Course: " + availableCourse_course.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                    //  TO LOAD THE UPDATED TABLE AFTER OPERATION
                    availableCourseShowListData();
                    //  TO CLEAR THE TEXT FIELDS
                    availableCourse_clearBtn_onAction();
                } else return;
                statement.close();
            }
            connect.close();
        } catch (Exception e) {e.printStackTrace();}
    }
    @FXML
    public void availableCourse_clearBtn_onAction () {
        availableCourse_course.setText("");
        availableCourse_description.setText("");
        availableCourse_degree.setText("");
    }
    @FXML
    public void availableCourse_deleteBtn_onAction() {
        String deleteData = "DELETE FROM course WHERE course = '"
                + availableCourse_course.getText() +"'";
        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if (availableCourse_course.getText().isEmpty()
                    || availableCourse_description.getText().isEmpty()
                    || availableCourse_degree.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Fields cannot be empty");
                alert.showAndWait();
            } else {
                // 🔥 NEW: Check if course has students or subjects
                String checkStudents = "SELECT COUNT(*) as count FROM student WHERE course = ?";
                PreparedStatement checkStmt = connect.prepareStatement(checkStudents);
                checkStmt.setString(1, availableCourse_course.getText());
                ResultSet checkResult = checkStmt.executeQuery();

                int studentCount = 0;
                if (checkResult.next()) {
                    studentCount = checkResult.getInt("count");
                }
                checkResult.close();
                checkStmt.close();

                String checkSubjects = "SELECT COUNT(*) as count FROM subject WHERE course = ?";
                checkStmt = connect.prepareStatement(checkSubjects);
                checkStmt.setString(1, availableCourse_course.getText());
                checkResult = checkStmt.executeQuery();

                int subjectCount = 0;
                if (checkResult.next()) {
                    subjectCount = checkResult.getInt("count");
                }
                checkResult.close();
                checkStmt.close();

                if (studentCount > 0 || subjectCount > 0) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cannot delete! This course has " + studentCount +
                            " students and " + subjectCount + " subjects.\n" +
                            "Remove them first.");
                    alert.showAndWait();
                    connect.close();
                    return;
                }

                // Original confirmation dialog
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete Course: " + availableCourse_course.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    availableCourseShowListData();
                    availableCourse_clearBtn_onAction();
                } else return;
                statement.close();
            }
            connect.close();
        } catch (Exception e) {e.printStackTrace();}
    }
//    END CODE FOR AVAILABLE COURSES FORM

//    START CODE FOR STUDENT ATTENDANCE FORM
public ObservableList<StudentAttendanceData> studentAttendanceListData(){
    ObservableList<StudentAttendanceData> listStudentAttendance = FXCollections.observableArrayList();

    String query;

    if ("Admin".equals(GetData.userRole)) {
        query = "SELECT student.studentNum, student.semester, student.course, subject.subject_name, " +
                "       student_attendance.attendance_date, student_attendance.status " +
                "FROM student_attendance " +
                "INNER JOIN student ON student_attendance.student_id = student.id " +
                "INNER JOIN subject ON student_attendance.subject_id = subject.id " +
                "WHERE student_attendance.attendance_date = CURRENT_DATE() " +
                "ORDER BY student.studentNum";
    } else {
        query = "SELECT student.studentNum, student.semester, student.course, subject.subject_name, " +
                "       student_attendance.attendance_date, student_attendance.status " +
                "FROM student_attendance " +
                "INNER JOIN student ON student_attendance.student_id = student.id " +
                "INNER JOIN subject ON student_attendance.subject_id = subject.id " +
                "WHERE student_attendance.attendance_date = CURRENT_DATE() AND subject.teacher_username = ? " +
                "ORDER BY student.studentNum";
    }

    connect = DatabaseConnection.connectDb();
    if (connect != null) {
        try {
            StudentAttendanceData record;
            prepare = connect.prepareStatement(query);

            if (!"Admin".equals(GetData.userRole)) {
                prepare.setString(1, GetData.username);
            }

            result = prepare.executeQuery();
            while (result.next()) {
                record = new StudentAttendanceData(
                        result.getString("studentNum"),
                        result.getString("semester"),
                        result.getString("course"),
                        result.getString("subject_name"),
                        result.getDate("attendance_date").toString(),
                        result.getString("status")
                );
                listStudentAttendance.add(record);
            }
            result.close();
            prepare.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return listStudentAttendance;
}
    private ObservableList<StudentAttendanceData> observableAttendanceData;

    @FXML
    public void studentAttendanceShowListData(){
        observableAttendanceData = studentAttendanceListData();  // Pass null for today

        studentAttendance_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        studentAttendance_col_semester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        studentAttendance_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        studentAttendance_col_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        studentAttendance_col_date.setCellValueFactory(new PropertyValueFactory<>("attendanceDate"));  // ✅ Changed
        studentAttendance_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        studentAttendance_tableView.setItems(observableAttendanceData);

    }

    @FXML
    public void studentAttendanceSemesterList(){
        List<String> semesterL = new ArrayList<>();
        for (String data: semesterList){
            semesterL.add(data);
        }
        ObservableList<String> ObList = FXCollections.observableArrayList(semesterL);
        studentAttendance_semester.setItems(ObList);

    }

    @FXML
    public void studentAttendanceCourseList(){
        String selectedSemester = studentAttendance_semester.getSelectionModel().getSelectedItem();
        if (selectedSemester == null) return;

        connect = DatabaseConnection.connectDb();
        if (connect != null){
            try {
                String query;
                if ("Admin".equals(GetData.userRole)) {
                    query = "SELECT DISTINCT s.course FROM student s " +
                            "WHERE s.semester = ? AND s.status = 'Enrolled' ORDER BY s.course";
                } else {
                    query = "SELECT DISTINCT s.course FROM student s " +
                            "INNER JOIN student_subject_enrollment sse ON s.id = sse.student_id " +
                            "INNER JOIN subject sub ON sse.subject_id = sub.id " +
                            "WHERE s.semester = ? AND s.status = 'Enrolled' AND sub.teacher_username = ? " +
                            "ORDER BY s.course";
                }

                prepare = connect.prepareStatement(query);
                prepare.setString(1, selectedSemester);
                if (!"Admin".equals(GetData.userRole)) {
                    prepare.setString(2, GetData.username);
                }

                result = prepare.executeQuery();
                ObservableList<String> courseList = FXCollections.observableArrayList();
                while (result.next()){
                    courseList.add(result.getString("course"));
                }
                studentAttendance_course.setItems(courseList);
                System.out.println("Loaded " + courseList.size() + " courses");
                result.close();
                prepare.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void studentAttendanceSubjectList(){
        String selectedSemester = studentAttendance_semester.getSelectionModel().getSelectedItem();
        String selectedCourse = studentAttendance_course.getSelectionModel().getSelectedItem();
        if (selectedSemester == null || selectedCourse == null) return;

        connect = DatabaseConnection.connectDb();
        if (connect != null){
            try {
                String query;
                if ("Admin".equals(GetData.userRole)) {
                    query = "SELECT DISTINCT sub.subject_name FROM subject sub " +
                            "INNER JOIN student_subject_enrollment sse ON sub.id = sse.subject_id " +
                            "INNER JOIN student s ON sse.student_id = s.id " +
                            "WHERE s.semester = ? AND s.course = ? AND s.status = 'Enrolled' " +
                            "ORDER BY sub.subject_name";
                } else {
                    query = "SELECT DISTINCT sub.subject_name FROM subject sub " +
                            "INNER JOIN student_subject_enrollment sse ON sub.id = sse.subject_id " +
                            "INNER JOIN student s ON sse.student_id = s.id " +
                            "WHERE s.semester = ? AND s.course = ? AND s.status = 'Enrolled' " +
                            "AND sub.teacher_username = ? ORDER BY sub.subject_name";
                }

                prepare = connect.prepareStatement(query);
                prepare.setString(1, selectedSemester);
                prepare.setString(2, selectedCourse);
                if (!"Admin".equals(GetData.userRole)) {
                    prepare.setString(3, GetData.username);
                }

                result = prepare.executeQuery();
                ObservableList<String> subjectList = FXCollections.observableArrayList();
                while (result.next()){
                    subjectList.add(result.getString("subject_name"));
                }
                studentAttendance_subject.setItems(subjectList);
                System.out.println("Loaded " + subjectList.size() + " subjects");
                result.close();
                prepare.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /* NEW METHOD: Auto-load ALL students when semester and course are selected
    @FXML
    public void studentAttendanceLoadAllStudents(){
        String selectedSemester = studentAttendance_semester.getSelectionModel().getSelectedItem();
        String selectedCourse = studentAttendance_course.getSelectionModel().getSelectedItem();
        String selectedSubject = studentAttendance_subject.getSelectionModel().getSelectedItem();

        if (selectedSemester == null || selectedCourse == null || selectedSubject == null) {
            return;
        }

        connect = DatabaseConnection.connectDb();
        if (connect != null) {
            try {
                String query = "SELECT DISTINCT studentNum FROM student WHERE semester = ? AND course = ? AND subject = ? AND status = 'Enrolled' ORDER BY studentNum";
                prepare = connect.prepareStatement(query);
                prepare.setString(1, selectedSemester);
                prepare.setString(2, selectedCourse);
                prepare.setString(3, selectedSubject);

                result = prepare.executeQuery();
                ObservableList<String> studentNumList = FXCollections.observableArrayList();
                while (result.next()) {
                    String studentNum = result.getString("studentNum");
                    studentNumList.add(studentNum);
                }
                studentAttendance_studentNum.setItems(studentNumList);

                /* // Show info to user
                if (studentNumList.size() > 0) {
                    System.out.println("Loaded " + studentNumList.size() + " students");
                } */

              /*  result.close();
                prepare.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } */

    @FXML
    public void studentAttendanceStudentNumList(){
        String selectedSemester = studentAttendance_semester.getSelectionModel().getSelectedItem();
        String selectedCourse = studentAttendance_course.getSelectionModel().getSelectedItem();
        String selectedSubject = studentAttendance_subject.getSelectionModel().getSelectedItem();
        if (selectedSemester == null || selectedCourse == null || selectedSubject == null) return;

        connect = DatabaseConnection.connectDb();
        if (connect != null) {
            try {
                String query = "SELECT DISTINCT s.studentNum FROM student s " +
                        "INNER JOIN student_subject_enrollment sse ON s.id = sse.student_id " +
                        "INNER JOIN subject sub ON sse.subject_id = sub.id " +
                        "WHERE s.semester = ? AND s.course = ? AND sub.subject_name = ? AND s.status = 'Enrolled' " +
                        "ORDER BY s.studentNum";

                prepare = connect.prepareStatement(query);
                prepare.setString(1, selectedSemester);
                prepare.setString(2, selectedCourse);
                prepare.setString(3, selectedSubject);

                result = prepare.executeQuery();
                ObservableList<String> studentNumList = FXCollections.observableArrayList();
                while (result.next()) {
                    studentNumList.add(result.getString("studentNum"));
                }
                studentAttendance_studentNum.setItems(studentNumList);
                System.out.println("Loaded " + studentNumList.size() + " students");
                result.close();
                prepare.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // Method to fetch student_id based on studentNum, semester, and course
    private int fetchStudentId(String studentNum, String semester, String course, String subject) {
        int studentId = -1;
        Connection tempConnect = null;
        PreparedStatement tempPrepare = null;
        ResultSet tempResult = null;

        try {
            tempConnect = DatabaseConnection.connectDb();
            if (tempConnect != null) {
                String query = "SELECT s.id FROM student s " +
                        "INNER JOIN student_subject_enrollment sse ON s.id = sse.student_id " +
                        "INNER JOIN subject sub ON sse.subject_id = sub.id " +
                        "WHERE s.studentNum = ? AND s.semester = ? AND s.course = ? AND sub.subject_name = ?";
                tempPrepare = tempConnect.prepareStatement(query);
                tempPrepare.setString(1, studentNum);
                tempPrepare.setString(2, semester);
                tempPrepare.setString(3, course);
                tempPrepare.setString(4, subject);

                tempResult = tempPrepare.executeQuery();
                if (tempResult.next()) {
                    studentId = tempResult.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (tempResult != null) tempResult.close();
                if (tempPrepare != null) tempPrepare.close();
                if (tempConnect != null) tempConnect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentId;
    }
    // Method to fetch course_id based on course
    private int fetchCourseId(String course) {
        int courseId = -1;
        Connection tempConnect = null;
        PreparedStatement tempPrepare = null;
        ResultSet tempResult = null;

        try {
            tempConnect = DatabaseConnection.connectDb();
            if (tempConnect != null) {
                String query = "SELECT id FROM course WHERE course = ?";
                tempPrepare = tempConnect.prepareStatement(query);
                tempPrepare.setString(1, course);

                tempResult = tempPrepare.executeQuery();

                if (tempResult.next()) {
                    courseId = tempResult.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (tempResult != null) tempResult.close();
                if (tempPrepare != null) tempPrepare.close();
                if (tempConnect != null) tempConnect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return courseId;
    }

    // Method to fetch subject_id based on subject name and course
    private int fetchSubjectId(String subjectName, String course) {
        int subjectId = -1;
        Connection tempConnect = null;
        PreparedStatement tempPrepare = null;
        ResultSet tempResult = null;

        try {
            tempConnect = DatabaseConnection.connectDb();
            if (tempConnect != null) {
                String query = "SELECT id FROM subject WHERE subject_name = ? AND course = ?";
                tempPrepare = tempConnect.prepareStatement(query);
                tempPrepare.setString(1, subjectName);
                tempPrepare.setString(2, course);

                tempResult = tempPrepare.executeQuery();

                if (tempResult.next()) {
                    subjectId = tempResult.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (tempResult != null) tempResult.close();
                if (tempPrepare != null) tempPrepare.close();
                if (tempConnect != null) tempConnect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return subjectId;
    }

    // Mark Present
    @FXML
    public void studentAttendanceMarkPresentBtnOnAction() {
        String selectedStudentNum = studentAttendance_studentNum.getValue();
        String selectedSemester = studentAttendance_semester.getValue();
        String selectedCourse = studentAttendance_course.getValue();
        String selectedSubject = studentAttendance_subject.getValue();

        if (selectedStudentNum == null || selectedSemester == null || selectedCourse == null || selectedSubject == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select Semester, Course, Subject and Student Number");
            alert.showAndWait();
            return;
        }

        Connection tempConnect = null;
        PreparedStatement tempPrepare = null;
        ResultSet tempResult = null;

        try {
            tempConnect = DatabaseConnection.connectDb();
            if (tempConnect == null) {
                throw new SQLException("Could not connect to database");
            }

            int studentId = fetchStudentId(selectedStudentNum, selectedSemester, selectedCourse, selectedSubject);
            int subjectId = fetchSubjectId(selectedSubject, selectedCourse);
            int courseId = fetchCourseId(selectedCourse);

            if (studentId == -1 || subjectId == -1 || courseId == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Could not find student, subject or course in database");
                alert.showAndWait();
                return;
            }

            // Check if attendance already marked today
            String checkQuery = "SELECT * FROM student_attendance WHERE student_id = ? AND subject_id = ? AND attendance_date = CURRENT_DATE";
            tempPrepare = tempConnect.prepareStatement(checkQuery);
            tempPrepare.setInt(1, studentId);
            tempPrepare.setInt(2, subjectId);
            tempResult = tempPrepare.executeQuery();

            if (tempResult.next()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Attendance already marked for Roll No " + selectedStudentNum + " today!");
                alert.showAndWait();
                return;
            }
            tempResult.close();
            tempPrepare.close();

            // Insert new attendance record
            String insertQuery = "INSERT INTO student_attendance (student_id, course_id, subject_id, attendance_date, status) VALUES (?, ?, ?, CURRENT_DATE, 'Present')";
            tempPrepare = tempConnect.prepareStatement(insertQuery);
            tempPrepare.setInt(1, studentId);
            tempPrepare.setInt(2, courseId);
            tempPrepare.setInt(3, subjectId);

            tempPrepare.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Roll No " + selectedStudentNum + " marked PRESENT!");
            successAlert.showAndWait();

            studentAttendanceShowListData();

            // Refresh home stats
            homeDisplayPresentToday();
            homeDisplayPresentTodayChart();

            // Auto-select next student
            int currentIndex = studentAttendance_studentNum.getSelectionModel().getSelectedIndex();
            if (currentIndex < studentAttendance_studentNum.getItems().size() - 1) {
                studentAttendance_studentNum.getSelectionModel().select(currentIndex + 1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Database error: " + e.getMessage());
            errorAlert.showAndWait();
        } finally {
            try {
                if (tempResult != null) tempResult.close();
                if (tempPrepare != null) tempPrepare.close();
                if (tempConnect != null) tempConnect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void studentAttendanceMarkAbsentBtnOnAction() {
        String selectedStudentNum = studentAttendance_studentNum.getValue();
        String selectedSemester = studentAttendance_semester.getValue();
        String selectedCourse = studentAttendance_course.getValue();
        String selectedSubject = studentAttendance_subject.getValue();

        if (selectedStudentNum == null || selectedSemester == null || selectedCourse == null || selectedSubject == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select Semester, Course, Subject and Student Number");
            alert.showAndWait();
            return;
        }

        Connection tempConnect = null;
        PreparedStatement tempPrepare = null;
        ResultSet tempResult = null;

        try {
            tempConnect = DatabaseConnection.connectDb();
            if (tempConnect == null) {
                throw new SQLException("Could not connect to database");
            }

            int studentId = fetchStudentId(selectedStudentNum, selectedSemester, selectedCourse, selectedSubject);
            int subjectId = fetchSubjectId(selectedSubject, selectedCourse);
            int courseId = fetchCourseId(selectedCourse);

            if (studentId == -1 || subjectId == -1 || courseId == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Could not find student, subject or course in database");
                alert.showAndWait();
                return;
            }

            // Check if attendance already marked today
            String checkQuery = "SELECT * FROM student_attendance WHERE student_id = ? AND subject_id = ? AND attendance_date = CURRENT_DATE";
            tempPrepare = tempConnect.prepareStatement(checkQuery);
            tempPrepare.setInt(1, studentId);
            tempPrepare.setInt(2, subjectId);
            tempResult = tempPrepare.executeQuery();

            if (tempResult.next()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Attendance already marked for Student #" + selectedStudentNum + " today!");
                alert.showAndWait();
                return;
            }
            tempResult.close();
            tempPrepare.close();

            // Insert absent record
            String insertQuery = "INSERT INTO student_attendance (student_id, course_id, subject_id, attendance_date, status) VALUES (?, ?, ?, CURRENT_DATE, 'Absent')";
            tempPrepare = tempConnect.prepareStatement(insertQuery);
            tempPrepare.setInt(1, studentId);
            tempPrepare.setInt(2, courseId);
            tempPrepare.setInt(3, subjectId);

            tempPrepare.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Student #" + selectedStudentNum + " marked ABSENT!");
            successAlert.showAndWait();

            studentAttendanceShowListData();

            // Refresh home stats
            homeDisplayAbsentToday();
            homeDisplayAbsentTodayChart();

            // Auto-select next student
            int currentIndex = studentAttendance_studentNum.getSelectionModel().getSelectedIndex();
            if (currentIndex < studentAttendance_studentNum.getItems().size() - 1) {
                studentAttendance_studentNum.getSelectionModel().select(currentIndex + 1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Database error: " + e.getMessage());
            errorAlert.showAndWait();
        } finally {
            try {
                if (tempResult != null) tempResult.close();
                if (tempPrepare != null) tempPrepare.close();
                if (tempConnect != null) tempConnect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void studentAttendanceClearBtnOnAction() {
        studentAttendance_semester.getSelectionModel().clearSelection();
        studentAttendance_course.getSelectionModel().clearSelection();
        studentAttendance_subject.getSelectionModel().clearSelection();
        studentAttendance_studentNum.getSelectionModel().clearSelection();
        studentAttendance_studentNum.getItems().clear();

        initializeComboBoxes(studentAttendance_semester, studentAttendance_course, studentAttendance_subject, studentAttendance_studentNum);
    }

    @FXML
    public void studentAttendanceSearchOnKeyTyped() {
        // Assuming observableAttendanceData is a properly populated ObservableList<StudentAttendanceData>
        FilteredList<StudentAttendanceData> filter = new FilteredList<>(observableAttendanceData, e -> true);

        // Assuming addStudent_search is your TextField for searching
        studentAttendance_search.textProperty().addListener((Observable, oldValue, newValue) -> {
            filter.setPredicate(predicateStudentData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                // You can simplify the conditions using a stream and anyMatch
                return Stream.of(
                        predicateStudentData.getStudentNum().toString(),
                        predicateStudentData.getSemester(),
                        predicateStudentData.getCourse(),
                        predicateStudentData.getAttendanceDate(),
                        //predicateStudentData.getExitTime(),
                        predicateStudentData.getStatus()
                ).anyMatch(data -> data.toLowerCase().contains(searchKey));
            });
        });

        SortedList<StudentAttendanceData> sortList = new SortedList<>(filter);

        // Assuming studentAttendance_tableView is your TableView
        sortList.comparatorProperty().bind(studentAttendance_tableView.comparatorProperty());
        studentAttendance_tableView.setItems(sortList);
    }
//    END CODE FOR STUDENT ATTENDANCE FORM

//    START MANAGE USERS FORM
    public ObservableList<UserData> userManagementListData () {
    ObservableList<UserData> listUsers = FXCollections.observableArrayList();
    String sql = "SELECT * FROM admin";
    connect = DatabaseConnection.connectDb();
    if (connect != null) {
        try {
            UserData record;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                record = new UserData(result.getInt("id"),
                        result.getString("username"),
                        result.getString("user_role"));
                listUsers.add(record);
            }
            result.close();
            prepare.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return listUsers;
}
    private ObservableList <UserData> observableUserManagementData;
    public void userManagementShowListData () {
        observableUserManagementData = userManagementListData();

        userManagement_col_serialNum.setCellValueFactory(cellData -> {
            int index = observableUserManagementData.indexOf(cellData.getValue()) + 1;
            return new SimpleIntegerProperty(index).asObject();
        });
        userManagement_col_username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        userManagement_col_userRole.setCellValueFactory(new PropertyValueFactory<>("userRole"));

        userManagement_tableView.setItems(observableUserManagementData);
    }
    @FXML
    public void userManagementSelect() {
        // Get the selected item from the TableView
        UserData selectedUser = userManagement_tableView.getSelectionModel().getSelectedItem();

        if (selectedUser != null) {
            // Set the selected data to the input fields
            userManagement_id.setText(String.valueOf(selectedUser.getUserId()));
            userManagement_username.setText(selectedUser.getUserName());
            userManagement_userRole.getSelectionModel().select(selectedUser.getUserRole());
        }
    }

    @FXML
    public void userManagement_userRoleList() {
        List<String> userRoleL = new ArrayList<>();
        Collections.addAll(userRoleL, userRoleList);
        ObservableList<String> ObList = FXCollections.observableArrayList(userRoleL);
        userManagement_userRole.setItems(ObList);
    }
    @FXML
    public void userManagementAddBtn_onAction() {
        if (!Objects.equals(GetData.userRole, "Admin")) {
            showAlert(Alert.AlertType.WARNING, "Access Denied",
                    "Only Admins can perform this action.");
            return;
        }
        String username = userManagement_username.getText();
        String password = userManagement_password.getText();
        String confirmPassword = userManagement_confirmPassword.getText();
        String userRole = userManagement_userRole.getValue();

        if (Objects.equals(username, "") || Objects.equals(password, "") || Objects.equals(confirmPassword, "") || userRole == null) {
            showAlert(Alert.AlertType.ERROR, "Error Message", "Fields cannot be empty");
            return; // Exit the method if empty
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Error Message", "Passwords do not match!");
            return; // Exit the method if passwords don't match
        }

        // Check if password is shorter than 8 characters and consists only of lowercase letters
        if (password.length() < 8 || password.matches("^[a-z]+$")) {
            showAlert(Alert.AlertType.ERROR, "Error Message", "Password must be at least 8 characters long and contain both uppercase and lowercase letters.");
            return; // Exit the method if password criteria are not met
        }

        String hashedPassword = hashPassword(password);

        // Insert the data into the database
        String query = "INSERT INTO admin (username, password_hash, user_role) VALUES (?, ?, ?)";
        connect = DatabaseConnection.connectDb();

        try {
            // Check if the user already exists
            String checkData = "SELECT username FROM admin WHERE username = ?";
            assert connect != null;
            PreparedStatement checkStatement = connect.prepareStatement(checkData);
            checkStatement.setString(1, username);
            ResultSet result = checkStatement.executeQuery();
            if (result.next()) {
                showAlert(Alert.AlertType.ERROR, "Error Message", "User '" + username + "' already exists!");
                return; // Exit if user already exists
            }
            checkStatement.close();

            // Insert the new user
            prepare = connect.prepareStatement(query);
            prepare.setString(1, username);
            prepare.setString(2, hashedPassword);
            prepare.setString(3, userRole);
            prepare.executeUpdate();

            showAlert(Alert.AlertType.INFORMATION, "Information Message", "User added successfully!");

            userManagementShowListData();
            // Clear the fields if needed
            userManagementClearBtn_onAction();

            prepare.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database-related exceptions
        }
    }
    private int fetchUserId(String username) {
        int userId = -1;
        connect = DatabaseConnection.connectDb();
        if (connect != null) {
            try {
                String query = "SELECT id FROM admin WHERE username = ?";
                PreparedStatement preparedStatement = connect.prepareStatement(query);
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    userId = resultSet.getInt("id");
                }
            } catch (SQLException e) {e.printStackTrace();}
        }
        return userId;
    }
    private boolean usernameExists(String username) {
        String query = "SELECT COUNT(*) FROM admin WHERE username = ?";
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @FXML
    public void userManagementUpdateBtn_onAction() {
        if (!Objects.equals(GetData.userRole, "Admin")) {
            showAlert(Alert.AlertType.WARNING, "Access Denied",
                    "Only Admins can perform this action.");
            return;
        }
        String userIdText = userManagement_id.getText();
        if (userIdText.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error Message", "Fields cannot be empty");
            return;
        }

        int userId = Integer.parseInt(userIdText);
        //int userId = Integer.parseInt(userManagement_id.getText());
        String username = userManagement_username.getText();
        String password = userManagement_password.getText();
        String confirmPassword = userManagement_confirmPassword.getText();
        String userRole = userManagement_userRole.getValue();
        String hashedPassword = hashPassword(password);

        // Check if fields are empty
        if (password.isEmpty() || confirmPassword.isEmpty() || userRole == null) {
            showAlert(Alert.AlertType.ERROR, "Error Message", "Fields cannot be empty");
            return;
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Error Message", "Passwords do not match!");
            return; // Exit the method if passwords don't match
        }

        connect = DatabaseConnection.connectDb();
        if (connect != null) {
            try {
                if (userId != fetchUserId(username) && usernameExists(username)) {
                    showAlert(Alert.AlertType.ERROR, "Error Message", "User " + username + " already exists");
                    return;
                }
                String query = "UPDATE admin SET " +
                        "username = ?, password_hash = ?, user_role = ? " +
                        "WHERE id = ?";
                prepare = connect.prepareStatement(query);
                prepare.setString(1, username);
                prepare.setString(2, hashedPassword);
                prepare.setString(3, userRole);
                prepare.setInt(4, userId);

                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to update?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    int updatedRows = prepare.executeUpdate();
                    if (updatedRows > 0) {
                        showAlert(Alert.AlertType.INFORMATION, "Information Message", "Updated Successfully");

                        userManagementShowListData();
                        // Clear the fields if needed
                        userManagementClearBtn_onAction();
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Error Message", "No rows were updated.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (prepare != null) {
                        prepare.close();
                    }
                    if (connect != null) {
                        connect.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @FXML
    public void userManagementDeleteBtn_onAction() {
        if (!Objects.equals(GetData.userRole, "Admin")) {
            showAlert(Alert.AlertType.WARNING, "Access Denied",
                    "Only Admins can perform this action.");
            return;
        }
        String deleteData = "DELETE FROM admin WHERE id = " + userManagement_id.getText();
        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if (userManagement_id.getText().isEmpty() || userManagement_username.getText().isEmpty() || userManagement_userRole.getSelectionModel().getSelectedItem().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Fields cannot be empty");
            } else if (Integer.parseInt(userManagement_id.getText()) == fetchUserId(userManagement_username.getText())){
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete User: " + userManagement_username.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);
                    showAlert(Alert.AlertType.INFORMATION, "Information Message", "Successfully Deleted!");
                    //  TO LOAD THE UPDATED TABLE AFTER OPERATION
                    userManagementShowListData();
                    // Clear the fields if needed
                    userManagementClearBtn_onAction();
                } else return;
                statement.close();
            }
            connect.close();
        } catch (Exception e) {e.printStackTrace();}
    }
    private void showAlert(Alert.AlertType alertType, String title, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    // Implementing a password hashing method here
    private String hashPassword(String password) {
        // Generate a salt for hashing (you can configure the strength as needed)
        String salt = BCrypt.gensalt(12);
        // Hash the password with the salt
        return BCrypt.hashpw(password, salt);
    }

    @FXML
    void userManagementClearBtn_onAction() {
        // Clear the input fields here
        userManagement_id.clear();
        userManagement_username.clear();
        userManagement_password.clear();
        userManagement_confirmPassword.clear();
        userManagement_userRole.getSelectionModel().clearSelection();

        initializeComboBoxes(userManagement_userRole);
    }
    public void hideUserId() {
        userManagement_id_label.setVisible(false);
        userManagement_id.setVisible(false);
    }

    private void setupAttendanceEventListeners() {
        // When semester changes → load courses and clear other fields
        studentAttendance_semester.setOnAction(e -> {
            studentAttendance_course.getSelectionModel().clearSelection();
            studentAttendance_course.getItems().clear();
            studentAttendance_subject.getSelectionModel().clearSelection();
            studentAttendance_subject.getItems().clear();
            studentAttendance_studentNum.getSelectionModel().clearSelection();
            studentAttendance_studentNum.getItems().clear();
            studentAttendanceCourseList(); // Load courses
        });

        // When course changes → load subjects and clear student list
        studentAttendance_course.setOnAction(e -> {
            studentAttendance_subject.getSelectionModel().clearSelection();
            studentAttendance_subject.getItems().clear();
            studentAttendance_studentNum.getSelectionModel().clearSelection();
            studentAttendance_studentNum.getItems().clear();
            studentAttendanceSubjectList(); // Load subjects
        });

        // When subject changes → load students
        studentAttendance_subject.setOnAction(e -> {
            studentAttendance_studentNum.getSelectionModel().clearSelection();
            studentAttendance_studentNum.getItems().clear();
            studentAttendanceStudentNumList(); // Load students
        });
    }

    // ==================== START CODE FOR MANAGE SUBJECTS FORM ====================
    public ObservableList<SubjectData> manageSubjectsListData() {
        ObservableList<SubjectData> listSubjects = FXCollections.observableArrayList();
        String sql = "SELECT * FROM subject ORDER BY subject_name";
        connect = DatabaseConnection.connectDb();
        try {
            SubjectData subjectD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                subjectD = new SubjectData(
                        result.getInt("id"),
                        result.getString("subject_name"),
                        result.getString("course"),
                        result.getString("semester"),
                        result.getString("teacher_username"),
                        result.getString("description")
                );
                listSubjects.add(subjectD);
            }
            result.close();
            prepare.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSubjects;
    }

    private ObservableList<SubjectData> manageSubjectsList;

    public void manageSubjectsShowListData() {
        manageSubjectsList = manageSubjectsListData();

        manageSubjects_col_subjectName.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        manageSubjects_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        manageSubjects_col_semester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        manageSubjects_col_teacher.setCellValueFactory(new PropertyValueFactory<>("teacherUsername"));
        manageSubjects_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));

        manageSubjects_tableView.setItems(manageSubjectsList);
    }

    @FXML
    public void manageSubjectsSelect() {
        SubjectData subjectD = manageSubjects_tableView.getSelectionModel().getSelectedItem();
        int num = manageSubjects_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }
        manageSubjects_subjectName.setText(subjectD.getSubjectName());
        manageSubjects_course.getSelectionModel().select(subjectD.getCourse());
        manageSubjects_semester.getSelectionModel().select(subjectD.getSemester());
        manageSubjects_teacherUsername.getSelectionModel().select(subjectD.getTeacherUsername());
        manageSubjects_description.setText(subjectD.getDescription());
    }

    @FXML
    public void manageSubjects_courseList() {
        String listCourse = "SELECT DISTINCT course FROM course ORDER BY course";
        connect = DatabaseConnection.connectDb();
        try {
            ObservableList<String> listC = FXCollections.observableArrayList();
            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();
            while (result.next()) {
                listC.add(result.getString("course"));
            }
            manageSubjects_course.setItems(listC);
            result.close();
            prepare.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void manageSubjects_teacherList() {
        String listTeacher = "SELECT username FROM admin WHERE user_role = 'Teacher' ORDER BY username";
        connect = DatabaseConnection.connectDb();
        try {
            ObservableList<String> listT = FXCollections.observableArrayList();
            prepare = connect.prepareStatement(listTeacher);
            result = prepare.executeQuery();
            while (result.next()) {
                listT.add(result.getString("username"));
            }
            manageSubjects_teacherUsername.setItems(listT);
            result.close();
            prepare.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void manageSubjects_semesterList() {
        List<String> semesterL = new ArrayList<>();
        for (String data : semesterList) {
            semesterL.add(data);
        }
        ObservableList<String> obList = FXCollections.observableArrayList(semesterL);
        manageSubjects_semester.setItems(obList);
    }

    @FXML
    public void manageSubjects_addBtn_onAction() {
        String insertData = "INSERT INTO subject (subject_name, course, semester, teacher_username, description) VALUES (?, ?, ?, ?, ?)";
        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if (manageSubjects_subjectName.getText().isEmpty()
                    || manageSubjects_course.getSelectionModel().getSelectedItem() == null
                    || manageSubjects_semester.getSelectionModel().getSelectedItem() == null
                    || manageSubjects_teacherUsername.getSelectionModel().getSelectedItem() == null
                    || manageSubjects_description.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Fields cannot be empty");
                alert.showAndWait();
            } else {
                // Check if subject already exists for this course AND semester
                String checkData = "SELECT * FROM subject WHERE subject_name = ? AND course = ? AND semester = ?";
                prepare = connect.prepareStatement(checkData);
                prepare.setString(1, manageSubjects_subjectName.getText());
                prepare.setString(2, manageSubjects_course.getSelectionModel().getSelectedItem());
                prepare.setString(3, manageSubjects_semester.getSelectionModel().getSelectedItem());  // ADD THIS LINE
                result = prepare.executeQuery();

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Subject '" + manageSubjects_subjectName.getText() + "' already exists for this course!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, manageSubjects_subjectName.getText());
                    prepare.setString(2, manageSubjects_course.getSelectionModel().getSelectedItem());
                    prepare.setString(3, manageSubjects_semester.getSelectionModel().getSelectedItem());
                    prepare.setString(4, manageSubjects_teacherUsername.getSelectionModel().getSelectedItem());
                    prepare.setString(5, manageSubjects_description.getText());
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Subject added successfully!");
                    alert.showAndWait();

                    manageSubjectsShowListData();
                    manageSubjects_clearBtn_onAction();
                }
                result.close();
                prepare.close();
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void manageSubjects_updateBtn_onAction() {
        SubjectData selectedSubject = manageSubjects_tableView.getSelectionModel().getSelectedItem();

        if (selectedSubject == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a subject to update");
            alert.showAndWait();
            return;
        }

        String updateData = "UPDATE subject SET subject_name = ?, course = ?, semester = ?, teacher_username = ?, description = ? WHERE id = ?";
        connect = DatabaseConnection.connectDb();
        try {
            Alert alert;
            if (manageSubjects_subjectName.getText().isEmpty()
                    || manageSubjects_course.getSelectionModel().getSelectedItem() == null
                    || manageSubjects_semester.getSelectionModel().getSelectedItem() == null
                    || manageSubjects_teacherUsername.getSelectionModel().getSelectedItem() == null
                    || manageSubjects_description.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Fields cannot be empty");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to update this subject?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(updateData);
                    prepare.setString(1, manageSubjects_subjectName.getText());
                    prepare.setString(2, manageSubjects_course.getSelectionModel().getSelectedItem());
                    prepare.setString(3, manageSubjects_semester.getSelectionModel().getSelectedItem());
                    prepare.setString(4, manageSubjects_teacherUsername.getSelectionModel().getSelectedItem());
                    prepare.setString(5, manageSubjects_description.getText());
                    prepare.setInt(6, selectedSubject.getId());
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Subject updated successfully!");
                    alert.showAndWait();

                    manageSubjectsShowListData();
                    manageSubjects_clearBtn_onAction();
                }
                prepare.close();
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void manageSubjects_deleteBtn_onAction() {
        SubjectData selectedSubject = manageSubjects_tableView.getSelectionModel().getSelectedItem();

        if (selectedSubject == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a subject to delete");
            alert.showAndWait();
            return;
        }

        String deleteData = "DELETE FROM subject WHERE id = ?";
        connect = DatabaseConnection.connectDb();
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete subject: " + selectedSubject.getSubjectName() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                prepare = connect.prepareStatement(deleteData);
                prepare.setInt(1, selectedSubject.getId());
                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Subject deleted successfully!");
                alert.showAndWait();

                manageSubjectsShowListData();
                manageSubjects_clearBtn_onAction();
                prepare.close();
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void manageSubjects_clearBtn_onAction() {
        manageSubjects_subjectName.setText("");
        manageSubjects_course.getSelectionModel().clearSelection();
        manageSubjects_semester.getSelectionModel().clearSelection();
        manageSubjects_teacherUsername.getSelectionModel().clearSelection();
        manageSubjects_description.setText("");

        initializeComboBoxes(manageSubjects_course, manageSubjects_teacherUsername);
    }
// ==================== END CODE FOR MANAGE SUBJECTS FORM ====================

    //    END MANAGE USERS FORM
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleChecker();
        displayUsername();
        defaultNav();
        homeDisplayTotalEnrolledStudents();
        homeDisplayPresentToday();
        homeDisplayAbsentToday();
        homeDisplayTotalEnrolledChart();
        homeDisplayPresentTodayChart();
        homeDisplayAbsentTodayChart();

        addStudentShowListData();
        addStudent_semesterList();
        addStudent_genderList();
        addStudent_statusList();
        setAddStudent_courseList(); // This will now load ALL courses for admin
        addStudent_search_onKeyTyped();

        availableCourseShowListData();

        studentAttendanceSemesterList();
        studentAttendanceShowListData();
        studentAttendanceSearchOnKeyTyped();
        setupAttendanceEventListeners();

        hideUserId();
        userManagementShowListData();
        userManagement_userRoleList();

        manageSubjectsShowListData();
        manageSubjects_courseList();
        manageSubjects_semesterList(); // NOW PROPERLY INITIALIZED
        manageSubjects_teacherList();
    }
}
