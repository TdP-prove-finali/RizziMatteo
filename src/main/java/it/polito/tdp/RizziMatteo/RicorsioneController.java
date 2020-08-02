package it.polito.tdp.RizziMatteo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.RizziMatteo.model.Artista;
import it.polito.tdp.RizziMatteo.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class RicorsioneController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSpesa;

    @FXML
    private TextField txtBudgetDisponibile;

    @FXML
    private TextField txtBudgetRimanente;

    @FXML
    private RadioButton radioTuttiGeneri;

    @FXML
    private ToggleGroup groupGeneri;

    @FXML
    private RadioButton radioGeneriSelezionati;

    @FXML
    private ComboBox<?> boxGeneri;

    @FXML
    private Button btnGeneri;

    @FXML
    private RadioButton radioNoPrivilegiati;

    @FXML
    private ToggleGroup groupPrivilegiati;

    @FXML
    private RadioButton radioPrivilegiati;

    @FXML
    private ComboBox<?> boxPrivilegiati;

    @FXML
    private Slider sliderPeso;

    @FXML
    private RadioButton radioArtistiIllimitati;

    @FXML
    private ToggleGroup groupNumeroArtisti;

    @FXML
    private RadioButton radioArtistiLimitati;

    @FXML
    private TextField txtNumeroArtisti;

    @FXML
    private Label lblErrore;

    @FXML
    private Button btnRicorsione;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnHome;

    @FXML
    private TableView<?> tableSoluzione;

    @FXML
    private TableColumn<?, ?> colNome;

    @FXML
    private TableColumn<?, ?> colGenere;

    @FXML
    private TableColumn<?, ?> colBiglietti;

    @FXML
    private TableColumn<?, ?> colCachet;

    @FXML
    void attivaLimitazione(ActionEvent event) {

    }

    @FXML
    void attivaPrivilegiati(ActionEvent event) {

    }

    @FXML
    void attivaSelezione(ActionEvent event) {

    }

    @FXML
    void avviaRicorsione(ActionEvent event) {

    }

    @FXML
    void disattivaLimitazione(ActionEvent event) {

    }

    @FXML
    void disattivaPrivilegiati(ActionEvent event) {

    }

    @FXML
    void disattivaSelezione(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void riempiPrivilegiati(ActionEvent event) {

    }

    @FXML
    void tornaHome(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtSpesa != null : "fx:id=\"txtSpesa\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert txtBudgetDisponibile != null : "fx:id=\"txtBudgetDisponibile\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert txtBudgetRimanente != null : "fx:id=\"txtBudgetRimanente\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert radioTuttiGeneri != null : "fx:id=\"radioTuttiGeneri\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert groupGeneri != null : "fx:id=\"groupGeneri\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert radioGeneriSelezionati != null : "fx:id=\"radioGeneriSelezionati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert boxGeneri != null : "fx:id=\"boxGeneri\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert btnGeneri != null : "fx:id=\"btnGeneri\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert radioNoPrivilegiati != null : "fx:id=\"radioNoPrivilegiati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert groupPrivilegiati != null : "fx:id=\"groupPrivilegiati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert radioPrivilegiati != null : "fx:id=\"radioPrivilegiati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert boxPrivilegiati != null : "fx:id=\"boxPrivilegiati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert sliderPeso != null : "fx:id=\"sliderPeso\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert radioArtistiIllimitati != null : "fx:id=\"radioArtistiIllimitati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert groupNumeroArtisti != null : "fx:id=\"groupNumeroArtisti\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert radioArtistiLimitati != null : "fx:id=\"radioArtistiLimitati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert txtNumeroArtisti != null : "fx:id=\"txtNumeroArtisti\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert lblErrore != null : "fx:id=\"lblErrore\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert btnRicorsione != null : "fx:id=\"btnRicorsione\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert btnHome != null : "fx:id=\"btnHome\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert tableSoluzione != null : "fx:id=\"tableSoluzione\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert colNome != null : "fx:id=\"colNome\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert colGenere != null : "fx:id=\"colGenere\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert colBiglietti != null : "fx:id=\"colBiglietti\" was not injected: check your FXML file 'Ricorsione.fxml'.";
        assert colCachet != null : "fx:id=\"colCachet\" was not injected: check your FXML file 'Ricorsione.fxml'.";

    }
    
	public void setModel(Model model) {
		this.model = model;
	}
}
