//设置全局表单提交格式
Vue.http.options.emulateJSON = true;

const Notfound = {
    template: '<h2>404</h2>'
}

const routerObj = new VueRouter({
    mode: 'history',
    routes: [{
        path: "*",
        component: Notfound
    },]
});

//Vue实例
new Vue({
    el: '#app',
    data() {
        return {
            activeIndex: '1',
            activeStep: 1,

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
            }
        }
    },
    methods: {},
    router: routerObj,
    created() {
        this.$http.post('/AirSystem_war_exploded/findTicketInfo.do?ticketsId=' + this.$route.query.ticketsId
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
        this.$http.post('/AirSystem_war_exploded/findAllInfoOfFlights.do?stCity=' +
            this.$route.query.stCity + '&edCity=' + this.$route.query.edCity + '&searchDate=' + this.$route.query.searchDate
        ).then(result => {
            if (result.body == null || JSON.stringify(result.body) === '{}' || selectTicket.ticketsNums == 0) {
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
    }
})