package Logica;

import Entidades.Incidente;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOInferencia extends DAOGenericoHibernate {
    public DAOInferencia() {
        super(Incidente.class);
    }
    public List<Incidente> incidentesEntreFechas(Date fechaInicio, Date fechaFinal){
        try (Session sesion = sessionManagerCreator.getSessionFactory().openSession()){
            CriteriaBuilder criteriaBuilder = sesion.getCriteriaBuilder();
            CriteriaQuery<Incidente> query = criteriaBuilder.createQuery(Incidente.class);
            Root<Incidente> root = query.from(Incidente.class);
            query.select(root).where(criteriaBuilder.between(root.get("fecha"),fechaInicio,fechaFinal));
            return sesion.createQuery(query).getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Incidente> incidentesPorEstado(boolean estado){
        try (Session sesion = sessionManagerCreator.getSessionFactory().openSession()){
            CriteriaBuilder criteriaBuilder = sesion.getCriteriaBuilder();
            CriteriaQuery<Incidente> query = criteriaBuilder.createQuery(Incidente.class);
            Root<Incidente> root = query.from(Incidente.class);
            query.select(root).where(criteriaBuilder.equal(root.get("estado_incidente"), estado));
            return sesion.createQuery(query).getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
}
