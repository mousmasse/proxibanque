/**
 * 
 */
package sn.objis.proxibanque.metier;

import java.time.LocalDate;

/**
 * Classe CompteEpargne 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public class CompteEpargne {

	private long numeroCompteEpargne;
	private double soldeEpargne;
	private LocalDate dateOuvertureEpargne;
	private double taux;
	private Client clientCompteEpargne;
	
	/**
	 *Constructeur sans paramètre 
	 */
	public CompteEpargne() {
		super();
	}

	/**
	 * Constructeur avec paramètre
	 * @param numeroCompteEpargne
	 * @param soldeEpargne
	 * @param dateOuvertureEpargne
	 * @param taux
	 * @param clientCompteEpargne
	 */
	public CompteEpargne(long numeroCompteEpargne, double soldeEpargne, LocalDate dateOuvertureEpargne, double taux,
			Client clientCompteEpargne) {
		super();
		this.numeroCompteEpargne = numeroCompteEpargne;
		this.soldeEpargne = soldeEpargne;
		this.dateOuvertureEpargne = dateOuvertureEpargne;
		this.taux = taux;
		this.clientCompteEpargne = clientCompteEpargne;
	}

	
	
	/**
	 * @return the numeroCompteEpargne
	 */
	public long getNumeroCompteEpargne() {
		return numeroCompteEpargne;
	}

	/**
	 * @param numeroCompteEpargne the numeroCompteEpargne to set
	 */
	public void setNumeroCompteEpargne(long numeroCompteEpargne) {
		this.numeroCompteEpargne = numeroCompteEpargne;
	}

	/**
	 * @return the soldeEpargne
	 */
	public double getSoldeEpargne() {
		return soldeEpargne;
	}

	/**
	 * @param soldeEpargne the soldeEpargne to set
	 */
	public void setSoldeEpargne(double soldeEpargne) {
		this.soldeEpargne = soldeEpargne;
	}

	/**
	 * @return the dateOuvertureEpargne
	 */
	public LocalDate getDateOuvertureEpargne() {
		return dateOuvertureEpargne;
	}

	/**
	 * @param dateOuvertureEpargne the dateOuvertureEpargne to set
	 */
	public void setDateOuvertureEpargne(LocalDate dateOuvertureEpargne) {
		this.dateOuvertureEpargne = dateOuvertureEpargne;
	}

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

	/**
	 * @return the clientCompteEpargne
	 */
	public Client getClientCompteEpargne() {
		return clientCompteEpargne;
	}

	/**
	 * @param clientCompteEpargne the clientCompteEpargne to set
	 */
	public void setClientCompteEpargne(Client clientCompteEpargne) {
		this.clientCompteEpargne = clientCompteEpargne;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteEpargne :\nnumeroCompteEpargne=" + numeroCompteEpargne + ", \nsoldeEpargne=" + soldeEpargne
				+ ", \ndateOuvertureEpargne=" + dateOuvertureEpargne + ", \ntaux=" + taux + ", \nclientCompteEpargne=" + clientCompteEpargne
				+ ".";
	}
		

}
