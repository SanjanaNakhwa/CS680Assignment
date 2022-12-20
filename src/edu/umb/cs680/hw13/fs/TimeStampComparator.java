package edu.umb.cs680.hw13;

import java.time.LocalDateTime;
import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        LocalDateTime a = o1.getCreationTime();
        LocalDateTime b = o2.getCreationTime();
        return a.compareTo(b);
    }    
}
