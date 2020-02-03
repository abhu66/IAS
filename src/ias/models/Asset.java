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
public class Asset {
   public int id;
   public String code;
   public String name;
   public String description;
   public String condition;
   public String createdDate;

    public Asset(String code, String name, String description, String condition, String createdDate) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.condition = condition;
        this.createdDate = createdDate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

   
}
