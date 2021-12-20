package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Publication implements Serializable {
    private String authors;
    private String title;
    private String keywords;
    private int publishedIn;
    private int audienceSize;
    private String impactFactor;
    private int type;// integer will differentiate the publication subclasses
    private String pubTN;

    /**
     * Publication's Constructor
     * @param author Publication's Author
     * @param title Publication's Title
     * @param keywords Publication's Main Keywords
     * @param publishedIn Publication's Year of Publishment
     * @param audienceSize Publication's Global Audience Size
     */
    public Publication(String author, String title, String keywords, int publishedIn, int audienceSize) {
        setAuthors(author);
        setTitle(title);
        setKeywords(keywords);
        setPublishedIn(publishedIn);
        setAudienceSize(audienceSize);
        setImpactFactor();
    }

    /**
     * Sets the Publication's Author(s) Name(s)
     * @param authors Publication's Author(s) Name(s) to be set
     */
    public void setAuthors(String authors) { this.authors = authors; }

    /**
     * Sets the Publication's Title
     * @param title Publication's Title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the Publication's Keywords
     * @param keywords Publication's Keywords to be set
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * Sets the Publication's Year of Publishment
     * @param publishedIn Publication's Year of Publishment to be set
     */
    public void setPublishedIn(int publishedIn) {
        this.publishedIn = publishedIn;
    }

    /**
     * Gets the Publication's Year of Publishment
     * @return Publication's Year of Publishment
     */
    public int getPublishedIn() {
        return publishedIn;
    }

    /**
     * Sets the Publication's Global Audience Size
     * @param audienceSize Publication's Global Audience Size to be set
     */
    public void setAudienceSize(int audienceSize) {
        this.audienceSize = audienceSize;
    }

    /**
     * Gets the Publication's Type
     * @return Publication's Type
     */
    public int getType() { return type; }

    /**
     * Sets the Publication's Type (each pub has a different type associated, irrelevant to the user's knowledge)
     * @param type Publication's Type to be set
     */
    public void setType(int type) { this.type = type; }

    /**
     * Sets the Publication's Impact Factor by analysing the type of the publication as well as the audience size.
     * This factor can range from A to C, being A a very good publication, able to reach to a large ammount of viewers, B being
     * the middle ground and C being a publication with a low ammount of overall viewers. Once the factor is determined based on
     * these 2 parameters, the value is set/associated to the respective Publication.
     */
    public void setImpactFactor(){
        switch(type){
            case 1:
                if(audienceSize >= 500)
                    this.impactFactor = "A";
                else if(audienceSize>=200)
                    this.impactFactor = "B";
                else if(audienceSize >= 0)
                    this.impactFactor = "C";
                else
                    System.out.println("Negative audience size!");
                break;

            case 2:
                if(audienceSize >= 1000)
                    this.impactFactor = "A";
                else if(audienceSize>=500)
                    this.impactFactor = "B";
                else if(audienceSize >= 0)
                    this.impactFactor = "C";
                else
                    System.out.println("Negative audience size!");
                break;

            case 3:

            case 4:
                if(audienceSize >= 10000)
                    this.impactFactor = "A";
                else if(audienceSize>=5000)
                    this.impactFactor = "B";
                else if(audienceSize >= 0)
                    this.impactFactor = "C";
                else
                    System.out.println("Negative audience size!");
                break;

            case 5:
                if(audienceSize >= 7500)
                    this.impactFactor = "A";
                else if(audienceSize>=2500)
                    this.impactFactor = "B";
                else if(audienceSize >= 0)
                    this.impactFactor = "C";
                else
                    System.out.println("Negative audience size!");
                break;
        }
    }


    /**
     * Method that allows the separation of multiple authors from a string. I've decided to store the author(s) information
     * in a single string since it doesnt require me to loop to obtain all of the authors in the toString method. Since I only
     * need individual authors in some specific occasions, I figured this could be a good way to implement it, being able to
     * separate them through ".split(arg)", being arg a comma followed by a space.
     * @return ArrayList containing the Publication's Individual Author's
     */
    public ArrayList<String> individualAuthors(){
        ArrayList<String> x = new ArrayList<>();
        String[] div = this.authors.split(", ");
        Collections.addAll(x, div);
        return x;
    }

    /**
     * Gets the Publication's Impact Factor
     * @return Publication's Impact Factor
     */
    public String getImpactFactor() { return impactFactor; }

    /**
     * Sets the Publication's Type Name
     * @param pubTN Publication's Type Name
     */
    public void setPubTN(String pubTN){ this.pubTN = pubTN; }

    /**
     * Gets the Publication's Type Name
     * @return Publication's Type Name
     */
    public String getPubTN() { return pubTN; }


    /**
     * Method that returns the Publication's Main Info
     * @return Publication's Main Info
     */
    @Override
    public String toString() {
        return ">> Title: " +
                title + "\n>> Authors: "+
                authors + "\n>> Publication Type: "+
                pubTN + "\n>> Keywords: "+
                keywords + "\n>> Published in " +
                publishedIn + "\n>> Audience Size: " +
                audienceSize + "\n>> Impact Factor: " +
                impactFactor;
    }

}
