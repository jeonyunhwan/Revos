package com.Rcommunity.Revos.domain.member.entity.repository;

import com.Rcommunity.Revos.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Transactional
public interface MemberRepository extends JpaRepository<Member,Integer> {
    //중복 처리
    boolean existsByEmail(String email);

    //
    Optional<Member> findByEmail(String email);
}
