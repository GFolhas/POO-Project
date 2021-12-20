package com.company;

import java.io.Serializable;

public class ConfArticle extends Publication implements Serializable {
    private String summary;
    private String confName;
    private String confDate;
    private String confLocation;

    /**
     * Conference Article's Constructor
     * @param author Conference Article's author
     * @param title Conference Article's title
     * @param keywords Conference Article's main keywords
     * @param publishedIn Conference Article's year of publishment
     * @param audienceSize Conference Article's Global Audience Size
     * @param summary Conference Article's Summary
     * @param confName Conference's Name
     * @param confDate Conference's Date
     * @param confLocation Conference's Location
     */
    public ConfArticle(String author, String title, String keywords, int publishedIn, int audienceSize, String summary, String confName, String confDate, String confLocation) {
        super(author, title, keywords, publishedIn, audienceSize);
        super.setType(1);
        super.setImpactFactor();
        setSummary(summary);
        setConfName(confName);
        setConfDate(confDate);
        setConfLocation(confLocation);
        setPubTN("Conference Article");
    }

    /**
     * Sets the Summary
     * @param summary summary to be set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Sets the Conference's Name
     * @param confName Conference's Name to be set
     */
    public void setConfName(String confName) {
        this.confName = confName;
    }

    /**
     * Sets the Conference's Date
     * @param confDate Conference's Date to be set
     */
    public void setConfDate(String confDate) {
        this.confDate = confDate;
    }

    /**
     * Sets the Conference's Location
     * @param confLocation Conference's Location to be set
     */
    public void setConfLocation(String confLocation) {
        this.confLocation = confLocation;
    }

    /**
     * Method that returns the Conference Article's Main Info
     * @return Conference Article's Main Info
     */
    @Override
    public String toString() {
        return super.toString() + "\n>> Summary: " +
                summary + "\n>> Conference Name: "+
                confName+"\n>> Conference Date: " +
                confDate + "\n>> Conference Location: " +
                confLocation + "\n\n";
    }
}
