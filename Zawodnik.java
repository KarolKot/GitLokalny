package model;

import java.time.LocalDate;

public class Zawodnik {

	private int idSkoczka;
	private String imie, nazwisko, kraj;
	private LocalDate dataUrodzenia;
	private int wzrost, waga;

	public Zawodnik() {
		// konstruktor domyślny, zaby nasza klasa była zgodna z java beans
		dataUrodzenia = LocalDate.now();
	}

	public Zawodnik(int idZadownika, String imie, String nazwisko, String kraj, LocalDate dataUrodzenia, int wzrost,
			int waga) {
		this.idSkoczka = idZadownika;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.kraj = kraj;
		this.dataUrodzenia = dataUrodzenia;
		this.wzrost = wzrost;
		this.waga = waga;
	}

	@Override
	public String toString() {
		return "Zawodnik [idZadownika=" + idSkoczka + ", imie=" + imie + ", nazwisko=" + nazwisko + ", kraj=" + kraj
				+ ", dataUrodzenia=" + dataUrodzenia + ", wzrost=" + wzrost + ", waga=" + waga + "]";
	}

	public int getIdZadownika() {
		return idSkoczka;
	}

	public void setIdZadownika(int idZadownika) {
		this.idSkoczka = idZadownika;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getKraj() {
		return kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

	public LocalDate getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(LocalDate dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public int getWzrost() {
		return wzrost;
	}

	public void setWzrost(int wzrost) {
		this.wzrost = wzrost;
	}

	public int getWaga() {
		return waga;
	}

	public void setWaga(int waga) {
		this.waga = waga;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataUrodzenia == null) ? 0 : dataUrodzenia.hashCode());
		result = prime * result + idSkoczka;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((kraj == null) ? 0 : kraj.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + waga;
		result = prime * result + wzrost;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zawodnik other = (Zawodnik) obj;
		if (dataUrodzenia == null) {
			if (other.dataUrodzenia != null)
				return false;
		} else if (!dataUrodzenia.equals(other.dataUrodzenia))
			return false;
		if (idSkoczka != other.idSkoczka)
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (kraj == null) {
			if (other.kraj != null)
				return false;
		} else if (!kraj.equals(other.kraj))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (waga != other.waga)
			return false;
		if (wzrost != other.wzrost)
			return false;
		return true;
	}
}
