package org.system.dao.hibernate.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.system.dao.hibernate.persistence.Order;
import org.system.domain.exception.OperationException;
import org.system.domain.hibernate.HibernateGenericDao;
/**
 * http://blog.csdn.net/u013433821/article/details/48731367
 * @author Administrator
 *
 */
public class OrderHibernate extends HibernateGenericDao<Order, Integer> implements OrderDao {

	@Override
	public Order getById(Integer id) throws OperationException {
		// TODO Auto-generated method stub
		return this.getById(id);
	}

	@Override
	public List<Order> getAll() throws OperationException {
		// TODO Auto-generated method stub
		return this.getAll();
	}

	@Override
	public List<Order> getByProperty(String propertyName, Object value) throws OperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getByproperties(Map<String, String> criterias) throws OperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order unique(String propertyName, Object value) throws OperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getSize() throws OperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Order entity) throws OperationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Order entity) throws OperationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Order entity) throws OperationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrUpdate(Order entity) throws OperationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrUpdateAll(Collection<Order> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void flush() throws OperationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void evict(Order entity) throws OperationException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Order> createQuery(String sql) throws OperationException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criteria createCriteria() throws OperationException
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public SQLQuery createSQLQuery(String sql) throws OperationException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByPage(String sql, int firstRow, int maxRow) throws OperationException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
