/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.math.BigInteger;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lenovo
 */
@Local
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {

    @PersistenceContext(unitName = "EJBBank-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }

    @Override
    public Account checkAccount(int id) {
        Query query = em.createNamedQuery("Account.findByAccountid");
        query.setParameter("accountid",id);
        
        try{
            return (Account)query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public String Payment(int id, double total) {
        
        if(checkAccount(id)!= null){
            
            Account acc = checkAccount(id);
            
            int pay = (int) (acc.getBalance().intValue() - total);
            
            acc.setBalance(BigInteger.valueOf(pay));
            
            return "Customer: "+acc.getAccountname()+" pay successful: your balance now is: "+ acc.getBalance().toString();
        }
        
        return "Payment fail";
    }
    
    
}
