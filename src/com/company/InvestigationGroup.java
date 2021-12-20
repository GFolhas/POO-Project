package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class InvestigationGroup implements Serializable {
    private String name;
    private String acronym;
    private String leadingInv;
    private final ArrayList<Investigator> invList;

    /**
     * Investigation Group's Constructor
     * @param name Investigation Group's Name
     * @param acronym Investigation Group's Acronym
     * @param leadingInv Investigation Group's Leading Investigator
     */
    public InvestigationGroup(String name, String acronym, String leadingInv) {
        setName(name);
        setAcronym(acronym);
        setLeadingInv(leadingInv);
        invList = new ArrayList<>();
    }

    /**
     * Sets the Investigation Group's Name
     * @param name Investigation Group's Name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Investigation Group's Name
     * @return Investigation Group's Name
     */
    public String getName() { return name; }

    /**
     * Sets the Investigation Group's Acronym
     * @param acronym Investigation Group's Acronym to be set
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     * Sets the Investigation Group's Acronym
     * @return Investigation Group's Acronym
     */
    public String getAcronym() { return acronym;}

    /**
     * Sets the Investigation Group's Leading Investigator
     * @param leadingInv Investigation Group's Leading Investigator to be set
     */
    public void setLeadingInv(String leadingInv) {
        this.leadingInv = leadingInv;
    }

    /**
     * Method that allows the insertion of a new investigator into the Investigation Group's Investigator List
     * @param w Investigator to be added to the list
     */
    public void addList(Investigator w){
        if(this.acronym.equals(w.getInvestigationGroup()) && !invList.contains(w)) {
            invList.add(w);
            w.setInvestigationGroup(this.acronym);
            return;
        }
        System.out.println("\n>> The investigator "+w.getInvName()+" is already associated with this group ("+w.getInvestigationGroup()+")");

    }

    /**
     * Method that returns the Investigation Group's Main Info
     * @return Investigation Group's Main Info
     */
    @Override
    public String toString() {
        return ">> Name: " +
                name + "\n>> Acronym: " +
                acronym + "\n>> Leading Investigator: " +
                leadingInv+"\n";
    }
}
