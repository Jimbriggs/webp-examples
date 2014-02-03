/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.sixthS.pers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.sixthS.ent.LoginRole;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class LoginRoleFacade extends AbstractFacade<LoginRole> {
    @PersistenceContext(unitName = "fifthPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginRoleFacade() {
        super(LoginRole.class);
    }

}
