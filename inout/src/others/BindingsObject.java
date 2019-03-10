package others;

public class BindingsObject {

    char screen_shift;

    BindingsObject() {
//read from bindings file and put the entries into the variables if existing
        //do it by case
        String str = "d";
        switch (str) {
            case "a":
                break;
            case "d":
                break;
            default:
                break;
        }
    }

}
//Upper casing everything...
/*
 char c = Character.toUpperCase(/* whatever );

 switch(c) {
 case 'A':
 //get the 'A' image;
 break;
 case 'B':
 //get the 'B' image;
 break;
 // (...)
 case 'Z':
 //get the 'Z' image;
 break;
 }
 */

//...or using fall-through cases by ommiting breaks.
/*char c = /* whatever ;

 switch(c) {
 case 'a':
 case 'A':
 //get the 'A' image;
 break;
 case 'b':
 case 'B':
 //get the 'B' image;
 break;
 // (...)
 case 'z':
 case 'Z':
 //get the 'Z' image;
 break;
 }
 */
