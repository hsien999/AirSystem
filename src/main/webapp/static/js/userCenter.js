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
    el: '#appCenter',
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
        const validatePass = (rule, value, callback) => {
            if (value === '') {
                return callback(new Error('请输入密码'));
            } else {
                if (this.newPass.checkPassWord !== '') {
                    this.$refs.newPass.validateField('checkPassWord');
                }
                return callback();
            }
        };
        const validatePass2 = (rule, value, callback) => {
            if (value === '') {
                return callback(new Error('请再次输入密码'));
            } else if (value !== this.newPass.newPassword) {
                return callback(new Error('两次输入密码不一致!'));
            } else {
                return callback();
            }
        };
        return {
            activeIndex: '-1',
            showSave: false,
            showEdit: false,
            showDetail: false,

            newPass: {
                checkPassWord: '',
                newPassword: '',
            },

            userChName: '',
            userId: 0,
            btn: 1,
            oneOrder: {
                orderId: '',
                tickets: [
                    {
                        ticketId: '',
                        passengerName: '',
                        passengerTel: '',
                        passengerCertype: '',
                        passengerCerid: '',
                        ticketPrice: '',
                        spaceId: '',
                        ticketSeat: '',
                    }
                ]
            },
            orders: [{
                orderId: '',
                orderSureTime: 0,
                orderPayType: '',
                orderState: '',
                orderContactName: '',
                orderContactTel: '',
                orderContactEmail: '',
                flightsId: '',
                upAirportName: '',
                downAirportName: '',
                orderNums: '',
                orderPrice: '',
                tickets: [
                    {
                        ticketId: '',
                        passengerName: '',
                        passengerTel: '',
                        passengerCertype: '',
                        passengerCerid: '',
                        ticketPrice: '',
                        spaceId: '',
                        ticketSeat: '',
                    }
                ]
            }],

            insertPass: {
                userId: 0,
                userpassId: '',
                userpassType: '',
                userpassName: '',
                userpassCerid: '',
                userpassCertype: '',
                userpassTel: '',
            }
            ,
            editPass: {
                userpassId: '',
                userpassType: '',
                userpassName: '',
                userpassCerid: '',
                userpassCertype: '',
                userpassTel: '',
            }
            ,
            userPasses: [{
                userpassId: '',
                userpassType: '',
                userpassName: '',
                userpassCerid: '',
                userpassCertype: '',
                userpassTel: '',
            }],
            //证件类型
            types:
                [{
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
                    label: '居民户口簿'
                }, {
                    value: '6',
                    label: '出生证明'
                }, {
                    value: '7',
                    label: '其他'
                },
                ],
            rules:
                {
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
                },
            rules2: {
                newPassword: [
                    {required: true, message: '请输入新密码', trigger: 'blur'},
                    {validator: validatePass, trigger: 'blur'}
                ],
                checkPassWord: [
                    {required: true, message: '请再次确认新密码', trigger: 'blur'},
                    {validator: validatePass2, trigger: 'blur'}
                ],
            }
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
    methods: {
        changePass(formName) {
            this.$refs[formName].validate((valid) => {
                if (!valid) {
                    this.$message({
                        message: '请输入正确信息',
                        type: 'warning',
                        duration: 6000
                    });
                } else {
                    this.$http.post('/AirSystem_war_exploded/user/changePass.do?newPass=' + this.newPass.newPassword
                    ).then(result => {
                        if (result.body.success) {
                            this.$message({
                                type: 'success',
                                message: result.body.message,
                                duration: 2000
                            });
                            setTimeout(() => {
                                this.$message({
                                    type: 'warning',
                                    message: '请重新登陆',
                                    duration: 2000
                                });
                            }, 2000)
                            setTimeout(() => {
                                window.location.href = "../logout";
                            }, 500)
                        } else {
                            this.$message({
                                type: 'warning',
                                message: result.body.message,
                                duration: 2000
                            });
                        }
                        this.resetForm(formName);
                    })
                }
            });
        },
        handleDelete(id) {
            this.$http.post('/AirSystem_war_exploded/user/delPass.do?userpassId=' + id
            ).then(result => {
                if (result.body.success) {
                    this.$message({
                        type: 'success',
                        message: result.body.message,
                        duration: 2000
                    });
                    this.searchPass();
                } else {
                    this.$message({
                        type: 'warning',
                        message: result.body.message,
                        duration: 2000
                    });
                }
            })
        },
        handleEdit(id) {
            this.$http.post('/AirSystem_war_exploded/user/findUserPassById.do?userpassId=' + id
            ).then(result => {
                if (result.body !== undefined && result.body !== null) {
                    this.editPass = result.body;
                    // this.resetForm('editPass');
                    this.showEdit = true;
                } else {
                    this.$message({
                        type: 'warning',
                        message: '编辑出错',
                        duration: 2000
                    });
                }
            })
        },


        savePass(formName) {
            this.$refs[formName].validate((valid) => {
                if (!valid) {
                    this.$message({
                        message: '请输入正确信息',
                        type: 'warning',
                        duration: 6000
                    });
                } else {
                    let flag = false;
                    this.userPasses.forEach(row => {
                        if (row.userpassCerid === this.insertPass.userpassCerid) flag = true;
                    })
                    if (flag) {
                        this.$message({
                            message: '已存在相同证件号的乘机人',
                            type: 'warning',
                            duration: 6000
                        });
                        return;
                    }
                    this.$http.post('/AirSystem_war_exploded/user/savePass.do',
                        JSON.stringify(this.insertPass)
                    ).then(result => {
                        if (result.body.success) {
                            this.$message({
                                type: 'success',
                                message: result.body.message,
                                duration: 2000
                            });
                            this.searchPass();
                            this.resetForm(formName);
                            this.showSave = false;
                        } else {
                            this.$message({
                                type: 'warning',
                                message: result.body.message,
                                duration: 2000
                            });
                            this.insertPass = {};
                            this.showSave = false;
                        }
                    })
                }
            });
        },

        updatePass(formName) {
            this.$refs[formName].validate((valid) => {
                if (!valid) {
                    this.$message({
                        message: '请输入正确信息',
                        type: 'warning',
                        duration: 6000
                    });
                } else {
                    let flag = false;
                    this.userPasses.forEach(row => {
                        if (row.userpassCerid === this.editPass.userpassCerid) flag = true;
                    })
                    if (flag) {
                        this.$message({
                            message: '已存在相同证件号的乘机人',
                            type: 'warning',
                            duration: 6000
                        });
                        return;
                    }
                    this.$http.post('/AirSystem_war_exploded/user/updatePass.do',
                        JSON.stringify(this.editPass)
                    ).then(result => {
                        if (result.body.success) {
                            this.$message({
                                type: 'success',
                                message: result.body.message,
                                duration: 2000
                            });
                            this.searchPass();
                            this.resetForm(formName);
                            this.showEdit = false;
                        } else {
                            this.$message({
                                type: 'warning',
                                message: result.body.message,
                                duration: 2000
                            });
                            this.insertPass = {};
                            this.showEdit = false;
                        }
                    })
                }
            });
        },


        //重置表单
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },

        searchPass() {
            this.$http.post('/AirSystem_war_exploded/user/getAllUserPass.do'
            ).then(result => {
                if (result.body !== undefined && result.body !== null && result.body !== {}) {
                    this.userPasses = result.body;
                } else {
                    this.$message({
                        type: 'warning',
                        message: '更新失败',
                        duration: 2000
                    });
                }
            })
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
                        window.location.href = "AirSystem_war_exploded/login.html";
                    }, 1000);
                }
            })
        },
        getAllOrders() {
            this.$http.post('/AirSystem_war_exploded/user/findAllInfoOfOrderById.do'
            ).then(result => {
                if (result.body !== undefined && result.body != null) {
                    this.orders = result.body;
                } else {
                    this.$message({
                        type: 'error',
                        message: "查询失败",
                        duration: 6000
                    });
                }
            })
        },
        getDetail(id) {
            this.$http.post('/AirSystem_war_exploded/user/findInfoOfOrderByOrderId.do?orderId=' + id
            ).then(result => {
                if (result.body !== undefined && result.body != null) {
                    this.oneOrder = result.body;
                    this.showDetail = true;
                    // this.resetForm('oneOrder');
                } else {
                    this.$message({
                        type: 'error',
                        message: "查询失败",
                        duration: 6000
                    });
                }
            })
        },
        change(id) {
            this.btn = id;
        },
        init() {
            this.userPasses = [];
        },
    },

    //声明周期钩子函数-->在data和methods渲染结束后执行
    created() {
        this.init();
        this.getUserChName();
        this.searchPass();
        this.getAllOrders();
    }

});




