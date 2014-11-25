/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.entwa2.pers;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.entwa2.ent.Address;
import jim.entwa2.ent.Address;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address> {
    @PersistenceContext(unitName = "entwa2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(Address.class);
    }

    static final String[] initNames = {"Brighton", "Southampton", "Plymouth"};

    public List<Address> createInitialData() {
        List<Address> l = new ArrayList<>();
        for (String s : initNames) {
            Address addr = new Address();
            addr.setCity(s);
            this.create(addr);
            l.add(addr);
        }
        return l;
    }
}
