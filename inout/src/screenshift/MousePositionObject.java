package screenshift;

import java.awt.MouseInfo;
import java.awt.PointerInfo;

public class MousePositionObject {

//total value
    int total_px_pos_x, total_px_pos_y;
//relative value
    PointerInfo mouse = MouseInfo.getPointerInfo();
    int rel_px_pos_x, rel_px_pos_y;
    double rel_perc_pos_x, rel_perc_pos_y;
    MyScreenDevice screen;
//    int scr_id = Character.getNumericValue(mouse.getDevice().getIDstring().charAt(8));
    //int pos_counter = 0; //delete if runing

    public MousePositionObject(MyScreenDeviceArray screens/*int x, int y, MyScreenDevice screen*/) {
//crates a pointerObject to read out the Information below
//takes the id of the screen the mouse is on at the moment,
//converts it to "int" and, takes that screen device and saves it in the variable
        this.screen = screens.screen[(int) Character.getNumericValue(mouse.getDevice().getIDstring().charAt(8))];

        /* // System.out.println("Number of screens found: " + screens.screen.length);
        String str = "";
        for (int i = 0; i < screens.screen.length; i++) {
            str += i + "; ";
        }
        //System.out.println("ScreenID found: " + str);//+ screens.screen.length);
        //System.out.println("Mouse is on screen No.: " + this.screen.id);
        */

        //Method calls forInformation about this Obbject
        makeTotalPositionInPx();
        makeRelativePositionInPx(screens);
        makeRelativePositionInPercent();
    }

    private void makeTotalPositionInPx() {
        this.total_px_pos_x = MouseInfo.getPointerInfo().getLocation().x;
        this.total_px_pos_y = this.mouse.getLocation().y;
        //System.out.println("Actual total x position: " + this.total_px_pos_x);
        //System.out.println("Actual total y position: " + this.total_px_pos_y);
    }

    private void makeRelativePositionInPx(MyScreenDeviceArray screens) {
        //Position counter adds the length of the other screens
        int pos_counter = 0;

        for (int i = 0; i < this.screen.id; i++) {
            pos_counter += screens.screen[i].width;
        }

        this.rel_px_pos_x = this.total_px_pos_x - pos_counter;
        this.rel_px_pos_y = this.total_px_pos_y;
        //System.out.println("Actual relative x position in pixel (position on this screen): " + this.rel_px_pos_x);
        //System.out.println("Actual relative y position in pixel (position on this screen): " + this.rel_px_pos_y);
    }

    private void makeRelativePositionInPercent() {
        this.rel_perc_pos_x = (double) this.rel_px_pos_x / this.screen.width;
        this.rel_perc_pos_y = (double) this.rel_px_pos_y / this.screen.height;
        //System.out.println("Actual total x position percentage: " + this.rel_perc_pos_x);
        //System.out.println("Actual total y position percentage: " + this.rel_perc_pos_y);
    }

}
