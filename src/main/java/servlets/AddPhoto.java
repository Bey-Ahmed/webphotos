package servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.Album;
import beans.Photo;
import dao.AlbumDAO;
import dao.PhotoDAO;

/**
 * Servlet implementation class AddPhoto
 */
@WebServlet("/addphoto")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10,      // 10 MB
		maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class AddPhoto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public static final String VUE_USER_NEW_PHOTO = "/WEB-INF/addPhoto.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Album> albums = AlbumDAO.getUserAlbumsThemes(1);
		request.setAttribute("albums", albums);
		getServletContext().getRequestDispatcher(VUE_USER_NEW_PHOTO).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String bio = request.getParameter("bio");
			int albumId = Integer.parseInt(request.getParameter("album-id"));
			Part filePart = request.getPart("file");
			String filePath = "C:\\Users\\Public\\" + filePart.getSubmittedFileName();
			
			for (Part part : request.getParts()) {
				part.write(filePath);
			}
			
			BufferedImage img = ImageIO.read(new File(filePath));
			int hauteur = img.getHeight();
			int largeur = img.getWidth();
			
			Photo photo = new Photo(filePath, bio, hauteur, largeur, albumId);
			
			if (PhotoDAO.add(photo)) request.setAttribute("success", 1);
			else request.setAttribute("success", 0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
			
		getServletContext().getRequestDispatcher(VUE_USER_NEW_PHOTO).forward(request, response);
		
	}

}
