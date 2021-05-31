package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBContext;
import model.Food;

public class FoodDAO {

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
    
    public List<Food> getAll() throws Exception{
    	String sql="Select * from Food";
    	List<Food> list=new ArrayList<>();
    	try {
    		conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Food food =new Food(rs.getString(1), rs.getString(2), rs.getString(4),rs.getString("Image") ,rs.getFloat(3));
                list.add(food);
            }
    	}
    	finally {
			closeConnection();
		}
    	return list;
    }
    
    public static void main(String[] args) {
        try {
            FoodDAO dao=new FoodDAO();
            dao.getAll().forEach((n) -> System.out.print(n));
        } catch (Exception e) {
            System.err.println("error");
            e.printStackTrace();
        }
    }
}
