package org.system.domain.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.jboss.logging.Logger;
import org.system.domain.exception.OperationException;

/**
 * 泛型Hibernate
 * 
 * @author Administrator
 *
 * @param <T>
 * @param <PK>
 */
public abstract class HibernateGenericDao<T extends Serializable, PK extends Serializable>
		implements HibernateEntityDao<T, PK>
{

	private static Logger logger = Logger.getLogger(HibernateGenericDao.class);

	Class<T> clazz = null;

	public Class<T> getClazz()
	{
		return clazz;
	}

	public void setClazz(Class<T> clazz)
	{
		this.clazz = clazz;
	}

	@Override
	public T getById(PK id) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		T entity = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("getById()>>session is null!");
				new OperationException("000001", "getById()>>session is null!");
			}
			tx = session.beginTransaction();
			entity = session.get(clazz, id);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "getById()>>session is null!");
		}

		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		List<T> result = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("getAll()>>session is null!");
				new OperationException("000001", "getAll()>>session is null!");
			}
			tx = session.beginTransaction();
			result = session.createCriteria(clazz).list();
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "getAll()>>session is null!");
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByProperty(String propertyName, Object value) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		List<T> result = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("getByProperty()>>session is null!");
				new OperationException("000001", "getByProperty()>>session is null!");
			}

			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(clazz);
			SimpleExpression propertyExpression = Restrictions.eq(propertyName, value);
			criteria.add(propertyExpression);

			result = (List<T>) criteria.list();
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "getByProperty()>>session is null!");
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByproperties(Map<String, String> criterias) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		List<T> result = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("getByproperty()>>session is null!");
				new OperationException("000001", "getById()>>session is null!");
			}

			if (null == criterias)
			{
				logger.error("getByproperty()>>criterias is null!");
				new OperationException("000001", "getByproperty()>>criterias is null!");
			}

			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(clazz).add(Restrictions.allEq(criterias));

			result = (List<T>) criteria.list();
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "getByproperty()>>session is null!");
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T unique(String propertyName, Object value) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		T entity = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("isUnique()>>session is null!");
				new OperationException("000001", "isUnique()>>session is null!");
			}
			tx = session.beginTransaction();
			entity = (T) session.createCriteria(clazz).add(Restrictions.eq(propertyName, value)).uniqueResult();
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "isUnique()" + e.getMessage());
		}
		return entity;
	}

	@Override
	public Long getSize() throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		Long size = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("getSize()>>session is null!");
				new OperationException("000001", "getSize()>>session is null!");
			}
			tx = session.beginTransaction();
			size = (Long) session.createCriteria(clazz).setProjection(Projections.rowCount()).uniqueResult();
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "getSize()>>session is null!");
		}

		return size;
	}

	@Override
	public void save(T entity) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("save()>>session is null!");
				new OperationException("000001", "save()>>session is null!");
			}
			tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "save()>>session is null!");
		}
	}

	@Override
	public void delete(T entity) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("delete()>>session is null!");
				new OperationException("000001", "delete()>>session is null!");
			}
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "delete()>>session is null!");
		}
	}

	@Override
	public void update(T entity) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("update()>>session is null!");
				new OperationException("000001", "update()>>session is null!");
			}
			tx = session.beginTransaction();
			session.update(entity);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "update()>>session is null!");
		}
	}

	@Override
	public void saveOrUpdate(T entity) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("saveOrUpdate()>>session is null!");
				new OperationException("000001", "saveOrUpdate()>>session is null!");
			}
			tx = session.beginTransaction();
			session.saveOrUpdate(entity);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "saveOrUpdate()>>session is null!");
		}
	}

	@Override
	public void saveOrUpdateAll(Collection<T> entities)
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("saveOrUpdateAll()>>session is null!");
				new OperationException("000001", "saveOrUpdateAll()>>session is null!");
			}
			tx = session.beginTransaction();
			session.saveOrUpdate(entities);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "saveOrUpdateAll()>>session is null!");
		}
	}

	@Override
	public void flush() throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("flush()>>session is null!");
				new OperationException("000001", "flush()>>session is null!");
			}
			tx = session.beginTransaction();
			session.flush();
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "flush()>>session is null!");
		}
	}

	@Override
	public void evict(T entity) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("evict()>>session is null!");
				new OperationException("000001", "evict()>>session is null!");
			}
			tx = session.beginTransaction();
			session.evict(entity);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "evict()>>session is null!");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> createQuery(String hql) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		Query query = null;
		
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("createQuery()>>session is null!");
				new OperationException("000001", "createQuery()>>session is null!");
			}
			tx = session.beginTransaction();
			query = session.createQuery(hql);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "createQuery()>>session is null!");
		}
		
		return query.list();
	}
	
	@Override
	public Criteria createCriteria() throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		Criteria criteria = null;
		
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("createSQLQuery()>>session is null!");
				new OperationException("000001", "createSQLQuery()>>session is null!");
			}
			tx = session.beginTransaction();
			criteria = session.createCriteria(clazz);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "createSQLQuery()>>session is null!");
		}
		
		return criteria;
	}

	@Override
	public SQLQuery createSQLQuery(String sql) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		SQLQuery sqlQuery = null;
		
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("createSQLQuery()>>session is null!");
				new OperationException("000001", "createSQLQuery()>>session is null!");
			}
			tx = session.beginTransaction();
			sqlQuery = session.createSQLQuery(sql);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "createSQLQuery()>>session is null!");
		}
		
		return sqlQuery;
	}
	
	@Override
	public List<T> findByPage(String sql, int firstRow, int maxRow) throws OperationException
	{
		Session session = null;
		Transaction tx = null;
		SQLQuery sqlQuery = null;
		
		try
		{
			session = HSessionUtils.getSession();
			if (null == session)
			{
				logger.error("createSQLQuery()>>session is null!");
				new OperationException("000001", "createSQLQuery()>>session is null!");
			}
			tx = session.beginTransaction();
			sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setFirstResult(firstRow);
			sqlQuery.setMaxResults(maxRow);
			tx.commit();
			session.close();
		}
		catch (Exception e)
		{
			if (session != null && tx != null)
			{
				tx.rollback();
			}
			new OperationException("000001", "createSQLQuery()>>session is null!");
		}
		
		return sqlQuery.list();
	}

}