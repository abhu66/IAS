/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.dao;

import ias.models.Transaction;
import ias.view.FormOutgoing;
import java.util.List;

/**
 *
 * @author asyst
 */
public interface TransactionDao {
    
    public void addNew(Transaction transaction,FormOutgoing formOutgoing);
    public List<Transaction> listTransaction(String param);
    public void deleteTransaction(String tr_number);
    public void removeItem(String code);
    
}
