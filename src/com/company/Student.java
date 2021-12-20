package com.company;

import java.io.Serializable;

public class Student extends Investigator implements Serializable {
    private String thesis;
    private String deliveryDate;
    private String guidingInv;

    /**
     * Student's Constructor
     * @param invName Student's Name
     * @param email Student's Email
     * @param investigationGroup Student's Investigation Group
     * @param thesis Student's Thesis
     * @param deliveryDate Student's Expected Delivery Date
     * @param guidingInv Student's Guiding Investigator
     */
    public Student(String invName, String email, String investigationGroup, String thesis, String deliveryDate, String guidingInv) {
        super(invName, email, investigationGroup);
        setThesis(thesis);
        setDeliveryDate(deliveryDate);
        setGuidingInv(guidingInv);
    }

    /**
     * Sets the Student's Thesis
     * @param thesis Student's Thesis to be set
     */
    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    /**
     * Sets the Student's Expected Delivery Date
     * @param deliveryDate Student's Delivery Date to be set
     */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * Sets the Student's Guiding Investigator
     * @param guidingInv Student's Guiding Investigator to be set
     */
    public void setGuidingInv(String guidingInv) { this.guidingInv = guidingInv; }

    /**
     * Method that allows us to differ how the effective members and students names are shown
     * @param invName Original Student's Name
     * @return string containing the initial of the student's first name and their last surname
     */
    public String nameCheck(String invName){
        String publishName;
        String[] newStr = invName.split("");
        String[] lastName = invName.split(" ");
        int index = lastName.length - 1;
        publishName = newStr[0] +"."+ lastName[index];
        return publishName;
    }

    /**
     * Method that returns the Student's Main Info
     * @return Student's Main Info
     */
    @Override
    public String toString() {
        return super.toString() + "\n>> Publisher Name: " +
                nameCheck(getInvName()) +
                "\n>> Thesis Title: " +
                thesis + "\n>> Predicted Completion Date: " +
                deliveryDate + "\n>> Guiding Investigator: " +
                guidingInv+"\n";
    }
}
