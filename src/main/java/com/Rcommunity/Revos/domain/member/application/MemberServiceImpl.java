package com.Rcommunity.Revos.domain.member.application;

import com.Rcommunity.Revos.domain.member.dto.MemberDto;
import com.Rcommunity.Revos.domain.member.entity.Member;
import com.Rcommunity.Revos.domain.member.entity.Role;
import com.Rcommunity.Revos.domain.member.entity.repository.MemberRepository;
import com.Rcommunity.Revos.global.exception.AppException;
import com.Rcommunity.Revos.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
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
                    .role(Role.User)
                    .build()
            );

            return "Success";
    }
}
