/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

// import javafx.event.ActionEvent;
import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import javafx.scene.control.CheckBox;
// import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
// import javafx.scene.control.TextField;

/**
 *
 * @author Alex
 */
public class FXMLMenuController {

//<editor-fold defaultstate="collapsed" desc="File">
    @FXML
    private MenuItem load;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem print;
    @FXML
    private MenuItem quit;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Special">
    @FXML
    private MenuItem entercustomfreq;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Utility">
    @FXML
    private MenuItem rsconversion;
    @FXML
    private MenuItem tempconversion;
    @FXML
    private MenuItem distanceconversion;
    @FXML
    private MenuItem airdensity;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Scales/Modes">
    @FXML
    private MenuItem majorscale;
    @FXML
    private MenuItem harmonicminor;
    @FXML
    private MenuItem naturalminor;
    @FXML
    private MenuItem melodicminor;
    @FXML
    private MenuItem ahavaraba;
    @FXML
    private MenuItem nativeam;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Help">
    @FXML
    private MenuItem help;
    @FXML
    private MenuItem drillsizes;
    @FXML
    private MenuItem tubingsizes;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Setup">
    @FXML
    private MenuItem setup;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Prev">
    @FXML
    private MenuItem prev;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Next">
    @FXML
    private MenuItem next;
//</editor-fold>

}
