//设置全局表单提交格式
Vue.http.options.emulateJSON = true;


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
            activeIndex: '1'
        };
    },
    methods: {
        click() {
            this.$http.post('/AirSystem_war_exploded/validateTel.do', {tel: '13774831008'}).then(result => {
                const flag = result.body.message;
                console.log(flag);
            });
        }
    }
})