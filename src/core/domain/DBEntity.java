/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.domain;

/**
 *
 * @author Heinrich
 */
public class DBEntity {
    private final String url = "jdbc:mysql://192.168.159.10:3306/MO";
    private final String user = "ricknb";
    private final String password = "asdf1234";
    
    //private final String url = "jdbc:mysql://localhost:3306/MO";
    //private final String user = "root";
    //private final String password = "123456";
    
    public String getUrl(){
        return url;
    }
    
    public String getUser(){
        return user;
    }
    
    public String getPassword(){
        return password;
    }
}
