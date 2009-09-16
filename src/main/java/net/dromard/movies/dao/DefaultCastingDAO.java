package net.dromard.movies.dao;

import java.util.List;

import net.dromard.movies.model.Casting;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultCastingDAO extends GenericDAO implements ICastingDAO {

	public Casting findById(int id) {
		return super.findById(Casting.class, id);
	}

	protected Class<Casting> getEntityClass() {
		return Casting.class;
	}

	public Casting persist(Casting entity) {
		if (entity.getId() == null) {
			return super.create(entity);
		} else { 
			return super.update(entity);
		}
	}

	public void remove(int id) {
		super.remove(getEntityClass(), id);
	}

	public List<Casting> findAll() {
		return super.findAll(Casting.class, "firstname");
	}

	@SuppressWarnings("unchecked")
	public Casting findOrCreate(String firstname, String lastname) {
		List<Casting> found = getEntityManager().createQuery("from " + Casting.class.getName() + " as obj where lower(obj.firstname) = lower(" + formatString(firstname) + ") and lower(obj.lastname) = lower(" + formatString(lastname) + ") ").getResultList();
		if (found.size() > 0) {
			return found.get(0);
		}
		return new Casting(firstname, lastname);
	}
}
