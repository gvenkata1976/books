package com.pine.rest.resource;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pine.documents.User;
import com.pine.repo.UserRepository;

@RestController
@RequestMapping("/admin/users")
public class UserResource extends BaseResource {

  @Autowired
  private UserRepository repo;
 
  @RequestMapping(method = RequestMethod.GET)
  public List<User> list() {
    return repo.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{userName}")
  public User get(@PathParam(value = "userName") String userName) {
    return repo.findByUserName(userName);
  }

  @RequestMapping(method = RequestMethod.POST)
  public @ResponseBody User add(@RequestBody User usr) {
    return repo.save(usr);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
  public @ResponseBody User update(@RequestBody User usr) {
    return repo.save(usr);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public void delete(@RequestBody User member) {
    repo.delete(member);
  }

}
