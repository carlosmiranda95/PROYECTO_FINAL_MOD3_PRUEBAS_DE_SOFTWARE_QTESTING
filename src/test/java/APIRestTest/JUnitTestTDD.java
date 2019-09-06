/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APIRestTest;

import com.mycompany.apirestproyectofinalmodulo3.ApiRestWallet;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.sql.DriverManager;
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
    public void testGetConnectionDB() throws ClassNotFoundException, SQLException{
        SQLiteConnectionWallet objConnection = new SQLiteConnectionWallet();
        assertTrue(objConnection.getConnection());
    }
    
    @Test
    public void testExistingSqliteDB() throws ClassNotFoundException, SQLException{
        SQLiteConnectionWallet objConnection = new SQLiteConnectionWallet();
        Class.forName("org.sqlite.JDBC");
        SQLiteConnectionWallet.con = DriverManager.getConnection("jdbc:sqlite:SQLiteWallet.db");
        assertFalse(objConnection.initialise());
        SQLiteConnectionWallet.con.close();
    }
    
    @Test
    public void testGetBalance() throws SQLException, ClassNotFoundException{
        SQLiteConnectionWallet objConnection = new SQLiteConnectionWallet();
        assertNotNull(objConnection.getBalance());
    }
    @Test
    public void testCashIn() throws ClassNotFoundException, SQLException{
        SQLiteConnectionWallet objConnection = new SQLiteConnectionWallet();
        assertNotNull(objConnection.cashIn(100));
    }
    @Test
    public void testCashOut() throws ClassNotFoundException, SQLException{
        SQLiteConnectionWallet objConnection = new SQLiteConnectionWallet();
        assertNotNull(objConnection.cashOut(50));
    }
    
    
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
