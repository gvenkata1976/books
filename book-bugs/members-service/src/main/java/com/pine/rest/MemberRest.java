package com.pine.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pine.util.LoggerUtil;
import com.pine.documents.Member;
import com.pine.repo.MemberRepository;

@RestController
public class MemberRest {

  @Autowired
  private MemberRepository repo;

  @RequestMapping(method = RequestMethod.GET, value = "/list")
  public List<Member> list() {
    return repo.findAll();
  }
  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public List<Member> search(@RequestBody Member member) {
    return repo.findAll(Example.of(member));
  }
  @RequestMapping(method = RequestMethod.POST, value = "/save")
  public @ResponseBody Member add(@RequestBody Member member) {
    return repo.save(member);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/update")
  public @ResponseBody Member update(@RequestBody Member member) {
    return repo.save(member);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
  public void delete(@RequestBody Member member) { 
    repo.delete(member);
  }

  @ExceptionHandler
  public void handleException(Exception ex) {
    LoggerUtil.error("Exception: ", ex);
  }
}
