package physics;

import others.ConstantsDefinitions;

public class Mechanics {

//Abfrage auf "schneller oder gleich wie c"
    public static boolean biggerOrEqualToC(double v) {
        boolean over9000 = v >= ConstantsDefinitions.const_c.doubleValue();
        return over9000;
    }

    //Collisiondetection
    //3D-Bewegung/Vektorenrechnung
    //lineare bewegung
    //rotation
    //drehimpuls
    //Trägheitsmoment
    //Stoß
    //Impulseerhaltung
    //Energieerhaltung
    //Relativitätstheorie
}
