package com.react.practice.entity;

import com.react.practice.dto.MemberDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.experimental.Accessors;


@Entity
@Setter
@Getter
@Table(name = "member")//테이블명
public class MemberEntity {
    @Id //pk
    private String memberId;

    @Column
    private String memberPw;

    @Column
    private String memberName;

    @Column(unique = true)
    private String memberPhone;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        //DTO > Entity
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberDTO.getMemberId());
        memberEntity.setMemberPw(memberDTO.getMemberPw());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberPhone(memberDTO.getMemberPhone());
        return memberEntity;

    }





}
