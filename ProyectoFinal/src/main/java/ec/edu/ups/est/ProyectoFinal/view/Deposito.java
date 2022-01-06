package ec.edu.ups.est.ProyectoFinal.view;

import java.io.IOException;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.est.ProyectoFinal.business.MovimientoONLocal;


/**
 * Servlet implementation class Deposito
 */
@WebServlet("/Deposito")
public class Deposito extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@Inject
	private MovimientoONLocal movimientoONLocal;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
				movimientoONLocal.insertarMovimientos(1,"555",15,225.3);
			
	
				
				
				
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
