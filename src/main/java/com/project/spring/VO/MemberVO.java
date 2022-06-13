package com.project.spring.VO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MemberVO {

    @NotNull
    private String userId;

    @NotBlank
    private String userPw;
    private String userEmail;
    private String userEmailCheck;
    private String userProfile;
    private String regDate;
    private String acctBan;
    @NotBlank
    private String userName;

    private String regPwConf;
}
