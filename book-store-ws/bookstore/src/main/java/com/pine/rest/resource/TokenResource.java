package com.pine.rest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pine.documents.SecuredUserDetails;
import com.pine.documents.User;
import com.pine.service.MongoSecurityService;

@RestController
@RequestMapping("/token")
public class TokenResource extends BaseResource {
  @Autowired
  MongoSecurityService service;

  @RequestMapping(method = RequestMethod.POST)
  public @ResponseBody User login(@RequestBody User user) throws Exception {
    SecuredUserDetails userDetail = (SecuredUserDetails) service.loadUserByUsername(user.getUserName());
    return userDetail.getUser();
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public void logout(@RequestBody User user) {

  }

}
