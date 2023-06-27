package dao;

import utils.MySQLUtils336;

import java.sql.*;

public class StudentsDao336 {
    /**
     * 查询所有学生数据
     */
    public static ResultSet findAll(){
        String sql = "select * from students";
        Connection connection = MySQLUtils336.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    /**
     * 通过学号查询
     */
    public static ResultSet findByNumber(String number){
        String sql = "select * from students where number = ?";
        Connection connection = MySQLUtils336.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            preparedStatement.setString(1,number);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    /**
     * 查询首条数据
     */
    public static ResultSet findFirst(){
        String sql = "SELECT * FROM students LIMIT 0,1";
        Connection connection = MySQLUtils336.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    /**
     * 查询最后一条数据
     */
    public static ResultSet findfinal(){
        String sql = "select * from students where id=(select max(id) from students)";
        Connection connection = MySQLUtils336.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    /**
     * 查询上一条数据
     */
    public static ResultSet findLast(int id){
        String sql = "select * from students where id = " +
                "(select max(id) from students where id < " + id + ")" ;
        Connection connection = MySQLUtils336.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    /**
     * 查询下一条数据
     */
    public static ResultSet findNext(int id){
        String sql = "select * from students where id = " +
                "(select min(id) from students where id > " + id + ")" ;
        Connection connection = MySQLUtils336.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    /**
     * 添加学生 insert into students(number,NAME,sex,profession,grade) value('14010008','aa','男','web','2016')
     */
    public static int add(String number,String name,String sex,String profession,String grade){
        try {
            ResultSet byNumber = StudentsDao336.findByNumber(number);
            if(byNumber.next()){
                return 3;
            }else {
                Connection connection = MySQLUtils336.getConnection();
                String sql = "insert into students(number,name,sex,profession,grade) values(?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,number);
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,sex);
                preparedStatement.setString(4,profession);
                preparedStatement.setString(5,grade);
                int i = preparedStatement.executeUpdate();
                return i;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除学生
     */
    public static int del(Integer id){
        try {
            Connection connection = MySQLUtils336.getConnection();
            String sql = "DELETE  FROM students where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 修改学生信息 update students set number = ?,name=?,sex=?,profession=?,grade=? where id =?
     */
    public static int upd(String number,String name,String sex,String profession,String grade,Integer id){
        try {
            Connection connection = MySQLUtils336.getConnection();
            String sql = "update students set number = ?,name = ?,sex = ?,profession = ?,grade = ? where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,number);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,sex);
            preparedStatement.setString(4,profession);
            preparedStatement.setString(5,grade);
            preparedStatement.setInt(6,id);
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据总条数 SELECT COUNT(*) FROM students
     */
    public static ResultSet findCount(){
        String sql = "SELECT COUNT(*) FROM students";
        Connection connection = MySQLUtils336.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}
