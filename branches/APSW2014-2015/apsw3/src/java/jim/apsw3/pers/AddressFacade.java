/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jim.apsw3.pers;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.apsw3.ents.Address;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address> {

    @PersistenceContext(unitName = "apsw3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(Address.class);
    }

    static String[] initialAddresses = {"Portsmouth", "London", "Southampton"};

    public List<Address> initAddresses() {
        List<Address> lst = new ArrayList<>();
        for (String s : initialAddresses) {
            Address a = new Address();
            a.setCity(s);
            this.create(a);
            lst.add(a);
        }
        return lst;
    }
}
