package it.polito.tdp.RizziMatteo.model;

public class Artista {

	private Integer id;
	private String nome;
	private String genere;
	private Long bigliettiVenduti;
	private Integer numeroDiShow;
	private Double numeroMedioBigliettiVenduti;
//	private Long ascoltiSpotifyMensili;
	private Integer cachetMedio;

	/**
	 * Crea un nuovo Artista a partire dai parametri inseriti
	 * 
	 * @param nome
	 * @param genere
	 * @param bigliettiVenduti
	 * @param numeroDiShow
	 * @param numeroMedioBigliettiVenduti
	 * @param ascoltiSpotifyMensili
	 * @param cachetMedio
	 */
	public Artista(Integer id, String nome, String genere, Long bigliettiVenduti, Integer numeroDiShow,
			Double numeroMedioBigliettiVenduti, /*Long ascoltiSpotifyMensili, */ Integer cachetMedio) {
		super();
		this.id = id;
		this.nome = nome;
		this.genere = genere;
		this.bigliettiVenduti = bigliettiVenduti;
		this.numeroDiShow = numeroDiShow;
		this.numeroMedioBigliettiVenduti = numeroMedioBigliettiVenduti;
	//	this.ascoltiSpotifyMensili = ascoltiSpotifyMensili;
		this.cachetMedio = cachetMedio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Long getBigliettiVenduti() {
		return bigliettiVenduti;
	}

	public void setBigliettiVenduti(Long bigliettiVenduti) {
		this.bigliettiVenduti = bigliettiVenduti;
	}

	public Integer getNumeroDiShow() {
		return numeroDiShow;
	}

	public void setNumeroDiShow(Integer numeroDiShow) {
		this.numeroDiShow = numeroDiShow;
	}

	public Double getNumeroMedioBigliettiVenduti() {
		return numeroMedioBigliettiVenduti;
	}

	public void setNumeroMedioBigliettiVenduti(Double numeroMedioBigliettiVenduti) {
		this.numeroMedioBigliettiVenduti = numeroMedioBigliettiVenduti;
	}

/*	public Long getAscoltiSpotifyMensili() {
		return ascoltiSpotifyMensili;
	}

	public void setAscoltiSpotifyMensili(Long ascoltiSpotifyMensili) {
		this.ascoltiSpotifyMensili = ascoltiSpotifyMensili;
	} */

	public Integer getCachetMedio() {
		return cachetMedio;
	}

	public void setCachetMedio(Integer cachetMedio) {
		this.cachetMedio = cachetMedio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Artista other = (Artista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}

}
