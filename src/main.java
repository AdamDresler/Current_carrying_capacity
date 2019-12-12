public class main {
    public static void main(String[] args) {
        double res = Icc("A1", 0, 6);

        System.out.println(res);
    }


    public static double Icc(String laying, int cableMaterial, double crossSection) {
        double Icc = 0.0;
        switch (laying) {
            case "A1": Icc = CurrentCapacityByIEC.Iz_A1_PVC1(cableMaterial, crossSection);
                break;

        }
        return Icc;
    }


}
