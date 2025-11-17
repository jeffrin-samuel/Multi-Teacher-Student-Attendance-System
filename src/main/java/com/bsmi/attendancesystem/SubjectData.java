package com.bsmi.attendancesystem;

public class SubjectData {
    private Integer id;
    private String subjectName;
    private String course;
    private String semester;
    private String teacherUsername;
    private String description;

    public SubjectData(Integer id, String subjectName, String course, String semester, String teacherUsername, String description) {
        this.id = id;
        this.subjectName = subjectName;
        this.course = course;
        this.semester = semester;  // NEW
        this.teacherUsername = teacherUsername;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public String getDescription() {
        return description;
    }

    // Setters - ADD THESE
    public void setId(Integer id) {
        this.id = id;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
