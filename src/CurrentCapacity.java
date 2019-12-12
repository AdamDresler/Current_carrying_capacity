public class CurrentCapacity {

    public static double Round(double value) {
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

    /**
     * Formula for current carrying capacity by IEC 60364-5-523
     * I = A x S^m  - B x S^n
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
     * Cable laying A1 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 2
     * IEC 60364-5-52 table B.52.2 col. 2
     *
     * @param cableMaterial cooper, aluminium
     */
    public static double Idd_A1_PVC1(int cableMaterial, double crossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(11.2, crossSection, 0.6118);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(8.61, crossSection, 0.616);
                break;
        }
        return Round(Icc);
    }

    /**
     * Cable laying A1 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C3 col. 2
     * IEC 60364-5-52 table B.52.4  col. 2
     *
     * @param cableMaterial cooper, aluminium
     */
    public static double Idd_A1_PVC3(int cableMaterial, double crossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(10.4, crossSection, 0.605);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(7.94, crossSection, 0.612);
                break;
        }
        return Round(Icc);
    }

    /**
     * Cable laying A1 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C2 col. 2
     * IEC 60364-5-52 table B.52.3 col. 2
     *
     * @param cableMaterial cooper, aluminium
     */
    public static double Idd_A1_XLPE1(int cableMaterial, double crossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(14.9, crossSection, 0.611);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(11.6, crossSection, 0.615);
                break;
        }
        return Round(Icc);
    }

    /**
     * Cable laying A1 for two wires of the cable are loaded in XLPE insulation
     * IEC 60364-5-523 table 52-C4 col. 2
     * IEC 60364-5-52 table B.52.5  col. 2
     *
     * @param cableMaterial cooper, aluminium
     */
    public static double Idd_A1_XLPE3(int cableMaterial, double crossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                Icc = formulaCurrentCapacity(13.34, crossSection, 0.611);
                break;
            //aluminium
            case 1:
                Icc = formulaCurrentCapacity(10.9, crossSection, 0.605);
                break;
        }
        return Round(Icc);
    }

    /**
     * Cable laying A2 for two wires of the cable are loaded in PVC insulation
     * IEC 60364-5-523 table 52-C1 col. 3
     * IEC 60364-5-52 table B.52.2 col. 3
     *
     * @param cableMaterial cooper, aluminium
     */
    public static double Idd_A2_PVC1(int cableMaterial, double crossSection) {
        double Icc = 0.0;
        switch (cableMaterial) {
            //cooper
            case 0:
                if (crossSection >= 120.0) {
                    Icc = formulaCurrentCapacity(10.19, crossSection, 0.6118);
                } else {
                    Icc = formulaCurrentCapacity(10.8, crossSection, 0.6015);
                }
                break;
            //aluminium
            case 1:
                if (crossSection >= 120.0) {
                    Icc = formulaCurrentCapacity(7.84, crossSection, 0.616);
                } else {
                    Icc = formulaCurrentCapacity(8.361, crossSection, 0.6025);
                }
                break;
        }
        return Round(Icc);
    }

}
