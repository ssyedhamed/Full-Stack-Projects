<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.blog.dao.PostDao"%>
<%@page import="com.blog.model.Post"%>


		<%
		Thread.sleep(200);
		ServletContext context=request.getServletContext();
		int cid=Integer.parseInt(request.getParameter("cid"));
		ArrayList<Post> posts=null;
		if(cid<=0){
		posts=PostDao.getAllPosts();
		 }
		else{
			posts=PostDao.getPosts(cid);
			if(posts.size()==0){
				response.setContentType("text/html");
				out.print("<h2>No posts in this category</h2> ");
				return;
			}
		}
		for(Post post: posts){
		/* String path=context.getRealPath("/images/BlogPosts")+File.separator+post.getImage(); */
		String path="FullStackBlog1/images/BlogPosts/8. New shortcut.lnk.png";
		String trim="8. New shortcut.lnk.png";
		trim=trim.replaceAll("\\s+", "");
		System.out.println(trim);
		%>
		<div class="post-card">
			<div class="post-image">
					<img alt="post img here" src="images/BlogPosts/8Newshortcut.png">
			
			</div>
			
			
			<div class="post-head">
				<h3><%=post.getTitle() %></h3>
				<p<%=post.getContent() %>></p>
				
			</div>
			<div class="post-footer " style="background-color: var(--bg-color);" >
				
				<a href="#" class="btn"><i class="fa-solid fa-thumbs-up"></i><span>10</span></a>
				<a href="showBlogs.jsp?pid=<%=post.getId()  %>&&name=<%=post.getTitle() %>" class="btn">Read More...</a>
				<a href="#" class="btn"><i class="fa-solid fa-comment"></i><span>10</span></a>
			</div>
		</div>
		<%
		}
		%>
