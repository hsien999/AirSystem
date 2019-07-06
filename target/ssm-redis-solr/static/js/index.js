//设置全局表单提交格式
// Vue.http.options.emulateJSON = true;

//Vue实例
new Vue({
    el: '#app',
    data() {


        return {
            activeIndex: '0',
            activeStep: 0,
            upDate: '',

            searchEntity: {
                stCity: [],
                edCity: [],
                planTime: ''
            },

            InfoOfFlight: [
                {
                    flightsId: '', //航班号
                    flightId: '', //执飞航班ID
                    date: '', //航班飞行时间
                    modelName: '',//机型
                    flightsMeals: '', //餐食类型
                    airrouteLength: '',//航线长
                    airportUpName: '',//起飞机场
                    airportDownName: '',//降落机场
                    cityStartName: '',//起飞城市
                    cityEndName: '',//降落城市
                    preUpTime: '',//预计起飞时间
                    preDownTime: '',//预计到达时间
                    planTime: '',//计划用时
                    tickets: [
                        {
                            ticketsId: '',//售票ID
                            spaceName: '',//舱位名称
                            ticketsPrice: '',//售票价
                            ticketsNums: '',//余票数
                            spaceId: '' //舱型ID
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

            tableData: [{
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }, {
                date: '2016-05-04',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1517 弄'
            }, {
                date: '2016-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1519 弄'
            }, {
                date: '2016-05-03',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1516 弄'
            }],

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
            }

        }

    },

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
                    this.$http.post('/AirSystem_war_exploded/findAllInfoOfFlights.do?stCity=' +
                        this.searchEntity.stCity[2] + '&edCity=' + this.searchEntity.edCity[2] + '&searchDate=' + this.searchEntity.planTime
                    ).then(result => {
                        try {
                            this.InfoOfFlight = result.body;
                        } catch (e) {
                            this.$message({
                                type: 'error',
                                message: "获取航班信息失败",
                                duration: 6000
                            });
                            this.$refs.searchEntity.resetFields();
                        }
                    })
                }
            });

        },

        handleEdit(index, row) {
            console.log(index, row);
        },

        handleDelete(index, row) {
            console.log(index, row);
        }
    },

    //声明周期钩子函数-->在data和methods渲染结束后执行
    created() {
        //首先加载城市信息
        this.getAllCitys();

    },
});




