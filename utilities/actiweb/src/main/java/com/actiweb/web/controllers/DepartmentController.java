package com.actiweb.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.actiweb.entities.Department;
import com.actiweb.service.IDepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseMultiActionController {

  @Autowired
  private IDepartmentService service;

  public DepartmentController() {

  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping("/reset")
  public ModelAndView reset(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    Department d = null;
    ModelAndView mv = new ModelAndView();
    String departmentId = request.getParameter("departmentId");
    try {
      d = service.fetchDepartmentById(departmentId);
    } catch (Exception e) {
      mv.addObject("msg", "Failed to List Employees");
      log.error("ERR_ACW_DPT_01", e); 
    }
    mv.addObject("Department", d);
    mv.setViewName("departmentDetails");
    return mv;
  }

  /**
   * @param request
   * @return
   */
  private Department getDepartment(HttpServletRequest request) {
    Department d = new Department();
    return d;
  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping("/add")
  public ModelAndView add(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    ModelAndView mv = new ModelAndView();
    Department d = getDepartment(request);
    try {
      print(d);
      service.addDepartment(d);
      mv.addObject("msg", "Added successfully");
    } catch (Exception e1) {
      mv.addObject("msg", "Failed to Add ");
      log.error("ERR_ACW_DPT_02", e1);
    }

    mv.addObject("department", d);
    mv.setViewName("addEditEmployee");
    return mv;

  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping("/delete")
  public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    ModelAndView mv = reset(request, response, command);
    Department d = getDepartment(request);

    try {
      service.deleteDepartment(d);
      mv.addObject("msg", "Deleted successfully");
    } catch (Exception e1) {
      mv.addObject("msg", "Failed to delete ");
    }

    mv.addObject("department", null);
    mv.setViewName("addEditDepartment");
    return mv;

  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping("/update")
  public ModelAndView update(HttpServletRequest request, HttpServletResponse response, Object command)
      throws Exception {
    Department d = getDepartment(request);
    ModelAndView mv = new ModelAndView();
    log.info("OrganizationController update..");
    try {
      print(d);
      service.updateDepartment(d);
      mv.addObject("msg", "Updated");

    } catch (Exception e1) {
      mv.addObject("msg", "Failed to Update Transaction");
      log.error("ERR_ACW_DPT_03", e1);
    }

    mv.addObject("department", d);
    mv.setViewName("addEditEmployee");
    return mv;

  }

  /**
   * @param employee
   */
  private void print(Department d) {

    StringBuffer sb = new StringBuffer();
    sb.append(
        "\n\n========================================================================================================\n");
    sb.append("| Department Id | Location | Country | Region  ");
    sb.append(
        "\n==========================================================================================================\n");
    sb.append("|").append(d.getDepartmentId());
    sb.append("|").append(d.getLocationId().getLocationId());
    sb.append("|").append(d.getLocationId().getCountryId().getCountryId());
    sb.append("|").append(d.getLocationId().getCountryId().getRegionId().getRegionId());
    sb.append("\n")
        .append("==============================================================================================\n\n");
    log.info(sb.toString());
  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping("/edit")
  public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    Department d = null;
    String id = request.getParameter("id");
    ModelAndView mv = new ModelAndView();
    try {
      log.info("Select department for id:" + id);
      d = service.fetchDepartmentById(id);
      mv.addObject("msg", "Select for Edit");
      print(d);
    } catch (Exception e) {
      mv.addObject("msg", "Failed to fetch departments ");
      log.error("ERR_ACW_DPT_04", e);
    }
    mv.addObject("department", d);
    mv.setViewName("addEditDepartment");
    return mv;
  }

  /**
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @RequestMapping("/list")
  public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
    ModelAndView mv = new ModelAndView();
    List<Department> list = null;
    log.info("OrganizationController list()..");
    try {
      list = service.fetchDepartments();
      mv.addObject("msg", "Listed");
    } catch (Exception e) {
      mv.addObject("msg", "Failed to fetch departments ");
      log.error("ERR_ACW_DPT_05", e);
    }

    mv.setViewName("departmentDetails");
    mv.addObject("departments", list);
    return mv;
  }

  // filters
  // roles
  public IDepartmentService getService() {
    return service;
  }

  public void setService(IDepartmentService service) {
    this.service = service;
  }

}
