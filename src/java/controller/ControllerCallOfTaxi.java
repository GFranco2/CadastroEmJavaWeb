/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CallOfTaxi;
import model.CallOfTaxiDAO;


/**
 *
 * @author Matheus Barriolo
 */
public class ControllerCallOfTaxi extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
           String nome = request.getParameter("nome");
           String login = request.getParameter("login");
           String senha = request.getParameter("senha");
           String confSenha = request.getParameter("confSenha");
           String email = request.getParameter("email");
           String complemento = request.getParameter("complemento");
           String estado = request.getParameter("estado");
           String cidade = request.getParameter("cidade");
           String bairro = request.getParameter("bairro");
           String logradouro = request.getParameter("logradouro");
           Integer dddTelefone = Integer.parseInt(request.getParameter("dddTelefone"));
           Integer telefone = Integer.parseInt(request.getParameter("Telefone"));
           Integer dddCelular = Integer.parseInt(request.getParameter("dddCelular"));
           Integer celular = Integer.parseInt(request.getParameter("celular"));
           
           
          
           
           
           CallOfTaxi objTaxi = new CallOfTaxi(nome, login, senha, confSenha, email, complemento, estado, cidade, bairro, logradouro, dddTelefone, telefone, dddCelular, celular);
           
           CallOfTaxiDAO dao = new CallOfTaxiDAO();
           dao.Adicionar(objTaxi);
           
        request.setAttribute("usuario", objTaxi);
        request.setAttribute("listaComputador", dao);
        RequestDispatcher view = request.getRequestDispatcher("view/callOfTaxi.jsp");
        view.forward(request,response);
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
