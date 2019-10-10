package com.zq.dao;

import com.zq.JDBCUtil;
import com.zq.bean.Emp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainDao {
    private static MainDao instance = new MainDao();
    public static String errMsg;

    public static MainDao getInstance() {
        return instance;
    }

    public boolean createTable() {
        try {
            PreparedStatement preparedStatement = JDBCUtil.connection
                    .prepareStatement("CREATE TABLE EMP(eid INT PRIMARY KEY ,`NAME` VARCHAR (20),JOB VARCHAR(20),Dno INT )");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
            return false;
        }
        return true;
    }

    public boolean deleteTable() {
        try {
            PreparedStatement preparedStatement = JDBCUtil.connection
                    .prepareStatement("DROP TABLE EMP");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
            return false;
        }
        return true;
    }

    public boolean insertPre(String eid, String name, String job, String dno) {
        try {
            PreparedStatement preparedStatement = JDBCUtil.connection
                    .prepareStatement("INSERT INTO EMP VALUES(?,?,?,?)");
            preparedStatement.clearParameters();
            preparedStatement.setString(1, eid);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, job);
            preparedStatement.setString(4, dno);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
            return false;
        }
        return true;
    }

    public boolean insert(String eid, String name, String job, String dno) {
        try {
            String sql = "INSERT INTO EMP VALUES(" + eid + ",\"" + name + "\",\"" + job + "\",\"" + dno + "\")";
            System.out.println(sql);
            JDBCUtil.connection.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
            return false;
        }
        return true;
    }

    public List<Emp> selectND() {
        List<Emp> list = new ArrayList<>();
        try {
            String sql = "SELECT `NAME`,DNO FROM EMP";
            ResultSet r = JDBCUtil.connection.createStatement().executeQuery(sql);

            while (r.next()) {
                list.add(new Emp().setName(r.getString(1)).setDno(r.getString(2)));
            }
            System.out.println(list.toString());

        } catch (SQLException e) {
            System.out.println("gg");
            e.printStackTrace();
            errMsg = e.getMessage();
            return new ArrayList<Emp>();
        }
        return list;
    }

    public List<Emp> selectAll() {
        List<Emp> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM EMP";
            ResultSet r = JDBCUtil.connection.createStatement().executeQuery(sql);

            while (r.next()) {
                System.out.println(r.toString());
                list.add(new Emp(r.getString(1), r.getString(2), r.getString(3), r.getString(4)));
            }
            System.out.println(list.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
            return new ArrayList<Emp>();
        }
        return list;
    }

    public List<Emp> selectSearch(String job, String dno) {
        List<Emp> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = JDBCUtil.connection
                    .prepareStatement("SELECT * FROM EMP WHERE JOB = ? AND DNO = ?");
            preparedStatement.clearParameters();
            preparedStatement.setString(1, job);
            preparedStatement.setString(2, dno);

            ResultSet r = preparedStatement.executeQuery();

            while (r.next()) {
                System.out.println(r.toString());
                list.add(new Emp(r.getString(1), r.getString(2), r.getString(3), r.getString(4)));
            }
            System.out.println(list.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
            return new ArrayList<Emp>();
        }
        return list;
    }
}
