/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FluteCalc;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Alex
 */
public class FXMLController {

//<editor-fold defaultstate="collapsed" desc="Top-Left">
    @FXML
    private TextField embouchurewidth;
    @FXML
    private TextField borediameter;
    @FXML
    private TextField wallthickness;
    @FXML
    private TextField embholelength;
    @FXML
    private TextField description;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Top-Right">
    @FXML
    private TextField scalesequence1;
    @FXML
    private TextField scalesequence2;
    @FXML
    private TextField scalesequence3;
    @FXML
    private TextField scalesequence4;
    @FXML
    private TextField scalesequence5;
    @FXML
    private TextField scalesequence6;
    @FXML
    private ComboBox frequencycombobox;

//Button Actions
    @FXML
    protected void handleCalcFreqButtonAction(ActionEvent event) {
        scalesequence1.setText("H");
        scalesequence2.setText("E");
        scalesequence3.setText("L");
        scalesequence4.setText("L");
        scalesequence5.setText("O");
        scalesequence6.setText("!");
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Center-Left">
    @FXML
    private Button calcfreq1;
    @FXML
    private Button calcfreq2;
    @FXML
    private CheckBox autorecalc;

    @FXML
    private TextField frequency1;
    @FXML
    private TextField frequency2;
    @FXML
    private TextField frequency3;
    @FXML
    private TextField frequency4;
    @FXML
    private TextField frequency5;
    @FXML
    private TextField frequency6;

    @FXML
    private TextField diameter1;
    @FXML
    private TextField diameter2;
    @FXML
    private TextField diameter3;
    @FXML
    private TextField diameter4;
    @FXML
    private TextField diameter5;
    @FXML
    private TextField diameter6;

//Button Actions
    @FXML
    protected void freqUpButton1(ActionEvent event) {
    }

    @FXML
    protected void freqUpButton2(ActionEvent event) {
    }

    @FXML
    protected void freqUpButton3(ActionEvent event) {
    }

    @FXML
    protected void freqUpButton4(ActionEvent event) {
    }

    @FXML
    protected void freqUpButton5(ActionEvent event) {
    }

    @FXML
    protected void freqUpButton6(ActionEvent event) {
    }

    @FXML
    protected void freqDownButton1(ActionEvent event) {
    }

    @FXML
    protected void freqDownButton2(ActionEvent event) {
    }

    @FXML
    protected void freqDownButton3(ActionEvent event) {
    }

    @FXML
    protected void freqDownButton4(ActionEvent event) {
    }

    @FXML
    protected void freqDownButton5(ActionEvent event) {
    }

    @FXML
    protected void freqDownButton6(ActionEvent event) {
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Center-Right">
    @FXML
    private TextField geocorrection;
    @FXML
    private TextField cutoffratiodeviation;

    @FXML
    private TextField notename0;
    @FXML
    private TextField chimheight0;
    @FXML
    private TextField nomlengths0;
    @FXML
    private TextField holespace0;
    @FXML
    private TextField localcutoff0;
    @FXML
    private TextField openholecorr0;
    @FXML
    private TextField closedholecorr0;
    @FXML
    private TextField newholepos0;
    @FXML
    private TextField cutoffratio0;
    @FXML
    private TextField ratiodeviation0;
    @FXML
    private TextField notename1;
    @FXML
    private TextField chimheight1;
    @FXML
    private TextField nomlengths1;
    @FXML
    private TextField holespace1;
    @FXML
    private TextField localcutoff1;
    @FXML
    private TextField openholecorr1;
    @FXML
    private TextField closedholecorr1;
    @FXML
    private TextField newholepos1;
    @FXML
    private TextField cutoffratio1;
    @FXML
    private TextField ratiodeviation1;
    @FXML
    private TextField notename2;
    @FXML
    private TextField chimheight2;
    @FXML
    private TextField nomlengths2;
    @FXML
    private TextField holespace2;
    @FXML
    private TextField localcutoff2;
    @FXML
    private TextField openholecorr2;
    @FXML
    private TextField closedholecorr2;
    @FXML
    private TextField newholepos2;
    @FXML
    private TextField cutoffratio2;
    @FXML
    private TextField ratiodeviation2;
    @FXML
    private TextField notename3;
    @FXML
    private TextField chimheight3;
    @FXML
    private TextField nomlengths3;
    @FXML
    private TextField holespace3;
    @FXML
    private TextField localcutoff3;
    @FXML
    private TextField openholecorr3;
    @FXML
    private TextField closedholecorr3;
    @FXML
    private TextField newholepos3;
    @FXML
    private TextField cutoffratio3;
    @FXML
    private TextField ratiodeviation3;
    @FXML
    private TextField notename4;
    @FXML
    private TextField chimheight4;
    @FXML
    private TextField nomlengths4;
    @FXML
    private TextField holespace4;
    @FXML
    private TextField localcutoff4;
    @FXML
    private TextField openholecorr4;
    @FXML
    private TextField closedholecorr4;
    @FXML
    private TextField newholepos4;
    @FXML
    private TextField cutoffratio4;
    @FXML
    private TextField ratiodeviation4;
    @FXML
    private TextField notename5;
    @FXML
    private TextField chimheight5;
    @FXML
    private TextField nomlengths5;
    @FXML
    private TextField holespace5;
    @FXML
    private TextField localcutoff5;
    @FXML
    private TextField openholecorr5;
    @FXML
    private TextField closedholecorr5;
    @FXML
    private TextField newholepos5;
    @FXML
    private TextField cutoffratio5;
    @FXML
    private TextField ratiodeviation5;
    @FXML
    private TextField notename6;
    @FXML
    private TextField nomlengths6;
    @FXML
    private TextField openholecorr6;
    @FXML
    private TextField closedholecorr6;
    @FXML
    private TextField newholepos6;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Bottom-Left">
    @FXML
    private TextField freq6;
    @FXML
    private TextField freq5;
    @FXML
    private TextField freq4;
    @FXML
    private TextField freq3;
    @FXML
    private TextField freq2;
    @FXML
    private TextField freq1;
    @FXML
    private TextField dia6;
    @FXML
    private TextField dia5;
    @FXML
    private TextField dia4;
    @FXML
    private TextField dia3;
    @FXML
    private TextField dia2;
    @FXML
    private TextField dia1;
    @FXML
    private TextField spacebetweencenters56;
    @FXML
    private TextField spacebetweencenters45;
    @FXML
    private TextField spacebetweencenters23;
    @FXML
    private TextField spacebetweencenters12;
    @FXML
    private TextField lengthtoboreratio;
    @FXML
    private TextField embarea;
    @FXML
    private TextField corctoendlength;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Bottom-Right">
    @FXML
    private TextField averagecutoff;
    @FXML
    private TextField numberofiterations;
//</editor-fold>

    public void test() {
        embouchurewidth.setText("asdf");

    }

}
