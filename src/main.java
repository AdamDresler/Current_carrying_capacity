public class main {
    public static void main(String[] args) {


        Cable cable = new Cable();
        cable.setType("YKYżo");
        cable.setInsulation("XLPE");
        cable.setWiresMaterial("AL");
        cable.setCrossSection(1.5);
        cable.setNumberOfWires(2);

        String laying = "G horizontal";
        int numberOfPhases = 3;
        double ambientTemperature = 15.0;

        double res = IEC_CableCurrentCapacity.getIcc(laying, cable.getInsulation(), numberOfPhases, cable.getWiresMaterial(), cable.getCrossSection());
        System.out.println(cable.getType() + " -  " + cable.getInsulation()+ "/"+cable.getWiresMaterial()+" - " + laying + "/"+ numberOfPhases+ " : " + cable.getCrossSection()+"mm2 / " + res + "A");

        IEC_CableCorrectionFactors correction_factor = new IEC_CableCorrectionFactors();
        double ambient_factor = correction_factor.ambientTempFactor(laying,ambientTemperature,cable.getInsulation());
        System.out.println(ambient_factor);

    }





}


