package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Photo;
import dao.PhotoDAO;

/**
 * Servlet implementation class Home
 */
@WebServlet("")
public class Home extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_USER_HOME = "/WEB-INF/index.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Photo> photos = PhotoDAO.getAllPhotos();
		request.setAttribute("photos", photos);
		getServletContext().getRequestDispatcher(VUE_USER_HOME).forward(request, response);
	}

}
