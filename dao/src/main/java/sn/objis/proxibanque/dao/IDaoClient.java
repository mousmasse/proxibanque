/**
 * 
 */
package sn.objis.proxibanque.dao;

import java.util.List;

import sn.objis.proxibanque.metier.Client;
import sn.objis.proxibanque.metier.Personnel;

/**
 * Interface IDaoClient 
 * @author Moustapha M. NDIAYE
 * @version 0.0.1-SNAPSHOT
 * @since 02/01/2019 
 */
public interface IDaoClient extends IDaoGenerique<Client> {

	public List<Client> lire();
	public List<Client> lire(Personnel personnel);
	 
	
}
