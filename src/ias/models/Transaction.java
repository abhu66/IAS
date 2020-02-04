/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.models;

import java.util.Date;

/**
 *
 * @author asyst
 */
public class Transaction {
    
    private int id;
    private String tr_number;
    private String person_id;
    private String asset_id;
    private Date starDate;
    private Date endDate;
    private String status;
    private String type;

    public Transaction(int id, String tr_number, String person_id, String asset_id, Date starDate, Date endDate, String status, String type) {
        this.id = id;
        this.tr_number = tr_number;
        this.person_id = person_id;
        this.asset_id = asset_id;
        this.starDate = starDate;
        this.endDate = endDate;
        this.status = status;
        this.type = type;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTr_number() {
        return tr_number;
    }

    public void setTr_number(String tr_number) {
        this.tr_number = tr_number;
    }
    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(String asset_id) {
        this.asset_id = asset_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
