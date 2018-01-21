package com.actiweb.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.actiweb.common.utils.Constants;
import com.actiweb.common.utils.ActiwebException;
import com.actiweb.entities.IBaseEntity;

public interface IBaseDao extends Constants {

  public Long count(DetachedCriteria criteria) throws ActiwebException;

  @SuppressWarnings("rawtypes")
  public List fetch(DetachedCriteria criteria) throws ActiwebException;

  @SuppressWarnings("rawtypes")
  public List fetch(DetachedCriteria criteria, int start, int end) throws ActiwebException;

  @SuppressWarnings("rawtypes")
  public List fetch(IBaseEntity e, DetachedCriteria criteria) throws ActiwebException;

  public void addEntity(IBaseEntity e) throws ActiwebException;

  public void updateEntity(IBaseEntity e) throws ActiwebException;

  public void deleteEntity(IBaseEntity e) throws ActiwebException;

  public void addAll(List<IBaseEntity> list) throws ActiwebException;

  public void updateAll(List<IBaseEntity> list) throws ActiwebException;

  public void deleteAll(List<IBaseEntity> list) throws ActiwebException;

}
