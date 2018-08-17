/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface AccountFacadeLocal {

    void create(Account account);

    void edit(Account account);

    void remove(Account account);
    
    String Payment(int id, double total);
    
    Account checkAccount(int id);

    Account find(Object id);

    List<Account> findAll();

    List<Account> findRange(int[] range);

    int count();

}
