/**
 * 
 */
package sn.objis.proxibanque.dao;

import java.util.List;

import sn.objis.proxibanque.metier.CompteCourant;
import sn.objis.proxibanque.metier.Personnel;

/**
 * Interface IDaoCompteCourant 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public interface IDaoCompteCourant extends IDaoGenerique<CompteCourant> {

	public List<CompteCourant> lire(Personnel personnel);
}
