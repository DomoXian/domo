/**
 * Created by xianguo on 18/10/17.
 * 自定义js
 */
document.write('<script language="JavaScript" charset="utf-8" src="/templates/js/jquery-1.11.0.min.js"></script>');
function myOnClick() {
    var x = document.getElementById("domoBtn");
    alert(x.innerText);
    AlertDialog("成功了");
}

/**
 * 创建HttpRequest对象
 * @returns {*}
 */
function getHttpRequest() {
    var httpRequest;
    if (window.XMLHttpRequest) {
        httpRequest = new XMLHttpRequest();
    } else {
        httpRequest = new ActiveXObject();
    }

    return httpRequest;
}

/**
 * 登录
 */
function login() {
    var request = getHttpRequest();
    request.open("POST", "/user/login.json", true);
    request.setRequestHeader("Content-type", "application/json");
    request.send();
}

/**
 * 注册
 */
function register() {

}

function AlertDialog(content) {
    if (content != null && content.trim.length == 0) {
        alert(content)
    }
}

$(document).ready(function () {
    $("button").click(function () {
        alert("suibia");
    });
});