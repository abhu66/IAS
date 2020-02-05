/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.dao;

import ias.models.Outgoing;
import java.util.List;

/**
 *
 * @author asyst
 */
public interface OutgoingDao {
    public void addNewOutgoing(Outgoing outgoing);
    public void updateOutgoing(Outgoing outgoing);
    public Outgoing findByTrNUmber(String tr_number);
    public List<Outgoing> listAllOutgoing(String param);
    public void deleteOutgoing(String tr_number);
    
}
