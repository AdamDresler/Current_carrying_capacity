/*
 * Copyright (c) 2019 Adam Dresler. All rights reserved.
 *
 */


public class Round {

    public static double Round10(double value) {
        if (value > 20.0) {
            value = Math.round((value * 10.0) / 10.0);
        } else {
            int x = (int) value;
            double y = value - x;
            if (y <= 0.25) {
                y = 0.0;
            } else if (y <= 0.75) {
                y = 0.5;
            } else if (y > 0.75) {
                y = 1.0;
            }
            value = x + y;
        }
        return value;
    }

    public static double Round100(double x){
        x = Math.round(x*100.0)/100.0;
        return x;
    }

    public static double Round1000(double x){
        x = Math.round(x*1000.0)/1000.0;
        return x;
    }

    public static double Round10000(double x){
        x = Math.round(x*10000.0)/10000.0;
        return x;
    }
}
