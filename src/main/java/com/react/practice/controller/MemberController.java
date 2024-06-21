package com.react.practice.controller;

import com.react.practice.dto.MemberDTO;
import com.react.practice.repository.MemberRepository;
import com.react.practice.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


//회원 관리 컨트롤러
@Controller
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;



    //회원가입 폼
    @GetMapping("/member/signup")
    public String singupFrom(){
        return "member/signup";
    }

    //회원가입 아이디 중복 확인
    @PostMapping("/member/signup")
        public String signup(@ModelAttribute MemberDTO memberDTO, RedirectAttributes redirect) {
            boolean exist = memberService.MemberIdCheck(memberDTO.getMemberId());
            if(exist){;
                return "member/idDuplicate";
            }
            memberService.signup(memberDTO);
            return "member/signSuccess";
        }


    @GetMapping("/member/login")//로그인 폼
    public String loginForm(){
        return "member/login";
    }

    @PostMapping("member/index")//
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        MemberDTO result = memberService.login(memberDTO);
        if (result != null){
            session.setAttribute("LoginID", result.getMemberId());
            return "redirect:/";
        }else{
            return "member/loginFail";
        }
    }

    /*@RequestMapping("/member/error")
    public String error(){
        return "error";
    }*/

    @GetMapping("/member/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";

    }

}
