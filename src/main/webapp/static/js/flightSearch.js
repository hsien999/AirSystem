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

//Vue实例
new Vue({
    el: '#appSearch',
    data() {
        return {
            activeIndex: '2',
            choice: '按航班线路',
            loading: false,

            searchEntity: {
                stCity: [],
                edCity: [],
                planTime: '',
            },
            searchEntity2: {
                flightsId: '',
                searchDate: '',
            },
            InfoOfFlight: [
                {
                    flightsId: '', //航班号
                    flightId: '', //执飞航班ID
                    date: '', //航班飞行日期
                    airportUpName: '',//起飞机场
                    airportDownName: '',//降落机场
                    planUpTime: '',//预计起飞时间
                    planDownTime: '',//预计到达时间
                    actUpTime: '',//实际起飞时间
                    actDownTime: '',//实际到达时间
                    state: '',//航班状态
                }
            ],
            citys: [
                {
                    value: '',
                    label: '',
                    children: [
                        {
                            value: '',
                            label: '',
                            children: [{
                                value: '',
                                label: '',
                            }]
                        }
                    ]
                }
            ],

            pickerOptions: {
                disabledDate(time) {
                    return (time.getTime() <= (Date.now() - 3600 * 1000 * 24 * 90)) && (time.getTime() <= (Date.now() + 3600 * 1000 * 24 * 90));
                },
            },

            rules: {
                stCity: [
                    {required: true, message: '请选择出发城市', trigger: 'change'},
                ],
                edCity: [
                    {required: true, message: '请选择到达城市', trigger: 'change'},
                ],
                planTime: [
                    {required: true, message: '请选择乘机时间', trigger: 'change'},
                ],
            },

        }

    },


    filters: {

        //过滤时间的秒
        timeFilter(time) {
            const values = (time || '').split(':');
            if (values.length >= 2) {
                const hours = parseInt(values[0], 10);
                const minutes = parseInt(values[1], 10);
                let hh = hours >= 10 ? hours : '0' + hours;
                let mm = minutes >= 10 ? minutes : '0' + minutes;
                return hh + ':' + mm;
            }
            /* istanbul ignore next */
            return '';
        },

        //格式化总时间
        sumTimeFilter(data) {
            const hours = Math.floor(data / 60);
            const minutes = Math.floor(data % 60);
            if (hours == 0 && minutes == 0) {
                return '';
            } else if (hours == 0) {
                return minutes + '分钟';
            } else if (minutes == 0) {
                return hours + '小时';
            } else {
                return hours + '小时' + minutes + '分钟';
            }

        },

        timeStampFilter(date) {
            let time = new Date(date);
            let y = time.getFullYear();
            let m = time.getMonth() + 1;
            let d = time.getDate();
            return y + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d);
        },

    },
    router: routerObj,
    methods: {

        getAllCitys() {
            this.$http.get('/AirSystem_war_exploded/static/js/citys.json').then(result => {
                this.citys = result.body;
            });
        },

        search(form) {
            this.$refs[form].validate((valid) => {
                /*通过表单验证*/
                if (!valid) {
                    //弹出错误信息提示框
                    this.$emit('user',
                        this.$message({
                            message: '请完成搜索信息',
                            type: 'warning',
                            duration: 6000
                        }),
                    );
                } else {
                    this.loading = true;
                    setTimeout(() => {
                        this.loading = false;
                    }, 2000);
                    //发送ajax请求
                    let url = '';
                    if (form === 'searchEntity') {
                        url = '/AirSystem_war_exploded/user/searchFlightByCityDate.do?stCity=' + this.searchEntity.stCity[2] + '&edCity='
                            + this.searchEntity.edCity[2] + '&planTime=' + this.searchEntity.planTime;
                    } else if (form === 'searchEntity2') {
                        url = '/AirSystem_war_exploded/user/searchFlightByIdDate.do?flightsId=' +
                            this.searchEntity2.flightsId + '&date=' + this.searchEntity2.searchDate;
                    }
                    this.$http.post(
                        url
                    ).then(result => {
                        if (result.body == null || JSON.stringify(result.body) === '[]' || result.body === undefined) {
                            this.$message({
                                type: 'warning',
                                message: "无相关航班信息",
                                duration: 2000
                            });
                            //清空
                            this.InfoOfFlight = [];
                            // this.$refs[form].resetFields();
                        } else {
                            console.log(result.body);
                            this.InfoOfFlight = result.body;
                            console.log(this.InfoOfFlight);
                        }
                    })
                }
            });

        },

        sortBy1(a, b) {
            return a.flightsId >= b.flightsId ? 1 : -1;
        },
        sortBy2(a, b) {
            return a.ticketsPrice - b.ticketsPrice;
        },

        init() {
            this.InfoOfFlight = [];
        }
    },

    //声明周期钩子函数-->在data和methods渲染结束后执行
    created() {
        this.init();
        //首先加载城市信息
        this.getAllCitys();
    }
});




