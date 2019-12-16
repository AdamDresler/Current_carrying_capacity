public class main {
    public static void main(String[] args) {
        String laying = "A1";
        String insulation = "PVC";
        int numberOfPhases = 0;
        int cableMaterial =1;
        double crossSection = 6.0;

        double res = getIcc(laying, insulation, numberOfPhases, cableMaterial, crossSection);

        System.out.println(res);
        System.out.println(is1phase(numberOfPhases));

        double d = new CurrentCapacityByIEC().Icc_D1_XLPE3(cableMaterial, crossSection);


        System.out.println("D1: " + d);
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
                        Icc = CurrentCapacityByIEC.Icc_A1_PVC1(cableMaterial, crossSection);
                        break;
                    case "A2":
                        Icc = CurrentCapacityByIEC.Icc_A2_PVC1(cableMaterial, crossSection);
                        break;
                }
            }else{
                switch (laying) {
                    case "A1":
                        Icc = CurrentCapacityByIEC.Icc_A1_XLPE1(cableMaterial, crossSection);
                        break;
                    case "A2":
                        Icc = CurrentCapacityByIEC.Icc_A2_XLPE1(cableMaterial, crossSection);break;

                }

            }

        } else {
            if (insulation.equals("PVC")) {
                switch (laying) {
                    case "A1":
                        Icc = CurrentCapacityByIEC.Icc_A1_PVC3(cableMaterial, crossSection);
                        break;
                    case "A2":
                        Icc = CurrentCapacityByIEC.Icc_A2_PVC3(cableMaterial, crossSection);
                        break;
                }
            }else{
                //TODO
            }

        }
        return Icc;
    }
}


