/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APIRestTest;

import com.mycompany.apirestproyectofinalmodulo3.ApiRestWallet;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persistence.SQLiteConnectionWallet;


/**
 *
 * @author Carlos Miranda Rocha
 */
public class JUnitTestTDD {
    
    public JUnitTestTDD() {
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
    
    @Test
    public void testCashIn() throws ClassNotFoundException, SQLException{
        
    }
    @Test
    public void testCashOut() throws SQLException, ClassNotFoundException{
        SQLiteConnectionWallet objConnection = new SQLiteConnectionWallet();
        String data = objConnection.cashOut(5.50);
        assertTrue(true);
    }
    @Test
    public void testGetBalance() throws SQLException, ClassNotFoundException{
        SQLiteConnectionWallet objConnection = new SQLiteConnectionWallet();
        assertNotNull(objConnection.getBalance());
    }
    
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
