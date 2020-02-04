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
public class Outgoing {
    
    private int id;
    private String tr_number;
    private String id_pic;
    private int total_asset;
    private String type;
    private Date startDate;
    private Date endDate;
    private String status;

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

    public String getId_pic() {
        return id_pic;
    }

    public void setId_pic(String id_pic) {
        this.id_pic = id_pic;
    }

    public int getTotal_asset() {
        return total_asset;
    }

    public void setTotal_asset(int total_asset) {
        this.total_asset = total_asset;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
    
    
    
    
}
