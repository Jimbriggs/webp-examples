/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jim.sixthS.pers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jim.sixthS.ent.LoginUser;

/**
 *
 * @author BriggsJ
 */
@Stateless
public class LoginUserFacade extends AbstractFacade<LoginUser> {
    @PersistenceContext(unitName = "fifthPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginUserFacade() {
        super(LoginUser.class);
    }

}
