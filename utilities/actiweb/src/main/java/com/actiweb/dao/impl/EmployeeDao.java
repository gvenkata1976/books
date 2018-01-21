package com.actiweb.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.dao.BaseDao;
import com.actiweb.dao.IEmployeeDao;
import com.actiweb.entities.Employee;

@Repository("employeeDao")
public class EmployeeDao extends BaseDao implements IEmployeeDao {

  @SuppressWarnings("unchecked")
  public List<String> getHierarchy() {
    String qry = "SELECT SYS_CONNECT_BY_PATH(last_name, '/') \"Path\""
        + "  FROM employee  start with manager_id is null CONNECT BY NOCYCLE PRIOR employee_id = manager_id ";
    Session session = beginTransaction(getFactory());
    List<String> list = null;
    try {
      list = (List<String>) session.createNativeQuery(qry).list();
      commitTransaction(session);
    } catch (Exception e) {
      log.error("Exception:", e);
      rollbackTransaction("ERR_ACW_EMP_01", session, e);
    }
    return list;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IEmployeeDao#fetchEmployees(int, int)
   */
  public Long countEmployees() {
    Long count = null;
    DetachedCriteria dc = getEmployeeCriteria();
    count = count(dc);
    return count;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IEmployeeDao#fetchEmployees(int, int)
   */
  @SuppressWarnings("unchecked")
  public List<Employee> fetchEmployees() {
    List<Employee> list = null;
    DetachedCriteria dc = getEmployeeCriteria();
    list = (List<Employee>) fetch(dc);
    return list;
  }

  /**
   * @return
   * @throws ActiwebException
   */
  @SuppressWarnings("unchecked")
  public List<Employee> fetchEmployees(int start, int size) {
    DetachedCriteria dc = getEmployeeCriteria();
    return (List<Employee>) fetch(dc, start, size);
  }

  /**
   * @return
   */
  private DetachedCriteria getEmployeeCriteria() {
    DetachedCriteria emp = DetachedCriteria.forClass(Employee.class, "emp");
    emp.createCriteria("emp.departmentId", "dept", JoinType.LEFT_OUTER_JOIN);
    emp.createCriteria("dept.locationId", "loc", JoinType.LEFT_OUTER_JOIN);
    emp.createCriteria("loc.countryId", "ctry", JoinType.LEFT_OUTER_JOIN);
    emp.createCriteria("ctry.regionId", "reg", JoinType.LEFT_OUTER_JOIN);
    return emp;
  }

  /**
   * @param e
   * @return
   * @throws ActiwebException
   */
  @SuppressWarnings("unchecked")
  public List<Employee> fetchEmployees(Employee e) {
    List<Employee> list = (List<Employee>) fetch(e, getEmployeeCriteria());
    return list;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.dao.IEmployeeDao#fetchEmployeeById(java.lang.String)
   */
  @SuppressWarnings("unchecked")
  @Override
  public Employee fetchEmployeeById(String employeeId) {
    Long empId = Long.valueOf(employeeId);
    Employee e = null;
    DetachedCriteria criteria = DetachedCriteria.forEntityName("com.actiweb.entities.Employee");
    criteria.add(Restrictions.eq("employeeId", empId));
    List<Employee> list = (List<Employee>) fetch(criteria);
    if (list != null && list.size() == 1) {
      e = list.get(0);
    }
    return e;
  } 
}
