/**
 * Created by luo on 27/02/2017.
 */
$(document).ready(function () {
    var checkInfoValid = function () {
        var strmg=register.signInKey.value;
        var pass=register.signInPasswd.value;
        if(strmg=="" ||  pass=="")
        {
            alert("用户名或密码为空,请输入用户名和密码...");
            return false;
        } else {
            return true;
        }
    }
    var commitUserInfo = function () {
        $("#submitUserinfo").click(function(){
            var request = {
                "signInKey":$("#signInKey").val(),
                "signInPasswd":$("#signInPasswd").val(),
                "signInType":"mail"
            };
            console.log(request);
            $.ajax({
                url:"user/signin",
                type:"post",
                contentType:"application/json",
                data:JSON.stringify(request),
                success: function(responseObj) {
                    var status = responseObj.status;
                    var isLegal = responseObj.data.isLegal;
                    var signInMessage = responseObj.data.signInMessage;
                    if(status == "success") {
                        if(isLegal == "YES") {
                            alert(signInMessage);
                        }else {
                            alert(signInMessage);
                        }
                    } else {
                        alert("后台异常,"+ responseObj.error.errorMessage);
                    }
                    console.log(jsonString);
                }
                // 数据请求异常,可以补充
            });
        });
    };
    // checkInfoValid();
    commitUserInfo();
});
