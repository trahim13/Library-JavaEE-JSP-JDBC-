package org.trahim.web.beans;

import org.trahim.web.db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by root on 19.08.2017.
 */
public class AuthorList {

    private ArrayList<Author> authorList = new ArrayList<>();

    private ArrayList<Author> getAuthors() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
//            rs = stmt.executeQuery("select * from library1.author order by fio");
            rs = stmt.executeQuery("select * from author order by fio");
            while (rs.next()) {
                Author author = new Author();
                author.setName(rs.getString("fio"));
                authorList.add(author);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt!=null) stmt.close();
                if (rs!=null)rs.close();
                if (conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return authorList;
    }



    public ArrayList<Author> getAuthorList() {
        if (!authorList.isEmpty()) {
            return authorList;
        } else {
            return getAuthors();
        }
    }
}
