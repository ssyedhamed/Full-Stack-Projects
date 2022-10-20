package net.controlller;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import net.helper.SessionFact;
import net.model.Note;

/**
 * Servlet implementation class AddNote
 */
@MultipartConfig
public class AddNote extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddNote() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Part image=request.getPart("image");
		String imageName=image.getSubmittedFileName();
		System.out.println(title+content+" "+imageName);
		Note note=new Note(title, content, imageName);
		SessionFactory factory=SessionFact.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(note);
		tx.commit();
		session.close();
		factory.close();
		response.sendRedirect("showNotes.jsp");
//		
//		doGet(request, response);
	}

}
