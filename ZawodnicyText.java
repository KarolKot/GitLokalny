package serwlety;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DostepDoBazy;
import model.Zawodnik;

@WebServlet("/ZawodnicyText")
public class ZawodnicyText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		try (DostepDoBazy dostep = new DostepDoBazy()) {
			List<Zawodnik> zawodnicy = dostep.getListaZawodnikow();
			out.println("Odczytałem " + zawodnicy.size() + " zawodników.");
			out.println("================================================");
			for (Zawodnik zawodnik : zawodnicy) {
				out.println(zawodnik);

			}
			out.println("================================================");

		} catch (SQLException e) {
			out.println("Był błąd");
			e.printStackTrace(out);
		}
	}
}
