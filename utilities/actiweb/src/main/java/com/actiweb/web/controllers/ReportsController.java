package com.actiweb.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.actiweb.entities.Employee;
import com.actiweb.service.IEmployeeService;

@Controller
public class ReportsController extends BaseMultiActionController {
  private static final String TABNAME = "Reports";
  @Autowired
  private IEmployeeService service;

  public ReportsController() {

  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  public ModelAndView reset(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    List<Employee> list = null;
    Employee employee = null;
    ModelAndView mv = new ModelAndView();
    String id = request.getParameter("employeeId");

    employee = new Employee();
    employee.setEmployeeId(Long.valueOf(id));
    list = service.fetchEmployees(employee);
    if (list != null && list.size() == 1) {
      employee = list.get(0);
    }
    mv.addObject("activeTab", TABNAME);

    mv.addObject("employee", employee);
    mv.setViewName("employeeDetails");
    return mv;
  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  public ModelAndView add(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    ModelAndView mv = new ModelAndView();
    Employee employee = getEmployee(request);

    print(employee);
    service.addEmployee(employee);
    mv.addObject("msg", "Added successfully");
    mv.addObject("activeTab", TABNAME);

    mv.addObject("employee", employee);
    mv.setViewName("addEditEmployee");
    return mv;

  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    ModelAndView mv = reset(request, response, command);
    Employee employee = getEmployee(request);
    service.deleteEmployee(employee);
    mv.addObject("msg", "Deleted successfully");
    mv.addObject("activeTab", TABNAME);
    mv.addObject("employee", null);
    mv.setViewName("addEditEmployee");
    return mv;

  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  public ModelAndView update(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    Employee employee = getEmployee(request);
    ModelAndView mv = new ModelAndView();
    log.info("ReportController ::update..");
    print(employee);
    service.updateEmployee(employee);
    mv.addObject("message", "Updated");
    mv.addObject("activeTab", TABNAME);
    mv.addObject("employee", employee);
    mv.setViewName("addEditEmployee");
    return mv;

  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    Employee employee = null;
    String id = request.getParameter("id");
    ModelAndView mv = new ModelAndView();

    log.info("ReportController ::Select employee for id:" + id);
    if ("0".equals(id)) {
      employee = getEmployee(request);
    } else {
      employee = service.fetchEmployeeById(id);
    }
    mv.addObject("msg", "Select for Edit");
    mv.addObject("activeTab", TABNAME);
    print(employee);

    mv.addObject("employee", employee);
    mv.setViewName("addEditEmployee");
    return mv;
  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  public ModelAndView showChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ModelAndView mv = new ModelAndView();
    List<String> hy = service.getHierarchy();
    mv.addObject("activeTab", TABNAME);
    mv.addObject("hierarchy", hy);
    mv.setViewName("showChart");
    return mv;
  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    ModelAndView mv = new ModelAndView();
    List<Employee> list = null;
    log.info("ReportController list()..");

    list = service.fetchEmployees();
    mv.addObject("msg", "List");
    mv.addObject("activeTab", TABNAME);

    mv.setViewName("employeeDetails");
    mv.addObject("employees", list);
    mv.addObject("employee", list.get(0));
    return mv;
  }

  // filters
  // roles
  public IEmployeeService getService() {
    return service;
  }

  public void setService(IEmployeeService service) {
    this.service = service;
  }

  public ModelAndView refresh(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    return list(request, response, command);
  }

}
