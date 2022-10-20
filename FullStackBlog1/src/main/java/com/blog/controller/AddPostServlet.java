package com.blog.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.blog.dao.PostDao;
import com.blog.model.Post;
import com.blog.model.UserBean;

/**
 * Servlet implementation class AddPostServlet
 */
@MultipartConfig
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/plain");

		response.getWriter().append("success");

	}

	public boolean isValidFile(String imageFile) {
		if (imageFile.endsWith("jpg") || imageFile.endsWith("jpeg") || imageFile.endsWith("png")) {
			return true;
		} else {
			return false;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("cat id from sevlet  " + request.getParameter("select"));
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user_details");

		String title = request.getParameter("post_title");
		String content = request.getParameter("post_content");
		String code = request.getParameter("post_code");
		Part image = request.getPart("post_pic");
		int userId = Integer.parseInt(user.getId());
		String category = request.getParameter("select");
		if (category == null) {
			response.setContentType("text/plain");

			response.getWriter().append("NoCategory");
			return;
		}
		int catId = Integer.parseInt(request.getParameter("select"));

		System.out.println("cat id : " + catId + " type: " + ((Object) catId).getClass().getSimpleName());
		Post post = new Post(title, content, code, catId, userId, image.getSubmittedFileName());
		System.out.println();
		System.out.println();
		String imageName = image.getSubmittedFileName();
		imageName=imageName.replaceAll("\\s+", "");
		if (PostDao.savePost(post)) {

			if (!image.getSubmittedFileName().equals("")) {
				if (isValidFile(imageName)) {
					ServletContext context = request.getServletContext();
					String hardPath = "C:\\Users\\SYEDS'\\Documents\\Full Stack Workspace\\FullStackBlog1\\src\\main\\webapp\\images\\BlogPosts";

					File file = new File(hardPath);
					file.mkdirs();
					String path = hardPath + File.separator + user.getId() + "." + imageName;
//			String localPath=request.getRealPath("/")+"images"+File.separator+image.getSubmittedFileName();
					byte[] b = new byte[image.getInputStream().available()];
					image.getInputStream().read(b);
					FileOutputStream fos = new FileOutputStream(path);
//			FileOutputStream fos1=new FileOutputStream(localPath);
					fos.write(b);
//			fos1.write(b);
					fos.close();
//			fos1.close();
					System.out.println("path/.........." + path);
				} else {
					response.setContentType("text/plain");

					response.getWriter().append("FileNotValid");
					return;
				}
			}
//			System.out.println("loical path/..........."+localPath);

			doGet(request, response);

		} else {
			response.setContentType("text/plain");
			response.getWriter().append("error");
		}
	}

}
