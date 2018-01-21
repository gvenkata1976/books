package com.actiweb.web.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.common.utils.Constants; 
import com.actiweb.entities.Department;
import com.actiweb.entities.Employee;

import common.util.date.DateUtil;
import common.util.lang.StringUtil;

public class BaseMultiActionController implements Constants {
  /**
   * @param request
   * @return
   */
  protected Employee getEmployee(HttpServletRequest request) {
    Employee e = new Employee();
    e.setFirstName(getRequestParameter(request, "firstName", ""));
    e.setEmployeeId(Long.valueOf(getRequestParameter(request, "employeeId", "0")));
    e.setEmail(getRequestParameter(request, "email", ""));
    e.setLastName(getRequestParameter(request, "lastName", ""));
    e.setPhoneNumber(getRequestParameter(request, "phoneNumber", ""));
    Date hireDate = getDate(getRequestParameter(request, "hireDate", ""));
    e.setHireDate(hireDate);
    e.setJobId(getRequestParameter(request, "jobId", "0"));
    e.setSalary(Double.valueOf(getRequestParameter(request, "salary", "0")));
    e.setCommissionPct(Double.valueOf(getRequestParameter(request, "commissionPct", "0")));
    e.setManagerId(Long.valueOf(getRequestParameter(request, "managerId", "0")));
    Department d = new Department();
    d.setDepartmentId(Long.valueOf(getRequestParameter(request, "departmentId.departmentId", "0")));
    e.setDepartmentId(d);
    return e;
  }

  /**
   * @param request
   * @param paramName
   * @param defaultValue
   * @return
   */
  protected String getRequestParameter(HttpServletRequest request, String paramName, String defaultValue) {

    String value = "";
    if (request != null) {
      value = request.getParameter(paramName);
    }
    value = StringUtil.trimToDefault(value, defaultValue);

    return value;
  }

  /**
   * @param parameter
   * @return
   */
  protected Date getDate(String parameter) {
    return DateUtil.parse(parameter, DATE_FORMAT_YYYY_MM_DD_HHmmss);
  }
   
  /**
   * @param employee
   */
  protected void print(Employee employee) {

    StringBuffer sb = new StringBuffer();
    sb.append(
        "\n\n========================================================================================================\n");
    sb.append(
        "EmployeeId | Email | FirstName | LastName | PhoneNumber | Commission% | Hire Date | Manager Id | Department Id");
    sb.append(
        "\n==========================================================================================================\n");
    sb.append("|").append(employee.getEmployeeId());
    sb.append("|").append(employee.getEmail());
    sb.append("|").append(employee.getFirstName());
    sb.append("|").append(employee.getLastName());
    sb.append("|").append(employee.getPhoneNumber());
    sb.append("|").append(employee.getCommissionPct());
    sb.append("|").append(employee.getHireDate());
    sb.append("|").append(employee.getManagerId());
    if (employee.getDepartmentId() != null) {
      sb.append("|").append(employee.getDepartmentId().getDepartmentId());
      /*
       * sb.append("|").append(
       * employee.getDepartmentId().getLocationId().getLocationId());
       * sb.append("|").append(
       * employee.getDepartmentId().getLocationId().getCountryId().
       * getCountryId()); sb.append("|").append(
       * employee.getDepartmentId().getLocationId().getCountryId().
       * getRegionId().getRegionId());
       */
    }
    sb.append("\n")
        .append("==============================================================================================\n\n");
    log.info(sb.toString());
  }

  @ExceptionHandler(ActiwebException.class)
  public ModelAndView handleException(ActiwebException ex) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("msg", "Exception occured ");
    mv.addObject("errorCode", ex.getErrorCode());
    mv.addObject("errorMessage", ex.getMessage());
    mv.addObject("cause", ex);
    log.error("Exception occured :", ex);
    return mv;
  }  
}
