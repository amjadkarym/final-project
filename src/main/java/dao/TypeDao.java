package dao;

import connection.DBConnection;
import model.TypeModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeDao {

    Connection conn = null;
    Statement stmt = null;


    public List<TypeModel> geTypes() {
        ResultSet rs = null;
        List<TypeModel> types = new ArrayList<TypeModel>();
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from types";

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                types.add(new TypeModel(rs.getInt("id"),
                        rs.getString("name"), rs.getString("description")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }// end finally try
        }

        return types;
    }


}