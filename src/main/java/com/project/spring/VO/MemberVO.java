package com.project.spring.VO;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class MemberVO {

    @NotNull @Size(max=15)
    private String userId;
    @NotNull @Size(max=20)
    @Pattern(regexp = "(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}")
    private String userPw;
    @NotNull @Email @Size(max=50)
    private String userEmail;
    private String userEmailCheck;

    private String userProfile;

    private String regDate;


    private String acctBan;
    @NotNull @Size(max=50)
    private String userName;
    @NotNull @Size(max=20)
    private String userPwConf;
}
