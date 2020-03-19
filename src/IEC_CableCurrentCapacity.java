import utils.ArrayUtils;


public class IEC_CableCurrentCapacity {
    Double[] arrayCrossSection = {1.5, 2.5, 4.0, 6.0, 10.0, 16.0, 25.0, 35.0, 50.0, 70.0, 95.0, 120.0, 150.0, 185.0, 240.0, 300.0};


    /**
     * Formula for current carrying capacity  Icc by IEC 60364-5-523
     * Icc = A x S^m  - B x S^n
     *
     * @param A -  coefficient
     * @param s - cable cross section
     * @param m - the exponent depends on the type of cable
     *
     * PN-HD 60364-5-52: 2011 laying cables A-C and E, F, G , this pattern is current
     */
    private static double formulaCurrentCapacity(double A, double s, double m) {
        return A * Math.pow(s, m);
    }


    /**
     * Cable laying A1 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 2
     * IEC 60364-5-52 table B.52.2 col. 2
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_A1_PVC1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(11.2, cableCrossSection, 0.6118);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(8.61, cableCrossSection, 0.616);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying A1 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C2 col. 2
     * IEC 60364-5-52 table B.52.3 col. 2
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_A1_XLPE1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(14.9, cableCrossSection, 0.611);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(11.6, cableCrossSection, 0.615);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying A1 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C3 col. 2
     * IEC 60364-5-52 table B.52.4  col. 2
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_A1_PVC3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(10.4, cableCrossSection, 0.605);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(7.94, cableCrossSection, 0.612);
                break;
        }
        return Round.Round05(Icc);
    }


    /**
     * Cable laying A1 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C4 col. 2
     * IEC 60364-5-52 table B.52.5  col. 2
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_A1_XLPE3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(13.34, cableCrossSection, 0.611);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(10.9, cableCrossSection, 0.605);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying A2 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 3
     * IEC 60364-5-52 table B.52.2 col. 3
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_A2_PVC1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            case "CU":
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(10.8, cableCrossSection, 0.6015);
                } else {
                    Icc = formulaCurrentCapacity(10.19, cableCrossSection, 0.6118);
                }
                break;
            case "AL":
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(8.361, cableCrossSection, 0.6025);
                } else {
                    Icc = formulaCurrentCapacity(7.84, cableCrossSection, 0.616);
                }
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying A2 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C2 col. 3
     * IEC 60364-5-52 table B.52.3 col. 3
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_A2_XLPE1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            case "CU":
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(14.46, cableCrossSection, 0.598);

                } else {
                    Icc = formulaCurrentCapacity(13.56, cableCrossSection, 0.611);
                }
                break;
            case "AL":
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(11.26, cableCrossSection, 0.602);
                } else {
                    Icc = formulaCurrentCapacity(10.56, cableCrossSection, 0.615);
                }
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying A2 for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C3 col. 3
     * IEC 60364-5-52 table B.52.4 col. 3
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_A2_PVC3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            case "CU":
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(10.1, cableCrossSection, 0.592);
                } else {
                    Icc = formulaCurrentCapacity(9.462, cableCrossSection, 0.605);
                }
                break;
            case "AL":
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(7.712, cableCrossSection, 0.5984);
                } else {
                    Icc = formulaCurrentCapacity(7.225, cableCrossSection, 0.612);
                }
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying A2 for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C4 col. 3
     * IEC 60364-5-52 table B.52.5 col. 3
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_A2_XLPE3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(12.95, cableCrossSection, 0.598);

                } else {
                    Icc = formulaCurrentCapacity(12.14, cableCrossSection, 0.611);
                }
                break;
            //aluminium
            case "AL":
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(10.58, cableCrossSection, 0.592);
                } else {
                    Icc = formulaCurrentCapacity(9.92, cableCrossSection, 0.605);
                }
                break;
        }
        return Round.Round05(Icc);
    }


    /**
     * Cable laying B1 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 4
     * IEC 60364-5-52 table B.52.2 col. 4
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_B1_PVC1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            case "CU":
                Icc = formulaCurrentCapacity(13.5, cableCrossSection, 0.625);
                break;
            case "AL":
                Icc = formulaCurrentCapacity(10.51, cableCrossSection, 0.6254);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying B1 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C2 col. 4
     * IEC 60364-5-52 table B.52.3 col. 4
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_B1_XLPE1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            case "CU":
                Icc = formulaCurrentCapacity(17.76, cableCrossSection, 0.6250);
                break;
            case "AL":
                Icc = formulaCurrentCapacity(13.95, cableCrossSection, 0.627);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying B1 for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C3 col. 4
     * IEC 60364-5-52 table B.52.4 col. 4
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_B1_PVC3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            case "CU":
                Icc = formulaCurrentCapacity(11.84, cableCrossSection, 0.628);
                break;
            case "AL":
                Icc = formulaCurrentCapacity(9.265, cableCrossSection, 0.627);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying B1 for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C4 col. 4
     * IEC 60364-5-52 table B.52.5 col. 4
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_B1_XLPE3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(15.62, cableCrossSection, 0.6252);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(12.3, cableCrossSection, 0.630);
                break;
        }
        return Round.Round05(Icc);
    }


    /**
     * Cable laying B2 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 5
     * IEC 60364-5-52 table B.52.2 col. 5
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_B2_PVC1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(13.1, cableCrossSection, 0.600);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(10.24, cableCrossSection, 0.5994);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying B2 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C2 col. 5
     * IEC 60364-5-52 table B.52.3 col. 5
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_B2_XLPE1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(17.25, cableCrossSection, 0.600);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(13.5, cableCrossSection, 0.603);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying B2 for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C3 col. 5
     * IEC 60364-5-52 table B.52.4 col. 5
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_B2_PVC3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(11.65, cableCrossSection, 0.6005);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(9.03, cableCrossSection, 0.601);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying B2 for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C4 col. 5
     * IEC 60364-5-52 table B.52.5 col. 5
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_B2_XLPE3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(15.17, cableCrossSection, 0.60);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(11.95, cableCrossSection, 0.605);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying C for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 6
     * IEC 60364-5-52 table B.52.2 col. 6
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_C_PVC1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(15.0, cableCrossSection, 0.622);

                } else {
                    Icc = formulaCurrentCapacity(15.0, cableCrossSection, 0.625);
                }
                break;
            //aluminium
            case "AL":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(11.6, cableCrossSection, 0.625);
                } else {
                    Icc = formulaCurrentCapacity(10.55, cableCrossSection, 0.640);
                }
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying C for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C2 col. 6
     * IEC 60364-5-52 table B.52.3 col. 6
     */
    private static double Icc_C_XLPE1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(18.77, cableCrossSection, 0.628);

                } else {
                    Icc = formulaCurrentCapacity(17.0, cableCrossSection, 0.650);
                }
                break;
            //aluminium
            case "AL":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(14.8, cableCrossSection, 0.625);
                } else {
                    Icc = formulaCurrentCapacity(12.6, cableCrossSection, 0.648);
                }
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying C for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C3 col. 6
     * IEC 60364-5-52 table B.52.4 col. 6
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_C_PVC3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(13.5, cableCrossSection, 0.625);

                } else {
                    Icc = formulaCurrentCapacity(12.4, cableCrossSection, 0.635);
                }
                break;
            //aluminium
            case "AL":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(10.5, cableCrossSection, 0.625);
                } else {
                    Icc = formulaCurrentCapacity(9.536, cableCrossSection, 0.6324);
                }
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying C for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C4 col. 6
     * IEC 60364-5-52 table B.52.5 col. 6
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_C_XLPE3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(17.0, cableCrossSection, 0.623);

                } else {
                    Icc = formulaCurrentCapacity(15.4, cableCrossSection, 0.635);
                }
                break;
            //aluminium
            case "AL":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(13.5, cableCrossSection, 0.625);
                } else {
                    Icc = formulaCurrentCapacity(11.5, cableCrossSection, 0.639);
                }
                break;
        }
        return Round.Round05(Icc);
    }


    /**
     * Cable laying D1 for two wires of the cable are loaded in PVC insulation
     * <p>
     * IEC 60364-5-52 table B.52.2 col. 7
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private double Icc_D1_PVC1(String cableMaterial, double cableCrossSection) {
        Double[] array;
        Double[] arrayD1_PVC1_Cooper = {22.0, 29.0, 37.0, 46.0, 60.0, 78.0, 99.0, 119.0, 140.0, 173.0, 204.0, 231.0, 261.0, 292.0, 336.0, 379.0};
        Double[] arrayD1_PVC1_Aluminium = {0.0, 22.0, 29.0, 36.0, 47.0, 61.0, 77.0, 93.0, 109.0, 135.0, 159.0, 180.0, 204.0, 228.0, 262.0, 296.0};
        double Icc;
        if (cableMaterial.equals("CU")) {
            array = arrayD1_PVC1_Cooper;
        } else {
            array = arrayD1_PVC1_Aluminium;
        }

        int x = ArrayUtils.findElementIndex(arrayCrossSection, cableCrossSection);
        Icc = array[x];
        return Round.Round05(Icc);
    }

    /**
     * Cable laying D1 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-52 table B.52.3 col. 7
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private double Icc_D1_XLPE1(String cableMaterial, double cableCrossSection) {
        Double[] array;
        Double[] arrayD1_XLPE1_Cooper = {25.0, 33.0, 43.0, 53.0, 71.0, 91.0, 116.0, 139.0, 164.0, 203.0, 239.0, 271.0, 306.0, 343.0, 395.0, 446.0};
        Double[] arrayD1_XLPE1_Aluminium = {0.0, 26.0, 33.0, 42.0, 55.0, 71.0, 90.0, 108.0, 128.0, 158.0, 186.0, 211.0, 238.0, 267.0, 307.0, 346.0};
        double Icc;
        if (cableMaterial.equals("CU")) {
            array = arrayD1_XLPE1_Cooper;
        } else {
            array = arrayD1_XLPE1_Aluminium;
        }

        int x = ArrayUtils.findElementIndex(arrayCrossSection, cableCrossSection);
        Icc = array[x];
        return Round.Round05(Icc);
    }

    /**
     * Cable laying D1 for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-52 table B.52.4 col. 7
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private double Icc_D1_PVC3(String cableMaterial, double cableCrossSection) {
        Double[] array;
        Double[] arrayD1_PVC3_Cooper = {18.0, 24.0, 30.0, 38.0, 50.0, 64.0, 82.0, 98.0, 116.0, 143.0, 169.0, 192.0, 217.0, 243.0, 280.0, 316.0};
        Double[] arrayD1_PVC3_Aluminium = {0.0, 18.5, 24.0, 30.0, 39.0, 50.0, 64.0, 77.0, 91.0, 112.0, 132.0, 150.0, 169.0, 190.0, 218.0, 247.0};
        double Icc;
        if (cableMaterial.equals("CU")) {
            array = arrayD1_PVC3_Cooper;
        } else {
            array = arrayD1_PVC3_Aluminium;
        }

        int x = ArrayUtils.findElementIndex(arrayCrossSection, cableCrossSection);
        Icc = array[x];
        return Round.Round05(Icc);
    }

    /**
     * Cable laying D1 for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-52 table B.52.5 col. 7
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private double Icc_D1_XLPE3(String cableMaterial, double cableCrossSection) {
        Double[] array;
        Double[] arrayD1_XLPE3_Cooper = {21.0, 28.0, 36.0, 44.0, 58.0, 75.0, 96.0, 115.0, 135.0, 167.0, 197.0, 223.0, 251.0, 281.0, 324.0, 365.0};
        Double[] arrayD1_XLPE3_Aluminium = {0.0, 22.0, 28.0, 35.0, 46.0, 59.0, 75.0, 90.0, 106.0, 130.0, 154.0, 174.0, 197.0, 220.0, 253.0, 286.0};
        double Icc;
        if (cableMaterial.equals("CU")) {
            array = arrayD1_XLPE3_Cooper;
        } else {
            array = arrayD1_XLPE3_Aluminium;
        }

        int x = ArrayUtils.findElementIndex(arrayCrossSection, cableCrossSection);
        Icc = array[x];
        return Round.Round05(Icc);
    }

    /**
     * Cable laying D2 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-52 table B.52.2 col. 8
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private double Icc_D2_PVC1(String cableMaterial, double cableCrossSection) {
        Double[] array;
        Double[] arrayD2_PVC1_Cooper = {22.0, 28.0, 38.0, 48.0, 64.0, 83.0, 110.0, 132.0, 156.0, 192.0, 230.0, 261.0, 293.0, 331.0, 382.0, 427.0};
        Double[] arrayD2_PVC1_Aluminium = {0.0, 0.0, 0.0, 0.0, 0.0, 63.0, 82.0, 98.0, 117.0, 145.0, 173.0, 200.0, 224.0, 255.0, 298.0, 336.0};
        double Icc;
        if (cableMaterial.equals("CU")) {
            array = arrayD2_PVC1_Cooper;
        } else {
            array = arrayD2_PVC1_Aluminium;
        }
        int x = ArrayUtils.findElementIndex(arrayCrossSection, cableCrossSection);
        Icc = array[x];
        return Round.Round05(Icc);
    }

    /**
     * Cable laying D2 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-52 table B.52.3 col. 8
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private double Icc_D2_XLPE1(String cableMaterial, double cableCrossSection) {
        Double[] array;
        Double[] arrayD2_XLPE1_Cooper = {27.0, 35.0, 46.0, 58.0, 77.0, 100.0, 129.0, 155.0, 183.0, 225.0, 270.0, 306.0, 343.0, 387.0, 448.0, 502.0};
        Double[] arrayD2_XLPE1_Aluminium = {0.0, 0.0, 0.0, 0.0, 0.0, 76.0, 98.0, 117.0, 139.0, 170.0, 204.0, 233.0, 261.0, 296.0, 343.0, 386.0};
        double Icc;
        if (cableMaterial.equals("CU")) {
            array = arrayD2_XLPE1_Cooper;
        } else {
            array = arrayD2_XLPE1_Aluminium;
        }
        int x = ArrayUtils.findElementIndex(arrayCrossSection, cableCrossSection);
        Icc = array[x];
        return Round.Round05(Icc);
    }

    /**
     * Cable laying D2 for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-52 table B.52.4 col. 8
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private double Icc_D2_PVC3(String cableMaterial, double cableCrossSection) {
        Double[] array;
        Double[] arrayD2_PVC3_Cooper = {19.0, 24.0, 33.0, 41.0, 54.0, 70.0, 92.0, 110.0, 130.0, 162.0, 193.0, 220.0, 246.0, 278.0, 320.0, 359.0};
        Double[] arrayD2_PVC3_Aluminium = {0.0, 0.0, 0.0, 0.0, 0.0, 53.0, 69.0, 83.0, 99.0, 122.0, 148.0, 169.0, 189.0, 214.0, 250.0, 282.0};
        double Icc;
        if (cableMaterial.equals("CU")) {
            array = arrayD2_PVC3_Cooper;
        } else {
            array = arrayD2_PVC3_Aluminium;
        }
        int x = ArrayUtils.findElementIndex(arrayCrossSection, cableCrossSection);
        Icc = array[x];
        return Round.Round05(Icc);
    }

    /**
     * Cable laying D2 for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-52 table B.52.5 col. 8
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private double Icc_D2_XLPE3(String cableMaterial, double cableCrossSection) {
        Double[] array;
        Double[] arrayD2_XLPE3_Cooper = {23.0, 30.0, 39.0, 49.0, 65.0, 84.0, 107.0, 129.0, 153.0, 188.0, 226.0, 257.0, 287.0, 324.0, 375.0, 419.0};
        Double[] arrayD2_XLPE3_Aluminium = {0.0, 0.0, 0.0, 0.0, 0.0, 64.0, 82.0, 98.0, 117.0, 114.0, 172.0, 197.0, 220.0, 250.0, 290.0, 326.0};
        double Icc;
        if (cableMaterial.equals("CU")) {
            array = arrayD2_XLPE3_Cooper;
        } else {
            array = arrayD2_XLPE3_Aluminium;
        }
        int x = ArrayUtils.findElementIndex(arrayCrossSection, cableCrossSection);
        Icc = array[x];
        return Round.Round05(Icc);
    }

    /**
     * Cable laying E for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C9/C10 col. 2
     * IEC 60364-5-52 table B.52.10/11 col. 2
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_E_PVC1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(16.8, cableCrossSection, 0.62);

                } else {
                    Icc = formulaCurrentCapacity(14.9, cableCrossSection, 0.646);
                }
                break;
            //aluminium
            case "AL":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(12.8, cableCrossSection, 0.627);
                } else {
                    Icc = formulaCurrentCapacity(11.4, cableCrossSection, 0.64);
                }
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying E for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C9/C10 col. 3
     * IEC 60364-5-52 table B.52.10/11 col. 3
     */
    private static double Icc_E_PVC3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(14.3, cableCrossSection, 0.62);

                } else {
                    Icc = formulaCurrentCapacity(12.9, cableCrossSection, 0.64);
                }
                break;
            //aluminium
            case "AL":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(11.0, cableCrossSection, 0.62);
                } else {
                    Icc = formulaCurrentCapacity(9.9, cableCrossSection, 0.64);
                }
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying E for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C11/C12 col. 2
     * IEC 60364-5-52 table B.52.12/13 col. 2
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_E_XLPE1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(20.5, cableCrossSection, 0.623);

                } else {
                    Icc = formulaCurrentCapacity(18.6, cableCrossSection, 0.646);
                }
                break;
            //aluminium
            case "AL":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(16.0, cableCrossSection, 0.625);
                } else {
                    Icc = formulaCurrentCapacity(13.4, cableCrossSection, 0.649);
                }
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying E for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C11/C12 col. 3
     * IEC 60364-5-52 table B.52.12/13 col. 3
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_E_XLPE3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(17.8, cableCrossSection, 0.623);

                } else {
                    Icc = formulaCurrentCapacity(16.4, cableCrossSection, 0.637);
                }
                break;
            //aluminium
            case "AL":
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(13.7, cableCrossSection, 0.623);
                } else {
                    Icc = formulaCurrentCapacity(12.6, cableCrossSection, 0.635);
                }
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying F for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C9/C10 col. 4
     * IEC 60364-5-52 table B.52.10 col. 4
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_F_PVC1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(17.1, cableCrossSection, 0.632);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(12.0, cableCrossSection, 0.653);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying F triangle for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C9/C10 col. 5
     * IEC 60364-5-52 table B.52.10 col. 5
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_F_tri_PVC3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(13.28, cableCrossSection, 0.6564);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(9.9, cableCrossSection, 0.663);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying F flat for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C9/C10 col. 6
     * IEC 60364-5-52 table B.52.10 col. 6
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_F_flat_PVC3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(13.75, cableCrossSection, 0.6581);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(10.2, cableCrossSection, 0.666);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying F for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C11/C12 col. 4
     * IEC 60364-5-52 table B.52.12/13 col. 4
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_F_XLPE1(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(20.8, cableCrossSection, 0.636);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(14.7, cableCrossSection, 0.654);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying F triangle for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C11/C12 col. 5
     * IEC 60364-5-52 table B.52.12/13 col. 5
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_F_tri_XLPE3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(16.0, cableCrossSection, 0.6633);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(11.9, cableCrossSection, 0.671);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying F flat for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C11/C12 col. 6
     * IEC 60364-5-52 table B.52.12/13 col. 6
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_F_flat_XLPE3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(16.57, cableCrossSection, 0.665);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(12.3, cableCrossSection, 0.673);
                break;
        }
        return Round.Round05(Icc);
    }


    /**
     * Cable laying G horizontal for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C9/C10 col. 7
     * IEC 60364-5-52 table B.52.10/11 col. 7
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_G_horizontal_PVC3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(18.75, cableCrossSection, 0.637);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(13.9, cableCrossSection, 0.647);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying G horizontal for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C11/C12 col. 7
     * IEC 60364-5-52 table B.52.12/13 col. 7
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_G_horizontal_XLPE3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(22.9, cableCrossSection, 0.644);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(16.5, cableCrossSection, 0.659);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying G vertical for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C9/C10 col. 8
     * IEC 60364-5-52 table B.52.10/11 col. 8
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_G_vertical_PVC3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(15.8, cableCrossSection, 0.654);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(12.5, cableCrossSection, 0.668);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Cable laying G vertical for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C11/C12 col. 8
     * IEC 60364-5-52 table B.52.12/13 col. 8
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */
    private static double Icc_G_vertical_XLPE3(String cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case "CU":
                Icc = formulaCurrentCapacity(19.1, cableCrossSection, 0.662);
                break;
            //aluminium
            case "AL":
                Icc = formulaCurrentCapacity(13.8, cableCrossSection, 0.676);
                break;
        }
        return Round.Round05(Icc);
    }

    /**
     * Current carrying capacity Icc for cable laying
     *
     * @param laying         cable laying
     * @param insulation     PVC/XLPE
     * @param numberOfPhases 1 or 3
     * @param wiresMaterial  CU (cooper) ora AL (aluminium)
     * @param crossSection   cable cross section
     * @return cable current capacity
     */
    public static double getIcc(String laying, String insulation, int numberOfPhases, String wiresMaterial, double crossSection) {
        double Icc = 0.0;
        if (numberOfPhases == 1) {
            if (insulation.equals("PVC")) {
                switch (laying) {
                    case "A1":
                        Icc = Icc_A1_PVC1(wiresMaterial, crossSection);
                        break;
                    case "A2":
                        Icc = Icc_A2_PVC1(wiresMaterial, crossSection);
                        break;
                    case "B1":
                        Icc = Icc_B1_PVC1(wiresMaterial, crossSection);
                        break;
                    case "B2":
                        Icc = Icc_B2_PVC1(wiresMaterial, crossSection);
                        break;
                    case "C":
                        Icc = Icc_C_PVC1(wiresMaterial, crossSection);
                        break;
                    case "D1":
                        Icc = new IEC_CableCurrentCapacity().Icc_D1_PVC1(wiresMaterial, crossSection);
                        break;
                    case "D2":
                        Icc = new IEC_CableCurrentCapacity().Icc_D2_PVC1(wiresMaterial, crossSection);
                        break;
                    case "E":
                        Icc = Icc_E_PVC1(wiresMaterial, crossSection);
                        break;
                    case "F":
                        Icc = Icc_F_PVC1(wiresMaterial, crossSection);
                        break;
                }
            } else if (insulation.equals("XLPE")) {
                switch (laying) {
                    case "A1":
                        Icc = Icc_A1_XLPE1(wiresMaterial, crossSection);
                        break;
                    case "A2":
                        Icc = Icc_A2_XLPE1(wiresMaterial, crossSection);
                        break;
                    case "B1":
                        Icc = Icc_B1_XLPE1(wiresMaterial, crossSection);
                        break;
                    case "B2":
                        Icc = Icc_B2_XLPE1(wiresMaterial, crossSection);
                        break;
                    case "C":
                        Icc = Icc_C_XLPE1(wiresMaterial, crossSection);
                        break;
                    case "D1":
                        Icc = new IEC_CableCurrentCapacity().Icc_D1_XLPE1(wiresMaterial, crossSection);
                        break;
                    case "D2":
                        Icc = new IEC_CableCurrentCapacity().Icc_D2_XLPE1(wiresMaterial, crossSection);
                        break;
                    case "E":
                        Icc = Icc_E_XLPE1(wiresMaterial, crossSection);
                        break;
                    case "F":
                        Icc = Icc_F_XLPE1(wiresMaterial, crossSection);
                        break;
                }
            }
        } else if (numberOfPhases == 3) {
            if (insulation.equals("PVC")) {
                switch (laying) {
                    case "A1":
                        Icc = Icc_A1_PVC3(wiresMaterial, crossSection);
                        break;
                    case "A2":
                        Icc = Icc_A2_PVC3(wiresMaterial, crossSection);
                        break;
                    case "B1":
                        Icc = Icc_B1_PVC3(wiresMaterial, crossSection);
                        break;
                    case "B2":
                        Icc = Icc_B2_PVC3(wiresMaterial, crossSection);
                        break;
                    case "C":
                        Icc = Icc_C_PVC3(wiresMaterial, crossSection);
                        break;
                    case "D1":
                        Icc = new IEC_CableCurrentCapacity().Icc_D1_PVC3(wiresMaterial, crossSection);
                        break;
                    case "D2":
                        Icc = new IEC_CableCurrentCapacity().Icc_D2_PVC3(wiresMaterial, crossSection);
                        break;
                    case "E":
                        Icc = Icc_E_PVC3(wiresMaterial, crossSection);
                        break;
                    case "F triangle":
                        Icc = Icc_F_tri_PVC3(wiresMaterial, crossSection);
                        break;
                    case "F flat":
                        Icc = Icc_F_flat_PVC3(wiresMaterial, crossSection);
                        break;
                    case "G horizontal":
                        Icc = Icc_G_horizontal_PVC3(wiresMaterial, crossSection);
                        break;
                    case "G vertical":
                        Icc = Icc_G_vertical_PVC3(wiresMaterial, crossSection);
                        break;
                }
            } else if (insulation.equals("XLPE")) {
                switch (laying) {
                    case "A1":
                        Icc = Icc_A1_XLPE3(wiresMaterial, crossSection);
                        break;
                    case "A2":
                        Icc = Icc_A2_XLPE3(wiresMaterial, crossSection);
                        break;
                    case "B1":
                        Icc = Icc_B1_XLPE3(wiresMaterial, crossSection);
                        break;
                    case "B2":
                        Icc = Icc_B2_XLPE3(wiresMaterial, crossSection);
                        break;
                    case "C":
                        Icc = Icc_C_XLPE3(wiresMaterial, crossSection);
                        break;
                    case "D1":
                        Icc = new IEC_CableCurrentCapacity().Icc_D1_XLPE3(wiresMaterial, crossSection);
                        break;
                    case "D2":
                        Icc = new IEC_CableCurrentCapacity().Icc_D2_XLPE3(wiresMaterial, crossSection);
                        break;
                    case "E":
                        Icc = Icc_E_XLPE3(wiresMaterial, crossSection);
                        break;
                    case "F triangle":
                        Icc = Icc_F_tri_XLPE3(wiresMaterial, crossSection);
                        break;
                    case "F flat":
                        Icc = Icc_F_flat_XLPE3(wiresMaterial, crossSection);
                        break;
                    case "G horizontal":
                        Icc = Icc_G_horizontal_XLPE3(wiresMaterial, crossSection);
                        break;
                    case "G vertical":
                        Icc = Icc_G_vertical_XLPE3(wiresMaterial, crossSection);
                        break;
                }
            }

        }

        return Icc;
    }


}
