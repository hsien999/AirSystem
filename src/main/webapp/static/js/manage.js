new Vue({
    el: '#app',
    data() {

        return {
            cityOptions: [
                {
                    "value": "ABCDE",
                    "label": "ABCDE",
                    "children": [
                        {
                            "value": "A",
                            "label": "A",
                            "children": []
                        },
                        {
                            "value": "B",
                            "label": "B",
                            "children": []
                        },
                        {
                            "value": "C",
                            "label": "C",
                            "children": []
                        },
                        {
                            "value": "D",
                            "label": "D",
                            "children": []
                        },
                        {
                            "value": "E",
                            "label": "E",
                            "children": []
                        }
                    ]
                },
                {
                    "value": "FGHJ",
                    "label": "FGHJ",
                    "children": [
                        {
                            "value": "F",
                            "label": "F",
                            "children": []
                        },
                        {
                            "value": "G",
                            "label": "G",
                            "children": []
                        },
                        {
                            "value": "H",
                            "label": "H",
                            "children": []
                        },
                        {
                            "value": "J",
                            "label": "J",
                            "children": []
                        }
                    ]
                },
                {
                    "value": "KLMN",
                    "label": "KLMN",
                    "children": [
                        {
                            "value": "K",
                            "label": "K",
                            "children": []
                        },
                        {
                            "value": "L",
                            "label": "L",
                            "children": []
                        },
                        {
                            "value": "M",
                            "label": "M",
                            "children": []
                        },
                        {
                            "value": "N",
                            "label": "N",
                            "children": []
                        }
                    ]
                },
                {
                    "value": "PQRST",
                    "label": "PQRST",
                    "children": [
                        {
                            "value": "P",
                            "label": "P",
                            "children": []
                        },
                        {
                            "value": "Q",
                            "label": "Q",
                            "children": []
                        },
                        {
                            "value": "R",
                            "label": "R",
                            "children": []
                        },
                        {
                            "value": "S",
                            "label": "S",
                            "children": []
                        },
                        {
                            "value": "T",
                            "label": "T",
                            "children": []
                        }
                    ]
                },
                {
                    "value": "WXYZ",
                    "label": "WXYZ",
                    "children": [
                        {
                            "value": "W",
                            "label": "W",
                            "children": []
                        },
                        {
                            "value": "X",
                            "label": "X",
                            "children": []
                        },
                        {
                            "value": "Y",
                            "label": "Y",
                            "children": []
                        },
                        {
                            "value": "Z",
                            "label": "Z",
                            "children": []
                        }
                    ]
                }
            ],

            spaceOptions: [],
            spaceOptions2: [
                {
                    label: 'A',
                    value: 'A'
                },
                {
                    label: 'B',
                    value: 'B'
                },
                {
                    label: 'C',
                    value: 'C'
                },
                {
                    label: 'D',
                    value: 'D'
                },
                {
                    label: 'E',
                    value: 'E'
                },
                {
                    label: 'F',
                    value: 'F'
                },
                {
                    label: 'G',
                    value: 'G'
                },
                {
                    label: 'H',
                    value: 'H'
                },
                {
                    label: 'I',
                    value: 'I'
                },
                {
                    label: 'J',
                    value: 'J'
                },
                {
                    label: 'K',
                    value: 'K'
                },
                {
                    label: 'L',
                    value: 'L'
                },
                {
                    label: 'M',
                    value: 'M'
                },
                {
                    label: 'N',
                    value: 'N'
                },
                {
                    label: 'O',
                    value: 'O'
                },
                {
                    label: 'P',
                    value: 'P'
                },
                {
                    label: 'Q',
                    value: 'Q'
                },
                {
                    label: 'R',
                    value: 'R'
                },
                {
                    label: 'S',
                    value: 'S'
                },
                {
                    label: 'T',
                    value: 'T'
                },
                {
                    label: 'U',
                    value: 'U'
                },
                {
                    label: 'V',
                    value: 'V'
                },
                {
                    label: 'W',
                    value: 'W'
                },
                {
                    label: 'X',
                    value: 'X'
                },
                {
                    label: 'Y',
                    value: 'Y'
                },
                {
                    label: 'Z',
                    value: 'Z'
                }
            ],
            modelOptions: [],
            upTable:[],

            downTable:[],
            airportUpOptions: [],

            airportDownOptions: [],
            props: {
                value: "id",
                label: "name",
                children: "children"
            },

            airport: {
                cityName: [],
                airportName: ''
            },

            modelSpace: {
                modelId: 0,
                spaceId: '',
                nums: 0,
            },
            spaceGroup: {
                space: {
                    spaceId: '',
                    spaceName: '',
                    baggageAllowance: 0,
                    spaceDiscount: 0.0
                },
                rule1: {
                    ruleType: 'A',
                    ruleRefund: 0,
                    ruleChange: 0
                },
                rule2: {
                    ruleType: 'B',
                    ruleRefund: 0,
                    ruleChange: 0
                },
                rule3: {
                    ruleType: 'C',
                    ruleRefund: 0,
                    ruleChange: 0
                },
                rule4: {
                    ruleType: 'D',
                    ruleRefund: 0,
                    ruleChange: 0
                },
            },
            model: {
                modelName: [],
                modelSpeed: 0,
            },
            infoOfFlights: {
                flightsId: '',
                modelId: null,
                flightsMeals: '',
                planUpTime: null,
                planTime: 0,
                airportUpName: '',
                airportDownName: '',
                airRouteLength: 0,
                // startCityName: [],
                // endCityName: []
            },

            tableAirport2: [{
                airportId: '',
                cityId: '',
                airportName: '',
            }],
            tableAirport:[] ,
            tableFlights: [],
            tableCity: [],
            tableModel: [],
            tableSpace: [],
            tableSpace2:[],
            selectItem: 0,
            defaultActive: '0',
            formInline: {},
            city: {
                cityName: '',
                cityAlp: '',
            },

            ////
            searchEntity1: {
                flightsId: '',
                searchDate: '',
            },
            infoOfFlights: [],
            searchResult1: [
                {
                    flightsId: '', //航班号
                    modelName: '',//机型
                    cityStartName: '',
                    cityEndName: '',
                    airportUpName: '',
                    airportDownName: '',
                    planUpTime: '',
                    planDownTime: '',

                    flightId: '', //执飞航班ID
                    date: '', //航班飞行日期
                    actUpTime: '',//实际起飞时间
                    actDownTime: '',//实际到达时间
                    state: '',//航班状态
                }
            ],
            newFlight: {
                flightId: '',
                flightsId: '', //航班号
                flightDate: '',
                preUpTime: '',
                preDownTime: '',
            },
            pickerOptions: {
                disabledDate(time) {
                    return time.getTime() <= (Date.now() - 3600 * 1000 * 24);
                },
            },
            showUpdate: false,
            upDateFlight: {
                flightId: '',
                preUpTime: '',
                preDownTime: '',
                actUpTime: '',
                actDownTime: '',
                state: '',
                flightInfo: '',
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
        timeStampFilter(date) {
            let time = new Date(date);
            let y = time.getFullYear();
            let m = time.getMonth() + 1;
            let d = time.getDate();
            return y + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d);
        },
    },
    methods: {

        handleUpdateFlight(id) {
            this.searchResult1.forEach(row => {
                if (row.flightId !== undefined && row.flightId === id) {
                    this.upDateFlight.flightId = row.flightId;
                    this.upDateFlight.preUpTime = row.planUpTime;
                    this.upDateFlight.preDownTime = row.planDownTime;
                    this.upDateFlight.actUpTime = row.planDownTime;
                    this.upDateFlight.actDownTime = row.actDownTime;
                    this.upDateFlight.state = row.state;
                }
            })
            this.showUpdate = true;
        },

        doUpdateFlight(formName) {
            this.$refs[formName].validate((valid) => {
                /*通过表单验证*/
                if (!valid) {
                    //弹出错误信息提示框
                    this.$message({
                        message: '请完成搜索信息',
                        type: 'warning',
                        duration: 6000
                    });
                } else {
                    this.$http.post(
                        '/AirSystem_war_exploded/doUpdateFlight.do?flightId=' +
                        this.upDateFlight.flightId + '&preUpTime=' + this.upDateFlight.preUpTime +
                        '&preDownTime=' + this.upDateFlight.preDownTime + '&actUpTime=' + this.upDateFlight.actUpTime
                        + '&actDownTime=' + this.upDateFlight.actDownTime + '&state=' + this.upDateFlight.state +
                        '&flightInfo=' + this.upDateFlight.flightInfo
                    ).then(result => {
                        if (result.body.success) {
                            this.searchFlight();
                            this.$message({
                                type: 'success',
                                message: result.body.message,
                                duration: 2000
                            });
                        } else {
                            this.$message({
                                type: 'warning',
                                message: result.body.message,
                                duration: 2000
                            });
                        }
                    })
                }
            });
        },

        insertFlight(formName) {
            this.$refs[formName].validate((valid) => {
                /*通过表单验证*/
                if (!valid) {
                    //弹出错误信息提示框
                    this.$message({
                        message: '请完成搜索信息',
                        type: 'warning',
                        duration: 6000
                    });
                } else {
                    if (this.infoOfFlights === undefined || this.infoOfFlights.length === 0) {
                        this.$message({
                            message: '请选择相应航班',
                            type: 'warning',
                            duration: 6000
                        });
                    } else {
                        this.newFlight.flightsId = this.infoOfFlights[0].flightsId;
                        this.$http.post(
                            '/AirSystem_war_exploded/insertFlight.do?flightsId=' +
                            this.searchEntity1.flightsId + '&flightDate=' + this.newFlight.flightDate +
                            '&preUpTime=' + this.newFlight.preUpTime + '&preDownTime=' + this.newFlight.preDownTime
                        ).then(result => {
                            if (result.body.success) {
                                this.searchFlight();
                                this.$message({
                                    type: 'success',
                                    message: result.body.message,
                                    duration: 2000
                                });
                                //清空
                                // this.searchResult1 = [];
                                // this.$refs[formName].resetFields();
                            } else {
                                this.$message({
                                    type: 'warning',
                                    message: result.body.message,
                                    duration: 2000
                                });
                            }
                        })
                    }
                }
            });
        },
        search1(formName) {
            this.$refs[formName].validate((valid) => {
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
                        this.searchFlight();
                    }
                }
            );
        },
        searchFlight() {
            this.$http.post(
                '/AirSystem_war_exploded/searchFlight.do?flightsId=' +
                this.searchEntity1.flightsId
            ).then(result => {
                if (result.body == null || JSON.stringify(result.body) === '[]' || result.body === undefined) {
                    this.$message({
                        type: 'warning',
                        message: "无相关航班信息",
                        duration: 2000
                    });
                } else {
                    this.searchResult1 = result.body;
                    this.infoOfFlights = new Array(result.body[0]);
                }
            })
        },




        insertCity(city) {
            this.$refs[city].validate((valid) => {
                /*通过表单验证*/
                if (valid) {
                    //提交表单
                    this.$http.post('/AirSystem_war_exploded/insertCity.do?cityName=' + this.city.cityName
                        + '&cityAlp=' + this.city.cityAlp
                    ).then(result => {
                        // 判断用户是否登录成功，后端返回JSON数据
                        if (result.body.success) {
                            this.$emit(
                                'city',
                                this.$message({
                                    message: '添加成功!',
                                    type: 'success',
                                    duration: 6000
                                }),
                            );
                        } else {
                            this.$emit(
                                'city',
                                this.$message({
                                    message: '城市已存在!',
                                    type: 'warning',
                                    duration: 6000
                                }),
                            );
                        }
                    });
                } else {
                    this.$emit(
                        'city',
                        this.$message({
                            message: '输入信息有误！',
                            type: 'warning',
                            duration: 6000
                        }),
                    );
                    return false;
                }
            });
        },
        //通过首字母获取城市对象
        findCityByAlp(s) {

            this.$http.post('/AirSystem_war_exploded/findCityByAlp.do?cityAlp=' + s
            ).then(result => {
                // 判断用户是否登录成功，后端返回JSON数据
                this.tableCity = result.body;
            });
        },

        insertSpaceGroup(form) {
            this.$refs[form].validate((valid) => {
                /*通过表单验证*/
                if (valid) {
                    this.$http.post('/AirSystem_war_exploded/insertSpaceGroup.do', JSON.stringify(this.spaceGroup)).then(result => {
                        if (result.body.success) {
                            this.showAllSpace(),
                                this.loadAllSpace(),
                                this.$emit(
                                    'spaceGroup',
                                    this.$message({
                                        message: result.body.message,
                                        type: 'success',
                                        duration: 6000
                                    }),
                                );
                        } else {
                            // 弹出错误信息框
                            this.$emit(
                                'spaceGroup',
                                this.$message({
                                    message: result.body.message,
                                    type: 'warning',
                                    duration: 6000
                                }),
                            );
                            // 清空表单状态
                            // this.$refs[spaceGroup].resetFields();
                        }
                    });
                } else {
                    this.$emit(
                        'spaceGroup',
                        this.$message({
                            message: '输入信息有误！',
                            type: 'warning',
                            duration: 6000
                        }),
                    );
                    return false;
                }
            });
        },

        showAllSpace() {
            this.$http.post('/AirSystem_war_exploded/showAllSpace.do'
            ).then(result => {
                this.tableSpace = result.body;
            });
        },

        getAllModel() {
            this.$http.post('/AirSystem_war_exploded/getAllModel.do'
            ).then(result => {
                this.tableModel = result.body;
            });
        },

        getAllAirport(){
            this.$http.post('/AirSystem_war_exploded/getAllAirport.do'
            ).then(result => {
                this.upTable = result.body;
                this.downTable = result.body;
            });
        },

        loadAllAirport() {

            this.airportUpOptions = [];
            this.airportDownOptions = [];

            this.upTable.forEach(row => {
                let data = {
                    value: row.airportName,
                    label: row.airportName
                }
                this.airportUpOptions.push(data);
                this.airportDownOptions.push(data);
            })
            console.log(this.tableSpace);
        },

        insertFlights(form){
            this.$refs[form].validate((valid) => {
                /*通过表单验证*/
                if (valid) {
                    this.$http.post('/AirSystem_war_exploded/insertFlights.do', JSON.stringify(this.infoOfFlights)).then(result => {
                        if (result.body.success) {
                            form,
                                this.$emit(
                                    form,
                                    this.$message({
                                        message: result.body.message,
                                        type: 'success',
                                        duration: 6000
                                    }),
                                );
                        } else {
                            // 弹出错误信息框
                            this.$emit(
                                form,
                                this.$message({
                                    message: result.body.message,
                                    type: 'warning',
                                    duration: 6000
                                }),
                            );
                            // 清空表单状态
                            // this.$refs[spaceGroup].resetFields();
                        }
                    });
                } else {
                    this.$emit(
                        form,
                        this.$message({
                            message: '输入信息有误！',
                            type: 'warning',
                            duration: 6000
                        }),
                    );
                    return false;
                }
            });
        },

        getAllCity() {
            this.$http.post('/AirSystem_war_exploded/getAllCity.do'
            ).then(result => {
                this.tableCity = result.body;
            });
        },

        loadAllSpace() {
            console.log(this.tableSpace);
            this.spaceOptions = [];
            this.tableSpace.forEach(row => {
                let data = {
                    value: row.spaceId,
                    label: row.spaceName
                }
                this.spaceOptions.push(data);
            })
            console.log(this.tableSpace);
        },


        getSpace2ById(id) {
            this.$http.post('/AirSystem_war_exploded/getSpaceById.do?modelId=' + id
            ).then(result => {
                this.tableSpace2 = result.body;
            });
        },

        loadAllModel() {
            this.modelOptions = [];
            this.tableModel.forEach(row => {
                let data = {
                    value: row.modelId,
                    label: row.modelName
                }
                this.modelOptions.push(data);
            })
        },

        loadAllCity() {
            console.log(this.tableCity);
            this.cityOptions.forEach(row => {
                row.children.forEach(row2 => {
                    row2.children = [];
                    this.tableCity.forEach(row3 => {
                        if (row2.label === row3.cityAlp) {
                            let data = {
                                value: row3.cityName,
                                label: row3.cityName
                            };
                            row2.children.push(data);
                        }
                    })
                })
            })
            console.log(this.cityOptions);
        },

        getAirportByCityName() {
            console.log(this.tableAirport2);
            this.$http.post('/AirSystem_war_exploded/getAirportByCityName.do?cityName=' + this.airport.cityName[2]
            ).then(result => {
                this.tableAirport2 = result.body;
            });
        },
        getAirportUpByCityName() {

            this.$http.post('/AirSystem_war_exploded/getAirportByCityName.do?cityName=' + this.infoOfFlights.startCityName[2]
            ).then(result => {
                this.tableAirport2 = result.body;
            });
        },
        getAirportDownCityName() {
            this.$http.post('/AirSystem_war_exploded/getAirportByCityName.do?cityName=' + this.infoOfFlights.endCityName[2]
            ).then(result => {
                this.tableAirport2 = result.body;
            });
        },

        // loadAirportUpOptions() {
        //     this.getAirportUpByCityName();
        //
        //     // console.log('999' + this.airportUpOptions);
        //
        //     setTimeout(() => {
        //         this.airportUpOptions = [];
        //         console.log(this.tableAirport2);
        //         this.tableAirport2.forEach(row => {
        //             let data = {
        //                 value: row.airportId,
        //                 label: row.airportName
        //             };
        //             console.log(row);
        //             console.log(row.airportName);
        //             this.airportUpOptions.push(data);
        //         });
        //         this.airportUpOptions = new Array(this.tableAirport2);
        //         console.log(this.tableAirport2);
        //     }, 1000);
        // },
        //
        // loadAirportDownOptions() {
        //     this.getAirportDownCityName();
        //     setTimeout(() => {
        //         this.airportDownOptions= [];
        //         console.log(this.tableAirport2);
        //         this.tableAirport2.forEach(row => {
        //             let data = {
        //                 value: row.airportName,
        //                 label: row.airportName
        //             }
        //             console.log(row);
        //             console.log(row.airportName);
        //             this.airportDownOptions.push(data);
        //         })
        //     }, 1000);
        // },

        addModel(form) {
            this.$refs[form].validate((valid) => {
                /*通过表单验证*/
                if (valid) {
                    this.$http.post('/AirSystem_war_exploded/addModel.do', JSON.stringify(this.model)).then(result => {
                        if (result.body.success) {
                            this.$emit(
                                form,
                                this.$message({
                                    message: result.body.message,
                                    type: 'success',
                                    duration: 6000
                                }),
                            );
                        } else {
                            // 弹出错误信息框
                            this.$emit(
                                form,
                                this.$message({
                                    message: result.body.message,
                                    type: 'warning',
                                    duration: 6000
                                }),
                            );
                            // 清空表单状态
                            // this.$refs[spaceGroup].resetFields();
                        }
                    });
                } else {
                    this.$emit(
                        form,
                        this.$message({
                            message: '输入信息有误！',
                            type: 'warning',
                            duration: 6000
                        }),
                    );
                    return false;
                }
            });

            setTimeout(() => {
                this.getAllModel();
                setTimeout(() => {
                    this.loadAllModel();
                }, 100)
            }, 100)


        },

        addAirport(form) {
            this.$refs[form].validate((valid) => {
                /*通过表单验证*/
                if (valid) {
                    this.$http.post('/AirSystem_war_exploded/addAirport.do?cityName=' + this.airport.cityName[2]
                        + '&airportName=' + this.airport.airportName).then(result => {
                        if (result.body.success) {
                            this.$emit(
                                form,
                                this.$message({
                                    message: result.body.message,
                                    type: 'success',
                                    duration: 6000
                                }),
                            );
                        } else {
                            // 弹出错误信息框
                            this.$emit(
                                form,
                                this.$message({
                                    message: result.body.message,
                                    type: 'warning',
                                    duration: 6000
                                }),
                            );
                            // 清空表单状态
                            // this.$refs[spaceGroup].resetFields();
                        }
                    });
                } else {
                    this.$emit(
                        form,
                        this.$message({
                            message: '输入信息有误！',
                            type: 'warning',
                            duration: 6000
                        }),
                    );
                    return false;
                }
            });
        },

        addMdsp(form) {
            this.$refs[form].validate((valid) => {
                /*通过表单验证*/
                if (valid) {
                    this.$http.post('/AirSystem_war_exploded/addMdsp.do?spaceId='
                        + this.modelSpace.spaceId + "&modelId=" + this.modelSpace.modelId
                        + "&nums=" + this.modelSpace.nums).then(result => {
                        if (result.body.success) {
                            this.$emit(
                                form,
                                this.$message({
                                    message: result.body.message,
                                    type: 'success',
                                    duration: 6000
                                }),
                            );
                        } else {
                            // 弹出错误信息框
                            this.$emit(
                                form,
                                this.$message({
                                    message: result.body.message,
                                    type: 'warning',
                                    duration: 6000
                                }),
                            );
                            // 清空表单状态
                            // this.$refs[spaceGroup].resetFields();
                        }
                    });
                } else {
                    this.$emit(
                        form,
                        this.$message({
                            message: '输入信息有误！',
                            type: 'warning',
                            duration: 6000
                        }),
                    );
                    return false;
                }
            });
            setTimeout(() => {
                this.getSpace2ById(this.modelSpace.modelId);
            }, 100)
        },


        setSelectItem(i) {
            this.selectItem = i;
            this.showAllSpace();
            this.getAllModel();
            this.getAllCity();
            this.getAllAirport();

            setTimeout(() => {
                this.loadAllModel();
                this.loadAllSpace();
                this.loadAllCity();
                this.loadAllAirport();
            }, 100)

        },


        activeIndex() {

        },
        value2() {

        },
        value1() {

        },

        fun() {
            console.log(this.spaceGroup.space.spaceId);
        },


        onSubmit() {

        },

    },
})