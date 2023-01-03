
var app = document.getElementById("app");
var vue = new Vue({
    el: "#app",
    methods: {
        deleteEmployee() {
            //获取form表单
            var form = document.getElementsByTagName("form")[0];
            //将超链接的href属性赋值给form表单的action属性
            //event.target表示当前触发事件的标签
            form.action = event.target.href;
            //表单提交
            form.submit();
            //阻止超链接的默认行为
            event.preventDefault();
        }
    }
});