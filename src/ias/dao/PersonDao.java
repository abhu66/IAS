/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.dao;

import ias.models.Person;
import ias.view.FormNewPic;
import java.util.List;

/**
 *
 * @author asyst
 */
public interface PersonDao {
    public void addNewPic(Person person,FormNewPic formNewPic);
    public List<Person> getAllPerson(String param);
    public Person findByNip(String nip);
    public void saveOnEdit(Person person);
}
