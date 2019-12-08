package com.example.studentinformationsystem.ui.main;

public class DatesOfAcademic {
    private String action;
    private String startDate;
    private String endDate;

    public DatesOfAcademic(String action, String startDate, String endDate){
        this.action = action;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
