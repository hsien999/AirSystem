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
    el: '#appMain',
    data() {

        return {
            activeIndex: '1',
            activeStep: 0,
            upDate: '',
            loading: false,
            baggageAllowance: 0,
            userChName: '',

            searchEntity: {
                stCity: [],
                edCity: [],
                planTime: '',
            },

            InfoOfFlight: [
                {
                    flightsId: '', //航班号
                    flightId: '', //执飞航班ID
                    date: '', //航班飞行时间
                    modelName: '',//机型
                    flightsMeals: '', //餐食类型
                    airrouteLength: 0,//航线长
                    airportUpName: '',//起飞机场
                    airportDownName: '',//降落机场
                    cityStartName: '',//起飞城市
                    cityEndName: '',//降落城市
                    preUpTime: '',//预计起飞时间
                    preDownTime: '',//预计到达时间
                    planTime: 0,//计划用时
                    tickets: [
                        {
                            ticketsId: '',//售票ID
                            spaceName: '',//舱位名称
                            ticketsPrice: 0,//售票价
                            ticketsNums: 0,//余票数
                            spaceId: '', //舱型ID
                        }
                    ]
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
            ticketRules: [{
                ruleType: '',
                ruleRefund: '',
                ruleChange: '',
            }],

            pickerOptions: {
                disabledDate(time) {
                    return time.getTime() <= (Date.now() - 3600 * 1000 * 24);
                },
                shortcuts: [{
                    text: '今天',
                    onClick(picker) {
                        picker.$emit('pick', new Date());
                    }
                }, {
                    text: '一周后',
                    onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() + 3600 * 1000 * 24 * 7);
                        picker.$emit('pick', date);
                    }
                }, {
                    text: '一个月后',
                    onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() + 3600 * 1000 * 24 * 30);
                        picker.$emit('pick', date);
                    }
                }]
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
                    this.$http.post('/AirSystem_war_exploded/findAllInfoOfFlights.do?stCity=' +
                        this.searchEntity.stCity[2] + '&edCity=' + this.searchEntity.edCity[2] + '&searchDate=' + this.searchEntity.planTime
                    ).then(result => {
                        if (result.body == null || JSON.stringify(result.body) === '[]') {
                            this.$message({
                                type: 'warning',
                                message: "无相关航班信息",
                                duration: 2000
                            });
                            this.InfoOfFlight = [];
                        } else {
                            this.InfoOfFlight = result.body;
                        }
                    })
                }
            });

        },

        showRules(spaceId) {
            this.$http.post('/AirSystem_war_exploded/findRulesById.do?spaceId=' + spaceId
            ).then(result => {
                this.ticketRules = result.body;
                this.ticketRules.forEach(row => {
                    if (row.ruleType.toLowerCase() == 'a') {
                        row.ruleType = '起飞前7天（含）前'
                    } else if (row.ruleType.toLowerCase() == 'b') {
                        row.ruleType = '起飞前7天（不含）至48小时（含）之间'
                    } else if (row.ruleType.toLowerCase() == 'c') {
                        row.ruleType = '起飞前48小时（不含）至4小时（含）之间'
                    } else {
                        row.ruleType = '起飞前4小时（含）后'
                    }
                })
            });
            this.$http.post('/AirSystem_war_exploded/findBaggageAllowance.do?spaceId=' + spaceId
            ).then(result => {
                this.baggageAllowance = result.body;
            })
        },

        orderTicket(flightId, ticketsId) {
            window.location.href = "/AirSystem_war_exploded/user/orderNav1.html?" + "&flightId=" + flightId + "&ticketsId=" + ticketsId;
        },
        getUserChName() {
            this.$http.post('/AirSystem_war_exploded/security/authentication.do'
            ).then(result => {
                if (result.body.success) {
                    if (result.body.message !== undefined && result.body.message != null)
                        this.userChName = "欢迎您，" + result.body.message;
                } else {
                    this.$message({
                        type: 'error',
                        message: "请先登录",
                        duration: 1000
                    });
                    setTimeout(() => {
                        window.location.href = "login.html";
                    }, 1000);
                }
            })
        },


        sortBy1(a, b) {
            return a.spaceId >= b.spaceId ? 1 : -1;
        }
        ,
        sortBy2(a, b) {
            return a.ticketsPrice - b.ticketsPrice;
        }
        ,

        init() {
            this.InfoOfFlight = [];
            if (this.$route.query.stCity !== undefined && this.$route.query.stCity !== "")
                this.searchEntity.stCity[2] = this.$route.query.stCity;
            if (this.$route.query.edCity !== undefined && this.$route.query.edCity !== "")
                this.searchEntity.edCity[2] = this.$route.query.edCity;
            if (this.$route.query.searchDate !== undefined && this.$route.query.searchDate !== "")
                this.searchEntity.planTime = this.$route.query.searchDate;

        }
    },

    //声明周期钩子函数-->在data和methods渲染结束后执行
    created() {
        this.init();
        //首先加载城市信息
        this.getAllCitys();
        this.getUserChName();
    }

});




