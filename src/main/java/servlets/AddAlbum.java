package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Album;
import dao.AlbumDAO;

/**
 * Servlet implementation class AddAlbum
 */
@WebServlet("/addalbum")
public class AddAlbum extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_USER_NEW_ALBUM = "/WEB-INF/addAlbum.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VUE_USER_NEW_ALBUM).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theme = request.getParameter("theme");
		int audience = Integer.parseInt(request.getParameter("audience"));
		
		Album album = new Album(theme, audience, 1);
		
		if (AlbumDAO.add(album)) request.setAttribute("success", 1);
		else request.setAttribute("success", 0);
			
		getServletContext().getRequestDispatcher(VUE_USER_NEW_ALBUM).forward(request, response);
	}

}
