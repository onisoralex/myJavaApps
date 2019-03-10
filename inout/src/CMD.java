package inout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This Class contains Methods that execute CMD-Commands like "ping"
 *
 * @author Alex
 */
public class CMD {

    public static void run(String str) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec(str);

        p.waitFor();
        p.destroy();
    }

    public static void runAsAdmin(String str) throws IOException, InterruptedException {
        //ProcessBuilder b = new ProcessBuilder(new String[]{"cmd.exe", "/C", "start", str});
        run("cmd.exe /c start");
    }

    public static void tasks() throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("tasklist.exe");
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;

        while ((line = r.readLine()) != null) {
            System.out.println(line);
        }
        r.close();

        p.waitFor();
        p.destroy();
    }

    public static void ping(String ip) throws IOException, InterruptedException {
        run("cmd.exe /c start ping " + ip);
    }

    public static void pingLocalhost() throws IOException, InterruptedException {
        ping("127.0.0.1");
    }
}
