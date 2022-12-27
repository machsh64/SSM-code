function check(username,password) {

    alert("进入了check");
    if (username===""||username==null){
        alert("请输入合法的用户名");
        return false;
    }
    if (password===""||password==null||parseInt(password.value)===123456){
        alert("请输入合法的密码");
        return false;
    }
    return true;
}
