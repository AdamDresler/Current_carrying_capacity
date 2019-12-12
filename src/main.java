public class main {
    public static void main(String[] args) {
        String laying = "A1";
        String insulation = "PVC";
        int numberOfPhases = 0;
        int cableMaterial =0;
        double crossSection = 6.0;

        double res = getIcc(laying, insulation, numberOfPhases, cableMaterial, crossSection);

        System.out.println(res);
        System.out.println(is1phase(numberOfPhases));
    }

    public static boolean is1phase(int pos) {
        boolean result = true;
        if (pos > 0) {
            return false;
        }
        return result;
    }


    public static double getIcc(String laying, String insulation, int numberOfPhases, int cableMaterial, double crossSection) {
        double Icc = 0.0;
        if (is1phase(numberOfPhases)) {
            if (insulation.equals("PVC")) {
                switch (laying) {
                    case "A1":
                        Icc = CurrentCapacityByIEC.Iz_A1_PVC1(cableMaterial, crossSection);
                        break;
                    case "A2":
                        Icc = CurrentCapacityByIEC.Iz_A2_PVC1(cableMaterial, crossSection);
                        break;
                }
            }else{
                switch (laying) {
                    case "A1":
                        Icc = CurrentCapacityByIEC.Iz_A1_XLPE1(cableMaterial, crossSection);
                        break;
                    case "A2":
                        Icc = CurrentCapacityByIEC.Iz_A2_XLPE1(cableMaterial, crossSection);break;
                }

            }

        } else {
            if (insulation.equals("PVC")) {
                switch (laying) {
                    case "A1":
                        Icc = CurrentCapacityByIEC.Iz_A1_PVC3(cableMaterial, crossSection);
                        break;
                    case "A2":
                        Icc = CurrentCapacityByIEC.Iz_A2_PVC3(cableMaterial, crossSection);
                        break;
                }
            }else{
                //TODO
            }

        }
        return Icc;
    }
}


