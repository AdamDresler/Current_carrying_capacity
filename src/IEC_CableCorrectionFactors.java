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
     * @param temperature  Double value represents ambient temperature
     * @param installation String value represents method for the cable installation method
     * @param insulation   String value represents the cable insulation type
     */
    public double ambientTempFactor(String installation, Double temperature, String insulation) {
        double factor = 0.0;
        Double[] factor_for_PVC = {1.22, 1.17, 1.12, 1.06, 1.0, 0.94, 0.87, 0.79, 0.71, 0.61, 0.50};
        Double[] factor_for_XLPE = {1.15, 1.12, 1.08, 1.04, 1.0, 0.96, 0.91, 0.87, 0.82, 0.76, 0.71};

        if (installation.equals("D1 single-core") || installation.equals("D1 multicore") || installation.equals("D2")) {
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
     * @param temperature  Double value represents ambient temperature
     * @param installation String value represents method for the cable installation method
     * @param insulation   String value represents the cable insulation type
     */
    public double ambientTempFactorInGround(String installation, Double temperature, String insulation) {
        double factor = 0.0;
        Double[] factor_for_PVC = {1.10, 1.05, 1.00, 0.95, 0.89, 0.84, 0.77, 0.71, 0.63, 0.55, 0.45};
        Double[] factor_for_XLPE = {1.07, 1.04, 1.00, 0.96, 0.93, 0.89, 0.85, 0.80, 0.76, 0.71, 0.65};

        if (installation.equals("D1 single-core") || installation.equals("D1 multicore") || installation.equals("D2")) {
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
     * @param installation      String value represents method for the cable installation method
     * @param groundResistivity integer value  representing the position of the value from the table  {0.5, 0.7, 1,1,5, 2, 2.5, 3}
     */
    public double groundResistivityFactor(String installation, int groundResistivity) {
        double factor = 1.0;
        // Ground resistivity     0,5 ,  0,7,  1  , 1,5,   2,   2,5,   3
        Double[] factor_for_D1_method = {1.28, 1.20, 1.18, 1.10, 1.05, 1.00, 0.96};
        Double[] factor_for_D2_method = {1.88, 1.62, 1.50, 1.28, 1.12, 1.00, 0.90};

        if (installation.equals("D1 single-core") || installation.equals("D1 multicore")) {
            factor = factor_for_D1_method[groundResistivity];
        } else if (installation.equals("D2")) {
            factor = factor_for_D2_method[groundResistivity];
        }
        return factor;
    }


    /**
     * Reduction factors for more than one circuit or one multi-core cable or for a group
     * of more than one circuit, or more than one multi-core cable, to be used with current carrying capacities
     * IEC 60364-5-52 method A-F table B.52.17
     * Installation method D2 - IEC 60364-5-52 table B.52.18
     * Installation method D1 - IEC 60364-5-52 table B.52.19
     *
     * @param installation   String value represents method for the cable installation method
     * @param numberOfCables represents number of parallel cables
     * @param placement      bundles
     */
    public double bundlesFactor(String installation, int numberOfCables, int placement) {

        //Installation method A-F
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

        //Installation method D2
        //B.52.18 col. 2 - Cables in contact
        Double[] placement_6 = {1.00, 0.75, 0.65, 0.60, 0.55, 0.50, 0.45, 0.43, 0.41};
        //B.52.18 col. 3 - Clearance between cables one diameter
        Double[] placement_7 = {1.00, 0.80, 0.70, 0.60, 0.55, 0.55, 0.51, 0.48, 0.46};
        //B.52.18 col. 4 - Clearance between cables 0.125m
        Double[] placement_8 = {1.00, 0.85, 0.75, 0.70, 0.65, 0.60, 0.59, 0.57, 0.55};
        //B.52.18 col. 5 - Clearance between cables 0.25m
        Double[] placement_9 = {1.00, 0.90, 0.80, 0.75, 0.70, 0.70, 0.67, 0.65, 0.63};
        //B.52.18 col. 6 - Clearance between cables 0.5m
        Double[] placement_10 = {1.00, 0.90, 0.85, 0.80, 0.80, 0.80, 0.76, 0.75, 0.74};

        //Installation method D1
        // Multicore cables in separate sheaths
        // B.52.19A col. 2 - Cables in contact
        Double[] placement_11 = {1.00, 0.85, 0.75, 0.70, 0.65, 0.60, 0.57, 0.54, 0.52};
        // B.52.19A col. 3 -  Clearance between cables 0.25m
        Double[] placement_12 = {1.00, 0.90, 0.85, 0.80, 0.80, 0.80, 0.76, 0.74, 0.73};
        //B.52.19A col. 4 - Clearance between cables 0.5m
        Double[] placement_13 = {1.00, 0.95, 0.90, 0.85, 0.85, 0.80, 0.80, 0.78, 0.77};
        //B.52.19A col. 5 - Clearance between cables 1m
        Double[] placement_14 = {1.00, 0.95, 0.95, 0.90, 0.90, 0.90, 0.88, 0.88, 0.87};

        //Installation method D1
        //Single-core cables in separate sheaths
        //B.52.19B col. 2 - Cables in contact
        Double[] placement_15 = {1.00, 0.80, 0.70, 0.65, 0.60, 0.60, 0.53, 0.50, 0.47};
        //B.52.19B col. 3 -  - Clearance between cables 0.25m
        Double[] placement_16 = {1.00, 0.90, 0.80, 0.75, 0.70, 0.70, 0.66, 0.63, 0.61};
        //B.52.19B col. 4 -  - Clearance between cables 0.5m
        Double[] placement_17 = {1.00, 0.90, 0.85, 0.80, 0.80, 0.80, 0.76, 0.74, 0.73};
        //B.52.19B col. 5 -  - Clearance between cables 1m
        Double[] placement_18 = {1.00, 0.95, 0.90, 0.90, 0.90, 0.90, 0.87, 0.87, 0.86};

        double factor = 1.0;

        switch (installation) {
            //Installation method C
            case "C":
                switch (placement) {
                    case 0:
                        factor = placement_1[numberOfCables];
                        break;
                    case 1:
                        factor = placement_2[numberOfCables];
                        break;
                    case 2:
                        factor = placement_3[numberOfCables];
                        break;
                }
                break;
            //Installation method E-F
            case "E":
            case "F":
                switch (placement) {
                    case 0:
                        factor = placement_1[numberOfCables];
                        break;
                    case 1:
                        factor = placement_2[numberOfCables];
                        break;
                    case 2:
                        factor = placement_3[numberOfCables];
                        break;
                    case 3:
                        factor = placement_4[numberOfCables];
                        break;
                    case 4:
                        factor = placement_5[numberOfCables];
                        break;
                }
                break;
            //Installation method D2
            case "D2":
                switch (placement) {
                    case 0:
                        factor = placement_6[numberOfCables];
                        break;
                    case 1:
                        factor = placement_7[numberOfCables];
                        break;
                    case 2:
                        factor = placement_8[numberOfCables];
                        break;
                    case 3:
                        factor = placement_9[numberOfCables];
                        break;
                    case 4:
                        factor = placement_10[numberOfCables];
                        break;
                }

                break;
            //Installation method D1 multicore
            case "D1 multicore":
                switch (placement) {
                    case 0:
                        factor = placement_11[numberOfCables];
                        break;
                    case 1:
                        factor = placement_12[numberOfCables];
                        break;
                    case 2:
                        factor = placement_13[numberOfCables];
                        break;
                    case 3:
                        factor = placement_14[numberOfCables];
                        break;
                }
                break;
            //Installation method D1 single-core
            case "D1 single-core":
                switch (placement) {
                    case 0:
                        factor = placement_15[numberOfCables];
                        break;
                    case 1:
                        factor = placement_16[numberOfCables];
                        break;
                    case 2:
                        factor = placement_17[numberOfCables];
                        break;
                    case 3:
                        factor = placement_18[numberOfCables];
                        break;
                }
                break;
            //Installation method A-F
            default:
                if (placement == 0) {
                    factor = placement_1[numberOfCables];
                }
                break;
        }
        return factor;
    }


}
