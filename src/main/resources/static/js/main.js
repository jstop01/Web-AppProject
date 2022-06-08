function pageMove(pageNumber) {
    // 1 회원가입 / 2 로그인
    if(pageNumber === "1") {
        location.href="/register";
    } else if(pageNumber === "2") {
        location.href="/login";
    }
}