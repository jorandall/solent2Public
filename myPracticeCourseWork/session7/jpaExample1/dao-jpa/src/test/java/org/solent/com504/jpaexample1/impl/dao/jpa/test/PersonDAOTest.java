/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.jpaexample1.impl.dao.jpa.test;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.jpaexample1.impl.dao.jpa.DAOFactoryJPAImpl;
import org.solent.com504.jpaexample1.model.dao.PersonDAO;
import org.solent.com504.jpaexample1.model.dto.Person;
import org.solent.com504.jpaexample1.model.dto.Role;

/**
 *
 * @author cgallen
 */
public class PersonDAOTest {

    final static Logger LOG = LogManager.getLogger(PersonDAOTest.class);

    private PersonDAO personDao = null;

    private DAOFactoryJPAImpl daoFactory = new DAOFactoryJPAImpl();

    @Before
    public void before() {
        personDao = daoFactory.getPersonDAO();
        assertNotNull(personDao);
    }

    // initialises database for each test
    private void init() {
        // delete all in database
        personDao.deleteAll();
        // add 5 patients
        for (int i = 1; i < 4; i++) {
            Person p = new Person();
            p.setAddress("address_" + i);
            p.setFirstName("firstName_" + i);
            p.setSecondName("secondName_" + i);
            p.setRole(Role.PATIENT);
            personDao.save(p);
        }
        for (int i = 1; i < 3; i++) {
            Person p = new Person();
            p.setAddress("address_" + i);
            p.setFirstName("firstName_" + i);
            p.setSecondName("secondName_" + i);
            p.setRole(Role.DENTIST);
            personDao.save(p);
        }
    }

    @Test
    public void createPersonDAOTest() {
        LOG.debug("start of createPersonDAOTest");
        // this test simply runs the before method
        LOG.debug("end of createPersonDAOTest");
    }

    @Test
    public void findByIdTest() {
        LOG.debug("start of findByIdTest()");
        assertNotNull(personDao);
        init();
        
        List<Person> people = personDao.findAll();
        assertFalse(people.isEmpty());
        
        Person p = people.get(0);
        LOG.debug("finding " + p);
        Long id = p.getId();
        
        Person p2 = personDao.findById(id);
        assertNotNull(p2);
        LOG.debug("end of findByIdTest()");
    }

    @Test
    public void saveTest() {
        LOG.debug("start of saveTest()");
        //TODO implement test
        LOG.debug("NOT IMPLEMENTED");
        LOG.debug("end of saveTest()");
    }

    @Test
    public void findAllTest() {
        LOG.debug("start of findAllTest()");

        init();
        List<Person> personList = personDao.findAll();
        assertNotNull(personList);
        
        // init should insert 5 people
        assertEquals(5, personList.size());

        // print out result
        String msg = "";
        for (Person person : personList) {
            msg = msg +"\n   " +  person.toString();
        }
        LOG.debug("findAllTest() retrieved:" + msg);

        List<Person> personFoundList = personDao.findAll();
        LOG.debug("people found =" + personFoundList.size());
        
        assertEquals(5, personFoundList.size());
        
        LOG.debug("end of findAllTest()");
    }

    @Test
    public void deleteByIdTest() {
        LOG.debug("start of deleteByIdTest()");
        assertNotNull(personDao);
        init();
        
        List<Person> personList = personDao.findAll();
        assertFalse(personList.isEmpty());
        
        Person p = personList.get(0);
        LOG.debug("deleting " + p);
        Long id = p.getId();
        
        personDao.deleteById(id);
        
        Person p2 = personDao.findById(id);
        assertNull(p2);
        
        LOG.debug("end of deleteByIdTest()");
    }

    @Test
    public void deleteTest() {
        LOG.debug("start of deleteTest()");
        
        assertNotNull(personDao);
        init();
        
        // Find all people
        List<Person> personList = personDao.findAll();
        assertFalse(personList.isEmpty());
        
        // get specific person
        Person p = personList.get(0);
        LOG.debug("person found p =" + p);
        
        //now find by id
        // now find by id
        Long id = p.getId();
        Person p2 = personDao.findById(id);
        LOG.debug("person found p2 = " + p2);
        assertNotNull(p2);
        
        LOG.debug("deleting " + p);
        personDao.delete(p);
        
        Person p3 = personDao.findById(id);
        LOG.debug("person found p3 =" + p3); // should be null
        
        assertNull(p3);
                
        LOG.debug("end of deleteTest()");
    }

    @Test
    public void deleteAllTest() {
        LOG.debug("start of deleteAllTest())");
        
        init();
        List<Person> personList = personDao.findAll();
        assertNotNull(personList);
        
        // init should insert 5 people
        assertEquals(5, personList.size());
        
        // delete all
        personDao.deleteAll();
        
        // refresh the list
        List<Person> people = personDao.findAll();
        assertTrue(people.isEmpty());
        
        LOG.debug("end of deleteAllTest()");
    }

    @Test
    public void findByRoleTest() {
        LOG.debug("start of findByIdTest()");
        
        init();
        List<Person> personList = personDao.findAll();
        assertNotNull(personList);
        
        List<Person> personList2 = personDao.findByRole(Role.PATIENT);
        assertEquals(3, personList2.size());
        
        List<Person> personList3 = personDao.findByRole(Role.DENTIST);
        assertEquals(2, personList3.size());
        
        LOG.debug("end of findByIdTest()");
    }

    @Test
    public void findByNameTest() {
        LOG.debug("start of findByNameTest()");
        //TODO implement test
        LOG.debug("NOT IMPLEMENTED");
        LOG.debug("end of findByNameTest())");

    }
}
