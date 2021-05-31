package dao;

import connection.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Account;

public class AccountDAO {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	private void closeConnection() throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();

		}
		if (conn != null) {
			conn.close();
		}
	}

	public boolean checkLogin(Account acc) throws Exception {
		String sql = "Select * from Account where Name = ? COLLATE SQL_Latin1_General_CP1_CS_AS and"
				+ " Password = ? COLLATE SQL_Latin1_General_CP1_CS_AS";
		boolean check = false;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, acc.getName());
			ps.setString(2, acc.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
			}
		} finally {
			closeConnection();
		}
		return check;
	}

	public List<Account> getAll() throws Exception {
		String sql = "Select * from Account";
		List<Account> list = new ArrayList<>();
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account acc = new Account(rs.getString("idAccount"), rs.getString("Name"), rs.getString("PhoneNo"));
				list.add(acc);
			}
		} finally {
			closeConnection();
		}
		return list;
	}

	public boolean register(Account acc) throws Exception {
		String sql = "INSERT INTO [dbo].[Account] ([idAccount],[Name],[Password]) VALUES " + "(?,?,?)";
		boolean check = false;
		int nextid=getLastid()+1;
		String id= Integer.toString(nextid);
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, acc.getName());
			ps.setString(3, acc.getPassword());
			check = ps.executeUpdate() > 0;
		} finally {
			closeConnection();
		}
		return check;
	}

	public int getLastid() throws Exception{
    	String sql="Select MAX(idAccount) from Account";
    	int lastId=0;
    	try {
    		conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()) {
            	lastId=rs.getInt(1);
            }
    	}
    	finally {
			
		}
    	return lastId;
    }

	public static void main(String[] args) {
		try {
			AccountDAO dao = new AccountDAO();
			Account acc = new Account("Test", "test", "test");
			System.out.print(dao.getLastid());
		} catch (Exception e) {
			System.err.println("error");
			e.printStackTrace();
		}
	}
}
