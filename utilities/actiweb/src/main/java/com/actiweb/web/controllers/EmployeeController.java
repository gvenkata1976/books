package com.actiweb.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.actiweb.entities.Employee;
import com.actiweb.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseMultiActionController {
  private static final String TABNAME = "Employee";
  @Autowired
  private IEmployeeService service;

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping("/reset.htm")
  public ModelAndView reset(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    List<Employee> list = null;
    Employee employee = null;

    String id = request.getParameter("employeeId");
    employee = new Employee();
    employee.setEmployeeId(Long.valueOf(id));
    list = service.fetchEmployees(employee);
    if (list != null && list.size() == 1) {
      employee = list.get(0);
    }
    ModelAndView mv = new ModelAndView();
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
  @RequestMapping("/add.htm")
  public ModelAndView add(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    ModelAndView mv = new ModelAndView();
    Employee employee = getEmployee(request);
    print(employee);
    service.addEmployee(employee);
    mv.addObject("msg", "Added successfully");
    mv.addObject("activeTab", "Employee");
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
  @RequestMapping("/delete.htm")
  public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    ModelAndView mv = reset(request, response, command);
    Employee employee = getEmployee(request);
    service.deleteEmployee(employee);
    mv.addObject("msg", "Deleted successfully");
    mv.addObject("activeTab", "Employee");
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
  @RequestMapping("/update.htm")
  public ModelAndView update(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    Employee employee = getEmployee(request);
    log.info("EmployeeController ::update..");
    print(employee);
    service.updateEmployee(employee);
    ModelAndView mv = new ModelAndView();
    mv.addObject("msg", "Updated");
    mv.addObject("activeTab", "Employee");
    mv.addObject("status", "success");
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
  @RequestMapping("/edit.htm")
  public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    Employee employee = null;
    String id = request.getParameter("id");
    log.info("EmployeeController ::Select employee for id:" + id);
    if ("0".equals(id)) {
      employee = getEmployee(request);
    } else {
      employee = service.fetchEmployeeById(id);
    }
    print(employee);
    ModelAndView mv = new ModelAndView();
    mv.addObject("msg", "Select for Edit");
    mv.addObject("activeTab", "Employee");
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
    List<String> hy = service.getHierarchy();
    ModelAndView mv = new ModelAndView();
    mv.addObject("activeTab", "Employee");
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
  @RequestMapping("/list.htm")
  public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {

    List<Employee> list = null;
    log.info("EmployeeController ::list()..");
    int pageNo = Integer.parseInt(getRequestParameter(request, "offset", "0"));
    Long count = service.countEmployees();
    int pageSize = 10;
    list = service.fetchEmployees(pageNo, pageSize);
    ModelAndView mv = new ModelAndView();
    mv.addObject("count", count);
    mv.addObject("offset", pageNo);
    mv.addObject("msg", "List of Employees");
    mv.addObject("activeTab", "Employee");
    mv.setViewName("employeeDetails");
    mv.addObject("employees", list);
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

  @RequestMapping("/refresh.htm")
  public ModelAndView refresh(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    return list(request, response, command);
  }

}
