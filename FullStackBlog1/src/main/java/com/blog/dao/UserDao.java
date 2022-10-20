package com.blog.dao;
import java.sql.*;



import com.blog.helper.ConnectionProvider;
import com.blog.model.UserBean;
public class UserDao {
	
	Connection conn=ConnectionProvider.getConnection();
	boolean done=false;
	public boolean registerUser(UserBean user) {
	String insert ="insert into user_table(name,email,password,gender,about) values(?,?,?,?,?)";
	try {
	PreparedStatement ps=conn.prepareStatement(insert);
	ps.setString(1, user.getName());
	ps.setString(2, user.getEmail());
	ps.setString(3, user.getPassword());
	ps.setString(4, user.getGender());
	ps.setString(5, user.getAbout());
	ps.executeUpdate();
	done=true;
	System.out.println("values have been inserted into db");
	}catch(Exception e ) {
		e.printStackTrace();
		return done;
	}
	return done;
}
	public UserBean loginUser(String email,String password) {
		UserBean oldUser=null;
		String getDetails="Select * from user_table where email=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(getDetails);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet set=ps.executeQuery();
			if(set.next()) {
				//success
				oldUser=new UserBean();
				oldUser.setId(set.getString("id"));
				oldUser.setName(set.getString("name"));
				oldUser.setEmail(set.getString("email"));
				oldUser.setGender(set.getString("gender"));
				oldUser.setAbout(set.getString("about"));
				oldUser.setRegisterTime(set.getTimestamp("register_time"));
				return oldUser;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return oldUser;
		
		
	}
	public boolean updateUser(UserBean user)  {
		// TODO Auto-generated method stub
		boolean success=false;
		String update="update user_table set name=?,password=?,about=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(update);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getAbout());
			ps.setString(4, user.getId());
			ps.executeUpdate();
			success=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return success;
	}
	public boolean contains(String email) {
		
		String getEmail="Select * from user_table where email=?";
		try {
			PreparedStatement ps=conn.prepareStatement(getEmail);
			ps.setString(1, email);
			ResultSet set=ps.executeQuery();
			if(set.next()) {
				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}