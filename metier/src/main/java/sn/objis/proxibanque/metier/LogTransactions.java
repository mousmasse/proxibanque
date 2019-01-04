package sn.objis.proxibanque.metier;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Classe LogTransactions 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public class LogTransactions {

	private long numeroLog;
	private LocalDate dateLog;
	private long numeroTransactionLog;
	private LocalDateTime dateTransactionLog;
	private double montantTransactionLog;
	private String typeOperationLog;
	private long numeroComptDebiteurLog;
	private long numeroCompteCrediteurLog; 
	
	
	/**
	 * Constructeur sans paramètre
	 */
	public LogTransactions() {
		super();
	}


	/**
	 * Constructeur avec paramètres
	 * @param numeroLog
	 * @param dateLog
	 * @param numeroTransactionLog
	 * @param dateTransactionLog
	 * @param montantTransactionLog
	 * @param typeOperationLog
	 * @param numeroComptDebiteurLog
	 * @param numeroCompteCrediteurLog
	 */
	public LogTransactions(long numeroLog, LocalDate dateLog, long numeroTransactionLog,
			LocalDateTime dateTransactionLog, double montantTransactionLog, String typeOperationLog,
			long numeroComptDebiteurLog, long numeroCompteCrediteurLog) {
		super();
		this.numeroLog = numeroLog;
		this.dateLog = dateLog;
		this.numeroTransactionLog = numeroTransactionLog;
		this.dateTransactionLog = dateTransactionLog;
		this.montantTransactionLog = montantTransactionLog;
		this.typeOperationLog = typeOperationLog;
		this.numeroComptDebiteurLog = numeroComptDebiteurLog;
		this.numeroCompteCrediteurLog = numeroCompteCrediteurLog;
	}


	/**
	 * @return the numeroLog
	 */
	public long getNumeroLog() {
		return numeroLog;
	}


	/**
	 * @param numeroLog the numeroLog to set
	 */
	public void setNumeroLog(long numeroLog) {
		this.numeroLog = numeroLog;
	}


	/**
	 * @return the dateLog
	 */
	public LocalDate getDateLog() {
		return dateLog;
	}


	/**
	 * @param dateLog the dateLog to set
	 */
	public void setDateLog(LocalDate dateLog) {
		this.dateLog = dateLog;
	}


	/**
	 * @return the numeroTransactionLog
	 */
	public long getNumeroTransactionLog() {
		return numeroTransactionLog;
	}


	/**
	 * @param numeroTransactionLog the numeroTransactionLog to set
	 */
	public void setNumeroTransactionLog(long numeroTransactionLog) {
		this.numeroTransactionLog = numeroTransactionLog;
	}


	/**
	 * @return the dateTransactionLog
	 */
	public LocalDateTime getDateTransactionLog() {
		return dateTransactionLog;
	}


	/**
	 * @param dateTransactionLog the dateTransactionLog to set
	 */
	public void setDateTransactionLog(LocalDateTime dateTransactionLog) {
		this.dateTransactionLog = dateTransactionLog;
	}


	/**
	 * @return the montantTransactionLog
	 */
	public double getMontantTransactionLog() {
		return montantTransactionLog;
	}


	/**
	 * @param montantTransactionLog the montantTransactionLog to set
	 */
	public void setMontantTransactionLog(double montantTransactionLog) {
		this.montantTransactionLog = montantTransactionLog;
	}


	/**
	 * @return the typeOperationLog
	 */
	public String getTypeOperationLog() {
		return typeOperationLog;
	}


	/**
	 * @param typeOperationLog the typeOperationLog to set
	 */
	public void setTypeOperationLog(String typeOperationLog) {
		this.typeOperationLog = typeOperationLog;
	}


	/**
	 * @return the numeroComptDebiteurLog
	 */
	public long getNumeroComptDebiteurLog() {
		return numeroComptDebiteurLog;
	}


	/**
	 * @param numeroComptDebiteurLog the numeroComptDebiteurLog to set
	 */
	public void setNumeroComptDebiteurLog(long numeroComptDebiteurLog) {
		this.numeroComptDebiteurLog = numeroComptDebiteurLog;
	}


	/**
	 * @return the numeroCompteCrediteurLog
	 */
	public long getNumeroCompteCrediteurLog() {
		return numeroCompteCrediteurLog;
	}


	/**
	 * @param numeroCompteCrediteurLog the numeroCompteCrediteurLog to set
	 */
	public void setNumeroCompteCrediteurLog(long numeroCompteCrediteurLog) {
		this.numeroCompteCrediteurLog = numeroCompteCrediteurLog;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LogTransactions :\nnumeroLog=" + numeroLog + ", \ndateLog=" + dateLog + ", \nnumeroTransactionLog="
				+ numeroTransactionLog + ", \ndateTransactionLog=" + dateTransactionLog + ", \nmontantTransactionLog="
				+ montantTransactionLog + ", \ntypeOperationLog=" + typeOperationLog + ", \nnumeroComptDebiteurLog="
				+ numeroComptDebiteurLog + ", \nnumeroCompteCrediteurLog=" + numeroCompteCrediteurLog + ".";
	}
	
	
	

}
