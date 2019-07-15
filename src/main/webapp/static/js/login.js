//设置全局表单提交格式
Vue.http.options.emulateJSON = true;

const Notfound = {
    template: '<h2>404</h2>'
};

const routerObj = new VueRouter({
    mode: 'history',
    routes: [{
        path: "*",
        component: Notfound
    },]
});
// Vue实例
new Vue({
    el: '#app',
    data() {
        return {
            login: {
                username: '',
                password: '',
                remember: ''
            },
            loading: {}, //loading动画
            activeIndex: '1',
            redUrl: '',
        };
    },
    router: routerObj,
    methods: {
        /**
         * loading加载动画
         */
        loadings() {
            this.loading = this.$loading({
                lock: true,
                text: '拼命加载中',
                spinner: 'el-icon-loading',
            });
            setTimeout(() => {
                this.loading.close();
            }, 2000);
        },

        submitForm(login) {
            this.$refs[login].validate((valid) => {
                /*通过表单验证*/
                if (valid) {
                    this.loadings(); //加载动画
                    //提交表单
                    this.$http.post('/AirSystem_war_exploded/login.do', {
                        username: this.login.username,
                        password: this.login.password,
                        remember: this.login.remember
                    }).then(result => {
                        // 判断用户是否登录成功，后端返回JSON数据
                        if (result.body.success) {
                            // console.log(this.$route.query.redUrl);
                            this.redUrl = this.$route.query.redUrl;
                            if (this.redUrl !== undefined && this.redUrl !== '') window.location.href = this.redUrl;
                            else window.location.href = "user/orderNav0.html";
                            this.loading.close(); //关闭动画加载
                        } else {
                            // 弹出错误信息框
                            this.$emit(
                                'submit-form',
                                this.$message({
                                    message: result.body.message,
                                    type: 'warning',
                                    duration: 6000
                                }),
                            );
                            // 清空表单状态
                            this.$refs[login].resetFields();
                        }
                    });
                } else {
                    this.$emit(
                        'submit-form',
                        this.$message({
                            message: '输入信息有误！',
                            type: 'warning',
                            duration: 6000
                        }),
                    );
                }
            });
        },
        loginEnter(login) {
            this.submitForm(login);
        },
    },
    created() {
        // this.redUrl = this.$route.query.redUrl;
        console.log(this.redUrl);
    }
});