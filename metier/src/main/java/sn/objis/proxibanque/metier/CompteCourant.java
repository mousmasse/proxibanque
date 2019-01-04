/**
 * 
 */
package sn.objis.proxibanque.metier;

import java.time.LocalDate;

/**
 * Classe CompteCourant 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public class CompteCourant {

	private long numeroCompteCourant; 
	private double soldeCourant;
	private LocalDate dateOuvertureCourant;
	private double decouvert;
	private Client clientCompteCourant; 
	
	/**
	 * Constructeur sans paramètre
	 */
	public CompteCourant() {
		super();
	}

	/**
	 * Constructeur avec paramètres
	 * @param numeroCompteCourant
	 * @param soldeCourant
	 * @param dateOuvertureCourant
	 * @param decouvert
	 * @param clientCompteCourant
	 */
	public CompteCourant(long numeroCompteCourant, double soldeCourant, LocalDate dateOuvertureCourant,
			double decouvert, Client clientCompteCourant) {
		super();
		this.numeroCompteCourant = numeroCompteCourant;
		this.soldeCourant = soldeCourant;
		this.dateOuvertureCourant = dateOuvertureCourant;
		this.decouvert = decouvert;
		this.clientCompteCourant = clientCompteCourant;
	}
	

	/**
	 * @return the numeroCompteCourant
	 */
	public long getNumeroCompteCourant() {
		return numeroCompteCourant;
	}

	/**
	 * @param numeroCompteCourant the numeroCompteCourant to set
	 */
	public void setNumeroCompteCourant(long numeroCompteCourant) {
		this.numeroCompteCourant = numeroCompteCourant;
	}

	/**
	 * @return the soldeCourant
	 */
	public double getSoldeCourant() {
		return soldeCourant;
	}

	/**
	 * @param soldeCourant the soldeCourant to set
	 */
	public void setSoldeCourant(double soldeCourant) {
		this.soldeCourant = soldeCourant;
	}

	/**
	 * @return the dateOuvertureCourant
	 */
	public LocalDate getDateOuvertureCourant() {
		return dateOuvertureCourant;
	}

	/**
	 * @param dateOuvertureCourant the dateOuvertureCourant to set
	 */
	public void setDateOuvertureCourant(LocalDate dateOuvertureCourant) {
		this.dateOuvertureCourant = dateOuvertureCourant;
	}

	/**
	 * @return the decouvert
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * @param decouvert the decouvert to set
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	/**
	 * @return the clientCompteCourant
	 */
	public Client getClientCompteCourant() {
		return clientCompteCourant;
	}

	/**
	 * @param clientCompteCourant the clientCompteCourant to set
	 */
	public void setClientCompteCourant(Client clientCompteCourant) {
		this.clientCompteCourant = clientCompteCourant;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteCourant :\nnumeroCompteCourant=" + numeroCompteCourant + ", \nsoldeCourant=" + soldeCourant
				+ ", \ndateOuvertureCourant=" + dateOuvertureCourant + ", \ndecouvert=" + decouvert
				+ ", \nclientCompteCourant=" + clientCompteCourant.toString() + ".";
	}
	
}
