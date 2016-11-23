/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosPubli.Servlets;

import com.serviciosPubli.Negocio.hogaresN;
import com.serviciosPubli.Negocio.tiposServiciosN;
import com.serviciosPubli.Persistencia.daoHogares;
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
public class hogaresServlet extends HttpServlet {

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

        String modulo = "./auth.hogares.jsp";
        String pagina = "./index.jsp";

        request.setAttribute("targetModulo", modulo);
        request.setAttribute("listado", null);
        request.setAttribute("listadoFiltros1", null);
        request.setAttribute("listadoFiltros2", null);
        request.setAttribute("mensaje", null);
        request.setAttribute("filtro", null);
        String men = "";

        String txtCodigoHogar = request.getParameter("txtCodigoHogar");
        String txtPagoElec = request.getParameter("txtPagoElec");
        String txtPagoAgua = request.getParameter("txtPagoAgua");
        String txtPagoGas = request.getParameter("txtPagoGas");

        String txtSearch = request.getParameter("txtSearch");

        String txtDesde = request.getParameter("txtDesde");
        String txtHasta = request.getParameter("txtHasta");
        
        String txtValorInicial = request.getParameter("txtValorInicial");
        String txtValorFinal = request.getParameter("txtValorFinal");
        

        hogaresN hoN = new hogaresN();
        tiposServiciosN tsN = new tiposServiciosN();

        try {
            request.setAttribute("listado", hoN.listadoHogares());
        } catch (Exception er) {
            request.setAttribute(men, er.getMessage());
        }

        if ("guardarHogar".equals(request.getParameter("action"))) {
            try {
                boolean valCodHohgar = hoN.valorValido(txtCodigoHogar, true);
                boolean valPagEle = hoN.valorValido(txtPagoElec, false);
                boolean valPagAgu = hoN.valorValido(txtPagoAgua, false);
                boolean valPagGas = hoN.valorValido(txtPagoGas, false);
                if (valCodHohgar && valPagEle && valPagAgu && valPagGas) {
                    hoN.insertarPagoHogar(txtCodigoHogar, txtPagoElec, txtPagoAgua, txtPagoGas);
                } else {
                    if (!valCodHohgar) {
                        men = "El código del hogar solo debe contener carecteres alfanuméricos";
                    } else if (!valPagEle) {
                        men = "El pago electricidad solo debe contener números";
                    } else if (!valPagAgu) {
                        men = "El pago agua solo debe contener números";
                    } else if (!valPagGas) {
                        men = "El pago gas solo debe contener números";
                    }
                }
            } catch (Exception er) {
                men = "" + er.getMessage();
            }
            try {
                request.setAttribute("listado", hoN.listadoHogares());
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }
        if ("consultarHogar".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", hoN.listadoPagosHogar(txtSearch));
                men = "Registro(s) de pago del hogar con código \" " + txtSearch + " \"";
                request.setAttribute("filtro", "true");
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }
        if ("listar".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", hoN.listadoHogares());
                request.setAttribute("filtro", "false");
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }
        if ("aplicarSubsidio".equals(request.getParameter("action"))) {
            try {
                hoN.aplicarSubsidio(hoN.listaHogaresUltimoPago(), tsN.listadoTiposServicio());
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }

        if ("filtroHogar_filtro1".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", null);
                request.setAttribute("filtro", "true");
                String ini = txtDesde + " 00:00:00";
                String fin = txtHasta + " 23:59:59";
                request.setAttribute("listadoFiltro1", hoN.filtroFechas(ini, fin));
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }

        if ("filtroHogar_filtro2".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", null);
                request.setAttribute("listadoFiltro1", null);
                request.setAttribute("filtro", "true");
                boolean validoIni = hoN.valorValido(txtValorInicial, false);
                boolean validoFin = hoN.valorValido(txtValorFinal, false);
                if (validoIni && validoFin) {
                    int ini = Integer.parseInt(txtValorInicial);
                    int fin = Integer.parseInt(txtValorFinal);
                    request.setAttribute("listadoFiltro2", hoN.valoresPago(ini, fin));
                }

            } catch (Exception e) {
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
