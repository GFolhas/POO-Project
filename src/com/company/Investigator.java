package com.company;


import java.io.Serializable;

abstract public class Investigator implements Serializable {
    private String invName;
    private String email;
    private String investigationGroup;

    /**
     * Investigator's Constructor
     * @param invName Investigator's Name
     * @param email Investigator's Email
     * @param investigationGroup Investigator's  Investigation Group
     */
    public Investigator(String invName, String email, String investigationGroup) {
        setInvName(invName);
        setEmail(email);
        setInvestigationGroup(investigationGroup);
    }


    /**
     * Method that sets the Investigator's Name
     * @param invName Investigator's Name
     */
    public void setInvName(String invName) {
        this.invName = invName;
    }

    /**
     * Method that sets the Investigator's Email
     * @param email Investigator's Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method that sets the Investigator's Investigation Group
     * @param investigationGroup Investigator's Investigation Group
     */
    public void setInvestigationGroup(String investigationGroup) {
        this.investigationGroup = investigationGroup;
    }

    /**
     * Method that gets the Investigator's Name
     * @return Investigator's Name
     */
    public String getInvName() {
        return invName;
    }

    /**
     * Method that gets the Investigator's Investigation Group
     * @return Investigator's Investigation Group
     */
    public String getInvestigationGroup() {
        return investigationGroup;
    }

    /**
     * Abstract Method that allows us to differ how the effective members and students names are shown
     * @param iName Original Investigator Name
     * @return In this class, this method doesn't run so it doesn't return anything
     */
    public abstract String nameCheck(String iName);

    /**
     * Method used to print the Investigator's personal details
     * @return String with the Investigator's personal details
     */
    @Override
    public String toString() {
        return ">> Name: " +
                invName +"\n>> Email: " +
                email + "\n>> Investigation Group: " +
                investigationGroup;
    }
}
