package phi6;

    //ALWAYS WORK IN 3D!!!
import java.math.BigDecimal;

public class VectorObject extends calc.Calculations {
    /*
     //Coordinate-Type & Origin Type +++++++++++++(Dimension and Type: c = cartesic, s = spherical, z = cylindrical)
     char ot = ' ';
     char t = ' ';
     */

//Vector Origin Coordinates
    private PointObject source = new PointObject(new BigDecimal[]{zero, zero, zero}, 'c');

//Destiantion Coordinates, ALAYS RELATIVE TO SOURCE!!!
    private PointObject destination = new PointObject(new BigDecimal[]{zero, zero, zero}, 'c');

//Use radius, phi and height for cylindrical coordinates
    /*//Vector Origin Coordinates
     //Cartesian
     BigDecimal x0 = zero, y0 = zero, z0 = zero;
     //Polar
     BigDecimal r0 = zero, ph0 = zero, th0 = zero;
     //Height (for Cylindrical
     BigDecimal h0 = zero;
     //Destiantion Coordinates
     //Cartesian
     BigDecimal x = zero, y = zero, z = zero;
     //Spherical
     //Height (for Cylindrical
     BigDecimal h = zero;
     */
//ThreeDimensional Vector
    public VectorObject(BigDecimal d1, BigDecimal d2, BigDecimal d3, char t) {
        setDestination(d1, d2, d3, t);
    }

//ThreeDimensional Vector
    public VectorObject(PointObject po) {
        this.destination = po;
    }

    public void setSource(BigDecimal d1, BigDecimal d2, BigDecimal d3, char type) {
        this.source = new PointObject(new BigDecimal[]{d1, d2, d3}, type);
    }

    public void setSource(PointObject po) {
        this.source = po;
    }

    public void setDestination(BigDecimal d1, BigDecimal d2, BigDecimal d3, char type) {
        this.destination = new PointObject(d1, d2, d3, type);
    }

    public void setDestination(PointObject po) {
        this.destination = po;
    }

    public void setNewRelativeDestination(PointObject po) {
        BigDecimal[] coord1 = this.destination.getCartesian();
        BigDecimal[] coord2 = po.getCartesian();

        this.destination = new PointObject(coord1[0].add(coord2[0]), coord1[1].add(coord2[1]), coord1[2].add(coord2[2]), po.getType());
    }

    public PointObject getSource() {
        return this.source;
    }

    public PointObject getDestination() {
        return this.destination;
    }

    public BigDecimal getLength() {
        return source.getDistanceTo(destination);
    }

//ToDo
    public void rotateAlongAxis(char axis, float degree) {

    }

    public void showAllValues() {
        //Use the getmethods of the source and destination PointObjects
        /*
         if (t == 'c') {
         System.out.println("-> Type: Cartesian");
         } else if (t == 'z') {
         System.out.println("-> Type: Cylindric");
         } else if (t == 's') {
         System.out.println("-> Type: Spheric");
         }
         System.out.println("-> Cartesian Origin: (x = " + x0 + " / y = " + y0 + " / z = " + z0 + ")");
         System.out.println("-> Polar Origin: (r = " + r0 + " / ph = " + ph0 + " / th = " + th0 + " / h = " + h0 + ")");
         System.out.println("-> Cartesian Destination: (x = " + x + " / y = " + y + " / z = " + z + ")");
         System.out.println("-> Polar Destination: (r = " + r + " / ph = " + ph + " / th = " + th + " / h = " + h + ")");
         */
    }

}
