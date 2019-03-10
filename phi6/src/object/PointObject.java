package object;

import maths.Calculations;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Alex
 */
public class PointObject extends Calculations {
    /*Uses Calculation Class*/
    /*Coordinates are ALWAYS relative to the origin position of the vector!!!*/
    /*Linear Coordinates work acording to the right hand rule and are positive in that directions
    
     Variation 1 is standard: (because it supports 2D with x an y Axis as a plane)
     - x to the right                          z| y
     - y to the back, away from the viever      |/__ x
     - z upwards
    
     Variation 2 is not supported:
     - x to the right                   |y
     - y upwards                        |___ x
     - z to the front, to the viever  z/
     */
    /*Angular Coordinates start at 3o'clock with 0 and go counterclockwise*/

    private BigDecimal[] coordinates = new BigDecimal[3];
    private char type; //Can only be "c" = Cartesian, "z" = Cylindrical, "s" = Spherical

    public PointObject(BigDecimal[] coordinate, char t) {

        if (coordinate.length == 3) {
            this.coordinates = coordinate;
            this.type = t;
        }

    }

    public PointObject(BigDecimal c1, BigDecimal c2, BigDecimal c3, char t) {
        this.coordinates[0] = c1;
        this.coordinates[1] = c2;
        this.coordinates[2] = c3;
        this.type = t;

    }

    public String getCoordinatesAsString() {
        String ret = null;
        // BigDecimal[] c = new BigDecimal[3];

        if (type == 'c') {
            ret = "( x = " + coordinates[0].toPlainString() + " / y = " + coordinates[1].toPlainString() + " / z = " + coordinates[2].toPlainString() + " )";
        } else if (type == 'z') {
            ret = "( r = " + coordinates[0].toPlainString() + " / ph = " + coordinates[1].toPlainString() + " / h = " + coordinates[2].toPlainString() + " )";
        } else if (type == 's') {
            ret = "( r = " + coordinates[0].toPlainString() + " / ph = " + coordinates[1].toPlainString() + " / th = " + coordinates[2].toPlainString() + " )";
        }

        return ret;
    }

    /**
     * Returns the absolute coordinates of this PointObject reative to the
     * origin point.
     *
     * @return absolute coordinates
     */
    public BigDecimal[] getCoordinates() {
        return this.coordinates;
    }

    /**
     * This Method returns the relative coordinates of this PointObject to the
     * specified PointObject.
     *
     * @param po Point Object for reference position
     * @return Aray of [<code>this.coordinate - po.coordinate</code>]
     */
    public BigDecimal[] getRelativeCoordinatesTo(PointObject po) {
        BigDecimal[] ret = new BigDecimal[3];
        BigDecimal[] cartesian_coordinates_1 = new BigDecimal[3];
        BigDecimal[] cartesian_coordinates_2 = new BigDecimal[3];

        if (this.type == po.type && (this.type == 'c' || this.type == 'z' || this.type == 's')) {
            cartesian_coordinates_1 = this.getCartesian();
            cartesian_coordinates_2 = po.getCartesian();

        } else {
            //Eventualy convert types
            System.out.println("Incompatible Types!");
        }

        //This will happen after the conversion
        ret[0] = cartesian_coordinates_1[0].subtract(cartesian_coordinates_2[0]);
        ret[1] = cartesian_coordinates_1[1].subtract(cartesian_coordinates_2[1]);
        ret[2] = cartesian_coordinates_1[2].subtract(cartesian_coordinates_2[2]);

        return ret;
    }

    /**
     * Returns the distance of this PointObject to the origin point.
     *
     * @return distance
     */
    public BigDecimal getDistanceToOrigin() {

        BigDecimal ret = zero;

        if (this.type == 'c') {//If coordinates system is Cartesic, use the coordinates
            ret = sqrt(this.coordinates[0].pow(2).add(this.coordinates[1].pow(2)), const_calc_prec);
            if (coordinates[2].compareTo(zero) != 0) {
                ret = sqrt(ret.pow(2).add(coordinates[2].pow(2)), const_calc_prec);
            }
        } else if (this.type == 'z') {//If coordinates system is Cylindric, use the r. Also h for 3D.
            ret = coordinates[0];
            //Length is given by r and h
            if (coordinates[2].compareTo(zero) != 0) {
                //ret = calc.Calculations.sqrt(ret.pow(2).add(coordinates[2].pow(2)), const_calc_prec);
            }
        } else if (this.type == 's') {//If coordinates system is Spheric, use the radius. Also theta for 3D.
            //Length is given only by r since there as no other length modifying dimension in spherical
            //ret = coordinates[0];
        }

        return ret.setScale(const_out_prec, RoundingMode.HALF_UP).stripTrailingZeros();
    }

    /**
     * First converts to Cartesian an then returns the distance based
     * oncartesian coordinates.
     *
     * @param po
     * @return distance
     */
    public BigDecimal getDistanceTo(PointObject po) {
        //Gets therelativecoordinates in order to put po as a new origin point.
        PointObject p = new PointObject(this.getRelativeCoordinatesTo(po), 'c');

        return p.getDistanceToOrigin();
    }

    /**
     * First converts to Cartesian an then returns the distance based
     * oncartesian coordinates.
     *
     * @param po
     * @return distance as a String
     */
    public String getDistanceToAsString(PointObject po) {
        return getDistanceTo(po).toPlainString();
    }

    public char getType() {
        return this.type;
    }

    /**
     * Checks if the Type is a valid one.
     *
     * @return returns <code>true</code> if the type is valid and
     * <code>false</code> if the type is invalid
     */
    public boolean typeCheck() {
        boolean check = false;

        if (this.type == 'c') {
            check = true;
        } else if (this.type == 'z') {
            check = true;
        } else if (this.type == 's') {
            check = true;
        } else {
            check = false;
        }

        return check;
    }

//<editor-fold defaultstate="collapsed" desc="Coordinates Conversion">
    public BigDecimal[] getCartesian() {
        BigDecimal[] var = new BigDecimal[3];

        if (this.type == 'z') {
            BigDecimal r = this.coordinates[0];
            BigDecimal ph = this.coordinates[1];
            BigDecimal th = this.coordinates[2];
            int precision = const_calc_prec;

            //Height is automaticaly z
            var[0] = null;
            var[1] = null;
            var[2] = th;

            /*
             sin ph * r = y 
             x = pythagorasget kathete(r,y);
             */
            BigDecimal part1 = Calculations.sin(ph, precision).multiply(r);
            var[1] = part1.setScale(const_out_prec, RoundingMode.HALF_UP).stripTrailingZeros();
            var[0] = (Calculations.pythagorasGetKathete(r, var[1], precision).setScale(precision, RoundingMode.HALF_UP)).stripTrailingZeros();

        } else if (this.type == 's') {
            System.out.println("Spherical to Cartesian does not exist yet!");

        } else if (this.type == 'c') {
            if (phi6_logging == true) {
                System.out.println("-> Coordinates arealready Cartesian!");
            }

            var = this.coordinates;

        } else {
            conversionError();
        }

        return var;
    }

    public BigDecimal[] getCylindrical() {
        BigDecimal[] var = new BigDecimal[3];

        if (this.type == 'c') {
            BigDecimal x = this.coordinates[0];
            BigDecimal y = this.coordinates[1];
            BigDecimal z = this.coordinates[2];
            int precision = const_calc_prec;

            var[0] = null;
            var[1] = null;
            var[2] = z;

            /*
             hyp R = pyhagorasgethyp(X,Yy)
             arcsin(y/r)
             */
            //This is the radius
            BigDecimal part1 = Calculations.pythagorasGetHypotenuse(x, y, precision);
            var[0] = part1.setScale(const_out_prec, RoundingMode.HALF_UP).stripTrailingZeros();
            //This is phi
            var[1] = (Calculations.arcSin(y.divide(part1, precision, RoundingMode.HALF_UP), precision)).setScale(const_out_prec, RoundingMode.HALF_UP).stripTrailingZeros();

        } else if (this.type == 's') {
            BigDecimal r = this.coordinates[0];
            BigDecimal ph = this.coordinates[1];
            BigDecimal th = this.coordinates[2];
            int precision = const_calc_prec;

            //Phi is the same
            var[0] = null;
            var[1] = ph;
            var[2] = null;

            BigDecimal part1 = Calculations.sin(th, precision).multiply(r);
            var[2] = part1.setScale(const_out_prec, RoundingMode.HALF_UP).stripTrailingZeros();
            var[0] = (Calculations.pythagorasGetKathete(r, part1, precision)).setScale(const_out_prec, RoundingMode.HALF_UP).stripTrailingZeros();

        } else if (this.type == 'z') {
            if (phi6_logging == true) {
                System.out.println("-> Coordinates arealready Cylindrical!");
            }

            var = this.coordinates;

        } else {
            conversionError();
        }

        return var;
    }

    public BigDecimal[] getSpherical() {
        BigDecimal[] var = new BigDecimal[3];

        if (this.type == 'c') {
            System.out.println("Cartesian to Spherical does not exist yet!");
        } else if (this.type == 'z') {
            BigDecimal r = this.coordinates[0];
            BigDecimal ph = this.coordinates[1];
            BigDecimal h = this.coordinates[2];
            int precision = const_calc_prec;

            //Phi is the same
            var[0] = null;
            var[1] = ph;
            var[2] = null;

            BigDecimal help = Calculations.pythagorasGetHypotenuse(r, h);
            var[0] = help.setScale(const_out_prec).stripTrailingZeros();
            var[2] = (Calculations.arcSin(h.divide(help, RoundingMode.HALF_UP)).setScale(precision)).stripTrailingZeros();

        } else if (this.type == 's') {
            if (phi6_logging == true) {
                System.out.println("-> Coordinates arealready Spherical!");
            }

            var = this.coordinates;

        } else {
            conversionError();

        }

        return var;
    }

    public void convertToCartesian() {
        this.coordinates = getCartesian();
        this.type = 'c';
    }

    public void convertToCylindrical() {
        this.coordinates = getCylindrical();
        this.type = 'z';
    }

    public void convertToSpherical() {
        this.coordinates = getSpherical();
        this.type = 's';
    }
//</editor-fold>

    private void conversionError() {
        System.out.println("Conversion ERROR! Could ot convert the specified Object!");
    }

}
