package inout;

import java.awt.AWTException;
import java.awt.Robot;

public class MouseMover {

    static inout.MyScreenDeviceArray screens = new inout.MyScreenDeviceArray();

    public static void move(int screen, int rel_px_pos_x, int rel_px_pos_y) throws AWTException {
        Robot aedan = new Robot();
        int mov_total_x = 0, mov_total_y = 0;

//calculates the absolute x position for the next screen
        for (int i = 0; i < screen; i++) {
            mov_total_x += screens.screen[i].width;
        }
        mov_total_x += rel_px_pos_x;
        mov_total_y += rel_px_pos_y;
//        System.out.println("Moving to x: " + mov_total_x + " (" + (mov_total_x - mov_rel_x) + " + " + mov_rel_x + ")");
//        System.out.println("Moving to y: " + mov_total_y);
//makes the MOVE
        aedan.mouseMove(mov_total_x, mov_total_y);

//        System.out.println("MOV X: " + mov_total_x + "\nMOV Y: " + mov_total_y);
    }

    public static void move(int screen, double rel_pos_x, double rel_pos_y) throws AWTException {
        Robot aedan = new Robot();
        int mov_total_x = 0, mov_total_y = 0;

        //calculates the relative percentage x and y position
//calculates the absolute x position for the next screen
        for (int i = 0; i < screen; i++) {
            mov_total_x += screens.screen[i].width;
        }
        mov_total_x = (int) ((screens.screen[screen].width * rel_pos_x));
        mov_total_y = (int) ((screens.screen[screen].height * rel_pos_y));

        //System.out.println("Moving to x: " + mov_total_x);
        //System.out.println("Moving to y: " + mov_total_y);

//        System.out.println("Moving to x: " + mov_total_x + " (" + (mov_total_x - mov_rel_x) + " + " + mov_rel_x + ")");
//        System.out.println("Moving to y: " + mov_total_y);
//makes the MOVE
        aedan.mouseMove(mov_total_x, mov_total_y);

//        System.out.println("MOV X: " + mov_total_x + "\nMOV Y: " + mov_total_y);
    }

}
