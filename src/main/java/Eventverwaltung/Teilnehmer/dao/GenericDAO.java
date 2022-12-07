package Eventverwaltung.Teilnehmer.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;


public abstract class GenericDAO<T> {

//    private final String UNIT_NAME = "Wichtel_AppCtr_EJB";

//    @PersistenceContext(unitName = UNIT_NAME)
    @Inject
    private EntityManager em;

    private Class<T> entityClass;

    public GenericDAO() {}



    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        this.em.persist(entity);
    }

    public T update(T entity) {
        return em.merge(entity);
    }

    protected boolean delete(Object id, Class<T> classe){
        T entityToBeRemoved = em.getReference(classe, id);
        try {
            em.remove(entityToBeRemoved);
            return true;
        } catch (Exception e) {
            System.out.println("Fehler beim Speichern der ID: "+ id.toString());
            return false;
        }
    }

    public T find(int entityId) {
        return em.find(entityClass, entityId);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    @SuppressWarnings("unchecked")
    protected T findOneResult (String namedQuary, Map<String, Object> parameters) {
        T result = null;
        try {
            Query query = em.createNamedQuery(namedQuary);
            if(parameters != null && !parameters.isEmpty()){
                populateQueryParameters(query, parameters);
            }

            result = (T) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Fehler bei der Query: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    protected List<T> findListResult(String namedQuery, Map<String, Object> parameters) {
        List<T> result = null;
        try{
            Query query = em.createNamedQuery(namedQuery);
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }
            result = (List<T>) query.getResultList();
        } catch (Exception e) {
            System.out.println("Fehler bei der Query: " + e.getMessage());
        }
        return result;
    }

    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
}
