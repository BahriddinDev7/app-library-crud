package uz.pdp.applibrary.servlet;

import jakarta.persistence.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.applibrary.entity.Book;
import uz.pdp.applibrary.manager.GetEntityTransaction;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(name = "uz.pdp.applibrary.servlet.MainPage", value = "/library")
public class MainPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        EntityManager entityManager = GetEntityTransaction.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("from Book ");

        @SuppressWarnings("unchecked")
        List<Book> books = (List<Book>) query.getResultList();

        transaction.commit();


        RequestDispatcher dispatcher = req.getRequestDispatcher("/main.jsp");
        req.setAttribute("books",books);
        dispatcher.forward(req,resp);

    }

}
