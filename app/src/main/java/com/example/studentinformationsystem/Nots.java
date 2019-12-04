package com.example.studentinformationsystem;

public class Nots {
    private String className;
    private int viseGrade;
    private int finalGrade;
    private String letterGrade;
    private String situation;
    private String classCode;
    private int averageGrade;
    private String dateOfAnnounce;
    private float credit;
    private String teacherName;

    public Nots(String className, int viseGrade, int finalGrade, String letterGrade, String situation){
        this.className = className;
        this.viseGrade = viseGrade;
        this.finalGrade = finalGrade;
        this.letterGrade = letterGrade;
        this.situation = situation;
    }

    public Nots(String className, int viseGrade, int finalGrade, String letterGrade, String situation, String classCode, int averageGrade, String dateOfAnnounce, float credit, String teacherName){
        this.className = className;
        this.viseGrade = viseGrade;
        this.finalGrade = finalGrade;
        this.letterGrade = letterGrade;
        this.situation = situation;
        this.classCode = classCode;
        this.averageGrade = averageGrade;
        this.dateOfAnnounce = dateOfAnnounce;
        this.credit = credit;
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getViseGrade() {
        return viseGrade;
    }

    public void setViseGrade(int viseGrade) {
        this.viseGrade = viseGrade;
    }

    public int getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(int finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getDateOfAnnounce() {
        return dateOfAnnounce;
    }

    public void setDateOfAnnounce(String dateOfAnnounce) {
        this.dateOfAnnounce = dateOfAnnounce;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
