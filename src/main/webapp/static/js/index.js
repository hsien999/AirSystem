//设置全局表单提交格式
// Vue.http.options.emulateJSON = true;

//Vue实例
new Vue({
    el: '#app',
    data() {
        return {
            activeStep: 0,

        }
    },
    methods: {},
    //声明周期钩子函数-->在data和methods渲染结束后执行
    created() {
        //首先加载分类数据
        this.getClassifyData();

        this.searchMap.pageCode = this.pageConf.pageCode; //初始化设置分页参数
        this.searchMap.pageSize = this.pageConf.pageSize;

        this.search();
    }
});