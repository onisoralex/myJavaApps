package screenshift;

//contains a Screen Device as an Object
import java.awt.GraphicsDevice;

public class MyScreenDevice {

    int id;
    int width;
    int height;

    MyScreenDevice(GraphicsDevice gd) {
//NUR VORUEBERGEHEND EINE LOESUNG (later comment: warum nur voruebergehend???)
        id = (int) Character.getNumericValue(gd.getIDstring().charAt(8));
        width = gd.getDisplayMode().getWidth();
        height = gd.getDisplayMode().getHeight();

//        System.out.println("- Initaialized Screen No." + id);
    }

}
