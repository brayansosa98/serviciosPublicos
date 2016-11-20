/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosPubli.Servlets;

import com.serviciosPubli.Entidades.tipoServicio;
import com.serviciosPubli.Negocio.hogaresN;
import com.serviciosPubli.Negocio.tiposServiciosN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class parametrizacionServlet extends HttpServlet {

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

        String modulo = "./auth.parametrizacion.jsp";// enviar respuesta
        String pagina = "./index.jsp";

        request.setAttribute("targetModulo", modulo);
        String valor_subsidio_Electricidad = request.getParameter("txtvalor_subsidio_Electricidad");
        String limite_pago_Electricidad = request.getParameter("txtlimite_pago_Electricidad");

        String valor_subsidio_agua = request.getParameter("txtvalor_subsidio_Agua");
        String limite_pago_agua = request.getParameter("txtlimite_pago_Agua");

        String valor_subsidio_Gas = request.getParameter("txtvalor_subsidio_Gas");
        String limite_pago_Gas = request.getParameter("txtlimite_pago_Gas");

        String men = "";

        tiposServiciosN tsN = new tiposServiciosN();
        hogaresN hoN = new hogaresN();

        request.setAttribute("listado", null);

        request.setAttribute("mensaje", null);

        try {
            request.setAttribute("listado", tsN.listadoTiposServicio());
        } catch (Exception er) {
            request.setAttribute(men, er.getMessage());
        }

        if ("actualizarElectricidad".equals(request.getParameter("action"))) {
            try {
                boolean valElec = tsN.valorValido(valor_subsidio_Electricidad);
                boolean limElec = tsN.valorValido(limite_pago_Electricidad);
                if (limElec == true && valElec == true) {
                    tsN.ActualizarTipoServicio("1", valor_subsidio_Electricidad, limite_pago_Electricidad);
                } else {
                    if (!valElec) {
                        men = "El campo valor subsidio (Electricidad) solo debe contener números";
                    } else {
                        men = "El campo limite de pago (Electricidad) solo debe contener números";
                    }
                }
            } catch (Exception er) {
                men = "" + er.getMessage();
            }
            try {
                request.setAttribute("listado", tsN.listadoTiposServicio());
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }

        if ("actualizarAgua".equals(request.getParameter("action"))) {
            try {
                boolean valElec = tsN.valorValido(valor_subsidio_agua);
                boolean limElec = tsN.valorValido(limite_pago_agua);
                if (limElec == true && valElec == true) {
                    tsN.ActualizarTipoServicio("2", valor_subsidio_agua, limite_pago_agua);
                } else {
                    if (!valElec) {
                        men = "El campo valor subsidio (Agua) solo debe contener números";
                    } else {
                        men = "El campo limite de pago (Agua) solo debe contener números";
                    }
                }
            } catch (Exception er) {
                men = "" + er.getMessage();
            }
            try {
                request.setAttribute("listado", tsN.listadoTiposServicio());
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }

        if ("actualizarGas".equals(request.getParameter("action"))) {
            try {
                boolean valGas = tsN.valorValido(valor_subsidio_Gas);
                boolean limGas = tsN.valorValido(limite_pago_Gas);
                if (limGas == true && valGas == true) {
                    tsN.ActualizarTipoServicio("3", valor_subsidio_Gas, limite_pago_Gas);
                } else {
                    if (!valGas) {
                        men = "El campo valor subsidio (Gas) solo debe contener números";
                    } else {
                        men = "El campo limite de pago (Gas) solo debe contener números";
                    }
                }
            } catch (Exception er) {
                men = "" + er.getMessage();
            }
            try {
                request.setAttribute("listado", tsN.listadoTiposServicio());
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }

        if ("calcularElectricidad".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", tsN.actualizarTiposServicio(tsN.listadoTiposServicio(), "1", tsN.promedioPago("1", hoN.listaHogaresUltimoPago())));
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }

        if ("calcularAgua".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", tsN.actualizarTiposServicio(tsN.listadoTiposServicio(), "2", tsN.promedioPago("2", hoN.listaHogaresUltimoPago())));
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }

        if ("calcularGas".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", tsN.actualizarTiposServicio(tsN.listadoTiposServicio(), "3", tsN.promedioPago("3", hoN.listaHogaresUltimoPago())));
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }

        request.setAttribute("mensaje", men);
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
