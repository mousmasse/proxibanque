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
