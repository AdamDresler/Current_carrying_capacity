/*
 * Copyright (c) 2019 Adam Dresler. All rights reserved.
 *
 */


public class Round {
    public static double Round05(double x){
        int x1 =  (int) x;
        double y = x - x1;
        if(y <= 0.25){
            y = 0.0;
        } else if (y <= 0.75){
            y = 0.5;
        }else if (y > 0.75){
            y=1.0;
        }

        return x1 + y;
    }
    public static double Round10(double x){
        x = Math.round(x*10.0)/10.0;
        return x;
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
