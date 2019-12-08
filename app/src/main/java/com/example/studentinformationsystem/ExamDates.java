package com.example.studentinformationsystem;

public class ExamDates {
    private String className;
    private String date;
    private String classRoom;

    public ExamDates(String className, String date, String classRoom){
        this.className = className;
        this.date = date;
        this.classRoom = classRoom;
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

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}
