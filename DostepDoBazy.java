package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DostepDoBazy implements AutoCloseable {
	private String PLIK_BAZY = "C:/Tools/zawodnicy.db";
	private Connection c;

	public DostepDoBazy() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + PLIK_BAZY);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Driver class not found", e);
		}
	}

	public void close() {
		if (c != null)
			try {
				c.close();
			} catch (Exception e) {
				// ignorujemy wyjatek w tym miejscu
			}
	}

	public List<Zawodnik> getListaZawodnikow() throws SQLException {

		final String sql = "SELECT * FROM zawodnicy";
		try (PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			return wczystajZawodnikowZResultSet(rs);
		}
	}

	private List<Zawodnik> wczystajZawodnikowZResultSet(ResultSet rs) throws SQLException {
		List<Zawodnik> lista = new ArrayList<>();
		while (rs.next()) {
			// Gdyby to była porządna baza:
			// LocalDate dataUr = rs.getDate("data_ur").toLocalDate();

			// Ale w SQLite nie ma prawdziwego wsparcia dla dat, daty są
			// trzymane jako TEXT
			LocalDate dataUr = LocalDate.parse(rs.getString("data_ur"));
			Zawodnik z = new Zawodnik(rs.getInt("id_skoczka"), rs.getString("imie"), rs.getString("nazwisko"),
					rs.getString("kraj"), dataUr, rs.getInt("wzrost"), rs.getInt("waga"));

			lista.add(z);
		}
		return lista;
	}

	public List<Zawodnik> zawodnicyZKraju(String kraj) throws SQLException {
		final String sql = "SELECT * FROM zawodnicy WHERE kraj = ?";
		try (PreparedStatement stmt = c.prepareStatement(sql)) {
			stmt.setString(1, kraj);

			try (ResultSet rs = stmt.executeQuery()) {

				return wczystajZawodnikowZResultSet(rs);
			}
		}
	}
}