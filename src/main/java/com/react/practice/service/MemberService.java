package com.react.practice.service;

import com.react.practice.dto.MemberDTO;
import com.react.practice.entity.MemberEntity;
import com.react.practice.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Optional;

@Service
@RequiredArgsConstructor //생성자 생성
public class MemberService {

    //생성자 의존성 주입
    private final MemberRepository memberRepository;

    //회원가입 정보 저장
    public void signup(MemberDTO memberDTO) {
        //DTO > Entity
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);// JPA제공 메소드 save()
    }

    //로그인 기능
    public MemberDTO login(MemberDTO memberDTO) {
        //아이디 확인
        Optional<MemberEntity> byMemberId = memberRepository.findByMemberId(memberDTO.getMemberId());

        if (byMemberId.isPresent()){
            MemberEntity memberEntity = byMemberId.get();
            //비밀번호 확인
            if (memberEntity.getMemberPw().equals(memberDTO.getMemberPw())){
                MemberDTO dto = MemberDTO.toMemberDTD(memberEntity);
                return  dto;
            }else {
                return null;
            }
        }else {
            //id없는 경우
            return null;
        }

    }

    //아이디 중복 확인
    public boolean MemberIdCheck(String memberId){
        Optional<MemberEntity> existMember = memberRepository.findByMemberId(memberId);
        return existMember.isPresent();
    }




}