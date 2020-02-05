/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.models;

/**
 *
 * @author asyst
 */
public class Lock {
    
    private int id;
    private boolean isLock;
    private String tr_number;

    public Lock(int id, boolean isLock, String tr_number) {
        this.id = id;
        this.isLock = isLock;
        this.tr_number = tr_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsLock() {
        return isLock;
    }

    public void setIsLock(boolean isLock) {
        this.isLock = isLock;
    }

    public String getTr_number() {
        return tr_number;
    }

    public void setTr_number(String tr_number) {
        this.tr_number = tr_number;
    }
    
}
