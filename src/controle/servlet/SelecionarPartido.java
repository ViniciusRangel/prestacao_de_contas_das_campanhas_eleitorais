package controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.PartidoControle;
import modelo.beans.Partido;

@WebServlet("/SelecionarPartido")
public class SelecionarPartido extends HttpServlet {

	private static final long serialVersionUID = 3822481979152525593L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PartidoControle partidoControle = new PartidoControle();

		String sigla = request.getParameter("sigla");

		Partido partido = new Partido();

		ArrayList<Partido> partidos = new ArrayList<>();
		try {
			for(Partido partidoBuscado : partidos) {
				if(partidoBuscado.getSigla().equalsIgnoreCase(sigla)) {
					partido = partidoBuscado;
				}
			}
			int anos[] = { 2010, 2006, 2002 };
			if (partido.getSigla().equals("0")) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/erro_partido_inexistente.jsp");
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("partido", partido);
				request.setAttribute("anos", anos);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/visualizar_partido.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}