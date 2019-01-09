/**
 * 
 */
package sn.objis.proxibanque.metier;


import java.time.LocalDate;

/**
 * Classe Transactioncmpt 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */

public class Transactioncmpt {

	 private long numeroTransaction;
	 private LocalDate dateTransaction;
	 private double montantTransaction;
	 private String typeOperation;
	 private long numeroComptDebiteur;
	 private long numeroCompteCrediteur;
	 private long numeroCompteCourant = 0;
	 private long numeroCompteEpargne = 0;
	
	/**
	 * Constructeur sans paramètre
	 */
	public Transactioncmpt() {
		super();
	}

	/**
	 * Constructeur avec paramètres
	 * @param numeroTransaction
	 * @param dateTransaction
	 * @param montantTransaction
	 * @param typeOperation
	 * @param numeroComptDebiteur
	 * @param numeroCompteCrediteur
	 * @param numeroCompteCourant
	 * @param numeroCompteEpargne
	 */
	public Transactioncmpt(long numeroTransaction, LocalDate dateTransaction, double montantTransaction,
			String typeOperation, long numeroComptDebiteur, long numeroCompteCrediteur, long numeroCompteCourant,
			long numeroCompteEpargne) {
		super();
		this.numeroTransaction = numeroTransaction;
		this.dateTransaction = dateTransaction;
		this.montantTransaction = montantTransaction;
		this.typeOperation = typeOperation;
		this.numeroComptDebiteur = numeroComptDebiteur;
		this.numeroCompteCrediteur = numeroCompteCrediteur;
		this.numeroCompteCourant = numeroCompteCourant;
		this.numeroCompteEpargne = numeroCompteEpargne;
	}

	/**
	 * @return the numeroTransaction
	 */
	public long getNumeroTransaction() {
		return numeroTransaction;
	}

	/**
	 * @param numeroTransaction the numeroTransaction to set
	 */
	public void setNumeroTransaction(long numeroTransaction) {
		this.numeroTransaction = numeroTransaction;
	}

	/**
	 * @return the dateTransaction
	 */
	public LocalDate getDateTransaction() {
		return dateTransaction;
	}

	/**
	 * @param dateTransaction the dateTransaction to set
	 */
	public void setDateTransaction(LocalDate dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	/**
	 * @return the montantTransaction
	 */
	public double getMontantTransaction() {
		return montantTransaction;
	}

	/**
	 * @param montantTransaction the montantTransaction to set
	 */
	public void setMontantTransaction(double montantTransaction) {
		this.montantTransaction = montantTransaction;
	}

	/**
	 * @return the typeOperation
	 */
	public String getTypeOperation() {
		return typeOperation;
	}

	/**
	 * @param typeOperation the typeOperation to set
	 */
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	/**
	 * @return the numeroComptDebiteur
	 */
	public long getNumeroComptDebiteur() {
		return numeroComptDebiteur;
	}

	/**
	 * @param numeroComptDebiteur the numeroComptDebiteur to set
	 */
	public void setNumeroComptDebiteur(long numeroComptDebiteur) {
		this.numeroComptDebiteur = numeroComptDebiteur;
	}

	/**
	 * @return the numeroCompteCrediteur
	 */
	public long getNumeroCompteCrediteur() {
		return numeroCompteCrediteur;
	}

	/**
	 * @param numeroCompteCrediteur the numeroCompteCrediteur to set
	 */
	public void setNumeroCompteCrediteur(long numeroCompteCrediteur) {
		this.numeroCompteCrediteur = numeroCompteCrediteur;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transactioncmpt :\nnumeroTransaction=" + numeroTransaction + ", \ndateTransaction=" + dateTransaction
				+ ", \nmontantTransaction=" + montantTransaction + ", \ntypeOperation=" + typeOperation
				+ ", \nnumeroComptDebiteur=" + numeroComptDebiteur + ", \nnumeroCompteCrediteur="
				+ numeroCompteCrediteur + ", \nnumeroCompteCourant=" + numeroCompteCourant + ", \nnumeroCompteEpargne="
				+ numeroCompteEpargne + ".";
	}
	

}
