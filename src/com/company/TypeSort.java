package com.company;

import java.util.Comparator;

public class TypeSort implements Comparator<Publication> {

    @Override
    public int compare(Publication o1, Publication o2) {
        return o1.getPubTN().compareTo(o2.getPubTN());
    }
}
