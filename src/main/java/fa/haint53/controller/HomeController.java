package fa.haint53.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fa.haint53.entities.User;
import fa.haint53.repository.MemberRepository;
import fa.haint53.service.MemberService;

@RestController
public class HomeController {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @GetMapping(value = {"/", "/home"})
    public List<User> user() {
        return memberRepository.findAll();
    }

    @GetMapping(value = "/save")
    public String save(@RequestBody User user) {
        System.out.println(user.toString());
        System.out.println(memberRepository.save(user));
        return "Success";
    }

    @GetMapping(value = "/error")
    public String getError() {
        System.out.println("asdsa");
        return "sadsdsa";
    }

    @GetMapping("delete/{id}")
    public Boolean deleteUser(@PathVariable("id") String id) throws Exception {

        try {
            return memberService.deleteUser(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id) {
        return memberRepository.findById(id);
    }

    @PostMapping("update")
    public User update(@RequestBody User user) throws Exception {
        return memberService.updateUser(user);
    }
}
