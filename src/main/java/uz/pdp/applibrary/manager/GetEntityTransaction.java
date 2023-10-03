package uz.pdp.applibrary.manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.HttpServletRequest;

public class GetEntityTransaction {
    public static String getPathInfo(HttpServletRequest request){
        return request.getPathInfo().substring(1);
    }
    public static EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ketmon");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
