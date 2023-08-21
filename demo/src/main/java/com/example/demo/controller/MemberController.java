package com.example.demo.controller;

import com.example.demo.domain.MemberVO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/members")
    public String getMemberList(Model model) {
        List<MemberVO> memberList = memberService.getMemberList();
        model.addAttribute("member", memberList);
        return "board/list";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "board/newregistration"; // 사용자 등록 화면으로 이동
    }

    @PostMapping("/register")
    public String registerMember(@RequestParam("name") String name, @RequestParam("email") String email) {
        MemberVO member = new MemberVO();
        member.setName(name);
        member.setEmail(email);
        memberService.registerMember(member);

        return "redirect:/members";
    }

//    @GetMapping("/members/modifypage/{id}")
//    public String showModifyPage(@PathVariable("id") int id, Model model) {
//        MemberVO member = memberService.getMemberById(id);
//       System.out.println(member);
//        model.addAttribute("member", member);
//        return "board/modifypage";
//    }

    @GetMapping("/members/modifypage/{id}")
    public String showModifyPage(@PathVariable("id") int id, Model model) {
        System.out.println("ID received: " + id); // Add this line for debugging
        MemberVO member = memberService.getMemberById(id);
        model.addAttribute("member", member);
        return "board/modifypage";
    }

    @PostMapping("/members/update")
    public String updateMember(@ModelAttribute MemberVO member) {
        memberService.updateMember(member);
        return "redirect:/members"; // Redirect to user list page
    }

    @GetMapping("/members/delete/{id}")
    public String deleteMember(@PathVariable("id") int id) {
        memberService.delete(id);
        return "redirect:/members"; // Redirect to user list page after deletion
    }
}

