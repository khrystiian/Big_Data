package servlets;
import recommender.*;
import twitter4j.JSONException;
import twitter4j.TwitterException;
import watson.Personality;
import movie.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MvcResult
 */
@WebServlet("/MvcResult")
public class MvcResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static ComparisonController con = new ComparisonController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MvcResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Movies recommended
		ArrayList<Movie> movies  =new ArrayList<>();
		String user = request.getParameter("twitterUsername");
		request.getSession().setAttribute("twitterUsername","@" +user);
		
		
		//Personality Insights 
		ComparisonController ctrl = new ComparisonController();
		Personality userInsights = ctrl.getUserInsights(user);
		
		
		try {
			movies = con.top5(user);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//movies = top5.top5temp();
		request.setAttribute("movie_list", movies);
		request.setAttribute("userInsights", userInsights);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("response.jsp");
		
		dispatcher.forward(request, response);
		
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		doGet(request, response);
	}

}
