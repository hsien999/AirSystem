//设置全局表单提交格式
Vue.http.options.emulateJSON = true;

//Vue实例
new Vue({
    el: '#app',
    data() {
        return {
            goods: [{
                id: '',
                title: '',
                price: '',
                image: '',
                category: '',
                brand: '',
                seller: ''
            }],

            //编辑表
            editor: {
                title: '',
                price: '',
                image: '',
                category: '',
                brand: '',
                seller: ''
            },
            searchEntity: {
                brand: '',
                seller: ''
            },
            //导航栏默认激活下标
            activeIndex: '1',
        }
    },
    methods: {}
})