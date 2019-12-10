package at;

import java.util.*;
import java.util.stream.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ActivityTracker {

	public static void main(String[] args) throws IOException {
		String filepath = "C:\\JAVA\\myapps\\TPH5\\src\\at\\Activities.txt";
		BufferedReader r = new BufferedReader(new FileReader(filepath));
		List<MonitoredData> data;

		for (;;) {
			r.mark(1000);
			if (r.readLine() == null) {
				break;
			}
			r.reset();
			String[] aux = r.readLine().split("\t\t");

			System.out.println(aux[0] + "\n" + aux[1] + "\n" + aux[2] + "\n");
		}

		r.close();
	}

}
