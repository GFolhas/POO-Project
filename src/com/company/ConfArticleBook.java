package com.company;

import java.io.Serializable;

public class ConfArticleBook extends Book implements Serializable {
    private String confName;
    private int articleNum;

    /**
     * Conference Article Book's Constructor
     * @param author Conference Article Book's author
     * @param title Conference Article Book's title
     * @param keywords Conference Article Book's main keywords
     * @param publishedIn Conference Article Book's year of publishment
     * @param audienceSize Conference Article Book's Global Audience Size
     * @param summary Conference Article Book's Summary
     * @param publishComp Conference Article Book's Publisher
     * @param ISBN Conference Article Book's ISBN
     */
    public ConfArticleBook(String author, String title, String keywords, int publishedIn, int audienceSize, String summary, String publishComp, String ISBN, String confName, int articleNum) {
        super(author, title, keywords, publishedIn, audienceSize, summary, publishComp, ISBN);
        super.setType(5);
        super.setImpactFactor();
        setConfName(confName);
        setArticleNum(articleNum);
        setPubTN("Conference Article Book");
    }

    /**
     * Sets the Conference's Name
     * @param confName Conference's Name to be set
     */
    public void setConfName(String confName) { this.confName = confName; }

    /**
     * Sets the Article's Number
     * @param articleNum Article's Number to be set
     */
    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }


    /**
     * Method that returns the Conference Article Book's Main Info
     * @return Conference Article Book's Main Info
     */
    @Override
    public String toString() {
        return super.toString() + ">> Conference Name: "+
                confName+"\n>> Article Number: " +
                articleNum + "\n\n";
    }
}
