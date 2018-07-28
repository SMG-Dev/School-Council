package SMG.SchoolCouncilPanel.repositories;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import SMG.SchoolCouncilPanel.entities.base.Entity;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class HibernateRepository<T extends Entity> implements GenericRepository<T> {
	private final SessionFactory sessionFactory;
	private Class<T> entityClass;

	public HibernateRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<T> getAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<T> criteriaQuery = builder.createQuery(getEntityClass());
		criteriaQuery.from(getEntityClass());

		List<T> entities = session.createQuery(criteriaQuery)
				.getResultList();

		transaction.commit();
		session.close();

		return entities;
	}

	@Override
	public List<T> getBy (String field, Object value) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<T> criteriaQuery = builder.createQuery(getEntityClass());
		Root<T> root = criteriaQuery.from(this.entityClass);
		criteriaQuery.select(root);
		criteriaQuery.where( builder.equal(root.get(field), value));
		List<T> entities = session.createQuery(criteriaQuery).getResultList();

		transaction.commit();
		session.close();

		return entities;
	}

	@Override
	public T create(T entity) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save (entity);
		transaction.commit();
		session.close();
		return entity;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}