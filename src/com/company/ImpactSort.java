package com.company;

import java.util.Comparator;

public class ImpactSort implements Comparator<Publication> {

    @Override
    public int compare(Publication o1, Publication o2) {
        return o1.getImpactFactor().compareTo(o2.getImpactFactor());
    }
}
