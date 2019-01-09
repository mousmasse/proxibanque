/**
 * 
 */
package sn.objis.proxibanque.dao;

import java.util.List;

import sn.objis.proxibanque.metier.Client;
import sn.objis.proxibanque.metier.CompteCourant;
import sn.objis.proxibanque.metier.CompteEpargne;
import sn.objis.proxibanque.metier.Personnel;
import sn.objis.proxibanque.metier.Transactioncmpt;

/**
 * Interface IDaoTransactioncmpt 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public interface IDaoTransactioncmpt extends IDaoGenerique<Transactioncmpt> {

	public List<Transactioncmpt> lire(CompteEpargne compteEpargne);
	public List<Transactioncmpt> lire(CompteCourant compteCourant);
	public List<Transactioncmpt> listetransactioncmptep(Personnel personnel);
	public List<Transactioncmpt> listetransactioncmptcr(Personnel personnel);
	public List<Transactioncmpt> listetransactioncmptep(Client client);
	public List<Transactioncmpt> listetransactioncmptcr(Client client);
	public Transactioncmpt dernierenregistrement();
}
