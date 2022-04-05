/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="areaCorretti"
    private TextArea areaCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="areaErrati"
    private TextArea areaErrati; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCalcolo"
    private Button buttonCalcolo; // Value injected by FXMLLoader

    @FXML // fx:id="buttonReset"
    private Button buttonReset; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnagramma"
    private TextField txtAnagramma; // Value injected by FXMLLoader

    @FXML
    void doCalcolo(ActionEvent event) {
    	String anagramm= txtAnagramma.getText();
    	Parola p= new Parola();
    	Set<String> lista = p.anagramma(anagramm);
    	
    	for(String sp: lista) {
    		if(model.isCorretto(sp)) {
    			areaCorretti.appendText(sp+"\n");
    		}else {
    			areaErrati.appendText(sp+"\n");
    		}
    	}
    }

    @FXML
    void doClear(ActionEvent event) {
    	txtAnagramma.clear();
    	areaErrati.clear();
    	areaCorretti.clear();
    }
    
  

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert areaCorretti != null : "fx:id=\"areaCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert areaErrati != null : "fx:id=\"areaErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonCalcolo != null : "fx:id=\"buttonCalcolo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonReset != null : "fx:id=\"buttonReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagramma != null : "fx:id=\"txtAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model m) {
    	this.model=m;
    }
}

