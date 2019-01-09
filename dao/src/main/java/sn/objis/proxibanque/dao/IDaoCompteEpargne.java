/**
 * 
 */
package sn.objis.proxibanque.dao;

import java.util.List;

import sn.objis.proxibanque.metier.CompteEpargne;
import sn.objis.proxibanque.metier.Personnel;

/**
 * Interface IDaoCompteEpargne 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public interface IDaoCompteEpargne extends IDaoGenerique<CompteEpargne> {

	public List<CompteEpargne> lire(Personnel personnel);
}
