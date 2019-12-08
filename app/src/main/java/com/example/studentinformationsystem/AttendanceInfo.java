package com.example.studentinformationsystem;

class AttendanceInfo {
    private String className;
    private float credit;
    private short classNo;
    private int attendanceHours;

    public AttendanceInfo(String className, float credit, short classNo, int attendanceHours){
        this.className = className;
        this.credit = credit;
        this.classNo = classNo;
        this.attendanceHours = attendanceHours;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public short getClassNo() {
        return classNo;
    }

    public void setClassNo(short classNo) {
        this.classNo = classNo;
    }

    public int getAttendanceHours() {
        return attendanceHours;
    }

    public void setAttendanceHours(int attendanceHours) {
        this.attendanceHours = attendanceHours;
    }
}
