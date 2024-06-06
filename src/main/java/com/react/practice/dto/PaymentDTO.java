package com.react.practice.dto;


import com.react.practice.entity.BuyerEntity;
import com.react.practice.entity.MemberEntity;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString
public class PaymentDTO {

    private String imp_uid;
    private String merchant_uid;

    private String amount;

    @Builder
    public PaymentDTO(String imp_uid){
        this.imp_uid = imp_uid;
    }

}
