package com.Rcommunity.Revos.domain.member.dto;


import com.Rcommunity.Revos.domain.member.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private Long id;
    private String email;
    private String name;
    private String password;
    private Role role;
}
