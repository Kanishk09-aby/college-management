package dao;

import model.Student;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public Student add(Student s) throws SQLException {
        String sql = "INSERT INTO students (roll_no, name, age, email) VALUES (?, ?, ?, ?)";

        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, s.getRollNo());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getEmail());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) s.setId(rs.getInt(1));
            }
        }

        return s;
    }

    public List<Student> listAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id, roll_no, name, age, email FROM students ORDER BY id";

        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("roll_no"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                ));
            }
        }
        return list;
    }

    public boolean deleteById(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public Student findByRoll(String rollNo) throws SQLException {
        String sql = "SELECT id, roll_no, name, age, email FROM students WHERE roll_no = ?";

        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, rollNo);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("roll_no"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("email")
                    );
                }
            }
        }
        return null;
    }
}
