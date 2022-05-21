//form에 있는 데이터 가져오기
$.fn.serializeObject = function () {
    var result = {}
    var extend = function (i, element) {
        var node = result[element.name]
        if ("undefined" !== typeof node && node !== null) {
            if ($.isArray(node)) {
                node.push(element.value)
            } else {
                result[element.name] = [node, element.value]
            }
        } else {
            result[element.name] = element.value
        }
    }

    $.each(this.serializeArray(), extend)
    return result
}


function saveUserInfo() {
    debugger
    var param = $("#signUp").serializeObject();
    debugger
    $.ajax({
        url: '/saveUser',
        type: 'POST',
        data: {'param': param},
        success: function (data) {
            alert(data)
        },
        error: function (err) {

        }
    })
};

$(function () {

    $("form").on("submit", function (e) {
        e.preventDefault();
        var $form = $(this).closest("form");
        var formData = $form.serializeObject();

        $("section div:eq(0)").append('<div id="d-spin" class="spinner-border">');
        $.ajax({
            type: $form.attr("method"),
            dataType: 'json',
            contentType: "application/json",
            data: JSON.stringify(formData),
            url: $form.attr("action"),
            beforeSend: function (xhr) {
                xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
            },
            success: function (res) {
                $("#d-spin").remove();
                if (res.duplicate) {
                    $.notify("중복된 이메일 입니다.");
                    $("input[name='email']").val("");
                    $("input[name='email']").focus();
                } else if (res.success) {
                    $.notify("회원 가입 완료되었습니다.");
                    setTimeout(function () {
                        window.location = document.referrer
                    }, 800);
                } else {
                    $("#d-spin").hide();
                    $.notify("crud fail");
                }
            },
            error: function (error) {
                alert(error.errorMsg);
            }
        });
    });

    $("#btn_loginForm").on("click", function () {
        location.href = document.referrer;
    });

});


