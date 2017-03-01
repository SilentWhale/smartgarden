/**
 * Created by luo on 27/02/2017.
 */

var checkInfoValid = function () {

    var strmg=register.username.value;
    var pass=register.password.value;
    if(strmg=="" ||  pass=="")
    {
        alert("用户名或密码为空,请输入用户名和密码...");
        return false;
    } else {
        return true;
    }
}
var commitUserInfo = function () {
    $("submitUserinfo").click(function(){
        var request = {
            "data":{
                "date": $("#dutyQueryDiv2 > #dutyDate2").val()
            }
        };
        console.log(request);
        $.ajax({
            url:"duty/query",
            type:"post",
            contentType:"application/json",
            data:JSON.stringify(request),
            success: function(responseObj) {
                var status = responseObj.status;
                var jsonString = JSON.stringify(responseObj);
                if(status == "success") {
                    updateTable(responseObj.data.dutyList);
                    $("#dutyArrangementList").show();
                } else {
                    alert("查询失败!" +"\n" + responseObj.errorMessage);
                }
                console.log(jsonString);
            }
        });
    });
};


$(document).ready(function () {
    
});
