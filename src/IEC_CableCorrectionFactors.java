import utils.ArrayUtils;

/**
 * Correction factors to calculate current carrying capacity
 */

public class IEC_CableCorrectionFactors {
    // Ambient temperature values
    Double[] temperature_value = {10.0, 15.0, 20.0, 25.0, 30.0, 35.0, 40.0, 45.0, 50.0, 55.0, 60.0};

    public IEC_CableCorrectionFactors() {
    }

    /**
     * Correction factor for ambient air temperature other than 30 degrees
     * IEC 60364-5-52 table B.52.14
     *
     * @param temperature Double value represents ambient temperature
     * @param installation String value represents method for the cable installation method
     * @param insulation  String value represents the cable insulation type
     */
    public double ambientTempFactor(String installation, Double temperature, String insulation) {
        double factor = 0.0;
        Double[] factor_for_PVC = {1.22, 1.17, 1.12, 1.06, 1.0, 0.94, 0.87, 0.79, 0.71, 0.61, 0.50};
        Double[] factor_for_XLPE = {1.15, 1.12, 1.08, 1.04, 1.0, 0.96, 0.91, 0.87, 0.82, 0.76, 0.71};

        if (installation.equals("D1") || installation.equals("D2")) {
            factor = 1.0;
        } else {
            int x = ArrayUtils.findElementIndex(temperature_value, temperature);
            switch (insulation) {
                case "PVC":
                    factor = factor_for_PVC[x];
                    break;
                case "XLPE":
                    factor = factor_for_XLPE[x];
                    break;
            }
        }
        return factor;
    }

    /**
     * Correction factor for ambient temperature id groud other than 20 degrees
     * IEC 60364-5-52 table B.52.15
     *
     * @param temperature Double value represents ambient temperature
     * @param installation String value represents method for the cable installation method
     * @param insulation  String value represents the cable insulation type
     */
    public double ambientTempFactorInGround(String installation, Double temperature, String insulation) {
        double factor = 0.0;
        Double[] factor_for_PVC = {1.10, 1.05, 1.00, 0.95, 0.89, 0.84, 0.77, 0.71, 0.63, 0.55, 0.45};
        Double[] factor_for_XLPE = {1.07, 1.04, 1.00, 0.96, 0.93, 0.89, 0.85, 0.80, 0.76, 0.71, 0.65};

        if (installation.equals("D1") || installation.equals("D2")) {
            int x = ArrayUtils.findElementIndex(temperature_value, temperature);
            switch (insulation) {
                case "PVC":
                    factor = factor_for_PVC[x];
                    break;
                case "XLPE":
                    factor = factor_for_XLPE[x];
                    break;
            }
        } else {
            factor = 1.0;
        }
        return factor;
    }


    /**
     * Ground resistivity factor is used for the D1 and D2 cable laying
     * IEC 60364-5-52 table B.52.16
     *
     * @param installation String value represents method for the cable installation method
     * @param groundResistivity integer value  representing the position of the value from the table  {0.5, 0.7, 1,1,5, 2, 2.5, 3}
     */
    public static double groundResistivityFactor(String installation, int groundResistivity) {
        double factor = 0.0;

        // Ground resistivity     0,5 ,  0,7,  1  , 1,5,   2,   2,5,   3
        Double[] factor_for_D1_method = {1.28, 1.20, 1.18, 1.10, 1.05, 1.00, 0.96};
        Double[] factor_for_D2_method = {1.88, 1.62, 1.50, 1.28, 1.12, 1.00, 0.90};

        if (installation.equals("D1")) {
            factor = factor_for_D1_method[groundResistivity];
        } else if (installation.equals("D2")) {
            factor = factor_for_D2_method[groundResistivity];
        } else {
            factor = 1.0;
        }
        return factor;
    }


    /**
     * Reduction factors for more than one circuit or one multi-core cable or for a group
     * of more than one circuit, or more than one multi-core cable, to be used with current carrying capacities
     * IEC 60364-5-52 table B.52.17
     *
     * @param installation String value represents method for the cable installation method
     * @param numberOfCables represents number of parallel cables
     * @param placement bundles
     */
    public static double bundlesFactor(String installation, int numberOfCables, int placement){
        double factor = 0.0;
        // Cable harness in the air, on the surface, built-in or encapsulated
        Double[] placement_1 = {1.00, 0.80, 0.70, 0.65, 0.60, 0.57, 0.54, 0.52, 0.50};
        // Cable harness in a single layer on a wall, floor or an unperforated installation tray
        Double[] placement_2 = {1.00, 0.85, 0.79, 0.75, 0.73, 0.72, 0.72, 0.71, 0.70};
        //Cable harness in a single layer directly under the wooden ceiling
        Double[] placement_3 = {0.95, 0.81, 0.72, 0.68, 0.66, 0.64, 0.63, 0.62, 0.61};
        // Cable harness in a single layer in a horizontal or vertical perforated installation tray
        Double[] placement_4 = {1.00, 0.88, 0.82, 0.77, 0.75, 0.73, 0.73, 0.72, 0.72};
        // Cable harness in a single layer Method E and F on the installation ladder, in the installation brackets
        Double[] placement_5 = {1.00, 0.87, 0.82, 0.80, 0.79, 0.79, 0.79, 0.78, 0.78};

        return factor;
    }

    /**
     * Reduction factors for more than one circuit, cables laid directly in the
     * ground
     * Installation method D2 - IEC 60364-5-52 table B.52.18
     * Installation method D1 - IEC 60364-5-52 table B.52.19
     *
     * @param installation String value represents method for the cable installation method
     * @param numberOfCables represents number of parallel cables
     * @param placement bundles
     */
    public static double bundlesFactorForD2(String installation, int numberOfCables, int placement){
        //Installation method D2
        //B.52.18 col. 2 - Cables in contact
        Double[] placement_1 = {1.00, 0.75, 0.65, 0.60, 0.55, 0.50};
        //B.52.18 col. 3 - Clearance between cables one diameter
        Double[] placement_2 = {1.00, 0.80, 0.70, 0.60, 0.55, 0.55};
        //B.52.18 col. 4 - Clearance between cables 0.125m
        Double[] placement_3 = {1.00, 0.85, 0.75, 0.70, 0.65, 0.60};
        //B.52.18 col. 5 - Clearance between cables 0.25m
        Double[] placement_4 = {1.00, 0.90, 0.80, 0.75, 0.70, 0.70};
        //B.52.18 col. 6 - Clearance between cables 0.5m
        Double[] placement_5 = {1.00, 0.90, 0.85, 0.80, 0.80, 0.80};

        //Installation method D1
        // Multicore cables in separate sheaths
        // B.52.19A col. 2 - Cables in contact
        Double[] placement_6 = {1.00, 0.85, 0.75, 0.70, 0.65, 0.60};
        // B.52.19A col. 3 -  Clearance between cables 0.25m
        Double[] placement_7 = {1.00, 0.90, 0.85, 0.80, 0.80, 0.80};
        //B.52.19A col. 4 - Clearance between cables 0.5m
        Double[] placement_8 = {1.00, 0.95, 0.90, 0.85, 0.85, 0.80};
        //B.52.19A col. 5 - Clearance between cables 1m
        Double[] placement_9 = {1.00, 0.95, 0.95, 0.90, 0.90, 0.90};
        //Single-core cables in separate sheaths
        //B.52.19B col. 2 - Cables in contact
        Double[] placement_10 = {1.00, 0.80, 0.70, 0.65, 0.60, 0.60};
        //B.52.19B col. 3 -  - Clearance between cables 0.25m
        Double[] placement_11 = {1.00, 0.90, 0.80, 0.75, 0.70, 0.70};
        //B.52.19B col. 4 -  - Clearance between cables 0.5m
        Double[] placement_12 = {1.00, 0.90, 0.85, 0.80, 0.80, 0.80};
        //B.52.19B col. 5 -  - Clearance between cables 1m
        Double[] placement_13 = {1.00, 0.95, 0.90, 0.90, 0.90, 0.90};

        double factor = 0.0;

        if (installation.equals("D2")){
            switch (placement){
                case 0: factor =  placement_1[numberOfCables];
                break;
            }

        }else if (installation.equals("D1")){

        }else {
            factor = 1.0;
        }

        return factor;
    }





}
