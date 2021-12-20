package com.company;

import java.util.Comparator;

public class DateSort implements Comparator<Publication> {

    public int compare(Publication o1, Publication o2) {
        return o1.getPublishedIn() - o2.getPublishedIn();
    }
}
