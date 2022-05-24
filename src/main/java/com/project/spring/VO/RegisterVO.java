package com.project.spring.VO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterVO {
    private String userId;
    private String nickName;
    private String userPw;
    private String userEmail;
    private String userEmailCheck;
    private String userProfile;
    private String regDate;
    private String acctBan;
}
