package com.pine.rest.resource;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pine.documents.Member;
import com.pine.repo.MemberRepository;

@RestController
@RequestMapping("/admin/members")
public class MemberResource extends BaseResource {

  @Autowired
  private MemberRepository repo;

  @RequestMapping(method = RequestMethod.POST, value = "/search")
  public List<Member> search(@RequestBody Member mem) {
    return repo.findAll(Example.of(mem));
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Member> list() {
    return repo.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public Member get(@PathParam(value = "id") String id) {
    return repo.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public @ResponseBody Member add(@RequestBody Member member) {
    return repo.save(member);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
  public @ResponseBody Member update(@RequestBody Member member) {
    return repo.save(member);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public void delete(@RequestBody Member member) {
    repo.delete(member);
  }

}
