package org.system.domain.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.system.domain.exception.OperationException;

public interface HibernateEntityDao<T extends Serializable,PK extends Serializable> {
	
	//根据主键获取实体
	public T getById(PK id) throws OperationException;
	
	//获取所有实体
	public List<T> getAll() throws OperationException;
    
	//根据属性获取实体
    public List<T> getByProperty(String propertyName,Object value) throws OperationException;
    
    //根据多个属性获取实体
    public List<T> getByproperties(Map<String,String> criterias) throws OperationException;
    
    //根据属性获取唯一值
    public T unique(String propertyName,Object value) throws OperationException;
    
    //获取实体总数
    public Long getSize() throws OperationException;
	
    //保存指定实体
	public void save(T entity) throws OperationException;
	
	//删除指定实体
    public void delete(T entity) throws OperationException;
   
    //更新指定实体
    public void update(T entity) throws OperationException;
   
    //保存或者更新实体
    public void saveOrUpdate(T entity) throws OperationException;
    
    //增加或更新集合中的全部实体
    public void saveOrUpdateAll(Collection<T> entities);
    
    //强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
    public void flush() throws OperationException;
    
    //
    public void evict(T entity) throws OperationException;
    
    //支持HQL查询
    public List<T> createQuery(String hql) throws OperationException;
    
    //支持QBC查询 QBC:Query By Criteria
    public Criteria createCriteria() throws OperationException;
    
    //执行普通SQL
    public SQLQuery createSQLQuery(String sql) throws OperationException;
    
    //分页查询
    public List<T> findByPage(final String sql, final int firstRow, final int maxRow) throws OperationException;
}
