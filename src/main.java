public class main {
    public static void main(String[] args) {


        Cable cable = new Cable();
        cable.setType("YKYżo");
        cable.setInsulation("XLPE");
        cable.setWiresMaterial("AL");
        cable.setCrossSection(2.5);
        cable.setNumberOfWires(1);

        String laying = "D1 single-core";
        int numberOfPhases = 3;
        double ambientTemperature = 20.0;

        double res = IEC_CableCurrentCapacity.getIcc(laying, cable.getInsulation(), numberOfPhases, cable.getWiresMaterial(), cable.getCrossSection());
        System.out.println(cable.getType() + " -  " + cable.getInsulation()+ "/"+cable.getWiresMaterial()+" - " + laying + "/"+ numberOfPhases+ " : " + cable.getCrossSection()+"mm2 / " + res + "A");

        IEC_CableCorrectionFactors correction_factor = new IEC_CableCorrectionFactors();
        double ambient_factor = correction_factor.ambientTempFactor(laying,ambientTemperature,cable.getInsulation());
        System.out.println("Ambient factor = "+ ambient_factor);

        double ambient_factor_in_ground = correction_factor.ambientTempFactorInGround(laying,ambientTemperature,cable.getInsulation());
        System.out.println("Ambient factor in ground = "+ ambient_factor_in_ground);

        double harness_factor = correction_factor.bundlesFactor(laying, cable.getNumberOfWires(),3);
        System.out.println("Harness factor = "+ harness_factor);

        System.out.println("Final Iz [A] = "+ res * ambient_factor * ambient_factor_in_ground * harness_factor);



    }





}


