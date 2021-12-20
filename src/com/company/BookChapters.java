package com.company;

import java.io.Serializable;

public class BookChapters extends Book implements Serializable {
    private String chpName;
    private int firstPage;
    private int lastPage;

    /**
     * Book Chapter's Constructor
     * @param author Book Chapter's author
     * @param title Book Chapter's title
     * @param keywords Book Chapter's main keywords
     * @param publishedIn Book Chapter's year of publishment
     * @param audienceSize Book Chapter's Global Audience Size
     * @param summary Book Chapter's Summary
     * @param publishComp Book Chapter's Publisher
     * @param ISBN Book Chapter's ISBN
     */
    public BookChapters(String author, String title, String keywords, int publishedIn, int audienceSize, String summary, String publishComp, String ISBN, String chpName, int firstPage, int lastPage) {
        super(author, title, keywords, publishedIn, audienceSize, summary, publishComp, ISBN);
        super.setType(4);
        super.setImpactFactor();
        setChpName(chpName);
        setFirstPage(firstPage);
        setLastPage(lastPage);
        setPubTN("Book Chapter");
    }

    /**
     * Sets the Book's Chapter Name
     * @param chpName Book's Chapter Name
     */
    public void setChpName(String chpName) {
        this.chpName = chpName;
    }

    /**
     * Sets the Book's Chapter Initial Page
     * @param firstPage Book's Chapter Initial Page
     */
    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    /**
     * Sets the Book's Chapter Final Page
     * @param lastPage Book's Chapter Final Page
     */
    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    /**
     * Method that returns the Book Chapter's Main Info
     * @return Book Chapter's Main Info
     */
    @Override
    public String toString() {
        return super.toString() + ">> Chapter Name: " +
                chpName + "\n>> Inicial Page: "+
                firstPage+"\n>> End Page: " +
                lastPage + "\n\n";
    }
}
