/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Carlos Miranda Rocha
 */
public class SQLiteConnectionWallet {
    public static Connection con;
    private static boolean hasData = false;
    public boolean getConnection() throws ClassNotFoundException, SQLException {
		 try{
                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:SQLiteWallet.db");
                    initialise();
                    return true;
                  }catch(ClassNotFoundException | SQLException e){
                      return false;
                  }
    }
    public boolean initialise() throws SQLException {
                 boolean respuesta = false;
		 if( !hasData ) {
			 hasData = true;
			 Statement state = con.createStatement();
			 ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='wallet'");
			 if(!res.next()) {
				 System.out.println("CONSTRUYENDO BASE DE DATOS.");
                                 res.close();
                                 state.close();
				  Statement state2 = con.createStatement();
				  state2.executeUpdate("create table wallet(saldo DOUBLE);");
				  PreparedStatement prep = con.prepareStatement("insert into wallet values(0);");
				  prep.execute();
                                  state2.close();
                                  prep.close();
                            respuesta = true;
			 }else{
                                res.close();
                                state.close();
                         }
		 }
                 return respuesta;
    }
  
    public String getBalance() throws SQLException, ClassNotFoundException {
                 if(con == null) {
			 this.getConnection();
		 }
		 Statement state = con.createStatement();
		 ResultSet res = state.executeQuery("select * from wallet");
                 String stres = res.getString("saldo");
                 state.close();
                 res.close();
                 con.close();
                 con = null;
                 return stres;
    }
    public String cashOut(double monto) throws SQLException, ClassNotFoundException{
                 if(con == null) {
			 this.getConnection();
		 }
		 
                 String sql = "UPDATE wallet SET saldo = saldo - " + monto;
                 PreparedStatement state = con.prepareStatement(sql);
		 state.execute();
                 state.close();
                 con.close();
                 con = null;
                 return this.getBalance();
    }
    public String cashIn(double monto) throws SQLException, ClassNotFoundException{
                 if(con == null) {
			 this.getConnection();
		 }
                 String sql = "UPDATE wallet SET saldo = saldo + " + monto;
		 PreparedStatement state = con.prepareStatement(sql);
		 state.execute();
                 state.close();
                 con.close();
                 con = null;
                 return this.getBalance();
    }
}
