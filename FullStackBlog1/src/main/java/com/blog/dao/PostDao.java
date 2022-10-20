package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.blog.helper.ConnectionProvider;
import com.blog.model.Category;
import com.blog.model.Post;

public class PostDao {
	static Connection conn=ConnectionProvider.getConnection();
	public static ArrayList<Category> getCategories(){
		ArrayList<Category> arr=new ArrayList<>();
		String getCat="select * from categories";
		try {
		Statement s=conn.createStatement();
		ResultSet set=s.executeQuery(getCat);
		while(set.next()) {
			int id=set.getInt("cid");
			System.out.println("cat id from post dao : "+id);
			String name=set.getString("name");
			String desc=set.getString("description");
			Category cat=new Category(id, name, desc);
			arr.add(cat);
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return arr;
		
	}
	
	
	public static boolean savePost(Post post1) {
		boolean f=false;
		String post="insert into posts(pTitle,pContent,pCode,pPic,catID,userID) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps= conn.prepareStatement(post);
			
			ps.setString(1,post1.getTitle());
			ps.setString(2,post1.getContent());
			ps.setString(3,post1.getCode());
			ps.setString(4,post1.getImage());
			ps.setInt(5,post1.getCatId());
			ps.setInt(6,post1.getUserId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	public static ArrayList<Post> getAllPosts(){
		ArrayList<Post> allPosts=new ArrayList<>();
		String getAllPosts="Select * from posts order by pid desc";
		try {
			Statement ps=conn.createStatement();
			
			ResultSet set=ps.executeQuery(getAllPosts);
			while(set.next()) {
				int pid=set.getInt("pid");
				String title=set.getString("pTitle");
				String content=set.getString("pContent");
				String code=set.getString("pCode");
				String image=set.getString("pPic");
				Timestamp date=set.getTimestamp("pDate");
				int categoryId=set.getInt("catID");
				int userId=set.getInt("userID");
				
					Post post=new Post(pid,title, content, code, date, categoryId, userId, image);
					allPosts.add(post);
					System.out.println("list has all the posts ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allPosts;
		
	}
	public static ArrayList<Post> getPosts(int catId){
		ArrayList<Post> posts=new ArrayList<>();
		String getPosts="Select * from posts  where catID=? order by pid desc";
		
		try {
			PreparedStatement ps=conn.prepareStatement(getPosts);
			ps.setInt(1, catId);
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				int pid=set.getInt("pid");
				String title=set.getString("pTitle");
				String content=set.getString("pContent");
				String code=set.getString("pCode");
				String image=set.getString("pPic");
				Timestamp date=set.getTimestamp("pDate");
				int userId=set.getInt("userID");
				
					Post post=new Post(pid, title, content, code, date, catId, userId, image);
					posts.add(post);
					
					System.out.println("list has category posts  ");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return posts;
	}
}
