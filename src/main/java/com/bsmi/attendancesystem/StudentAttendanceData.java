package com.bsmi.attendancesystem;

public class StudentAttendanceData {
    private String studentNum;
    private String semester;
    private String course;
    private String subject;
    private String attendanceDate;  // Changed from entryTime/exitTime
    private String status;

    // Constructor - NOW ONLY 6 PARAMETERS (removed entry_time and exit_time)
    public StudentAttendanceData(String studentNum, String semester, String course, String subject,
                                 String attendanceDate, String status) {
        this.studentNum = studentNum;
        this.semester = semester;
        this.course = course;
        this.subject = subject;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }

    // Getters
    public String getStudentNum() {
        return studentNum;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourse() {
        return course;
    }

    public String getSubject() {
        return subject;
    }

    public String getAttendanceDate() {  // NEW - replaces getEntryTime() and getExitTime()
        return attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}