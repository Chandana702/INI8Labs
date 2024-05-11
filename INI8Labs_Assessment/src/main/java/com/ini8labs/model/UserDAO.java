package com.ini8labs.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {
	public static String registerUser(String name,String email,long phone,String date,String gender) {
		Connection con = null;
		PreparedStatement ps;
        String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            con = Connector.requestConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from users where email='" + email + "' or phone='" + phone + "';");
            boolean b = rs.next();
            if (b) {
                status = "existed";
            } else {
                ps = (PreparedStatement) con.prepareStatement("insert into users values(0,?,?,?,?,?)");
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setLong(3, phone);
                ps.setString(4, date);
                ps.setString(5, gender);
                int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
	}
	
	public static User getUserinfo(int id) {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        String qry = "select * from users where id=?";
        try {
        	con = Connector.requestConnection();
            ps = con.prepareStatement(qry);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPhone(rs.getLong(4));
                u.setDate(rs.getString(5));
                u.setGender(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
	
	public static boolean editUser(int id,String name,String email,long phone,String date,String gender) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update users set name=?,email=?,phone=?,dob=?,gender=? where id=?";
		int res = 0;
		boolean b = false;;
		try {
			con = Connector.requestConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setLong(3, phone);
			ps.setString(4, date);
			ps.setString(5, gender);
			ps.setInt(6, id);
			res = ps.executeUpdate();
			if(res > 0) {
				b = true;
			}
			else {
				b = false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public static boolean deleteUser(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from users where id=?";
		int res = 0;
		boolean b = false;
		try {
			con = Connector.requestConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			res = ps.executeUpdate();
			if(res > 0) {
				b = true;
			}
			else {
				b = false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public static ArrayList<User> getUserinfo() {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> al = new ArrayList<>();
        String qry = "select * from users";
        try {
        	con = Connector.requestConnection();
            ps = con.prepareStatement(qry);
            rs = ps.executeQuery(qry);
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPhone(rs.getLong(4));
                u.setDate(rs.getString(5));
                u.setGender(rs.getString(6));
                al.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return al;
    }
}
