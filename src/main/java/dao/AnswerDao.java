package dao;

import connection.DBConnection;
import model.AnswerModel;
import model.QuestionModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnswerDao {

    Connection conn = null;
    Statement stmt = null;

    public AnswerModel getAnswerById(int id) {
        AnswerModel answer = null;
        return answer;
    }

    public List<AnswerModel> getAnswersByQuesId(int id) {
        ResultSet rs = null;
        List<AnswerModel> answers = new ArrayList<AnswerModel>();
        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            String sql = "select a.id as id, a.title as title, qa.answer_id as answer_id, qa.status as status from answers a, ques_ans qa  where qa.question_id = " + id + " and a.id = qa.answer_id";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                answers.add(new AnswerModel(rs.getInt("id"),
                        rs.getString("title"), rs.getString("answer_id"), rs.getInt("status")));
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
        return answers;
    }
}
