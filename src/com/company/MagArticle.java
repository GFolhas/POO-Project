package com.company;

public class MagArticle extends Publication{
    private String summary;
    private String magName;
    private String magDate;
    private int magNumber;

    /**
     * Magazine Article's Constructor
     * @param author Magazine Article's Author
     * @param title Magazine Article's Title
     * @param keywords Magazine Article's Main Keywords
     * @param publishedIn Magazine Article's Year of Publishment
     * @param audienceSize Magazine Article's Global Audience Size
     * @param summary Magazine Article's Summary
     * @param magName Magazine Article's Name
     * @param magDate Magazine Article's Date
     * @param magNumber Magazine Article's Number
     */
    public MagArticle(String author, String title, String keywords, int publishedIn, int audienceSize, String summary, String magName, String magDate, int magNumber) {
        super(author, title, keywords, publishedIn, audienceSize);
        super.setType(2);
        super.setImpactFactor();
        setSummary(summary);
        setMagName(magName);
        setMagDate(magDate);
        setMagNumber(magNumber);
        setPubTN("Magazine Article");
    }

    /**
     * Sets the Magazine Article's Summary
     * @param summary Magazine Article's Summary to be set
     */
    public void setSummary(String summary) { this.summary = summary; }

    /**
     * Sets the Magazine Article's Name
     * @param magName Magazine Article's Name to be set
     */
    public void setMagName(String magName) { this.magName = magName; }

    /**
     * Sets the Magazine Article's Date
     * @param magDate Magazine Article's Date to be set
     */
    public void setMagDate(String magDate) { this.magDate = magDate; }

    /**
     * Sets the Magazine Article's Number
     * @param magNumber Magazine Article's Number to be set
     */
    public void setMagNumber(int magNumber) { this.magNumber = magNumber; }

    /**
     * Method that returns the Magazine Article's Main Info
     * @return Magazine Article's Main Info
     */
    @Override
    public String toString() {
        return super.toString() + "\n>> Summary: " +
                summary + "\n>> Magazine Article: "+
                magName+"\n>> Magazine Article Release Date: " +
                magDate + "\n>> Magazine Number: " +
                magNumber + "\n\n";
    }
}
