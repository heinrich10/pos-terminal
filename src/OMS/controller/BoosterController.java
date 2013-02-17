/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OMS.controller;

import OMS.controller.MenuController;
import Core.domain.DBEntity;
import OMS.domain.Booster;
import OMS.domain.MenuItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heinrich
 */
public class BoosterController {

    private ArrayList<Booster> arrBooster;

    public ArrayList<Booster> loadBooster() {


        try {
            DBEntity db = new DBEntity();

            Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());

            PreparedStatement pst = con.prepareStatement(
                    "SELECT  code, description, quantity, price FROM OMS_RM_BOOSTER");

            ResultSet rs = pst.executeQuery();

            arrBooster = new ArrayList();

            while (rs.next()) {

                arrBooster.add(new Booster(rs.getString("code"), rs.getString("description"), rs.getInt("quantity"), rs.getInt("price")));
            }

            System.out.println(arrBooster.size());
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);

        }
        return arrBooster;
    }
}
