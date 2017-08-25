package org.trahim.web.servlet;

import org.trahim.web.beans.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;


public class ShowImage extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");

        OutputStream out = response.getOutputStream();

            try {
                int index = Integer.valueOf(request.getParameter("index"));

                ArrayList<Book> list = (ArrayList<Book>)request.getSession(false).getAttribute("currentBookList");
                Book book = list.get(index);
                response.setContentLength(book.getImage().length);
                out.write(book.getImage());
            } finally {
                out.close();
            }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "Shot description";
    }
}
