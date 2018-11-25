package dao;

import connection.DBConnection;
import model.QuestionModel;
import model.UserModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {

    Connection conn = null;
    Statement stmt = null;

    public QuestionModel getQuestionById(String id) {
        ResultSet rs = null;
        QuestionModel question = null;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            String sql = "";
            sql = "select * from questions where id = " + id;

            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                question = new QuestionModel(rs.getInt("id"), rs.getString("title"), rs.getInt("type_id"), rs.getString("level"));
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
        return question;
    }

    public List<QuestionModel> getQuestionsByTypeId(String typeId, String quesCSV, String level) {
        ResultSet rs = null;
        List<QuestionModel> questions = new ArrayList<QuestionModel>();
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            String sql = "";
            if("".equals(quesCSV)) {
                sql = "select * from questions where type_id = " + typeId + " and level = '" + level + "'";
            } else {
                sql = "select * from questions where type_id = " + typeId + " and id not in ( " + quesCSV +") and level = '" + level + "'";
            }

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                questions.add(new QuestionModel(rs.getInt("id"), rs.getString("title"), rs.getInt("type_id"), rs.getString("level")));
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
        return questions;
    }
}