
/**
 * Correction factors to calculate current carrying capacity
 */

public class CorrectionFactors {

    /**
     * Ground resistivity factor is used for the D1 and D2 cable laying
     * @param groungRes  integer value repesents ground resistivity  0.5, 0.7, 1,1,5, 2, 2.5, 3
     */
    public static double groundResistivityFactor(String laying, int groungRes) {
        double groundResFator = 0.0;

        // Grund resistivity     0,5 ,  0,7,  1  , 1,5,   2,   2,5,   3
        Double[] groungResFactofForD1 = {1.28, 1.20, 1.18, 1.10, 1.05, 1.00, 0.96};
        Double[] groundResFactorForD2 = {1.88, 1.62, 1.50, 1.28, 1.12, 1.00, 0.90};

        if (laying.equals("D1")) {
            groundResFator = groungResFactofForD1[groungRes];
        } else if (laying.equals("D2")) {
            groundResFator = groundResFactorForD2[groungRes];
        } else {
            groundResFator = 1.0;
        }
        return groundResFator;
    }

}
