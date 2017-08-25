package org.trahim.web.servlet;

import org.trahim.web.beans.Book;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class PdfContent extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try {
            int index = Integer.valueOf(request.getParameter("index"));

            HashMap sessionMap = (HashMap)getServletContext().getAttribute("sessionMap");

            HttpSession session = (HttpSession)sessionMap.get(request.getParameter("session_id"));

            ArrayList<Book> list = (ArrayList<Book>) session.getAttribute("currentBookList");
            Book book = list.get(index);
            book.fillPdfContent();
            response.setContentLength(book.getContent().length);
            out.write(book.getContent());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            out.close();
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
