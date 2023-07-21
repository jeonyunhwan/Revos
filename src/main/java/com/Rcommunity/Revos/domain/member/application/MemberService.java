package com.Rcommunity.Revos.domain.member.application;

import com.Rcommunity.Revos.domain.member.dto.MemberDto;
import com.Rcommunity.Revos.domain.member.dto.UserSignResponse;
import com.Rcommunity.Revos.domain.member.entity.repository.MemberRepository;
import org.springframework.stereotype.Service;


public interface MemberService {
    public String register(MemberDto memberDto) throws Exception;
    public UserSignResponse login(MemberDto request) throws Exception;
}
