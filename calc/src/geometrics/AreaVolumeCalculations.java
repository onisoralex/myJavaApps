package geometrics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import others.ConstantsDefinitions;

public class AreaVolumeCalculations extends ConstantsDefinitions {

    public static BigDecimal rectangleArea(BigDecimal x, BigDecimal y) {
        return (x.multiply(y)).stripTrailingZeros();
    }

    public static BigDecimal blockVolume(BigDecimal x, BigDecimal y, BigDecimal z) {
        return (x.multiply(y.multiply(z))).stripTrailingZeros();
    }

    public static BigDecimal circleArea(BigDecimal r) {
        return (const_pi.multiply(r.pow(2))).stripTrailingZeros();
    }

    public static BigDecimal sphereVolume(BigDecimal r) {
        return (const_pi.multiply(r.pow(3)).multiply(four).divide(three, RoundingMode.HALF_EVEN)).stripTrailingZeros();
    }

    public static BigDecimal cylinderVolume(BigDecimal r, BigDecimal h) {
        return (const_pi.multiply(r.pow(2)).multiply(h)).stripTrailingZeros();
    }

    public static BigDecimal ellipseArea(BigDecimal a, BigDecimal b) {
        //pi * (small radius * big radius)
        return (const_pi.multiply(a.multiply(b))).stripTrailingZeros();
    }

    public static BigDecimal roundedRectangleArea(BigDecimal l, BigDecimal w, BigDecimal r) {
        BigDecimal area;

        //Calculate the Rectangular area
        area = l.multiply(w);
        //Subtract the corners of the rectangle to make the rounded rectangleshape
        area = area.subtract(rectangleArea(r.multiply(two), r.multiply(two)).add(circleArea(r)));

        return area;
    }

}
