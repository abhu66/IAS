/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.dao;

import ias.models.Lock;

/**
 *
 * @author asyst
 */
public interface LockDao {
    public void addNew(Lock lock);
    public void updateLock(Lock lock);
    public void deleteLock(String tr_number);
    public Lock findByTrNumber(String tr_number);
}
