package uz.pdp.applibrary.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.applibrary.entity.Book;
import uz.pdp.applibrary.manager.GetEntityTransaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "uz.pdp.applibrary.servlet.AddBook", value = "/library/add")
@MultipartConfig(location = "C:/Users/User/Desktop/uploads")
public class AddBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/add.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        int page = Integer.parseInt(req.getParameter("page"));
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        LocalDate publishDate = LocalDate.parse(req.getParameter("publishDate"));
        String desc = req.getParameter("desc");

        EntityManager entityManager = GetEntityTransaction.getEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Book build = Book.builder()
                .title(title)
                .pages(page)
                .authorName(author)
                .publisher(publisher)
                .publishedAt(publishDate)
                .description(desc)
                .build();

        entityManager.persist(build);
        transaction.commit();

        PrintWriter writer = resp.getWriter();

        writer.println("""
                <h1> Book successfully added
                <br><br>
                <a href="/library">Go to main page</a>
                """);
    }
}
