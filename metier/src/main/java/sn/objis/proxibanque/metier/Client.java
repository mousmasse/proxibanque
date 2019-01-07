/**
 * 
 */
package sn.objis.proxibanque.metier;

/**
 * Classe Client 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */

public class Client {

	private long idClient;
	private String nomClient;
	private String prenomClient;
	private String emailClient;
	private String adresseClient;
	private String ville;
	private int codePostalClient;
	private int telephone;
	private String profession;
	private Agence agence;
	private Personnel conseiller;
	/**
	 *Constructeur sans paramètre  
	 */
	public Client() {
		super();
	}
	/**
	 * Constructeur avec paramètres 
	 * @param idClient
	 * @param nomClient
	 * @param prenomClient
	 * @param emailClient
	 * @param adresseClient
	 * @param ville
	 * @param codePostalClient
	 * @param telephone
	 * @param profession
	 * @param agence
	 * @param conseiller
	 */
	public Client(long idClient, String nomClient, String prenomClient, String emailClient, String adresseClient,
			String ville, int codePostalClient, int telephone, String profession, Agence agence, Personnel conseiller) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.emailClient = emailClient;
		this.adresseClient = adresseClient;
		this.ville = ville;
		this.codePostalClient = codePostalClient;
		this.telephone = telephone;
		this.profession = profession;
		this.agence = agence;
		this.conseiller = conseiller;
	}
	
	
	
	/**
	 * @return the idClient
	 */
	public long getIdClient() {
		return idClient;
	}
	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	/**
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}
	/**
	 * @param nomClient the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	/**
	 * @return the prenomClient
	 */
	public String getPrenomClient() {
		return prenomClient;
	}
	/**
	 * @param prenomClient the prenomClient to set
	 */
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	/**
	 * @return the emailClient
	 */
	public String getEmailClient() {
		return emailClient;
	}
	/**
	 * @param emailClient the emailClient to set
	 */
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	/**
	 * @return the adresseClient
	 */
	public String getAdresseClient() {
		return adresseClient;
	}
	/**
	 * @param adresseClient the adresseClient to set
	 */
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the codePostalClient
	 */
	public int getCodePostalClient() {
		return codePostalClient;
	}
	/**
	 * @param codePostalClient the codePostalClient to set
	 */
	public void setCodePostalClient(int codePostalClient) {
		this.codePostalClient = codePostalClient;
	}
	/**
	 * @return the telephone
	 */
	public int getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
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
	/**
	 * @return the conseiller
	 */
	public Personnel getConseiller() {
		return conseiller;
	}
	/**
	 * @param conseiller the conseiller to set
	 */
	public void setConseiller(Personnel conseiller) {
		this.conseiller = conseiller;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client :\nidClient=" + idClient + ", \nnomClient=" + nomClient + ", \nprenomClient=" + prenomClient
				+ ", \nemailClient=" + emailClient + ", \nadresseClient=" + adresseClient + ", \nville=" + ville
				+ ", \ncodePostalClient=" + codePostalClient + ", \ntelephone=" + telephone + ", \nprofession="
				+ profession + ", \nagence=" + agence.toString() + ", \nconseiller=" + conseiller.toString() + ".";
	}
	
	

}
