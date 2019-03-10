package inout;

import java.awt.AWTException;
import java.util.ResourceBundle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

/**
 *
 * @author Alex
 */
public class MouseFunctions {

    static boolean log = false;

    /**
     * Returns the x and y Position of the mouse pointer onthe actual screen.
     *
     * @return x and y position
     */
    public static int[] getMousePositionOnThisScreen() {
        MyScreenDeviceArray screens = new inout.MyScreenDeviceArray();
        MousePositionObject mouse = new MousePositionObject(screens);
        int[] pos = new int[2];

        pos[0] = mouse.rel_px_pos_x;
        pos[1] = mouse.rel_px_pos_y;

        if (log = true) {
            System.out.println("( x = " + pos[0] + " / y = " + pos[1] + " )");
        }

        return pos;
    }

    /**
     * Rerturns the Screen ID at the mouses position.
     *
     * @return Screen ID
     */
    public static int getActualScreenId() {
        MyScreenDeviceArray screens = new inout.MyScreenDeviceArray();
        MousePositionObject mouse = new MousePositionObject(screens);

        int screen_id = mouse.screen.id;

        if (log = true) {
            System.out.println("-> Actual screen ID: " + screen_id);
        }

        return screen_id;
    }

    /**
     * Moves Mouse to the specified position.
     *
     * @param deviceId Screen ID (0 is the first screen)
     * @param x x-position
     * @param y y-position
     * @throws AWTException
     */
    public static void mouseMove(int deviceId, int x, int y) throws AWTException {
        inout.MouseMover.move(deviceId, x, y);
    }

    /**
     * Clicks and releases the mouse at the actual position. Use 50 for normal
     * click.
     *
     * @param time Time between press and release of button.
     * @throws AWTException
     * @throws InterruptedException
     */
    public static void mouseClick(int time) throws AWTException, InterruptedException {
        Robot rob = new Robot();

        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        sleep(time);
        rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    /**
     * Doubleclicks at the actual posistion. Use 100 for normal doubleclick.
     *
     * @param time Time between clicks.
     * @throws AWTException
     * @throws InterruptedException
     */
    public static void mouseDoubleClick(int time) throws AWTException, InterruptedException {
        Robot rob = new Robot();
        int time_to_release = 50;

        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        sleep(time_to_release);
        rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        sleep(time);
        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        sleep(time_to_release);
        rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    /**
     * Clicks at the catual position, drags to the specified coordinates and
     * releases the click.
     *
     * @param deviceId Screen ID (0 is the first screen)
     * @param x x-position
     * @param y y-position
     * @throws AWTException
     */
    public static void mouseDragAndDrop(int deviceId, int x, int y) throws AWTException {
        Robot r = new Robot();

        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        mouseMove(deviceId, x, y);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    /**
     * Moves the mouse to the next screen. The position is the percentage
     * position of the actual scren.
     *
     * @throws AWTException
     */
    public static void shiftScreen() throws AWTException {
        final inout.MyScreenDeviceArray screens = new inout.MyScreenDeviceArray();
        inout.ScreenShift.doTheMoves(screens);
    }

}
