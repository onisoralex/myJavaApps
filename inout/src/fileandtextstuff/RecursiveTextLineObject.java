package fileandtextstuff;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * ThisObject is a recursive Object that can contain consecutive lines of text
 * or whatever you need. It is meant to be able to sort and export as String[].
 *
 * @author Alex
 */
public class RecursiveTextLineObject {

    public int length;
    public RecursiveTextLineObject next = null;
    public String textline = null;

    public RecursiveTextLineObject(BufferedReader reader, int counter) throws IOException {
        this.length = counter + 1;
        this.textline = reader.readLine();
        //create the next node
        if (textline != null) {
            this.next = new RecursiveTextLineObject(reader, counter + 1);
        }
        //take the length of the next node backwards. if this is the last node, the length will be unchanged
        if (this.next != null) {
            length = this.next.length;
        }
    }

}
