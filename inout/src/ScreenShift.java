package inout;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

public class ScreenShift {

    static boolean log = false;
    static int mov_rel_x, mov_rel_y;
    final static inout.MyScreenDeviceArray screens = new inout.MyScreenDeviceArray();
    static inout.MousePositionObject mouse;
    static int next_screen;
    static char dedicated_key = 's';

    public static void main() throws AWTException {
        Scanner sc = new Scanner(System.in);
        String pressed_key;

        if (log == true) {
            System.out.println("-> Number of Screens found: " + screens.screen.length);
        }

        do {
            pressed_key = sc.next();
            if (pressed_key.charAt(0) == dedicated_key) {
                doTheMoves(screens);
            }
        } while (pressed_key.charAt(0) != 'w');
        System.out.println("EXIT");

    }

//this method executes the move commands based on iput of the user
    /**
     * Changes the position of the mouse to the next screen
     *
     * @param screens
     * @throws AWTException
     */
    public static void doTheMoves(inout.MyScreenDeviceArray screens) throws AWTException {
        mouse = new inout.MousePositionObject(screens);
        calculateNextScreenRelativeCoordinatesInPixel();
        moveToNextScreen();
    }

//gets the relative position where the mouse should be on the next screen
    private static void calculateNextScreenRelativeCoordinatesInPixel() {
        next_screen = (mouse.screen.id + 1) % screens.screen.length;
        mov_rel_x = (int) (mouse.rel_perc_pos_x * screens.screen[next_screen].width);
        mov_rel_y = (int) (mouse.rel_perc_pos_y * screens.screen[next_screen].height);

        if (log == true) {
            System.out.println("-> Current Mouse Screen: " + mouse.screen.id);
            System.out.println("-> Current Mouse Position x: " + mouse.rel_px_pos_x);
            System.out.println("-> Current Mouse Position y: " + mouse.rel_px_pos_y);
            System.out.println("-> Next Screen Width: " + screens.screen[next_screen].width);
            System.out.println("-> Next Screen Height: " + screens.screen[next_screen].height);
            //System.out.println("-> Calculated relative Position x: " + mov_rel_x);
            //System.out.println("-> Calculated relative Position y: " + mov_rel_y);
            System.out.println("-> new x = " + mov_rel_x + ", new y = " + mov_rel_y);
        }
    }

//calculates and moves to the next screen
    private static void moveToNextScreen() throws AWTException {

        inout.MouseMover.move(next_screen, mov_rel_x, mov_rel_y);
        if (log == true) {
            System.out.println("-> Moved to Screen: " + next_screen + "; x = " + mov_rel_x + " / y = " + mov_rel_y);
        }
//delete the comments below?
        /*  Robot aedan = new Robot();
         
         int mov_total_x = 0, mov_total_y = 0;

         //calculates the absolute x position for the next screen
         for (int i = 0; i < next_screen; i++) {
         mov_total_x += screens.screen[i].width;
         }
         mov_total_x += mov_rel_x;
         mov_total_y += mov_rel_y;
         //        System.out.println("Moving to x: " + mov_total_x + " (" + (mov_total_x - mov_rel_x) + " + " + mov_rel_x + ")");
         //        System.out.println("Moving to y: " + mov_total_y);
         //makes the MOVE
         aedan.mouseMove(mov_total_x, mov_total_y);

         //System.out.println("MOV X: " + mov_total_x + "\nMOV Y: " + mov_total_y);
         */
    }

}
