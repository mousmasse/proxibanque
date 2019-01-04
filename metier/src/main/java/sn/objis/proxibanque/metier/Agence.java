/**
 * 
 */
package sn.objis.proxibanque.metier;

import java.time.LocalDate;

/**
 * Classe Agence 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public class Agence {
	private long numeroAgence;
	private LocalDate dateCreation;
	private String libAgence;
	
	/**
	 * Constructeur sans paramètre 
	 */
	public Agence() {
		
	}

	/**
	 * Constructeur avec paramètres
	 * @param numeroAgence
	 * @param dateCreation
	 * @param libAgence
	 */
	public Agence(long numeroAgence, LocalDate dateCreation, String libAgence) {
		super();
		this.numeroAgence = numeroAgence;
		this.dateCreation = dateCreation;
		this.libAgence = libAgence;
	}

	/**
	 * @return the numeroAgence
	 */
	public long getNumeroAgence() {
		return numeroAgence;
	}

	/**
	 * @param numeroAgence the numeroAgence to set
	 */
	public void setNumeroAgence(long numeroAgence) {
		this.numeroAgence = numeroAgence;
	}

	/**
	 * @return the dateCreation
	 */
	public LocalDate getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * @return the libAgence
	 */
	public String getLibAgence() {
		return libAgence;
	}

	/**
	 * @param libAgence the libAgence to set
	 */
	public void setLibAgence(String libAgence) {
		this.libAgence = libAgence;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agence :\nnumeroAgence=" + numeroAgence + ", \ndateCreation=" + dateCreation + ", \nlibAgence="
				+ libAgence + ".";
	}
	

}
