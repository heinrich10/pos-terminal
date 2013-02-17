/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.domain;

/**
 *
 * @author Heinrich
 */
public class DBEntity {
    private String url = "jdbc:mysql://192.168.159.10:3306/MO";
    private String user = "ricknb";
    private String password = "asdf1234";
    
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
