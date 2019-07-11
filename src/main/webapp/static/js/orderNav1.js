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
    el: '#appUser',
    data() {
        //手机号码验证
        const checkTel = (rule, value, callback) => {

            if (value === '') {
                return callback(new Error('请输入手机号码'));
            } else {
                const reg1 = /^[0-9]{1,20}$/;
                if (!reg1.test(value)) {
                    return callback(new Error('请输入数字值'));
                } else {
                    //截止2019/1/1 已开通的号段
                    const reg2 = /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/;
                    if (!reg2.test(value)) {
                        return callback(new Error('请输入正确的手机号码'));
                    } else return callback();
                }
            }
        };
        const checkName = (rule, value, callback) => {
            if (value === '') {
                return callback(new Error('请输入姓名'));
            } else if (value.length > 20) {
                return callback(new Error('姓名过长'));
            } else {
                const reg1 = /^[a-zA-Z]+$/;
                const reg2 = /^[\u4E00-\u9FA5]{1,20}$/;
                if (!reg1.test(value) && !reg2.test(value)) {
                    return callback(new Error('请输入正确的姓名格式(英文或者中文)'));
                } else {
                    return callback();
                }
            }
        };
        const checkCerid = (rule, value, callback) => {
            if (value === '') {
                return callback(new Error('请输入证件号'));
            } else {
                const format = /^(([1][1-5])|([2][1-3])|([3][1-7])|([4][1-6])|([5][0-4])|([6][1-5])|([7][1])|([8][1-2]))\d{4}(([1][9]\d{2})|([2]\d{3}))(([0][1-9])|([1][0-2]))(([0][1-9])|([1-2][0-9])|([3][0-1]))\d{3}[0-9xX]$/;
                //号码规则校验
                if (!format.test(value)) {
                    return callback(new Error('请输入正确的证件号'));
                }
                //区位码校验
                //出生年月日校验   前正则限制起始年份为1900;
                const year = value.substr(6, 4),//身份证年
                    month = value.substr(10, 2),//身份证月
                    date = value.substr(12, 2),//身份证日
                    time = Date.parse(month + '-' + date + '-' + year),//身份证日期时间戳date
                    now_time = Date.parse(Date.now()),//当前时间戳
                    dates = (new Date(year, month, 0)).getDate();//身份证当月天数
                if (time > now_time || date > dates) {
                    return callback(new Error('请输入正确的证件号'));
                }
                //校验码判断
                const c = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];   //系数
                const b = ['1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'];  //校验码对照表
                const id_array = value.split("");
                let sum = 0;
                for (let k = 0; k < 17; k++) {
                    sum += parseInt(id_array[k]) * parseInt(c[k]);
                }
                if (id_array[17].toUpperCase() !== b[sum % 11].toUpperCase()) {
                    return callback(new Error('请输入正确的证件号'));
                } else return callback();
            }
        };
        return {
            activeIndex: '1',
            activeStep: 1,
            loading: {},
            contactPeo: [],
            orderArr: [],

            //再次确认登陆信息
            auth: {
                authPassword: '',
            },

            //执飞航班信息
            InfoOfFlight: {
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
            },
            //售票信息
            selectTicket: {
                ticketsId: '',//售票ID
                spaceName: '',//舱位名称
                ticketsPrice: 0,//售票价
                ticketsNums: 0,//余票数
                spaceId: '', //舱型ID
            },
            //常用乘机人信息
            userPass: [
                {
                    userpassId: '',
                    userpassName: '',
                    userpassCerid: '',
                    userpassCertype: '',
                    userpassTel: '',
                    userpassType: '',
                }
            ],
            //乘机人
            orderPass: [
                {
                    passengerId: '',
                    passengerName: '',
                    passengerCerid: '',
                    passengerCertype: '',
                    passengerTel: '',
                    passengerTyep: '',
                }
            ],
            order: {
                orderSureTime: 0,
                orderPayTime: 0,
                orderPayType: '',
                orderState: '',
                orderContactName: '',
                orderContactTel: '',
                orderContactEmail: '',
            },

            //乘客人表单信息
            selectPass: {
                passengerId: '',
                passengerName: '',
                passengerCerid: '',
                passengerCertype: '',
                passengerTel: '',
                passengerTyep: '',
            },
            orderInfo: {
                orderId: '',//订单编号
                orderSureTime: '',
                orderContactName: '',
                flightsId: '',
                upAirportName: '',
                downAirportName: '',
                orderNums: '',
                orderPrice: 0,
                //机票信息
                tickets: [
                    {
                        passengerName: '',
                        ticketPrice: 0,
                        airportFee: 0,
                        fuelSurcharge: 0,
                        sumPrice: 0,
                    }
                ]
            },


            //证件类型
            types: [
                {
                    value: '1',
                    label: '身份证'
                }, {
                    value: '2',
                    label: '港澳居民居住证'
                }, {
                    value: '3',
                    label: '台湾居民居住证'
                }, {
                    value: '4',
                    label: '护照'
                }, {
                    value: '5',
                    label: '居民户口蒲'
                },
                {
                    value: '6',
                    label: '出生证明'
                },
                {
                    value: '7',
                    label: '其他'
                },
            ],
            //校验规则
            rules: {
                userpassTel: [
                    {required: true, message: '请输入手机号码', trigger: 'blur'},
                    {validator: checkTel, trigger: 'blur',}
                ],
                userpassName: [
                    {required: true, message: '请输入姓名', trigger: 'blur'},
                    {validator: checkName, trigger: 'blur'}
                ],
                userpassCerid: [
                    {required: true, message: '请输入证件号', trigger: 'blur'},
                    {validator: checkCerid, trigger: 'blur'}
                ],
                userpassCertype: [
                    {required: true, message: '请选择证件类型', trigger: 'blur'},
                ],
                userpassType: [
                    {required: true, message: '请选择乘客类型', trigger: 'blur'},
                ],
                orderContactName: [
                    {required: true, message: '请输入姓名', trigger: 'blur'},
                    // {validator: checkName, trigger: 'blur'}
                ],
                orderContactTel: [
                    {required: true, message: '请输入手机号码', trigger: 'blur'},
                    // {validator: checkTel, trigger: 'blur',}
                ],
                orderContactEmail: [
                    // {validator: checkTel, trigger: 'blur',}
                ],
            }
        }
    },
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
        stepPre() {
            window.location.href = '/AirSystem_war_exploded/user/orderNav0?stCity=' + this.InfoOfFlight.cityStartName + '&edCity=' +
                this.InfoOfFlight.cityEndName + '&searchDate=' + this.InfoOfFlight.date;
        },
        stepNext(formName) {
            if (formName === 'order') {
                this.$refs[formName].validate((valid) => {
                    /*通过表单验证*/
                    let msg = '下单失败';
                    let type = 'warning';
                    if (!valid || this.orderPass.length === 0) {
                        //弹出错误信息提示框
                        msg = '请完善信息';
                    } else if (this.orderPass.length > 5) {
                        msg = '最多选择5个乘机人';
                    } else {
                        this.order.orderSureTime = new Date();
                        this.order.orderPayTime = new Date();
                        this.$http.post('/AirSystem_war_exploded/user/sureOrder.do?',
                            JSON.stringify({
                                ticketsId: this.selectTicket.ticketsId,
                                order: this.order,
                                passengerList: this.orderPass,
                            })
                        ).then(result => {
                            if (result.body !== undefined && result.body != null) {
                                msg = '下单成功';
                                type = "success";
                                this.orderInfo = result.body;
                                console.log(this.orderInfo);
                                this.orderInfo.tickets.forEach(row => {
                                    row.sumPrice = row.ticketPrice + row.airportFee + row.fuelSurcharge;
                                })
                                if (this.activeStep < 4) this.activeStep++;
                            } else {
                                msg = '下单失败';
                                type = "error";
                            }
                        });
                    }
                    setTimeout(() => {
                        this.$emit('order',
                            this.$message({
                                message: msg,
                                type: type,
                                duration: 6000
                            }),
                        );
                    }, 1000)
                });
            }

        },
        searchTicket() {
            this.$http.post('/AirSystem_war_exploded/findTicketsInfo.do?ticketsId=' +
                this.$route.query.ticketsId
            ).then(result => {
                if (result.body == null || JSON.stringify(result.body) === '{}' || result.body.ticketsNums === 0) {
                    this.$message({
                        type: 'warning',
                        message: "无相关售票信息或该票已售完",
                        duration: 2000
                    });
                    //待设置跳转
                } else {
                    this.selectTicket = result.body;
                }
            });
        },
        searchFlight() {
            this.$http.post('/AirSystem_war_exploded/findFlightInfo.do?flightId=' + this.$route.query.flightId
            ).then(result => {
                if (result.body == null || JSON.stringify(result.body) === '{}') {
                    this.$message({
                        type: 'warning',
                        message: "无相关执飞航班信息",
                        duration: 2000
                    });
                    //待设置跳转
                } else {
                    this.InfoOfFlight = result.body;
                }
            });
        },
        searchUserPass() {
            this.$http.post('/AirSystem_war_exploded/user/getAllUserPass.do'
            ).then(result => {
                if (result.body != null && JSON.stringify(result.body) !== '{}') {
                    this.userPass = result.body;
                }
            });
        },
        init() {
            this.userPass = [];
            this.orderPass = [];
            // this.selectPass = {};
            this.selectPass.passengerTyep = '成人';
            this.contactPeo = new Array(this.order);
        },
        //动态添加
        insertUserPass(tag) {
            // this.selectPass = {};
            this.selectPass.passengerId = tag.userpassId;
            this.selectPass.passengerName = tag.userpassName;
            this.selectPass.passengerCerid = tag.userpassCerid;
            this.selectPass.passengerCertype = tag.userpassCertype;
            this.selectPass.passengerTel = tag.userpassTel;
            this.selectPass.passengerTyep = tag.userpassType;
        },
        //动态删除
        handleClose(tag) {
            this.orderPass.splice(this.orderPass.indexOf(tag), 1);
        },

        //提交乘客人信息表单
        submitPass(formName) {
            this.$refs[formName].validate((valid) => {
                /*通过表单验证*/
                console.log(this.selectPass.userpassCerid);
                let msg = '添加失败';
                let type = 'warning'
                if (!valid) {
                    //弹出错误信息提示框
                    msg = '输入信息有误';
                } else if (this.orderPass.length > 5) {
                    msg = '最多选择5个乘机人';
                } else {
                    if (this.selectPass !== {}) {
                        msg = '添加成功';
                        let flag = true;
                        this.orderPass.forEach(row => {
                            if (row.passengerCerid === this.selectPass.passengerCerid) {
                                flag = false;
                                msg = '已存在该证件号的乘机人';
                            }
                        })
                        if (flag) {
                            this.orderPass.push(JSON.parse(JSON.stringify(this.selectPass)));
                            type = 'success';
                        }
                    } else msg = '添加失败';
                }
                this.$emit('selectPass',
                    this.$message({
                        message: msg,
                        type: type,
                        duration: 6000
                    }),
                );

            });
        },
        //重置表单
        resetForm(formName) {
            this.$refs[formName].resetFields();
            this.selectPass = {};
            this.selectPass.passengerTyep = '成人';
        },

        postOrder(formName) {
            this.$refs[formName].validate((valid) => {
                /*通过表单验证*/
                if (!valid) {
                    //弹出错误信息提示框
                    msg = '请输入密码确认';
                    this.$message({
                        type: 'warning',
                        message: '请完善信息',
                        duration: 6000
                    });
                } else if (this.orderPass.length > 5) {
                    this.$message({
                        type: 'warning',
                        message: '最多选择5个乘机人',
                        duration: 6000
                    });
                } else {
                    this.order.orderPayTime = this.getTimeStamp();
                    this.$http.post('/AirSystem_war_exploded/user/postOrder.do?orderId=' +
                        this.orderInfo.orderId + '&orderPayTime=' + this.order.orderPayTime + '&authPassword=' + this.auth.authPassword,
                    ).then(result => {
                        if (result.body.success) {
                            this.$message({
                                type: 'success',
                                message: result.body.message,
                                duration: 6000
                            });
                            this.getTicketDetail();
                            if (this.activeStep < 4) this.activeStep++;
                        } else {
                            this.$message({
                                type: 'error',
                                message: result.body.message,
                                duration: 6000
                            });
                        }
                    });

                }
            });


        },
        cancelOrder() {
            this.$http.post('/AirSystem_war_exploded/user/cancelOrder.do?orderId=' +
                this.orderInfo.orderId
            ).then(result => {
                if (result.body.success) {
                    this.$message({
                        type: 'success',
                        message: result.body.message,
                        duration: 6000
                    });
                } else {
                    this.$message({
                        type: 'error',
                        message: result.body.message,
                        duration: 2000
                    });
                    setTimeout(() => {
                        window.location.href = "login.html";
                    }, 2000);
                }
            });
        },
        getTimeStamp() {
            let date = new Date(+new Date() + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
            return date;
        },
        getTicketDetail() {
            this.$http.post('/AirSystem_war_exploded/user/getTicketDetail.do?orderId=' +
                this.orderInfo.orderId
            ).then(result => {
                if (result.body != null) {
                    this.orderInfo = result.body;
                    this.orderArr.push(JSON.parse(JSON.stringify(this.orderInfo)));
                    if (this.activeStep < 4) this.activeStep++;
                } else {
                    this.$message({
                        type: 'error',
                        message: '订单查看失败',
                        duration: 6000
                    });
                }
            });
        },

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
            if (hours === 0 && minutes === 0) {
                return '';
            } else if (hours === 0) {
                return minutes + '分钟';
            } else if (minutes === 0) {
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
            let h = time.getHours();
            let mm = time.getMinutes();
            let s = time.getSeconds();
            return y + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d)
                + ' ' + (h < 10 ? '0' + h : h) + ':' + (mm < 10 ? '0' + mm : mm) + ':' + (s < 10 ? '0' + s : s);
        },

    },

    router: routerObj,

    created() {
        //加载前动画
        this.init();
        this.loadings();
        this.searchTicket();
        this.searchFlight();
        this.searchUserPass();
    }
})
;