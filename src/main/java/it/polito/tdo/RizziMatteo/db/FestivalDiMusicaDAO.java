package it.polito.tdo.RizziMatteo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.RizziMatteo.model.Artista;

public class FestivalDiMusicaDAO {

	public List<Artista> listAllArtists() {
		String sql = "SELECT * FROM artisti";
		List<Artista> list = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Artista artista = new Artista(res.getInt("id"), res.getString("nome"), res.getString("genere"),
						res.getLong("biglietti_venduti"), res.getInt("numero_di_show"),
						res.getDouble("numero_medio_biglietti_venduti"), res.getLong("cachet_medio"));

				list.add(artista);
			}
			conn.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Artista> getArtistsByPartOfName(String nome) {
		String sql = "SELECT * FROM artisti";
		List<Artista> list = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				if (res.getString("nome").toLowerCase().contains(nome.toLowerCase())) {
					Artista artista = new Artista(res.getInt("id"), res.getString("nome"), res.getString("genere"),
							res.getLong("biglietti_venduti"), res.getInt("numero_di_show"),
							res.getDouble("numero_medio_biglietti_venduti"), res.getLong("cachet_medio"));
					list.add(artista);
				}
			}
			conn.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Artista> getArtistsByMusicalGenre(String genere) {
		String sql = "SELECT * FROM artisti WHERE genere = ?";
		List<Artista> list = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, genere);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Artista artista = new Artista(res.getInt("id"), res.getString("nome"), res.getString("genere"),
						res.getLong("biglietti_venduti"), res.getInt("numero_di_show"),
						res.getDouble("numero_medio_biglietti_venduti"), res.getLong("cachet_medio"));

				list.add(artista);
			}
			conn.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Artista> getArtistsByAverageTicketsSold(Double media) {
		String sql = "SELECT * FROM artisti WHERE numero_medio_biglietti_venduti >= ?";
		List<Artista> list = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setDouble(1, media);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Artista artista = new Artista(res.getInt("id"), res.getString("nome"), res.getString("genere"),
						res.getLong("biglietti_venduti"), res.getInt("numero_di_show"),
						res.getDouble("numero_medio_biglietti_venduti"), res.getLong("cachet_medio"));

				list.add(artista);
			}
			conn.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Artista> getArtistsByCachet(Long cachet) {
		String sql = "SELECT * FROM artisti WHERE cachet_medio <= ?";
		List<Artista> list = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setLong(1, cachet);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Artista artista = new Artista(res.getInt("id"), res.getString("nome"), res.getString("genere"),
						res.getLong("biglietti_venduti"), res.getInt("numero_di_show"),
						res.getDouble("numero_medio_biglietti_venduti"), res.getLong("cachet_medio"));

				list.add(artista);
			}
			conn.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<String> getMusicalGenres() {
		String sql = "SELECT DISTINCT genere FROM artisti ORDER BY genere";
		List<String> list = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				list.add(res.getString("genere"));
			}
			conn.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
