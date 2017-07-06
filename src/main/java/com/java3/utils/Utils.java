package com.java3.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by jon.lynch on 7/5/17.
 */
public class Utils {

    /**
     * Get a list of years starting with current year and back for n
     * @param n
     */
    public static List<Integer> getYears(int n) {
        List<Integer> yearList = new ArrayList<Integer>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        do {
            yearList.add(currentYear--);
            n--;
        } while(n > 0);

        return yearList;
    }

}
