<%@page import="org.trahim.web.enums.SearchType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.trahim.web.beans.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../WEB-INF/jspf/left_menu.jspf" %>
<%@include file="../WEB-INF/jspf/letters.jspf" %>


<jsp:useBean id="bookList" class="org.trahim.web.beans.BookList" scope="page"/>



<div class="book_list">



    <%
        ArrayList<Book> list = null;

        if (request.getParameter("genre_id") != null) {
            long genreId = Long.valueOf(request.getParameter("genre_id"));
            list = bookList.getBooksByGenre(genreId);
        } else if (request.getParameter("letter") != null) {
            String letter = request.getParameter("letter");
            list = bookList.getBooksByLetter(letter);
        } else if (request.getParameter("search_string") != null) {
            String searchStr = request.getParameter("search_string");
            SearchType type = SearchType.TITLE;
            if (request.getParameter("search_option").equals("Автор")) {
                type = SearchType.AUTHOR;
            }

            if (searchStr != null && !searchStr.trim().equals("")) {
                list = bookList.getBooksBySearch(searchStr, type);
            }

        } else if (session.getAttribute("currentBookList") != null) {
            list = (ArrayList<Book>) session.getAttribute("currentBookList");
        }else{
            list = bookList.getAllBooks();

        }
    %>
    <h5 style="text-align: left; margin-top:20px;">Найдено книг: <%=list.size() %> </h5>
    <%
        session.setAttribute("currentBookList", list);
        for (Book book : list) {

    %>

    <div class="book_info">
        <div class="book_title">
            <p> <%=book.getName()%></p>
        </div>
        <div class="book_image">
            <a href="#"><img src="<%=request.getContextPath()%>/ShowImage?index=<%=list.indexOf(book)%>" height="250" width="190" alt="Обложка"/></a>
        </div>
        <div class="book_details">
            <br><strong>ISBN:</strong> <%=book.getIsbn()%>
            <br><strong>Издательство:</strong> <%=book.getPublisher()%>

            <br><strong>Количество страниц:</strong> <%=book.getPageCount()%>
            <br><strong>Год издания:</strong> <%=book.getPublishDate()%>
            <br><strong>Автор:</strong> <%=book.getAuthor()%>
            <p style="margin:10px;"> <a href="content.jsp?index=<%=list.indexOf(book)%>">Читать</a></p>
        </div>
    </div>


    <%}%>



</div>
