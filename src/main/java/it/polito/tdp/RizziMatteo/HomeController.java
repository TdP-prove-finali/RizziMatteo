package it.polito.tdp.RizziMatteo;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.RizziMatteo.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HomeController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnRicerca;

	@FXML
	private Button btnRicorsione;

	@FXML
	void doRicerca(ActionEvent event) {
		try {
			Stage stage = null;
			BorderPane root = null;
			
			stage = (Stage) btnRicerca.getScene().getWindow();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Ricerca.fxml"));
			root = loader.load();
			
			RicercaController controller = loader.getController();
			Model model = new Model();
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			
			stage.setTitle("Ricerca degli artisti");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void doRicorsione(ActionEvent event) {
		try {
			Stage stage = null;
			BorderPane root = null;
			
			stage = (Stage) btnRicorsione.getScene().getWindow();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Ricorsione.fxml"));
			root = loader.load();
			
			RicorsioneController controller = loader.getController();
			Model model = new Model();
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			
			stage.setTitle("Combinazione ottima degli artisti");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		assert btnRicerca != null : "fx:id=\"btnRicerca\" was not injected: check your FXML file 'Home.fxml'.";
		assert btnRicorsione != null : "fx:id=\"btnRicorsione\" was not injected: check your FXML file 'Home.fxml'.";

	}
}
