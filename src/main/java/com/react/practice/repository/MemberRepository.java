package com.react.practice.repository;

import com.react.practice.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    //Spring Data JPA
    Optional<MemberEntity> findByMemberId(String memberId);
    //사용자 아이디 찾기


}
