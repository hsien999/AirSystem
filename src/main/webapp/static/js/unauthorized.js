//设置全局表单提交格式
Vue.http.options.emulateJSON = true;

//Vue实例
new Vue({
    el: '#app',
    data() {
        return {}
    },
    created() {
        this.$message({
            type: 'warning',
            message: "请先登录",
            duration: 1000
        });
    },
    mounted() {
        setTimeout(() => {
            window.location.href = "login.html";
        }, 1000);
    }
})