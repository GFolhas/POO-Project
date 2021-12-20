package com.company;

import java.io.Serializable;

public class Book extends Publication implements Serializable {
    private String summary;
    private String publishComp;
    private String ISBN;

    /**
     * Book's Constructor
     * @param author Book's author
     * @param title Book's title
     * @param keywords Book's main keywords
     * @param publishedIn Book's year of publishment
     * @param audienceSize Book's Global Audience Size
     * @param summary Book's Summary
     * @param publishComp Book's Publisher
     * @param ISBN Book's ISBN
     */
    public Book(String author, String title, String keywords, int publishedIn, int audienceSize, String summary, String publishComp, String ISBN) {
        super(author, title, keywords, publishedIn, audienceSize);
        super.setType(3);
        super.setImpactFactor();
        setSummary(summary);
        setPublishComp(publishComp);
        setISBN(ISBN);
        setPubTN("Book");
    }

    /**
     * Sets the Book's Summary
     * @param summary Book's Summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Sets the Book's Publisher
     * @param publishComp Book's Publisher
     */
    public void setPublishComp(String publishComp) {
        this.publishComp = publishComp;
    }

    /**
     * Sets the Book's ISBN
     * @param ISBN Book's ISBN
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }


    /**
     * Method that returns the Book's Main Info
     * @return Book's Main Info
     */
    @Override
    public String toString() {
        return super.toString() + "\n>> Summary: " +
                summary + "\n>> Publishing Company: "+
                publishComp+"\n>> ISBN: " +
                ISBN + "\n\n";
    }
}
