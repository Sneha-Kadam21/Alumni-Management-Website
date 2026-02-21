package com.alumni.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AlumniDAO {

	
	private String jdbcURL="jdbc:mysql://localhost:3306/alumni_db";
	private String jdbcUserName="root";
	private String jdbcPassword="Sneha@559";
	
	private static final String INSERT_ALUMNI_SQL="INSERT INTO alumni(name,email,graduation_year,course) values (?,?,?,?)";
	
	private static final String SELECT_ALL_ALUMNI="select * from alumni";
	private static final String DELETE_ALUMNI_SQL="DELETE FROM alumni WHERE id=?";
	
	//Database Connection
	protected Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}return DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
	}
	
	public void insertAlumni(String name,String email,int year,String course) throws SQLException{
		try(Connection connection=getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(INSERT_ALUMNI_SQL)){
			preparedStatement.setString(1,name);
			preparedStatement.setString(2, email);
			preparedStatement.setInt(3, year);
			preparedStatement.setString(4, course);
			preparedStatement.executeUpdate();
		}
	}
	
	//get all alumni
	public List<String[]> selectAllAlumni() throws SQLException{
		List<String[]> alumniList=new ArrayList<>();
		try(Connection connection=getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_ALUMNI);
				ResultSet rs=preparedStatement.executeQuery()){
			while(rs.next()) {
				String[] alumni=new String[5];
				alumni[0]=String.valueOf(rs.getInt("id"));
				alumni[1]=rs.getString("name");
				alumni[2]=rs.getString("email");
				alumni[3]=String.valueOf(rs.getInt("graduation_year"));
				alumni[4]=rs.getString("course");
				alumniList.add(alumni);
				
			}
		}
		return alumniList;
		
	}
	//DELETE ALUMNI 
	public void deleteAlumni(int id) throws SQLException{
		try(Connection connection=getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(DELETE_ALUMNI_SQL)){
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();
		}
		
	}
	// Update Alumni
	public void updateAlumni(int id, String name, String email, int year, String course) throws SQLException {

	    String sql = "UPDATE alumni SET name=?, email=?, graduation_year=?, course=? WHERE id=?";

	    try (Connection connection = getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setString(1, name);
	        preparedStatement.setString(2, email);
	        preparedStatement.setInt(3, year);
	        preparedStatement.setString(4, course);
	        preparedStatement.setInt(5, id);

	        preparedStatement.executeUpdate();
	    }
	}
	// Search Alumni
	public List<String[]> searchAlumni(String keyword, String type) throws SQLException {

	    List<String[]> list = new ArrayList<>();

	    String sql = "";

	    if (type.equals("name")) {
	        sql = "SELECT * FROM alumni WHERE name LIKE ?";
	    } else if (type.equals("email")) {
	        sql = "SELECT * FROM alumni WHERE email LIKE ?";
	    } else if (type.equals("year")) {
	        sql = "SELECT * FROM alumni WHERE graduation_year = ?";
	    }

	    try (Connection connection = getConnection();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        if (type.equals("year")) {
	            ps.setInt(1, Integer.parseInt(keyword));
	        } else {
	            ps.setString(1, "%" + keyword + "%");
	        }

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new String[]{
	                String.valueOf(rs.getInt("id")),
	                rs.getString("name"),
	                rs.getString("email"),
	                String.valueOf(rs.getInt("graduation_year")),
	                rs.getString("course")
	            });
	        }
	    }

	    return list;
	}
}
