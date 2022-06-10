package com.project.spring.VO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberVO {
    private String userId;
    private String userPw;
    private String userEmail;
    private String userEmailCheck;
    private String userProfile;
    private String regDate;
    private String acctBan;
    private String userName;

    private String regPwConf;
}
