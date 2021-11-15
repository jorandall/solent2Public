package org.solent.com504.factoryandfacade.test;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.impl.AnimalObjectFactory;
import org.solent.com504.factoryandfacade.model.FarmFacade;

/**
 *
 * @author cgallen
 */
public class FarmFacadeTest {
   

    @Test
    public void FarmFacadeTest() {

        FarmFacade farmFacade = AnimalObjectFactory.getFarmFacade();
        assertNotNull(farmFacade);
        
        List<Animal> animals = farmFacade.getAllAnimals();
        assertTrue(animals.isEmpty());
        
        // test create cat
        String catName = "fluffy";
        farmFacade.addCat(catName);
        
        animals = farmFacade.getAllAnimals();
        assertEquals(1, animals.size());
        
        assertEquals(catName, animals.get(0).getName());
  
        // test create dog
        String dogName = "rex";
        farmFacade.addDog(dogName);
        
        animals = farmFacade.getAllAnimals();
        assertEquals(2, animals.size());
        
        assertEquals(dogName, animals.get(1).getName());
        
        // test create dog
        String cowName = "bessy";
        farmFacade.addCow(cowName);
        
        animals = farmFacade.getAllAnimals();
        assertEquals(3, animals.size());
        
        assertEquals(cowName, animals.get(2).getName());

    }
}
