package com.example.studentinformationsystem;

public class Nots {
    private String className;
    private int viseGrade;
    private int finalGrade;
    private String letterGrade;
    private String situation;

    public Nots(String className, int viseGrade, int finalGrade, String letterGrade, String situation){
        this.className = className;
        this.viseGrade = viseGrade;
        this.finalGrade = finalGrade;
        this.letterGrade = letterGrade;
        this.situation = situation;
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
}
