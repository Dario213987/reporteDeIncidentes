package Logica;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class DAOGenericoHibernate<T> implements DAOInterfazGenerica<T>{
    private Class<T> clase;
    public DAOGenericoHibernate(Class<T> clase) {
        this.clase = clase;
    }

    @Override
    public T getByID(int id) {
        try (Session sesion = sessionManagerCreator.getSessionFactory().openSession()){
            return sesion.get(clase,id);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> getAll() {
        try (Session sesion = sessionManagerCreator.getSessionFactory().openSession()){
            CriteriaQuery<T> query = sesion.getCriteriaBuilder().createQuery(clase);
            Root<T> root = query.from(clase);
            query.select(root);
            return sesion.createQuery(query).getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void save(T t) {
        try (Session sesion = sessionManagerCreator.getSessionFactory().openSession()){
            sesion.beginTransaction();
            sesion.persist(t);
            sesion.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void saveAll(List<T> tList) {
        try (Session sesion = sessionManagerCreator.getSessionFactory().openSession()){
            sesion.beginTransaction();
            tList.forEach(sesion::persist);
            sesion.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(T t) {
        try (Session sesion = sessionManagerCreator.getSessionFactory().openSession()){
            sesion.beginTransaction();
            sesion.merge(t);
            sesion.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateAll(List<T> tList) {
        try (Session sesion = sessionManagerCreator.getSessionFactory().openSession()){
            sesion.beginTransaction();
            tList.forEach(sesion::merge);
            sesion.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(T t) {
        try (Session sesion = sessionManagerCreator.getSessionFactory().openSession()){
            sesion.beginTransaction();
            sesion.remove(t);
            sesion.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteAll(List<T> tList) {
        try (Session sesion = sessionManagerCreator.getSessionFactory().openSession()){
            sesion.beginTransaction();
            tList.forEach(sesion::remove);
            sesion.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
