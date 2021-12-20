package com.company;

import java.io.Serializable;

public class EffectiveMember extends Investigator implements Serializable {
    private int officeNum;
    private int phoneNumDEI;

    /**
     * Effective Member's Constructor
     * @param invName Effective Member's Name
     * @param email Effective Member's Email
     * @param investigationGroup Effective Member's Investigation Group
     * @param officeNum Effective Member's Office Number
     * @param phoneNumDEI Effective Member's DEI Cellphone Number
     */
    public EffectiveMember(String invName, String email, String investigationGroup, int officeNum, int phoneNumDEI) {
        super(invName, email, investigationGroup);
        setOfficeNum(officeNum);
        setPhoneNumDEI(phoneNumDEI);
    }

    /**
     * Sets the Effective Member's Office Number
     * @param officeNum Effective Member's Office Number to be set
     */
    public void setOfficeNum(int officeNum) {
        this.officeNum = officeNum;
    }

    /**
     * Sets the Effective Member's DEI Phone Number
     * @param phoneNumDEI Effective Member's DEI Phone Number to be set
     */
    public void setPhoneNumDEI(int phoneNumDEI) {
        this.phoneNumDEI = phoneNumDEI;
    }

    /**
     * Method that allows us to differ how the effective members and students names are shown
     * @param invName Original Effective Member's Name
     * @return string containing the investigator's status (Professor) as well as their first and last name
     */
    public String nameCheck(String invName){
        String publishName;
        String[] div = invName.split(" ");
        int index = div.length - 1;
        publishName = "Professor " + div[0] +" "+ div[index];
        return publishName;
    }

    /**
     * Method that returns the Effective Member's Main Info
     * @return Effective Member's Main Info
     */
    @Override
    public String toString() {
        return super.toString() + "\n>> Publisher Name: " +
                nameCheck(getInvName()) +
                "\n>> Office Number: " +
                officeNum + "\n>> DEI Phone Number: " +
                phoneNumDEI +"\n";
    }
}
