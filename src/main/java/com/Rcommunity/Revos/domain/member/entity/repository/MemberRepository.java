package com.Rcommunity.Revos.domain.member.entity.repository;

import com.Rcommunity.Revos.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    //중복 처리
    boolean existsByEmail(String email);

}
