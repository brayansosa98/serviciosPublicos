/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosPubli.Servlets;

import com.serviciosPubli.Entidades.usuario;
import com.serviciosPubli.Negocio.usuarioN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class login extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        String pagina = "./login.jsp";
        HttpSession session = request.getSession();

        usuarioN un = new usuarioN();
        usuario u = new usuario();

        String user = request.getParameter("txtUser");
        String clave = request.getParameter("txtPass");

        String men = "";

        if ("".equals(clave) || null == clave) {
            men = "Ingrese la  contraseña";
        }
        if ("".equals(user) || null == user) {
            men = "Ingrese el usuario";
        }
        if ("".equals(clave) && "".equals(user)) {
            men = "Ingrese el usuario y la contraseña";
        }
        if ("".equals(men)) {
            u = un.getValidarIngreso(user, clave);
            if (u.getUsuario() != "0") {
                request.getSession(true).setAttribute("usuario", u);
                pagina = "./index.jsp";
            } else {
                pagina = "./login.jsp";
                men = "El usuario y/o contraseña no coinciden";
            }
        }

        request.setAttribute("mensajeError", men);
        request.getRequestDispatcher(pagina).forward(request, response);
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
