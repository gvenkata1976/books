package com.actiweb.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.dao.BaseDao;
import com.actiweb.dao.IDepartmentDao;
import com.actiweb.entities.Department;

@Repository("departmentDao")
public class DepartmentDao extends BaseDao implements IDepartmentDao {

  /**
   * @return
   */
  private DetachedCriteria getDepartmentCriteria() {
    DetachedCriteria emp = DetachedCriteria.forClass(Department.class, "dept");
    emp.createCriteria("dept.locationId", "loc", JoinType.LEFT_OUTER_JOIN);
    emp.createCriteria("loc.countryId", "ctry", JoinType.LEFT_OUTER_JOIN);
    emp.createCriteria("ctry.regionId", "reg", JoinType.LEFT_OUTER_JOIN);
    return emp;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Department> fetchDepartments() throws ActiwebException {
    List<Department> list = (List<Department>) fetch(getDepartmentCriteria());
    return list;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Department fetchDepartment(String departmentId) throws ActiwebException {
    Department d = null;
    DetachedCriteria criteria = DetachedCriteria.forEntityName("com.actiweb.entities.Department");
    criteria.add(Restrictions.eq("departmentId", departmentId));
    List<Department> list = (List<Department>) fetch(criteria);
    if (list != null && list.size() == 1) {
      d = list.get(0);
    }
    return d;
  }

}
