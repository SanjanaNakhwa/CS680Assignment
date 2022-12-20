package edu.umb.cs680.hw13;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement o1, FSElement o2) {
        Integer a = o1.getSize();
        Integer b = o2.getSize();
        return a.compareTo(b);
    }
    
}
