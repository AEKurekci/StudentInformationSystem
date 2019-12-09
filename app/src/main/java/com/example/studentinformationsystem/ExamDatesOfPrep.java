package com.example.studentinformationsystem;

class ExamDatesOfPrep {
    private String className;
    private String date;
    private String grade;
    public ExamDatesOfPrep(String className, String date){
        this.className = className;
        this.date = date;
    }
    public ExamDatesOfPrep(String className, String date, String grade){
        this.className = className;
        this.date = date;
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
