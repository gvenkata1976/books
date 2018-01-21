package com.actiweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.actiweb.common.utils.ActiwebException;

public class BaseSession {
  /**
   * @param factory
   * @return
   */
  protected Session beginTransaction(SessionFactory factory) {
    Session session = factory.openSession();
    session.beginTransaction();
    return session;
  }

  /**
   * @param session
   */
  protected void commitTransaction(Session session) {
    session.flush();
    session.getTransaction().commit();
  }

  /**
   * @param session
   * @param ex
   * @throws ActiwebException
   */
  protected void rollbackTransaction(String errorCode, Session session, Exception ex) throws ActiwebException {
    if (session.getTransaction() != null) {
      session.getTransaction().rollback();
    }
    throw new ActiwebException(errorCode, ex);
  }

  /**
   * @param session
   */
  protected void closeQuietly(Session session) {
    try {
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
