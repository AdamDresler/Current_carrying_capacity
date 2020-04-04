public class old {
    /*
     * Copyright (c) 2019 Adam Dresler. All rights reserved.
     *
     */

    /*
     * Obliczenia oparto o norme PN IEC 60364-5-523
     * Wzory na obciążakność pochodzą z ww normy
     * Aktualizacja do normy PN HD 60364-5-52:2011
     */
    double Idd1;
    double crossSection;
    double kTemp;
    double kBundle;
    double fGroundRes;


    // Wzór na obciażalność dlugotrwalą
    public static double formulaIddIEC1(double kA, double crossSection, double kApower) {
        /* Wzór na obciazalnosc dlugotrwala zn PN IEC 60364-5-523
         * I = A x S^m  - B x S^n
         *  kA - współczynnik A
         *  crossSection - przekrój s
         *  kApower - wykładnik m
         *  PN-HD 60364-5-52:2011 wartości dla ułożenia A-C oraz E można obliczac z tego wzoru
         */
        return kA * Math.pow(crossSection, kApower);
    }

    // Obliczenie podstawowej wartości pradu obciążenia długotrwłego
    public void IddIEC1(int posTypeMaterial, int posNumberOfPhase, int posTypeInsulation, int posLayingCable, int posCrossSection) {
        switch (posTypeMaterial) {
            //CU
            case 0:
                //PVC
                switch (posTypeInsulation) {
                    case 0:
                        //1-f (norma stara / nowa  52-C1 / B.52.2)
                        switch (posNumberOfPhase) {
                            case 0:
                                //A1
                                switch (posLayingCable) {
                                    case 0:
                                        Idd1 = formulaIddIEC1(11.2, crossSection, 0.6118);
                                        break;
                                    //A2
                                    case 1:
                                        // >=120mm2
                                        if (posCrossSection >= 11) {
                                            Idd1 = formulaIddIEC1(10.19, crossSection, 0.6118);
                                            // <120
                                        } else {
                                            Idd1 = formulaIddIEC1(10.8, crossSection, 0.6015);
                                        }
                                        break;
                                    //B1
                                    case 2:
                                        Idd1 = formulaIddIEC1(13.5, crossSection, 0.625);
                                        break;
                                    //B2
                                    case 3:
                                        Idd1 = formulaIddIEC1(13.1, crossSection, 0.600);
                                        break;
                                    //C
                                    case 4:
                                        Idd1 = formulaIddIEC1(15.0, crossSection, 0.625);
                                        break;
                                    //D1
                                    case 5:
                                        Double[] D1PVC1f = {22.0, 29.0, 37.0, 46.0, 60.0, 78.0, 99.0, 119.0, 140.0, 173.0, 204.0, 231.0, 261.0, 292.0, 336.0, 379.0};
                                        Idd1 = D1PVC1f[posCrossSection];
                                        break;
                                    //D2
                                    case 6:
                                        Double[] D2PVC1f = {22.0, 28.0, 38.0, 48.0, 64.0, 83.0, 110.0, 132.0, 156.0, 192.0, 230.0, 261.0, 293.0, 331.0, 382.0, 427.0};
                                        Idd1 = D2PVC1f[posCrossSection];
                                        break;

                                    //E (tabela 52-C9)
                                    case 7:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(14.9, crossSection, 0.646);
                                            // <16
                                        } else {
                                            Idd1 = formulaIddIEC1(16.8, crossSection, 0.62);
                                        }
                                        break;
                                }
                                break;
                            //3-f	(norma tabela 52-C3 / B.52.4)
                            case 1:
                                //A1
                                switch (posLayingCable) {
                                    case 0:
                                        Idd1 = formulaIddIEC1(10.4, crossSection, 0.605);
                                        break;
                                    //A2
                                    case 1:
                                        // >=120mm2
                                        if (posCrossSection > 11) {
                                            Idd1 = formulaIddIEC1(9.462, crossSection, 0.605);
                                            // <120
                                        } else {
                                            Idd1 = formulaIddIEC1(10.1, crossSection, 0.592);
                                        }
                                        break;
                                    //B1
                                    case 2:
                                        Idd1 = formulaIddIEC1(11.84, crossSection, 0.628);
                                        break;
                                    //B2
                                    case 3:
                                        Idd1 = formulaIddIEC1(11.65, crossSection, 0.6005);
                                        break;
                                    //C
                                    case 4:
                                        // >=16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(12.4, crossSection, 0.635);
                                            // <16mm2
                                        } else {
                                            Idd1 = formulaIddIEC1(13.5, crossSection, 0.625);
                                        }
                                        break;
                                    //D1
                                    case 5:
                                        Double[] D1PVC3f = {18.0, 24.0, 30.0, 38.0, 50.0, 64.0, 82.0, 98.0, 116.0, 143.0, 169.0, 192.0, 217.0, 243.0, 280.0, 316.0};
                                        Idd1 = D1PVC3f[posCrossSection];
                                        break;
                                    //D2
                                    case 6:
                                        Double[] D2PVC3f = {19.0, 24.0, 33.0, 41.0, 54.0, 70.0, 92.0, 110.0, 130.0, 162.0, 193.0, 220.0, 246.0, 278.0, 320.0, 359.0};
                                        Idd1 = D2PVC3f[posCrossSection];
                                        break;

                                    //E (tabela E52-C9)
                                    case 7:
                                        // >=16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(12.9, crossSection, 0.64);
                                            // <16
                                        } else {
                                            Idd1 = formulaIddIEC1(14.3, crossSection, 0.62);
                                        }
                                }
                                break;
                        }
                        break;
                    //XLPE
                    case 1:
                        //1-f (norma tabela 52-C2 / B.52.3)
                        switch (posNumberOfPhase) {
                            case 0:
                                switch (posLayingCable) {
                                    //A1
                                    case 0:
                                        Idd1 = formulaIddIEC1(14.9, crossSection, 0.611);
                                        break;
                                    //A2
                                    case 1:
                                        // >120mm2
                                        if (posCrossSection > 11) {
                                            Idd1 = formulaIddIEC1(13.56, crossSection, 0.611);
                                            // <=120
                                        } else {
                                            Idd1 = formulaIddIEC1(14.46, crossSection, 0.598);
                                        }
                                        break;
                                    //B1
                                    case 2:
                                        Idd1 = formulaIddIEC1(17.76, crossSection, 0.625);
                                        break;
                                    //B2
                                    case 3:
                                        Idd1 = formulaIddIEC1(17.25, crossSection, 0.600);
                                        break;
                                    //C
                                    case 4:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(17.0, crossSection, 0.650);
                                            // <=16mm2
                                        } else {
                                            Idd1 = formulaIddIEC1(17.77, crossSection, 0.628);
                                        }
                                        break;
                                    //D1
                                    case 5:
                                        Double[] D1xlpe1f = {25.0, 33.0, 43.0, 53.0, 71.0, 91.0, 116.0, 139.0, 164.0, 203.0, 239.0, 271.0, 306.0, 343.0, 395.0, 446.0};
                                        Idd1 = D1xlpe1f[posCrossSection];
                                        break;
                                    //D2
                                    case 6:
                                        Double[] D2xlpe1f = {27.0, 35.0, 46.0, 58.0, 77.0, 100.0, 129.0, 155.0, 183.0, 225.0, 270.0, 306.0, 343.0, 387.0, 448.0, 502.0};
                                        Idd1 = D2xlpe1f[posCrossSection];
                                        break;
                                    //E (tabela 52-C11)
                                    case 7:
                                        // >=16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(18.6, crossSection, 0.646);
                                            // <16
                                        } else {
                                            Idd1 = formulaIddIEC1(20.5, crossSection, 0.623);
                                        }
                                }
                                break;
                            //3-f	(norma tabela 52-C4 / B.52.5)
                            case 1:
                                switch (posLayingCable) {
                                    //A1
                                    case 0:
                                        Idd1 = formulaIddIEC1(13.34, crossSection, 0.611);
                                        break;
                                    //A2
                                    case 1:
                                        // >120mm2
                                        if (posCrossSection > 11) {
                                            Idd1 = formulaIddIEC1(12.14, crossSection, 0.611);
                                            // <=120
                                        } else {
                                            Idd1 = formulaIddIEC1(12.95, crossSection, 0.598);
                                        }
                                        break;
                                    //B1
                                    case 2:
                                        Idd1 = formulaIddIEC1(15.62, crossSection, 0.6252);
                                        break;
                                    //B2
                                    case 3:
                                        Idd1 = formulaIddIEC1(15.17, crossSection, 0.60);
                                        break;
                                    //C
                                    case 4:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(15.4, crossSection, 0.635);
                                            // <=16mm2
                                        } else {
                                            Idd1 = formulaIddIEC1(17.0, crossSection, 0.623);
                                        }
                                        break;
                                    //D1
                                    case 5:
                                        Double[] D1xlpe3f = {21.0, 28.0, 36.0, 44.0, 58.0, 75.0, 96.0, 115.0, 135.0, 167.0, 197.0, 223.0, 251.0, 281.0, 324.0, 365.0};
                                        Idd1 = D1xlpe3f[posCrossSection];
                                        break;
                                    //D2
                                    case 6:
                                        Double[] D2xlpe3f = {23.0, 30.0, 39.0, 49.0, 65.0, 84.0, 107.0, 129.0, 153.0, 188.0, 226.0, 257.0, 287.0, 324.0, 375.0, 419.0};
                                        Idd1 = D2xlpe3f[posCrossSection];
                                        break;
                                    //E (tabela 52-C11)
                                    case 7:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(16.4, crossSection, 0.637);
                                            // <=16
                                        } else {
                                            Idd1 = formulaIddIEC1(17.8, crossSection, 0.623);
                                        }
                                }
                                break;
                        }
                        break;
                }

                break;
            //AL
            case 1:
                //PVC
                switch (posTypeInsulation) {
                    case 0:
                        //1-f (norma tabela 52-C1/ B.52.2)
                        switch (posNumberOfPhase) {
                            case 0:
                                //A1
                                switch (posLayingCable) {
                                    case 0:
                                        Idd1 = formulaIddIEC1(8.61, crossSection, 0.616);
                                        break;
                                    //A2
                                    case 1:
                                        // >120mm2
                                        if (posCrossSection > 11) {
                                            Idd1 = formulaIddIEC1(7.84, crossSection, 0.616);
                                            // <120
                                        } else {
                                            Idd1 = formulaIddIEC1(8.361, crossSection, 0.6025);
                                        }
                                        break;
                                    //B1
                                    case 2:
                                        Idd1 = formulaIddIEC1(10.51, crossSection, 0.6254);
                                        break;
                                    //B2
                                    case 3:
                                        Idd1 = formulaIddIEC1(10.24, crossSection, 0.5994);
                                        break;
                                    //C
                                    case 4:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(10.55, crossSection, 0.640);
                                            // <=16mm2
                                        } else {
                                            Idd1 = formulaIddIEC1(11.6, crossSection, 0.625);
                                        }
                                        break;
                                    //D1
                                    case 5:
                                        Double[] d1pvcAl1f = {0.0, 22.0, 29.0, 36.0, 47.0, 61.0, 77.0, 93.0, 109.0, 135.0, 159.0, 180.0, 204.0, 228.0, 262.0, 296.0};
                                        Idd1 = d1pvcAl1f[posCrossSection];
                                        break;
                                    //D2
                                    case 6:
                                        Double[] D2pvcAl1f = {0.0, 0.0, 0.0, 0.0, 0.0, 63.0, 82.0, 98.0, 117.0, 145.0, 173.0, 200.0, 224.0, 255.0, 298.0, 336.0};
                                        Idd1 = D2pvcAl1f[posCrossSection];
                                        break;
                                    //E (tabela 52-C10)
                                    case 7:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(11.4, crossSection, 0.64);
                                            // <=16
                                        } else {
                                            Idd1 = formulaIddIEC1(12.8, crossSection, 0.627);
                                        }
                                }
                                break;
                            //3-f	(norma tabela 52-C3)
                            case 1:
                                //A1
                                switch (posLayingCable) {
                                    case 0:
                                        Idd1 = formulaIddIEC1(7.94, crossSection, 0.612);
                                        break;
                                    //A2
                                    case 1:
                                        // >120mm2
                                        if (posCrossSection > 11) {
                                            Idd1 = formulaIddIEC1(7.225, crossSection, 0.612);
                                            // <=120
                                        } else {
                                            Idd1 = formulaIddIEC1(7.712, crossSection, 0.5984);
                                        }
                                        break;
                                    //B1
                                    case 2:
                                        Idd1 = formulaIddIEC1(9.265, crossSection, 0.627);
                                        break;
                                    //B2
                                    case 3:
                                        Idd1 = formulaIddIEC1(11.65, crossSection, 0.6005);
                                        break;
                                    //C
                                    case 4:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(9.535, crossSection, 0.6324);
                                            // <=16mm2
                                        } else {
                                            Idd1 = formulaIddIEC1(10.5, crossSection, 0.625);
                                        }
                                        break;
                                    //D1
                                    case 5:
                                        Double[] d1pvcAl3f = {0.0, 18.5, 24.0, 30.0, 39.0, 50.0, 64.0, 77.0, 91.0, 112.0, 132.0, 150.0, 169.0, 190.0, 218.0, 247.0};
                                        Idd1 = d1pvcAl3f[posCrossSection];
                                        break;
                                    //D2
                                    case 6:
                                        Double[] D2pvcAl3f = {0.0, 0.0, 0.0, 0.0, 0.0, 53.0, 69.0, 83.0, 99.0, 122.0, 148.0, 169.0, 189.0, 214.0, 250.0, 282.0};
                                        Idd1 = D2pvcAl3f[posCrossSection];
                                        break;
                                    //E (tabela 52-C10 kolumna 3)
                                    case 7:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(9.9, crossSection, 0.64);
                                            // <=16
                                        } else {
                                            Idd1 = formulaIddIEC1(11, crossSection, 0.62);
                                        }
                                }
                                break;
                        }
                        break;
                    //XLPE
                    case 1:
                        //1-f (norma tabela 52-C2)
                        switch (posNumberOfPhase) {
                            case 0:
                                switch (posLayingCable) {
                                    //cabinet_a1
                                    case 0:
                                        Idd1 = formulaIddIEC1(11.6, crossSection, 0.615);
                                        break;
                                    //cabinet_a2
                                    case 1:
                                        // >120mm2
                                        if (posCrossSection > 11) {
                                            Idd1 = formulaIddIEC1(10.56, crossSection, 0.615);
                                            // <=120
                                        } else {
                                            Idd1 = formulaIddIEC1(11.26, crossSection, 0.602);
                                        }
                                        break;
                                    //B1
                                    case 2:
                                        Idd1 = formulaIddIEC1(13.95, crossSection, 0.627);
                                        break;
                                    //B2
                                    case 3:
                                        Idd1 = formulaIddIEC1(13.5, crossSection, 0.603);
                                        break;
                                    //C
                                    case 4:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(12.6, crossSection, 0.648);
                                            // <=16mm2
                                        } else {
                                            Idd1 = formulaIddIEC1(14.8, crossSection, 0.625);
                                        }
                                        break;
                                    //D1
                                    case 5:
                                        Double[] d1xlpeAl1f = {0.0, 26.0, 33.0, 42.0, 55.0, 71.0, 90.0, 108.0, 128.0, 158.0, 186.0, 211.0, 238.0, 267.0, 307.0, 346.0};
                                        Idd1 = d1xlpeAl1f[posCrossSection];
                                        break;
                                    //D2
                                    case 6:
                                        Double[] D2xlpeAl1f = {0.0, 0.0, 0.0, 0.0, 0.0, 76.0, 98.0, 117.0, 139.0, 170.0, 204.0, 233.0, 261.0, 296.0, 343.0, 386.0};
                                        Idd1 = D2xlpeAl1f[posCrossSection];
                                        break;
                                    //E (tabela 52-C12 kolumna 2)
                                    case 7:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(13.4, crossSection, 0.649);
                                            // <=16
                                        } else {
                                            Idd1 = formulaIddIEC1(16.0, crossSection, 0.625);
                                        }
                                }
                                break;
                            //3-f	(norma tabela 52-C4)
                            case 1:
                                switch (posLayingCable) {
                                    //cabinet_a1
                                    case 0:
                                        Idd1 = formulaIddIEC1(10.9, crossSection, 0.605);
                                        break;
                                    //cabinet_a2
                                    case 1:
                                        // >120mm2
                                        if (posCrossSection > 11) {
                                            Idd1 = formulaIddIEC1(9.92, crossSection, 0.605);
                                            // <120
                                        } else {
                                            Idd1 = formulaIddIEC1(10.58, crossSection, 0.592);
                                        }
                                        break;
                                    //B1
                                    case 2:
                                        Idd1 = formulaIddIEC1(12.3, crossSection, 0.630);
                                        break;
                                    //B2
                                    case 3:
                                        Idd1 = formulaIddIEC1(11.95, crossSection, 0.605);
                                        break;
                                    //C
                                    case 4:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(11.5, crossSection, 0.639);
                                            // <=16mm2
                                        } else {
                                            Idd1 = formulaIddIEC1(13.5, crossSection, 0.625);
                                        }
                                        break;
                                    //D1
                                    case 5:
                                        Double[] d1xlpeAl3f = {0.0, 22.0, 28.0, 35.0, 46.0, 59.0, 75.0, 90.0, 106.0, 130.0, 154.0, 174.0, 197.0, 220.0, 253.0, 286.0};
                                        Idd1 = d1xlpeAl3f[posCrossSection];
                                        break;
                                    //D2
                                    case 6:
                                        Double[] D2xlpeAl3f = {0.0, 0.0, 0.0, 0.0, 0.0, 64.0, 82.0, 98.0, 117.0, 114.0, 172.0, 197.0, 220.0, 250.0, 290.0, 326.0};
                                        Idd1 = D2xlpeAl3f[posCrossSection];
                                        break;

                                    //E (tabela 52-C12 kolumna 3)
                                    case 7:
                                        // >16mm2
                                        if (posCrossSection > 5) {
                                            Idd1 = formulaIddIEC1(12.6, crossSection, 0.635);
                                            // <=16
                                        } else {
                                            Idd1 = formulaIddIEC1(13.7, crossSection, 0.623);
                                        }
                                }
                                break;
                        }
                        break;
                }

                break;
        }

    }//method

    // Współczynnik poprawkowy dla temperatury otoczenia
    public void temperatureFactor(int posTemperature, int posTypeIsolation, int posDisposeCable) {
        //Ułożenie D
        double ktemp = 0.0;
        if (posDisposeCable == 5 || posDisposeCable == 6) {
            switch (posTypeIsolation) {
                //PVC
                case 0:
                    switch (posTemperature) {
                        case 0:
                            kTemp = 1.10;
                            break; //10C
                        case 1:
                            kTemp = 1.05;
                            break; //15C
                        case 2:
                            kTemp = 1.00;
                            break; //20C
                        case 3:
                            kTemp = 0.95;
                            break; //25C
                        case 4:
                            kTemp = 0.89;
                            break; //30C
                        case 5:
                            kTemp = 0.84;
                            break;
                        case 6:
                            kTemp = 0.77;
                            break;
                        case 7:
                            kTemp = 0.71;
                            break;
                        case 8:
                            kTemp = 0.63;
                            break;
                        case 9:
                            kTemp = 0.55;
                            break;
                        case 10:
                            kTemp = 0.45;
                            break; //60C
                    }
                    break;
                //XLPE
                case 1:
                    switch (posTemperature) {
                        case 0:
                            kTemp = 1.07;
                            break; //10C
                        case 1:
                            kTemp = 1.04;
                            break;
                        case 2:
                            kTemp = 1.00;
                            break; //20C
                        case 3:
                            kTemp = 0.96;
                            break;
                        case 4:
                            kTemp = 0.93;
                            break;
                        case 5:
                            kTemp = 0.89;
                            break;
                        case 6:
                            kTemp = 0.85;
                            break;
                        case 7:
                            kTemp = 0.80;
                            break;
                        case 8:
                            kTemp = 0.76;
                            break;
                        case 9:
                            kTemp = 0.71;
                            break;
                        case 10:
                            kTemp = 0.65;
                            break; //60C
                    }
                    break;
            }

        } else {
            switch (posTypeIsolation) {
                //Ułożenie cabinet A1-C,E
                //PVC
                case 0:
                    switch (posTemperature) {
                        case 0:
                            kTemp = 1.22;
                            break; //10C
                        case 1:
                            kTemp = 1.17;
                            break;
                        case 2:
                            kTemp = 1.12;
                            break;
                        case 3:
                            kTemp = 1.06;
                            break;
                        case 4:
                            kTemp = 1.00;
                            break; //30C
                        case 5:
                            kTemp = 0.94;
                            break;
                        case 6:
                            kTemp = 0.87;
                            break;
                        case 7:
                            kTemp = 0.79;
                            break;
                        case 8:
                            kTemp = 0.71;
                            break;
                        case 9:
                            kTemp = 0.61;
                            break;
                        case 10:
                            kTemp = 0.50;
                            break; //60C
                    }
                    break;
                //XLPE
                case 1:
                    switch (posTemperature) {
                        case 0:
                            kTemp = 1.15;
                            break; //10C
                        case 1:
                            kTemp = 1.12;
                            break;
                        case 2:
                            kTemp = 1.08;
                            break;
                        case 3:
                            kTemp = 1.04;
                            break;
                        case 4:
                            kTemp = 1.00;
                            break; //30C
                        case 5:
                            kTemp = 0.96;
                            break;
                        case 6:
                            kTemp = 0.91;
                            break;
                        case 7:
                            kTemp = 0.87;
                            break;
                        case 8:
                            kTemp = 0.82;
                            break;
                        case 9:
                            kTemp = 0.76;
                            break;
                        case 10:
                            kTemp = 0.71;
                            break; //60C
                    }
                    break;
            }
        }

    }//method

    // Współczynnik poprawkowy dla wiązek
    public void wiresFactor(int posNumberOfCables, int posDisposeCable, int posDisposeBundle) {
        Double[] t1 = {1.00, 0.80, 0.70, 0.65, 0.60, 0.57};
        Double[] t2 = {1.00, 0.85, 0.79, 0.75, 0.73, 0.72};
        Double[] t3 = {0.95, 0.81, 0.72, 0.68, 0.66, 0.64};
        Double[] t4 = {1.00, 0.88, 0.82, 0.77, 0.75, 0.73};
        Double[] t5 = {1.00, 0.87, 0.82, 0.80, 0.79, 0.79};
        Double[] td1 = {1.00, 0.75, 0.65, 0.60, 0.55, 0.50};//B.52.18 col. 2
        Double[] td2 = {1.00, 0.80, 0.70, 0.60, 0.55, 0.55};//B.52.18 col. 3
        Double[] td3 = {1.00, 0.85, 0.75, 0.70, 0.65, 0.60};//B.52.18 col. 4
        Double[] td4 = {1.00, 0.90, 0.80, 0.75, 0.70, 0.70};//B.52.18 col. 5
        Double[] td5 = {1.00, 0.90, 0.85, 0.80, 0.80, 0.80}; //B.52.18 col. 6
        Double[] td6 = {1.00, 0.85, 0.75, 0.70, 0.65, 0.60}; //B.52.19A col. 2
        Double[] td7 = {1.00, 0.90, 0.85, 0.80, 0.80, 0.80}; //B.52.19A col. 3
        Double[] td8 = {1.00, 0.95, 0.90, 0.85, 0.85, 0.80}; //B.52.19A col. 4
        Double[] td9 = {1.00, 0.95, 0.95, 0.90, 0.90, 0.90}; //B.52.19A col. 5
        Double[] td10 = {1.00, 0.80, 0.70, 0.65, 0.60, 0.60};//B.52.19B col. 2
        Double[] td11 = {1.00, 0.90, 0.80, 0.75, 0.70, 0.70};//B.52.19B col. 3
        Double[] td12 = {1.00, 0.90, 0.85, 0.80, 0.80, 0.80};//B.52.19B col. 4
        Double[] td13 = {1.00, 0.95, 0.90, 0.90, 0.90, 0.90};//B.52.19B col. 5

        if (posNumberOfCables > 0) {

            // D1
            if (posDisposeCable == 5) {
                switch (posDisposeBundle) {
                    case 1:
                        kBundle = td6[posNumberOfCables];
                        break;   //Table 52-E3A kol. 2
                    case 2:
                        kBundle = td7[posNumberOfCables];
                        break;   //Table 52-E3A kol. 3
                    case 3:
                        kBundle = td8[posNumberOfCables];
                        break;   //Table 52-E3A kol. 4
                    case 4:
                        kBundle = td9[posNumberOfCables];
                        break;   //Table 52-E3A kol. 5
                    case 5:
                        kBundle = td10[posNumberOfCables];
                        break;  //Table 52-E3B kol. 2
                    case 6:
                        kBundle = td11[posNumberOfCables];
                        break; //Table 52-E3B kol. 3
                    case 7:
                        kBundle = td12[posNumberOfCables];
                        break; //Table 52-E3B kol. 4
                    case 8:
                        kBundle = td13[posNumberOfCables];
                        break; //Table 52-E3B kol. 5
                }

            }
            // D2
            else if (posDisposeCable == 6) {
                switch (posDisposeBundle) {
                    case 0:
                        kBundle = td1[posNumberOfCables];
                        break;   //Table 52-E2 kol. 2
                    case 1:
                        kBundle = td2[posNumberOfCables];
                        break;      //Table 52-E2 kol. 3
                    case 2:
                        kBundle = td3[posNumberOfCables];
                        break;      //Table 52-E2 kol. 4
                    case 3:
                        kBundle = td4[posNumberOfCables];
                        break;      //Table 52-E2 kol. 5
                    case 4:
                        kBundle = td5[posNumberOfCables];
                        break;      //Table 52-E2 kol. 6
                }

            }
            //E i F
            else if (posDisposeCable == 7) {
                switch (posDisposeBundle) {
                    case 0:
                        kBundle = t1[posNumberOfCables];
                        break; //Table 52-E1 poz. 1
                    case 2:
                        kBundle = t4[posNumberOfCables];
                        break; //Table 52-E1 poz. 4
                    case 3:
                        kBundle = t5[posNumberOfCables];
                        break; //Table 52-E1 poz. 5
                }
            }
            // C
            else if (posDisposeCable == 4) {
                switch (posDisposeBundle) {
                    case 0:
                        kBundle = t1[posNumberOfCables];
                        break; //Table 52-E1 poz. 1
                    case 1:
                        kBundle = t2[posNumberOfCables];
                        break; //Table 52-E1 poz. 2
                    case 2:
                        kBundle = t3[posNumberOfCables];
                        break; //Table 52-E1 poz. 3
                }
            }
            // A-B
            else {
                if (posDisposeBundle == 0) {
                    kBundle = t1[posNumberOfCables];
                    //Table 52-E1 poz. 1
                }
            }

        } else {

            kBundle = 1.0;
        }
    }

    // Współczynnik poprawkowy dla kabli ułożonych bezpośrednio w gruncie (Ułożenie D)
    public void groundResistivityFactor(int posGroundResistivity, int posDisposeCable) {
        // Opór cieplny     0,5 ,  0,7,  1  , 1,5,   2,   2,5,   3
        Double[] grfD1 = {1.28, 1.20, 1.18, 1.10, 1.05, 1.00, 0.96};
        Double[] grfD2 = {1.88, 1.62, 1.50, 1.28, 1.12, 1.00, 0.90};
        if (posDisposeCable == 5) {
            fGroundRes = grfD1[posGroundResistivity];
        } else if (posDisposeCable == 6) {
            fGroundRes = grfD2[posGroundResistivity];
        } else {
            fGroundRes = 1.0;
        }

    }

    public void IddResult1() {



        Idd1 = Idd1 * kTemp * kBundle * fGroundRes;
        Idd1 = Round.Round05(Idd1);
    }//method


}


