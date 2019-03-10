package others;

/**/
//This is just an Info file to some programming Know-How

//<editor-fold defaultstate="collapsed" desc="long & double Value Range">
/*
 int: 32-Bit; -2147483648 - +2147483647; factorial(16);
 long: 64-Bit; -9223372036854775808 - +9223372036854775807; factorial(20);

 foat: 32-Bit; einfache Genauigkeit; factorial(): 20. Erg: 2.43290202E18
 21. Erg: -4.24929001E18
 in Zehnerpotenz Hochzählen(1-9,10-90,100-1000,...):
 Erg: 3.1111113E38
 Var: 1.0000001E38
 double: 64-Bit; doppelte Genauigkeit; factorial(): 20. Erg: 2.43290200817664E18
 21. Erg: -4.2492900494192148E18
 in Zehnerpotenz Hochzählen(1-9,10-90,100-1000,...):
 Erg: 1.1111111111111108E308
 Var: 9.999999999999999E306
 Bei der Notation einer Konstante gilt eine Zahl als Gleitkommazahl, wenn sie einen Dezimalpunkt oder einen Exponenten (durch E oder e eingeleitet) enthält (in diesem Fall wird sie als double interpretiert), bzw. wenn ihr der Buchstabe F oder f für float bzw. D oder d für double angehängt wird:

 3.14          Ein einfacher double-Wert.
 6.02E23       Ein großer double-Wert (= 6.02E+23).
 2.718F	      Ein einfacher float-Wert.
 123.4E+306D   Ein großer double-Wert mit redundantem D.
 In Java sind Gleitkommawerte ohne Angabe von F oder f vom Typ double.

 float floatVar = 3.14E5F;  // F am Ende erforderlich,
 // sonst Compilezeitfehler.
 // Ohne F oder f wird die
 // Zahl als double interpretiert.
 double doubleVar = 3.14E5; // D ist am Ende nicht
 // erforderlich.


 */
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="long, double & BigDecimal Tests"> 
/*
 //it is a long variable, so l is needed at the end
 long a = 9223372036854775807L;
 System.out.println(a);
 //Long To Double Conversion
 double x = a;
 //Double T BigDecimal Conversion, doule Value gets rounded up
 BigDecimal big = new BigDecimal(a);
 System.out.println(big);
 //Output of the double Value
 System.out.println(x);
 //first negative long Value
 a = (long) x + 1;
 System.out.println(a);
 //Double T BigDecimal Conversion, doule Value gets rounded up, but can exeed
 //the long value, because it is no long anymore
 big = new BigDecimal(x);
 System.out.println(big);
 */
//</editor-fold>
