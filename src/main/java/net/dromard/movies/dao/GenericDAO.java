package net.dromard.movies.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAO {
	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	protected EntityManager getEntityManager() {
		if (em == null) throw new IllegalStateException("EntityManager has not been set on before usage");
		return em;
	}

	protected <T> T findById(Class<T> entityClass, int id) {
		T entity = getEntityManager().find(entityClass, id);
		return entity;
	}

	protected <T> T update(T entity) {
		return getEntityManager().merge(entity);
	}

	protected <T> T create(T entity) {
		return getEntityManager().merge(entity);
	}
	
	protected <T> void remove(Class<T> entityClass, int id) {
		getEntityManager().remove(findById(entityClass, id));
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> entityClass, String orderField) {
		return getEntityManager().createQuery("from " + entityClass.getName() + " order by " + orderField).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findNext(T entity, String field, String value) {
		List<T> resultList = getEntityManager().createQuery("from " + entity.getClass().getName() + " where " + field + " > " + formatString(value) + " order by " + field).getResultList();
		if (resultList.size() > 0) {
			return resultList.get(0);
		}
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findPrevious(T entity, String field, String value) {
		List<T> resultList = getEntityManager().createQuery("from " + entity.getClass().getName() + " where " + field + " < " + formatString(value) + " order by " + field).getResultList();
		if (resultList.size() > 0) {
			return resultList.get(resultList.size()-1);
		}
		return entity;
	}
	
	public void flush() {
		getEntityManager().flush();
	}

	public void clear() {
		getEntityManager().clear();
	}

    /**
     * Format a string parameter to HQL Format. Inhib nested quote by doubling it.
     * @param str HQL parameter
     * @return if str is null, return null, else quoted string.
     */
    public static String formatString(final String str) {
        if (str == null) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        result.append("'");
        result.append(str.replaceAll("'", "''"));
        result.append("'");
        return result.toString();
    }
}
