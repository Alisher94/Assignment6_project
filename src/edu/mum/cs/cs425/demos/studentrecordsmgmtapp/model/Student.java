package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student
{
    String ID;
    String Name;
    String DateOfAdmission;

    public Student() {

    }

    public Student(String ID) {
        this.ID = ID;
    }

    public Student(String ID, String name, String dateOfAdmission) {
        this.ID = ID;
        Name = name;
        DateOfAdmission = dateOfAdmission;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDateOfAdmission() {
        return DateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        DateOfAdmission = dateOfAdmission;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", DateOfAdmission='" + DateOfAdmission + '\'' +
                '}';
    }

    public Date GetAdmissionDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        return sdf.parse(this.DateOfAdmission);
    }

}
