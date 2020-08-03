package it.polito.tdp.RizziMatteo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.RizziMatteo.model.Artista;
import it.polito.tdp.RizziMatteo.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RicorsioneController {

	private Model model;
	private List<String> generiAmmessi;

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
	private ComboBox<String> boxGeneri;

	@FXML
	private Button btnGeneri;
	
    @FXML
    private Button btnConfermaGeneri;

	@FXML
	private RadioButton radioNoPrivilegiati;

	@FXML
	private ToggleGroup groupPrivilegiati;

	@FXML
	private RadioButton radioPrivilegiati;

	@FXML
	private ComboBox<String> boxPrivilegiati;
	
    @FXML
    private Button btnPrivilegiati;

    @FXML
    private Label lblPrivilegiati;

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
	private TableView<Artista> tableSoluzione;

	@FXML
	private TableColumn<Artista, String> colNome;

	@FXML
	private TableColumn<Artista, String> colGenere;

	@FXML
	private TableColumn<Artista, Double> colBiglietti;

	@FXML
	private TableColumn<Artista, Long> colCachet;
	
    @FXML
    void aggiungiAPrivilegiati(ActionEvent event) {

    }

	@FXML
	void attivaLimitazione(ActionEvent event) {
		this.txtNumeroArtisti.setDisable(false);

	}

	@FXML
	void attivaPrivilegiati(ActionEvent event) {
		this.boxPrivilegiati.setDisable(false);
		this.sliderPeso.setDisable(false);
		this.btnPrivilegiati.setDisable(false);
		this.lblPrivilegiati.setDisable(false);

	}

	@FXML
	void attivaSelezione(ActionEvent event) {
		this.boxGeneri.setDisable(false);
		this.btnGeneri.setDisable(false);
		
		this.radioPrivilegiati.setDisable(true);
		this.radioNoPrivilegiati.setDisable(true);
		this.boxPrivilegiati.setDisable(true);
		this.sliderPeso.setDisable(true);
		this.btnPrivilegiati.setDisable(true);
		this.lblPrivilegiati.setDisable(true);
		this.boxPrivilegiati.getItems().clear();
	}

	@FXML
	void avviaRicorsione(ActionEvent event) {
		this.lblErrore.setText("");
		
		if(this.radioPrivilegiati.isDisabled() && this.radioNoPrivilegiati.isDisabled()) {
			this.lblErrore.setText("Errore! Per poter avviare la ricorsione devi prima confermare la selezione dei generi musicali.");
			return;
		}
		
		if(this.radioPrivilegiati.isSelected()) {
			if(this.boxPrivilegiati.getItems().size() == 0) {
				this.lblErrore.setText("Errore! Hai selezionato l'opzione dei generi privilegiati, ma non hai aggiunto alcun genere tra i privilegiati!");
				return;
			}
		}
		
	}

	@FXML
	void disattivaLimitazione(ActionEvent event) {
		this.txtNumeroArtisti.setDisable(true);

	}

	@FXML
	void disattivaPrivilegiati(ActionEvent event) {
		this.boxPrivilegiati.setDisable(true);
		this.sliderPeso.setDisable(true);
		this.btnPrivilegiati.setDisable(true);
		this.lblPrivilegiati.setDisable(true);

	}

	@FXML
	void disattivaSelezione(ActionEvent event) {
		this.boxGeneri.setDisable(true);
		this.btnGeneri.setDisable(true);
		
		this.radioPrivilegiati.setDisable(true);
		this.radioNoPrivilegiati.setDisable(true);
		this.boxPrivilegiati.setDisable(true);
		this.sliderPeso.setDisable(true);
		this.btnPrivilegiati.setDisable(true);
		this.lblPrivilegiati.setDisable(true);
		this.boxPrivilegiati.getItems().clear();
	}

	@FXML
	void doReset(ActionEvent event) {

	}
	
    @FXML
    void permettiSceltaPrivilegiati(ActionEvent event) {
    	this.lblErrore.setText("");
    	this.generiAmmessi = new ArrayList<>();
    	
		if(this.radioGeneriSelezionati.isSelected()) {
			if(this.boxPrivilegiati.getItems().size() == 0) {
				this.lblErrore.setText("Errore! Per poter confermare i generi selezionati devi averne aggiunto almeno uno.");
				return;
			}
		} else if(this.radioTuttiGeneri.isSelected()) {
			this.boxPrivilegiati.getItems().addAll(this.model.getMusicalGenres());
		}
		
		this.generiAmmessi.addAll(this.boxPrivilegiati.getItems());
		
		if(this.radioPrivilegiati.isSelected()) {
			this.boxPrivilegiati.setDisable(false);
			this.sliderPeso.setDisable(false);
			this.btnPrivilegiati.setDisable(false);
			this.lblPrivilegiati.setDisable(false);
		}
		
    	this.radioPrivilegiati.setDisable(false);
		this.radioNoPrivilegiati.setDisable(false);

    }

	@FXML
	void riempiPrivilegiati(ActionEvent event) {
		this.lblErrore.setText("");
		String genere = this.boxGeneri.getValue();
		
		if(genere == null) {
			this.lblErrore.setText("Errore! Per poter aggiungere il genere musicale selezionato ne dei selezionare uno dall'apposito menu.");
			return;
		}
		
		if(this.boxPrivilegiati.getItems().contains(genere)) {
			this.lblErrore.setText("Errore! Il genere selezionato è stato già aggiunto.");
			return;
		}
		
		this.boxPrivilegiati.getItems().add(genere);
	}

	@FXML
	void tornaHome(ActionEvent event) {
		try {
			Stage stage = null;
			BorderPane root = null;
			
			stage = (Stage) this.btnHome.getScene().getWindow();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
			root = loader.load();
			
			HomeController controller = loader.getController();
			
			Scene scene = new Scene(root);
			
			stage.setTitle("Homepage");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
        assert btnConfermaGeneri != null : "fx:id=\"btnConfermaGeneri\" was not injected: check your FXML file 'Ricorsione.fxml'.";
		assert radioNoPrivilegiati != null : "fx:id=\"radioNoPrivilegiati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
		assert groupPrivilegiati != null : "fx:id=\"groupPrivilegiati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
		assert radioPrivilegiati != null : "fx:id=\"radioPrivilegiati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
		assert btnPrivilegiati != null : "fx:id=\"btnPrivilegiati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
		assert lblPrivilegiati != null : "fx:id=\"lblPrivilegiati\" was not injected: check your FXML file 'Ricorsione.fxml'.";
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
		this.boxGeneri.getItems().addAll(this.model.getMusicalGenres());
		
		this.colBiglietti.setCellValueFactory(new PropertyValueFactory<Artista, Double>("numeroMedioBigliettiVenduti"));
		this.colCachet.setCellValueFactory(new PropertyValueFactory<Artista, Long>("cachetMedio"));
		this.colGenere.setCellValueFactory(new PropertyValueFactory<Artista, String>("genere"));
		this.colNome.setCellValueFactory(new PropertyValueFactory<Artista, String>("nome"));
	}
}
