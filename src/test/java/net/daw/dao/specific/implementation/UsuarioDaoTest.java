/*
 * Copyright (c) 2015 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * openAUSIAS: The stunning micro-library that helps you to develop easily 
 * AJAX web applications by using Java and jQuery
 * openAUSIAS is distributed under the MIT License (MIT)
 * Sources at https://github.com/rafaelaznar/openAUSIAS
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 */
package net.daw.dao.specific.implementation;

import java.sql.Connection;
import net.daw.bean.specific.implementation.UsuarioBean;
import net.daw.connection.implementation.BoneConnectionPoolImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a044533450e
 */
public class UsuarioDaoTest {

    public UsuarioDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFromLogin method, of class UsuarioDao.
     */
    @Test
    public void testGetFromLogin() throws Exception {
        System.out.println("getFromLogin");
        UsuarioBean oBean1 = null;
        UsuarioDao oUsuarioDao = null;

        Connection oConnection = new BoneConnectionPoolImpl().newConnection();

        oBean1 = new UsuarioBean();
        oUsuarioDao = new UsuarioDao(oConnection);

        //rellenar el bean1
        //guardar el bean1 usando dao
        //crear un bean2 vacio
        //establecer en el bean2 el id que sale del id del bean1
        //rellenar el bean2 con el dao get
        //comparar  el bean 1 con el bean 2
        //Rellenamos manualmente el primer bean
        oBean1.setId(2);
        oBean1.setCiudad("Madrid");
        oBean1.setLogin("juan");
        oBean1.setId_tipousuario(3);
        oBean1.setId_estado(3);
        oBean1.setPassword("juan");
        oBean1.setFirma("http://criticalandia.com críticas de entretenimiento, listas, opiniones...");
        oBean1.setSkin("main");

        //Creamos el segundo bean
        UsuarioBean oBean2 = null;
        oBean2 = new UsuarioBean();

        oBean2.setLogin(oBean1.getLogin());
        oBean2.setPassword(oBean1.getPassword());
        oBean2 = oUsuarioDao.getFromLogin(oBean2);
        
//        System.out.println(oBean2.getId());

        //Comparamos los atributos de los dos objetos bean
        assertEquals(oBean1.getLogin(), oBean2.getLogin());
        assertEquals(oBean1.getId(), oBean2.getId());
        assertEquals(oBean1.getCiudad(), oBean2.getCiudad());
        assertEquals(oBean1.getPassword(), oBean2.getPassword());
        assertEquals(oBean1.getSkin(), oBean2.getSkin());
        assertEquals(oBean1.getId_tipousuario(), oBean2.getId_tipousuario());

    }

}
