/**
 * 
 */
package sn.objis.proxibanque.metier;

import java.time.LocalDate;

/**
 * Classe Personnel 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public class Personnel {

	private long idPersonnel;
	private String nomPersonnel;
	private String prenomPersonnel;
	private String typePersonnel;
	private String adressePersonnel;
	private int telPersonnel;
	LocalDate dateEmbauche;
	private Agence agence;
	/**
	 * Constructeur sans paramètre 
	 */
	public Personnel() {
		super();
	}
	
		
	/**
	 * Constructeur avec paramètres
	 * @param idPersonnel
	 * @param nomPersonnel
	 * @param prenomPersonnel
	 * @param typePersonnel
	 * @param adressePersonnel
	 * @param telPersonnel
	 * @param dateEmbauche
	 * @param agence
	 */
	public Personnel(long idPersonnel, String nomPersonnel, String prenomPersonnel, String typePersonnel,
			String adressePersonnel, int telPersonnel, LocalDate dateEmbauche, Agence agence) {
		super();
		this.idPersonnel = idPersonnel;
		this.nomPersonnel = nomPersonnel;
		this.prenomPersonnel = prenomPersonnel;
		this.typePersonnel = typePersonnel;
		this.adressePersonnel = adressePersonnel;
		this.telPersonnel = telPersonnel;
		this.dateEmbauche = dateEmbauche;
		this.agence = agence;
	}



	/**
	 * @return the idPersonnel
	 */
	public long getIdPersonnel() {
		return idPersonnel;
	}


	/**
	 * @param idPersonnel the idPersonnel to set
	 */
	public void setIdPersonnel(long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}


	/**
	 * @return the nomPersonnel
	 */
	public String getNomPersonnel() {
		return nomPersonnel;
	}


	/**
	 * @param nomPersonnel the nomPersonnel to set
	 */
	public void setNomPersonnel(String nomPersonnel) {
		this.nomPersonnel = nomPersonnel;
	}


	/**
	 * @return the prenomPersonnel
	 */
	public String getPrenomPersonnel() {
		return prenomPersonnel;
	}


	/**
	 * @param prenomPersonnel the prenomPersonnel to set
	 */
	public void setPrenomPersonnel(String prenomPersonnel) {
		this.prenomPersonnel = prenomPersonnel;
	}


	/**
	 * @return the typePersonnel
	 */
	public String getTypePersonnel() {
		return typePersonnel;
	}


	/**
	 * @param typePersonnel the typePersonnel to set
	 */
	public void setTypePersonnel(String typePersonnel) {
		this.typePersonnel = typePersonnel;
	}


	/**
	 * @return the adressePersonnel
	 */
	public String getAdressePersonnel() {
		return adressePersonnel;
	}


	/**
	 * @param adressePersonnel the adressePersonnel to set
	 */
	public void setAdressePersonnel(String adressePersonnel) {
		this.adressePersonnel = adressePersonnel;
	}


	/**
	 * @return the telPersonnel
	 */
	public int getTelPersonnel() {
		return telPersonnel;
	}


	/**
	 * @param telPersonnel the telPersonnel to set
	 */
	public void setTelPersonnel(int telPersonnel) {
		this.telPersonnel = telPersonnel;
	}


	/**
	 * @return the dateEmbauche
	 */
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}


	/**
	 * @param dateEmbauche the dateEmbauche to set
	 */
	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}


	/**
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}


	/**
	 * @param agence the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personnel :\nidPersonnel=" + idPersonnel + ", \nnomPersonnel=" + nomPersonnel + ", \nprenomPersonnel="
				+ prenomPersonnel + ", \ntypePersonnel=" + typePersonnel + ", \nadressePersonnel=" + adressePersonnel
				+ ", \ntelPersonnel=" + telPersonnel + ", \ndateEmbauche=" + dateEmbauche + ", \nagence=" + agence.toString()
				+ ".";
	}
	
	
	
}
