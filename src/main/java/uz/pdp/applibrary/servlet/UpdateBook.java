package uz.pdp.applibrary.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.applibrary.entity.Book;
import uz.pdp.applibrary.manager.GetEntityTransaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "uz.pdp.applibrary.servlet.UpdateBook", value = "/library/update/*")
public class UpdateBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = GetEntityTransaction.getPathInfo(req);

        EntityManager entityManager = GetEntityTransaction.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Book book = entityManager.find(Book.class, id);
        transaction.commit();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/update.jsp");
        req.setAttribute("updatingBook",book);
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String desc = req.getParameter("desc");
        int pages = Integer.parseInt(req.getParameter("pages"));


        System.out.println("pages = " + pages);
        System.out.println("desc = " + desc);
        System.out.println("publisher = " + publisher);
        System.out.println("author = " + author);
        System.out.println("title = " + title);


        Book book = Book.builder()
                .title(title)
                .authorName(author)
                .publisher(publisher)
                .pages(pages)
                .build();
        PrintWriter writer = resp.getWriter();
        EntityManager entityManager = GetEntityTransaction.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.merge(book);
        transaction.commit();



        resp.sendRedirect("/library");
       /* writer.println("""
                <h1> Book successfully updated
                <br><br>
                <a href="/library">Go to main page</a>
                """);*/

    }
}
