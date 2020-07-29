package it.polito.tdp.RizziMatteo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.RizziMatteo.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HomeController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxFiltro;

    @FXML
    private ComboBox<?> boxGenere;

    @FXML
    private TextField txtNumeroBiglietti;

    @FXML
    private TextField txtCachet;

    @FXML
    private TextField txtNome;

    @FXML
    private Button btnRicerca;

    @FXML
    private Button btnAggiungi;

    @FXML
    private Button btnSoluzione;

    @FXML
    private TableView<?> tableArtista;

    @FXML
    private TableColumn<?, ?> tcNome;

    @FXML
    private TableColumn<?, ?> tcGenere;

    @FXML
    private TableColumn<?, ?> tcBiglietti;

    @FXML
    private TableColumn<?, ?> tcCachet;

    @FXML
    void abilitaSelezione(ActionEvent event) {

    }

    @FXML
    void aggiungiSoluzioneParziale(ActionEvent event) {

    }

    @FXML
    void avviaRicerca(ActionEvent event) {

    }

    @FXML
    void vaiAllaSoluzione(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert boxFiltro != null : "fx:id=\"boxFiltro\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert boxGenere != null : "fx:id=\"boxGenere\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert txtNumeroBiglietti != null : "fx:id=\"txtNumeroBiglietti\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert txtCachet != null : "fx:id=\"txtCachet\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert btnRicerca != null : "fx:id=\"btnRicerca\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert btnAggiungi != null : "fx:id=\"btnAggiungi\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert btnSoluzione != null : "fx:id=\"btnSoluzione\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert tableArtista != null : "fx:id=\"tableArtista\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert tcNome != null : "fx:id=\"tcNome\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert tcGenere != null : "fx:id=\"tcGenere\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert tcBiglietti != null : "fx:id=\"tcBiglietti\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert tcCachet != null : "fx:id=\"tcCachet\" was not injected: check your FXML file 'Ricerca.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		List<String> filtri = new ArrayList<>();
		filtri.add(new String("Trova tutti gli artisti"));
		filtri.add(new String("Trova gli artisti appartenenti ad un genere"));
		filtri.add(new String("Trova gli artisti dato il nome o una parte di esso"));
		filtri.add(new String("Trova gli artisti per numero medio di biglietti venduti"));
		filtri.add(new String("Trova gli artisti per cachet"));
		this.boxFiltro.getItems().addAll(filtri);
		
	}
}
