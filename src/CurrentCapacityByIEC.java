import utils.ArrayUtils;

import java.lang.reflect.Array;

public class CurrentCapacityByIEC {
    Double[] arrayCrossSection = {1.5, 2.5, 4.0, 6.0, 10.0, 16.0, 25.0, 35.0, 50.0, 70.0, 95.0, 120.0, 150.0, 185.0, 240.0, 300.0};


    /**
     * Formula for current carrying capacity  Icc by IEC 60364-5-523
     * Icc = A x S^m  - B x S^n
     *
     * @param A -  coefficient
     * @param s - cable cross section
     * @param m - the exponent depends on the type of cable
     *          <p>
     *          PN-HD 60364-5-52: 2011 laying cables A-C and E, this pattern is current
     */
    private static double formulaCurrentCapacity(double A, double s, double m) {
        return A * Math.pow(s, m);
    }

    /**
     * Current carrying capacity Icc for cable laying
     *
     * @param cableMaterial     cooper CU / aluminium AL
     * @param cableCrossSection cable cross section
     */

    /*
     * Cable laying A1 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 2
     * IEC 60364-5-52 table B.52.2 col. 2
     */
    public static double Icc_A1_PVC1(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(11.2, cableCrossSection, 0.6118);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(8.61, cableCrossSection, 0.616);
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying A1 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C2 col. 2
     * IEC 60364-5-52 table B.52.3 col. 2
     */
    public static double Icc_A1_XLPE1(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(14.9, cableCrossSection, 0.611);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(11.6, cableCrossSection, 0.615);
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying A1 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C3 col. 2
     * IEC 60364-5-52 table B.52.4  col. 2
     */
    public static double Icc_A1_PVC3(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(10.4, cableCrossSection, 0.605);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(7.94, cableCrossSection, 0.612);
                break;
        }
        return Round.Round10(Icc);
    }


    /*
     * Cable laying A1 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C4 col. 2
     * IEC 60364-5-52 table B.52.5  col. 2
     */
    public static double Icc_A1_XLPE3(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(13.34, cableCrossSection, 0.611);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(10.9, cableCrossSection, 0.605);
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying A2 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 3
     * IEC 60364-5-52 table B.52.2 col. 3
     */
    public static double Icc_A2_PVC1(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(10.8, cableCrossSection, 0.6015);
                } else {
                    Icc = formulaCurrentCapacity(10.19, cableCrossSection, 0.6118);
                }
                break;
            //aluminium
            case 1:
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(8.361, cableCrossSection, 0.6025);
                } else {
                    Icc = formulaCurrentCapacity(7.84, cableCrossSection, 0.616);
                }
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying A2 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C2 col. 3
     * IEC 60364-5-52 table B.52.3 col. 3
     */
    public static double Icc_A2_XLPE1(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(14.46, cableCrossSection, 0.598);

                } else {
                    Icc = formulaCurrentCapacity(13.56, cableCrossSection, 0.611);
                }
                break;
            //aluminium
            case 1:
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(11.26, cableCrossSection, 0.602);
                } else {
                    Icc = formulaCurrentCapacity(10.56, cableCrossSection, 0.615);
                }
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying A2 for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C3 col. 3
     * IEC 60364-5-52 table B.52.4 col. 3
     */
    public static double Icc_A2_PVC3(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(10.1, cableCrossSection, 0.592);
                } else {
                    Icc = formulaCurrentCapacity(9.462, cableCrossSection, 0.605);
                }
                break;
            //aluminium
            case 1:
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(7.712, cableCrossSection, 0.5984);
                } else {
                    Icc = formulaCurrentCapacity(7.225, cableCrossSection, 0.612);
                }
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying A2 for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C4 col. 3
     * IEC 60364-5-52 table B.52.5 col. 3
     */
    public static double Icc_A2_XLPE3(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(12.95, cableCrossSection, 0.598);

                } else {
                    Icc = formulaCurrentCapacity(12.14, cableCrossSection, 0.611);
                }
                break;
            //aluminium
            case 1:
                if (cableCrossSection <= 120.0) {
                    Icc = formulaCurrentCapacity(10.58, cableCrossSection, 0.592);
                } else {
                    Icc = formulaCurrentCapacity(9.92, cableCrossSection, 0.605);
                }
                break;
        }
        return Round.Round10(Icc);
    }


    /*
     * Cable laying B1 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 4
     * IEC 60364-5-52 table B.52.2 col. 4
     */
    public static double Icc_B1_PVC1(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(13.5, cableCrossSection, 0.625);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(10.51, cableCrossSection, 0.6254);
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying B1 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C2 col. 4
     * IEC 60364-5-52 table B.52.3 col. 4
     */
    public static double Icc_B1_XLPE1(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(17.76, cableCrossSection, 0.6250);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(13.95, cableCrossSection, 0.627);
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying B1 for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C3 col. 4
     * IEC 60364-5-52 table B.52.4 col. 4
     */
    public static double Icc_B1_PVC3(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(11.84, cableCrossSection, 0.628);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(9.265, cableCrossSection, 0.627);
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying B1 for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C4 col. 4
     * IEC 60364-5-52 table B.52.5 col. 4
     */
    public static double Icc_B1_XLPE3(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(15.62, cableCrossSection, 0.6252);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(12.3, cableCrossSection, 0.630);
                break;
        }
        return Round.Round10(Icc);
    }


    /*
     * Cable laying B2 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 5
     * IEC 60364-5-52 table B.52.2 col. 5
     */
    public static double Icc_B2_PVC1(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(13.1, cableCrossSection, 0.600);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(10.24, cableCrossSection, 0.5994);
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying B2 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C2 col. 5
     * IEC 60364-5-52 table B.52.3 col. 5
     */
    public static double Icc_B2_XLPE1(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(17.25, cableCrossSection, 0.600);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(13.5, cableCrossSection, 0.603);
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying B2 for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C3 col. 5
     * IEC 60364-5-52 table B.52.4 col. 5
     */
    public static double Icc_B2_PVC3(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(11.65, cableCrossSection, 0.6005);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(9.03, cableCrossSection, 0.601);
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying B2 for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C4 col. 5
     * IEC 60364-5-52 table B.52.5 col. 5
     */
    public static double Icc_B2_XLPE3(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(15.17, cableCrossSection, 0.60);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(11.95, cableCrossSection, 0.605);
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying C for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 6
     * IEC 60364-5-52 table B.52.2 col. 6
     */
    public static double Icc_C_PVC1(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(15.0, cableCrossSection, 0.622);

                } else {
                    Icc = formulaCurrentCapacity(15.0, cableCrossSection, 0.625);
                }
                break;
            //aluminium
            case 1:
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(11.6, cableCrossSection, 0.625);
                } else {
                    Icc = formulaCurrentCapacity(10.55, cableCrossSection, 0.640);
                }
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying C for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C2 col. 6
     * IEC 60364-5-52 table B.52.3 col. 6
     */
    public static double Icc_C_XLPE1(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(18.77, cableCrossSection, 0.628);

                } else {
                    Icc = formulaCurrentCapacity(17.0, cableCrossSection, 0.650);
                }
                break;
            //aluminium
            case 1:
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(14.8, cableCrossSection, 0.625);
                } else {
                    Icc = formulaCurrentCapacity(12.6, cableCrossSection, 0.648);
                }
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying B2 for three wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C3 col. 6
     * IEC 60364-5-52 table B.52.4 col. 6
     */
    public static double Icc_C_PVC3(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(13.5, cableCrossSection, 0.625);

                } else {
                    Icc = formulaCurrentCapacity(12.4, cableCrossSection, 0.635);
                }
                break;
            //aluminium
            case 1:
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(10.5, cableCrossSection, 0.625);
                } else {
                    Icc = formulaCurrentCapacity(9.536, cableCrossSection, 0.6324);
                }
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying C for three wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C4 col. 6
     * IEC 60364-5-52 table B.52.5 col. 6
     */
    public static double Icc_C_XLPE3(int cableMaterial, double cableCrossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(17.0, cableCrossSection, 0.623);

                } else {
                    Icc = formulaCurrentCapacity(15.4, cableCrossSection, 0.635);
                }
                break;
            //aluminium
            case 1:
                if (cableCrossSection <= 16.0) {
                    Icc = formulaCurrentCapacity(13.5, cableCrossSection, 0.625);
                } else {
                    Icc = formulaCurrentCapacity(11.5, cableCrossSection, 0.639);
                }
                break;
        }
        return Round.Round10(Icc);
    }

    /*
     * Cable laying D1 for two wires of the cable are loaded in XLPE insulation
     *
     * IEC 60364-5-52 table B.52.5 col. 6
     */

    public double Icc_D1_XLPE3(int cableMaterial, double cableCrossSection) {
        Double[] array;
        Double[] arrayD1_XLPE3_Cooper = {21.0, 28.0, 36.0, 44.0, 58.0, 75.0, 96.0, 115.0, 135.0, 167.0, 197.0, 223.0, 251.0, 281.0, 324.0, 365.0};
        Double[] arrayD1_XLPE3_Aluminium = {0.0, 22.0, 28.0, 35.0, 46.0, 59.0, 75.0, 90.0, 106.0, 130.0, 154.0, 174.0, 197.0, 220.0, 253.0, 286.0};
        double Icc = 0.0;
        if (cableMaterial ==0){
            array = arrayD1_XLPE3_Cooper;
        }else{
            array = arrayD1_XLPE3_Aluminium;
        }

            int x = ArrayUtils.findElementIndex(arrayCrossSection, cableCrossSection);
            Icc = array[x];
            return Round.Round10(Icc);
        }


    }
