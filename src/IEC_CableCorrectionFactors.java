import utils.ArrayUtils;

/**
 * Correction factors to calculate current carrying capacity
 */

public class IEC_CableCorrectionFactors {

    /**
     * Correction factor for ambient air temperature other than 30 degrees
     * IEC 60364-5-52 table B.52.14
     * @param temperature String value repesents ambient temperature
     */
    public static double ambietTempFactor(String laying, Double temperature, String insulation){
        double factor = 0.0;
        Double [] temperatureValue =    {10.0, 15.0, 20.0, 25.0,30.0, 35.0, 40.0, 45.0, 50.0, 55.0, 60.0 };
        Double [] tempFactorPVC =       {1.22, 1.17, 1.12, 1.06, 1.0, 0.94, 0.87, 0.79, 0.71, 0.61, 0.50 };
        Double [] tempFactorXLPE =      {1.15, 1.12, 1.08, 1.04, 1.0, 0.96, 0.91, 0.87, 0.82, 0.76, 0.71 };

        if (laying.equals("D1") || laying.equals("D2")){
            factor = 1.0;
        }else {
            int x = ArrayUtils.findElementIndex(temperatureValue,temperature);
            switch (insulation){
                case "PVC":
                    factor = tempFactorPVC[x];
                break;
                case "XLPE":
                    factor = tempFactorXLPE[x];
                    break;
            }
        }

        return factor;
    }

    /**
     * Ground resistivity factor is used for the D1 and D2 cable laying
     * IEC 60364-5-52 table B.52.16
     * @param groungRes  integer value repesents ground resistivity  0.5, 0.7, 1,1,5, 2, 2.5, 3
     */
    public static double groundResistivityFactor(String laying, int groungRes) {
        double factor = 0.0;

        // Grund resistivity     0,5 ,  0,7,  1  , 1,5,   2,   2,5,   3
        Double[] groungResFactofForD1 = {1.28, 1.20, 1.18, 1.10, 1.05, 1.00, 0.96};
        Double[] groundResFactorForD2 = {1.88, 1.62, 1.50, 1.28, 1.12, 1.00, 0.90};

        if (laying.equals("D1")) {
            factor = groungResFactofForD1[groungRes];
        } else if (laying.equals("D2")) {
            factor = groundResFactorForD2[groungRes];
        } else {
            factor = 1.0;
        }
        return factor;
    }



}
