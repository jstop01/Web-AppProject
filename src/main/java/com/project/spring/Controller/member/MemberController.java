package com.project.spring.Controller.member;

import com.project.spring.VO.MemberVO;
import com.project.spring.VO.UploadFileVO;
import com.project.spring.service.RegisterService;
import com.project.spring.service.file.UploadFileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    RegisterService registerService;

    @Autowired
    UploadFileService uploadFileService;

    private static Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @GetMapping("/login")
    public String loginMove(Model model) {
        return "login";
    }

    @PostMapping(value = "/loginAction")
    public String login(@ModelAttribute MemberVO memberVO) {
        //로그인 로직 구현
        return "";
    }

    @GetMapping("/register")
    public String signUpMove(Model model) {
        model.addAttribute("memberVO", new MemberVO());
        model.addAttribute("uploadFileVO", new UploadFileVO());
        return "register";
    }

    @PostMapping(value = "/saveUser")
    public String saveUserInfo(@Validated @ModelAttribute MemberVO memberVO , BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model, @RequestPart(value = "uploadFile", required = false) MultipartFile files) throws IllegalStateException, IOException, Exception {

        addUserValidation(memberVO, bindingResult);
        if (bindingResult.hasErrors()){
            LOGGER.info("errors={}", bindingResult);
            return "register";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        memberVO.setRegDate(sdf.format(today));


        memberProfileInsert(files, memberVO);

        return "login";

    }


    public void addUserValidation(MemberVO memberVO, BindingResult bindingResult) {
        //사용자 이름 검증
        if(!StringUtils.hasText(memberVO.getUserName())) {
            /*bindingResult.addError(new FieldError("memberVO","userName",memberVO.getUserName(),false,new String[]{"required.memberVO.userName"},null,null));*/
            bindingResult.rejectValue("userName","required");
        }
        //사용자 아이디 검증
        if(!StringUtils.hasText(memberVO.getUserId())) {
            /*bindingResult.addError(new FieldError("memberVO","userId",memberVO.getUserId(),false,new String[]{"required.memberVO.userId"},null,null));*/
            bindingResult.rejectValue("userId","required");
        }
        int idCount = registerService.idOverlapCheck(memberVO);
        if(idCount>0) {
            bindingResult.addError(new FieldError("memberVO","userId","아이디 중복입니다."));
        }
        //사용자 비밀번호 검증
        if(!StringUtils.hasText(memberVO.getUserPw())) {
            /*bindingResult.addError(new FieldError("memberVO","userPw",memberVO.getUserPw(),false,new String[]{"required.memberVO.userPw"},null,null));*/
            bindingResult.rejectValue("userPw","required");
        }
        //사용자 이름 검증
        if(!StringUtils.hasText(memberVO.getUserPwConf())) {
            /*bindingResult.addError(new FieldError("memberVO","userPwConf",memberVO.getRegPwConf(),false,new String[]{"required.memberVO.regPwConf"},null,null));*/
            bindingResult.rejectValue("userPwConf","required");
        }
        if(!StringUtils.hasText(memberVO.getUserPw())) {
            /*bindingResult.addError(new FieldError("memberVO","userEmail",memberVO.getUserEmail(),false,new String[]{"required.memberVO.userEmail"},null,null));*/
            bindingResult.rejectValue("userEmail","required");
        }
    }


    public void memberProfileInsert(MultipartFile files,MemberVO memberVO) throws IllegalStateException, IOException, Exception {

        if(files.isEmpty()){ // 파일 데이터 비어 있는지지
            //memberVO.setUserProfile("C:/dev/image/defaultProfile.jpg"); //윈도우용
            memberVO.setUserProfile("/Users/ijaeseog/Desktop/dev/image/");//맥용
            memberVO.setUserProfile("/home/ljs/userProfile/deaultProfile.png");
            registerService.userRegister(memberVO);
       } else {
            String fileName = files.getOriginalFilename(); // 업로드한 파일의 이름을 구함
            String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();//확장자
            File destinationFile; //DB에 저장할 파일 고유명
            String destinationFileName;
            String fileUrl_Windows = "C:/dev/image/";//파일경로
            String fileUrl_Ubuntu = "/home/ljs/userProfile/";
            String fileUrl_Mac = "";

            do {
                destinationFileName = UUID.randomUUID().toString() + "." + fileNameExtension; // UUID와 파일 확장자 합침
                destinationFile = new File(fileUrl_Windows + destinationFileName); //파일 경로 + 파일명.확장자 합치기
            } while (destinationFile.exists());

            destinationFile.getParentFile().mkdir(); //디렉토리 생성
            files.transferTo(destinationFile); //업로드한 파일 데이터를 files에 저장

            UploadFileVO file = new UploadFileVO();
            file.setUploadFileName(destinationFileName);
            file.setOriginFileName(fileName);
            file.setFileUrl(fileUrl_Windows);
            file.setUserId(memberVO.getUserId());
            memberVO.setUserProfile(fileUrl_Windows+""+destinationFileName);  //윈도우용
            //memberVO.setUserProfile(fileUrl_Ubuntu+""+destinationFileName); //우분투용
            //memberVO.setUserProfile(fileUrl_Mac+""+destinationFileName);    //맥용

            uploadFileService.fileInsert(file);
            registerService.userRegister(memberVO);
        }


    }



}
