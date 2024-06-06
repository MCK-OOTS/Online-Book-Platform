package com.react.practice.dto;

import com.react.practice.entity.MemberEntity;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor //기본생성자
@AllArgsConstructor //필드값 생성자
@ToString
public class MemberDTO {
    private String memberName;
    private String memberId;
    private String memberPw;
    private String memberPhone;

    public static MemberDTO toMemberDTD(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberId(memberEntity.getMemberId());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberPw(memberEntity.getMemberPw());
        memberDTO.setMemberPhone(memberEntity.getMemberPhone());

        return memberDTO;
    }

}
