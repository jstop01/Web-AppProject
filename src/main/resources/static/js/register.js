// $(document).ready(function() {
//     // 모두 로딩되었을때
//     $("#loginId").on("propertychange change keyup paste input", function() {
//         var userID = $("#loginId").val();
//         alert(userID);
//         $.ajax({
//             type : "POST",
//             url : "/idOverlapCheck",
//
//             data : {
//                 userId : userID
//             },
//             success : function (data) {
//             },
//             error : function (data) {
//             }
//         })
//     });
// });