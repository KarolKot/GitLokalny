package serwlety;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DostepDoBazy;
import model.Zawodnik;

@WebServlet("/ZawodnicyZKraju")
public class ZawodnicyZKraju extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dzialaj(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dzialaj(req, resp);
	}

	private void dzialaj(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String kraj = request.getParameter("kraj");

		try (DostepDoBazy dostep = new DostepDoBazy()) {

			List<Zawodnik> listaZawodnikow;
			if (kraj != null && !kraj.isEmpty()) {
				listaZawodnikow = dostep.zawodnicyZKraju(kraj);
			} else {
				listaZawodnikow = dostep.getListaZawodnikow();
			}

			request.setAttribute("zawodnicy", listaZawodnikow);

		} catch (SQLException e) {
			throw new ServletException("Błąd bazy danych", e);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("zawodnicy_z_kraju.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}

	}

}