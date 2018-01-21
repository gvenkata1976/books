package com.actiweb.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.dao.IBaseDao;
import com.actiweb.entities.IBaseEntity;

public class BaseDao extends BaseSession implements IBaseDao {
  @Autowired
  private SessionFactory factory;

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IBaseDao#count(org.hibernate.criterion.DetachedCriteria)
   */
  @Override
  public Long count(DetachedCriteria criteria) throws ActiwebException {
    Session session = beginTransaction(getFactory());
    Long count = null;
    try {
      Criteria c = criteria.getExecutableCriteria(session);
      c.setProjection(Projections.rowCount());
      count = (Long) c.uniqueResult();
      commitTransaction(session);
    } catch (Exception e) {
      rollbackTransaction("ERR_ACW_01", session, e);
    } finally {
      closeQuietly(session);
    }
    return count;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IBaseDao#fetch(org.hibernate.criterion.DetachedCriteria)
   */
  @Override
  public List<?> fetch(DetachedCriteria criteria) throws ActiwebException {
    Session session = beginTransaction(getFactory());
    List<?> list = null;
    try {
      Criteria c = criteria.getExecutableCriteria(session);
      list = c.list();
      commitTransaction(session);
    } catch (Exception e) {
      rollbackTransaction("ERR_ACW_02", session, e);
    } finally {
      closeQuietly(session);
    }

    return list;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IBaseDao#fetch(java.lang.String)
   */
  @Override
  public List<?> fetch(DetachedCriteria criteria, int start, int size) throws ActiwebException {
    Session session = beginTransaction(getFactory());
    List<?> list = null;
    try {
      Criteria c = criteria.getExecutableCriteria(session);
      c.setFirstResult(start);
      c.setMaxResults(size);
      list = c.list();
      commitTransaction(session);
    } catch (Exception e) {
      rollbackTransaction("ERR_ACW_03", session, e);
    } finally {
      closeQuietly(session);
    }

    return list;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IBaseDao#fetch(java.lang.String,
   * com.actiweb.entities.IBaseEntity)
   */
  @Override
  public List<?> fetch(IBaseEntity e, DetachedCriteria criteria) throws ActiwebException {
    Session session = beginTransaction(getFactory());
    List<?> list = null;
    try {
      list = (List<?>) criteria.getExecutableCriteria(session).add(Example.create(e)).list();
      commitTransaction(session);
    } catch (Exception ex) {
      rollbackTransaction("ERR_ACW_04", session, ex);
    } finally {
      closeQuietly(session);
    }
    return list;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IBaseDao#addEntity(com.actiweb.entities.IBaseEntity)
   */
  public void addEntity(IBaseEntity e) throws ActiwebException {
    Session session = beginTransaction(factory);
    try {
      session.save(e);
      commitTransaction(session);
    } catch (Exception ex) {
      rollbackTransaction("ERR_ACW_05", session, ex);
    } finally {
      closeQuietly(session);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IBaseDao#updateEntity(com.actiweb.entities.IBaseEntity)
   */
  public void updateEntity(IBaseEntity e) throws ActiwebException {
    Session session = beginTransaction(factory);
    try {
      session.update(e);
      commitTransaction(session);
    } catch (Exception ex) {
      rollbackTransaction("ERR_ACW_06", session, ex);
    } finally {
      closeQuietly(session);
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IBaseDao#deleteEntity(com.actiweb.entities.IBaseEntity)
   */
  public void deleteEntity(IBaseEntity e) throws ActiwebException {
    Session session = beginTransaction(factory);
    try {
      session.delete(e);
      commitTransaction(session);
    } catch (Exception ex) {
      rollbackTransaction("ERR_ACW_07", session, ex);
    } finally {
      closeQuietly(session);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IBaseDao#addAll(java.util.List)
   */
  public void addAll(List<IBaseEntity> list) throws ActiwebException {
    Session session = beginTransaction(factory);
    try {
      for (Iterator<IBaseEntity> iterator = list.iterator(); iterator.hasNext();) {
        IBaseEntity iBaseEntity = (IBaseEntity) iterator.next();
        session.save(iBaseEntity);
      }
      commitTransaction(session);
    } catch (Exception ex) {
      rollbackTransaction("ERR_ACW_08", session, ex);
    } finally {
      closeQuietly(session);
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IBaseDao#updateAll(java.util.List)
   */
  public void updateAll(List<IBaseEntity> list) throws ActiwebException {
    Session session = beginTransaction(factory);
    try {
      for (Iterator<IBaseEntity> iterator = list.iterator(); iterator.hasNext();) {
        IBaseEntity iBaseEntity = (IBaseEntity) iterator.next();
        session.update(iBaseEntity);
      }
      commitTransaction(session);
    } catch (Exception ex) {
      rollbackTransaction("ERR_ACW_09", session, ex);
    } finally {
      closeQuietly(session);
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IBaseDao#deleteAll(java.util.List)
   */
  public void deleteAll(List<IBaseEntity> list) throws ActiwebException {
    Session session = beginTransaction(factory);
    try {
      for (Iterator<IBaseEntity> iterator = list.iterator(); iterator.hasNext();) {
        IBaseEntity iBaseEntity = (IBaseEntity) iterator.next();
        session.delete(iBaseEntity);
      }
      commitTransaction(session);
    } catch (Exception ex) {
      rollbackTransaction("ERR_ACW_10", session, ex);
    } finally {
      closeQuietly(session);
    }

  }

  /**
   * @return
   */
  public SessionFactory getFactory() {
    return factory;
  }

  /**
   * @param factory
   */
  public void setFactory(SessionFactory factory) {
    this.factory = factory;
  }
}
