//设置全局表单提交格式
Vue.http.options.emulateJSON = true;

//Vue实例
new Vue({
    el: '#app',
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
                        console.log(1);
                        return callback(new Error('请输入正确的手机号码'));
                    }
                    //验证是否已存在
                    this.$http.post('/AirSystem_war_exploded/validateTel.do', {tel: value}).then(result => {
                        if (result.body.success === false) return callback(new Error('该手机号已注册'));
                        else return callback();
                    });
                }
            }
        };
        const checkChName = (rule, value, callback) => {
            if (value === '') {
                return callback(new Error('请输入姓名'));
            } else {
                const reg = /^[\u4E00-\u9FA5]{1,5}$/;
                if (!reg.test(value)) {
                    return callback(new Error('请输入中文'));
                } else {
                    return callback();
                }
            }
        };
        const checkEnName = (rule, value, callback) => {
            if (value === '') {
                return callback(new Error('请输入拼音/英文姓名'));
            } else {
                const reg = /^[a-zA-Z]+$/;
                if (!reg.test(value)) {
                    return callback(new Error('拼音/英文姓名只能含有字母'));
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
                const c = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);   //系数
                const b = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');  //校验码对照表
                const id_array = value.split("");
                let sum = 0;
                for (let k = 0; k < 17; k++) {
                    sum += parseInt(id_array[k]) * parseInt(c[k]);
                }
                if (id_array[17].toUpperCase() != b[sum % 11].toUpperCase()) {
                    return callback(new Error('请输入正确的证件号'));
                }
                this.$http.post('/AirSystem_war_exploded/validateCerId.do', {cerId: value}).then(result => {
                    if (result.body.success === false) return callback(new Error('该证件号已注册'));
                    else return callback();
                });
            }
        };
        const checkType = (rule, value, callback) => {
            // console.log('value1 ==' + value);
            if (value === '') {
                return callback(new Error('请选择证件类型'));
            } else {
                return callback();
            }
        };
        const checkRadio = (rule, value, callback) => {
            // console.log('value2 ==' + this.commit);
            if (this.commit != '1') {
                return callback(new Error('请选择'));
            } else {
                return callback();
            }
        };
        const validatePass = (rule, value, callback) => {
            if (value === '') {
                return callback(new Error('请输入密码'));
            } else {
                if (this.userInfo2.checkPass !== '') {
                    this.$refs.userInfo2.validateField('checkPass');
                }
                return callback();
            }
        };
        const validatePass2 = (rule, value, callback) => {
            console.log(value);
            if (value === '') {
                return callback(new Error('请再次输入密码'));
            } else if (value !== this.userInfo2.userPass) {
                return callback(new Error('两次输入密码不一致!'));
            } else {
                return callback();
            }
        };
        return {
            //导航栏、步骤条活动下标
            activeIndex: '1',
            activeStep: 0,
            commit: '',

            //用户信息
            userInfo1: {
                userCerid: '',
                userCerType: '',
                userChname: '',
                userEnname: '',
            },
            userInfo2: {
                userTel: '',
                userPass: '',
                checkPass: '',
            },

            //自定义+默认校验规则
            rules1: {
                userChname: [
                    {validator: checkChName, trigger: 'blur'}
                ],
                userEnname: [
                    {validator: checkEnName, trigger: 'blur'}
                ],
                userCerid: [
                    {validator: checkCerid, trigger: 'blur'}
                ],
                userCerType: [
                    {validator: checkType, trigger: 'blur'}
                ],
                commit: [
                    {validator: checkRadio, trigger: 'blur'}
                ]

            },
            rules2: {
                userTel: [
                    {required: true, message: '请输入手机号码', trigger: 'blur'},
                    {validator: checkTel, trigger: 'blur',}
                ], userPass: [
                    {required: true, message: '请输入密码', trigger: 'blur'},
                    {validator: validatePass, trigger: 'blur'}
                ],
                checkPass: [
                    {required: true, message: '请确认密码', trigger: 'blur'},
                    {validator: validatePass2, trigger: 'blur'}
                ]
            },

            //证件类型
            types: [{
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
                label: '其他'
            }],

        }

    },
    methods: {
        //步骤条移动
        //异步等待调回
        stepNext(form) {
            //处理两个表单
            if (this.activeStep == 0) {
                this.$refs[form].validate((valid) => {
                    /*通过表单验证*/
                    if (!valid) {
                        //弹出错误信息提示框
                        this.$emit('user',
                            this.$message({
                                message: '输入信息有误！',
                                type: 'warning',
                                duration: 6000
                            }),
                        );
                    } else {
                        if (this.activeStep++ > 2) this.activeStep = 0;
                    }
                });
            } else if (this.activeStep == 1) {
                this.$refs[form].validate((valid) => {
                    /*通过表单验证*/
                    if (!valid) {
                        //弹出错误信息提示框
                        this.$emit('user',
                            this.$message({
                                message: '输入信息有误！',
                                type: 'warning',
                                duration: 6000
                            }),
                        );
                    } else {
                        this.$http.post('/AirSystem_war_exploded/register.do', JSON.stringify({
                            userCerid: this.userInfo1.userCerid,
                            userCerType: this.userInfo1.userCerType,
                            userChname: this.userInfo1.userChname,
                            userEnname: this.userInfo1.userEnname,
                            userTel: this.userInfo2.userTel,
                            userPass: this.userInfo2.userPass,
                        })).then(result => {
                            if (result.body.success) {
                                this.$message({
                                    type: 'success',
                                    message: result.body.message,
                                    duration: 6000
                                });
                                this.activeStep = 2;
                            } else {
                                this.$message({
                                    type: 'warning',
                                    message: result.body.message,
                                    duration: 6000
                                });
                                // if (this.activeStep++ > 2) this.activeStep = 0;
                            }
                        })
                    }
                });
            }
        },

        stepPrev() {
            if (this.activeStep-- < 0) this.activeStep = 0;
        },
    },
})