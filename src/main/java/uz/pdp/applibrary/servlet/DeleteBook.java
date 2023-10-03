package uz.pdp.applibrary.servlet;

import jakarta.persistence.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.applibrary.entity.Book;
import static uz.pdp.applibrary.manager.GetEntityTransaction.*;
import java.io.IOException;


@WebServlet(name = "uz.pdp.applibrary.servlet.DeleteBook", value = "/library/delete/*")
public class DeleteBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        String id = getPathInfo(req);

        transaction.begin();
        Book book = entityManager.find(Book.class,id);
        transaction.commit();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/delete.jsp");
        req.setAttribute("deletingBook",book);
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Book book = entityManager.find(Book.class, getPathInfo(req));
        entityManager.remove(book);
        transaction.commit();
        resp.sendRedirect("/library");

    }


}
