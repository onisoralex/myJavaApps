package inout;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

//contains multiple Screen Devices settings stored in arrays
public class MyScreenDeviceArray {

    MyScreenDevice[] screen;

    MyScreenDeviceArray() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        screen = new inout.MyScreenDevice[gd.length];

//        System.out.println("MyDeviceArray:\n- Number of devices found: " + gd.length);
        for (int i = 0; i < screen.length; i++) {
            screen[i] = new inout.MyScreenDevice(gd[i]);
        }

//        System.out.println("- Number of devices assigned: " + screen.length + "\n");
    }

}
