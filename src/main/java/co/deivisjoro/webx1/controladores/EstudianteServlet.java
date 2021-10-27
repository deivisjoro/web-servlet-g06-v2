package co.deivisjoro.webx1.controladores;

import co.deivisjoro.webx1.bd.Conexion;
import co.deivisjoro.webx1.modelos.dao.EstudianteDAO;
import co.deivisjoro.webx1.modelos.entidades.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ESTUDIANTE
 */
@WebServlet(name = "Estudiante", urlPatterns = {"/estudiantes"})
public class EstudianteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Conexion conexion = new Conexion();
        EstudianteDAO estudianteDAO = new EstudianteDAO(conexion);

        String opcion = request.getParameter("accion");
        
        opcion = (opcion==null) ? "listar" :  opcion;
        
        
        if(opcion.equals("ingresar")){
            boolean ingresar = (request.getParameter("guardar")!=null) ? true :  false;
            
            if(ingresar){
                Estudiante estudiante = new Estudiante();
                estudiante.setNombre(request.getParameter("nombre"));
                estudiante.setNota1(Float.parseFloat(request.getParameter("nota1")));
                estudiante.setNota2(Float.parseFloat(request.getParameter("nota2")));
                estudiante.setNota3(Float.parseFloat(request.getParameter("nota3")));
                Estudiante e = estudianteDAO.add(estudiante);
                
                response.sendRedirect("estudiantes");
                
                /*if(e.getId()!=0){
                }
                else{
                }*/
            }            
            else{
                request.getRequestDispatcher("ingresar.jsp").forward(request, response);
            }
            
        }
        else if(opcion.equals("eliminar")){
            
            int id = (request.getParameter("id")!=null) ? Integer.parseInt(request.getParameter("id")) :  0;
            System.out.println("El valor de id es "+id);
            if(id!=0){
                estudianteDAO.delete(id);
                response.sendRedirect("estudiantes");
            }
        }
        else{
            ArrayList<Estudiante> estudiantes = estudianteDAO.list();
        
            request.setAttribute("estudiantes", estudiantes);

            request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
