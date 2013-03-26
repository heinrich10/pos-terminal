/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.domain;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author Heinrich
 */
public class SessionFactory {
    
    private static SqlSessionFactory sqlSessionFactory;
    
    static{
        try {
            String resource = "db/config/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(SessionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static SqlSessionFactory getSqlSession(){
        return sqlSessionFactory;
    }
}
