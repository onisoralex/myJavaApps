package survey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import static java.lang.Thread.sleep;
import java.util.HashMap;

public class BigBrother {

    public static void surveyStart(String args[]) throws IOException, InterruptedException {
        Calendar cal;
        //Set the Path to the Config File
        String config_path = "src/survey/config.ini";
        //Read out the Config File and return all Lines from the config File
        String[] config_file = readConfigFile(config_path);
        //Delete unnecessary Lines and save into an new Array
        String[] config_line = extractConfigOptions(config_file);
        //Create a HashMap with the Nname of the Variable as ID and the Option as Content
        HashMap h = makeHashMap(config_line);

        //rtsp://192.168.0.90:554/mpeg4/media.amp
        // "C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe"  --sout=\"#duplicate{dst=std{access=file,mux=asf,dst='outputflder.format'},dst=nodisplay}" --run-time=
//==Parameters==================================================================
        //Path to the executeable File of VLC
        //final String vlc_path = "C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe";
        final String vlc_path = h.get("vlc_path").toString();
        //Folder where to save all recorded Video Files to
        //final String output_folder = "C:\\Users\\Alex\\Desktop\\";
        final String output_folder = h.get("output_folder").toString();
        //Adresses of the devices to record
        //String[] device = {"rtsp://192.168.0.91:554/mpeg4/media.amp", "rtsp://192.168.0.92:554/mpeg4/media.amp", "rtsp://192.168.0.93:554/mpeg4/media.amp"};       //Adresses of the devices to record
        String[] device = h.get("device").toString().split(",");
        //Set the Name for the Sources in the Video Files
        String source_name = h.get("source_name").toString();
        //Desired Format of the Video Files
        final String video_format = h.get("video_format").toString();
        //Time for Recording in Minutes and to use further for other Calculations
        int timer = Integer.parseInt(h.get("timer").toString());
        //Other additional Options
        String options = h.get("options").toString();
//==Commands====================================================================

        //Define the Commands to be executed
        String[] code = new String[3];
        code[0] = h.get("code_0").toString();
        code[1] = h.get("code_1").toString();
        code[2] = h.get("code_2").toString();
        /*
        code[0] = "\"" + vlc_path + "\" ";
        code[1] = " --sout=\"#duplicate{dst=std{access=file,mux=asf,dst='" + output_folder;
        code[2] = "." + videoFormat + "'},dst=nodisplay}\" --run-time=" + recordtime;
         */
        cal = Calendar.getInstance();
        int already_passed_minutes = cal.get(Calendar.MINUTE);
        //Calculate remaining Time in Seconds
        int firsttime_time = (timer - (already_passed_minutes % timer)) * 60;
        //Add 5 Seconds to Timer
        int firsttime_time_plus = firsttime_time + 5;

        startRecording(vlc_path, device, source_name, output_folder, video_format, timer, firsttime_time_plus, code, options);

    }

    static void startRecording(String vlc_path, String[] device, String source_name, String output_folder, String video_format, int timer, int firsttime_time_plus, String[] code, String options) throws IOException, InterruptedException {
        String str;
        boolean first_time = true;
        String name_time;
        int recordtimer;

        while (true) {
            name_time = makeTimeForFileName();
            //Set recordtimer for the first Run else set the normal Time
            if (first_time) {
                recordtimer = firsttime_time_plus;
            } else {
                //Conversion to Seconds added
                recordtimer = timer * 60;
            }

            for (int i = 0; i < device.length; i++) {
                str = vlc_path + " " + device[0] + " " + code[0] + output_folder + sourceName(source_name, i) + "_" + name_time + "." + video_format + code[1] + " " + code[2] + "=" + recordtimer + " " + options;
                System.out.println("Stringtoexecute: " + str);
                Runtime.getRuntime().exec(str);
            }

            int sleeptimer;
            /*
            //Set sleeptimer for the first Run else set the normal Time
            if (first_time) {
                sleeptimer = firsttime_time_plus * 1000;
            } else {
                //Conversion to Seconds added
                sleeptimer = timer * 60000;
            }
             */
            sleep(recordtimer * 1000);

            first_time = false;

        }
    }

    public static String[] readConfigFile(String file) throws IOException {
        int line_counter = 0;
        BufferedReader r = new BufferedReader(new FileReader(file));

        //Count the number of lines in the textfile
        while (r.readLine() != null) {
            line_counter++;
        }

        //Create the necessary array
        String[] arr = new String[line_counter];
        r.close();
        //Reopen file
        r = new BufferedReader(new FileReader(file));
        //r.reset();

        //Read out all lines into an array
        for (int i = 0; i < line_counter; i++) {
            arr[i] = r.readLine();
        }

        r.close();

        return arr;
    }

    public static String[] extractConfigOptions(String[] config_file) {
        String[] config_line;
        int c = 0;

        //Count Number of unusable Lines in File
        for (int i = 0; i < config_file.length; i++) {
            if (config_file[i].startsWith("#")) {
                c++;
            }
        }

        //Create a String Array for usable Lines
        config_line = new String[config_file.length - c];
        //!!!Reset c!!!
        c = 0;

        //Extract only needed Lines
        for (int i = 0; i < config_file.length; i++) {
            if (!(config_file[i].startsWith("#"))) {
                config_line[c] = config_file[i];
                c++;
            }
        }

        return config_line;
    }

    public static HashMap makeHashMap(String[] config_line) {
        HashMap hash = new HashMap();
        //Helpvariable for storing both sides of the configs
        String[] help;

        for (int i = 0; i < config_line.length; i++) {
            //Remove all Spaces (not for the first Option - Path to VLC), Split the option & store it into the Helpvariable
            if (i == 0) {
                help = config_line[i].split("=");
            } else {
                help = config_line[i].replaceAll(" ", "").split("=");
            }

            if (help.length >= 2) {
                if (help.length > 2) {
                    String str = "";

                    //Add a "=" after every Option Part except for he last one
                    for (int j = 1; j < help.length; j++) {
                        str += help[j];

                        if (j < (help.length - 1)) {
                            str += "=";
                        }
                    }

                    help[1] = str;
                }

                hash.put(help[0], help[1]);
            } else {
                hash.put(help[0], "");
            }
        }

        return hash;
    }

    public static String sourceName(String source_name, int i) {
        return source_name + (i + 1);
    }

    public static String makeTimeForFileName() {
        String month, day, hour, minute;

        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);

        month = Integer.toString(cal.get(Calendar.MONTH) + 1);
        if (Integer.valueOf(month) <= 9) {
            month = "0" + month;
        }

        day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        if (Integer.valueOf(day) <= 9) {
            day = "0" + day;
        }

        hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        if (Integer.valueOf(hour) <= 9) {
            hour = "0" + hour;
        }

        minute = Integer.toString(cal.get(Calendar.MINUTE));
        if (Integer.valueOf(minute) <= 9) {
            minute = "0" + minute;
        }

        return year + "-" + month + "-" + day + "---" + hour + minute;
    }

}
