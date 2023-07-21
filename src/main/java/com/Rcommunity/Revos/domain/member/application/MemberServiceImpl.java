package com.Rcommunity.Revos.domain.member.application;

import com.Rcommunity.Revos.domain.member.dto.MemberDto;
import com.Rcommunity.Revos.domain.member.dto.UserSignResponse;
import com.Rcommunity.Revos.domain.member.entity.Member;
import com.Rcommunity.Revos.domain.member.entity.Role;
import com.Rcommunity.Revos.domain.member.entity.repository.MemberRepository;
import com.Rcommunity.Revos.global.exception.AppException;
import com.Rcommunity.Revos.global.exception.ErrorCode;
import com.Rcommunity.Revos.global.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtProvider jwtProvider;
    //
    public String register(MemberDto memberDto) throws Exception{

        // 중복 처리
        if(memberRepository.existsByEmail(memberDto.getEmail())){
            throw new AppException(ErrorCode.USERNAME_DUPLICATED, memberDto.getEmail() + " 은 이미 가입하셨습니다.");
        }

        memberRepository.save(Member.builder()
                    .email(memberDto.getEmail())
                    .password(bCryptPasswordEncoder.encode(memberDto.getPassword()))
                    .name(memberDto.getPassword())
                    .role(Role.USER)
                    .build()
            );

            return "Success";
    }
    public UserSignResponse login(MemberDto request) throws Exception {
        Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));

        if (!bCryptPasswordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        }

        return UserSignResponse.builder()
                .id(Long.valueOf(member.getId()))
                .email(member.getEmail())
                .name(member.getName())
                .roles(Collections.singletonList(member.getRole()))
                .token(jwtProvider.createToken(member.getEmail(), Collections.singletonList(member.getRole())))
                .build();

    }

}
