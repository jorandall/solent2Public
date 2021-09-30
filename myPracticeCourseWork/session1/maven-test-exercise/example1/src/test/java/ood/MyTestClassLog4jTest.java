/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ood;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jofai
 */
public class MyTestClassLog4jTest {

    @Test
    public void writeAboutMe() {
        MyTestClassLog4j myTestClassLog4j = new MyTestClassLog4j();
        String response = myTestClassLog4j.writeAboutMe();
        assertNotNull(response);
        
    }

}
