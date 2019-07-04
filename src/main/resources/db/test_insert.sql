insert into tb_city (city_name) values ('北京'),('上海'),('厦门') ;
select * from tb_city ;
delete from tb_city where 1=1;


insert into tb_airport(city_id, airport_name) values (9,'北京机场T1'),(10,'上海机场T1'),(11,'厦门机场T2'),(9,'北京机场T2') ;
select * from tb_airport;


insert into tb_airroute(airport_up, airport_down, airroute_length)
values (1,2,1000),(1,3,2000),(1,4,3000),(2,1,1000),(2,3,4000),(2,4,5000),(3,1,2000),(3,2,4000),(3,4,6000),(4,1,3000),(4,2,5000),(4,3,6000);
select * from tb_airroute;

insert into tb_model ( model_name, model_speed)
values ('空客747',500),('波音110',550),('D919',600);
select * from tb_model;


insert into tb_space (space_id, space_name, baggage_allowance)
values ('X','头等舱',60),('Y','商务舱',30),('Z','经济舱',15);
select * from tb_model;
select * from tb_space;


insert into tb_mdsp (model_id, space_id, nums)
values (1,'X',10),(2,'X',15),(3,'X',20),(1,'Y',30),(2,'Y',20),(3,'Y',25),(1,'Z',120),(2,'Z',110),(3,'Z',100);
select * from tb_mdsp;


insert into tb_rule (space_id, rule_type, rule_refund, rule_change)
values ('X','1',90,90),('Y','1',80,80),('Z','1',85,85) ;
select * from tb_rule;


insert into tb_flights (flights_id, model_id, airroute_id, flights_meals, plan_upTime, plan_downTime, plan_time)
values ('MF001',1,1,'晚餐','7:30','9:30','2'),('MF002',2,2,'晚餐','9:30','11.30','2'),('MF003',3,3,'早餐','6:30','9.30','3'),('MF004',1,4,'晚餐','7:30','9.30','2'),
       ('MF005',2,5,'早餐','7:30','9.30','2'),('MF006',3,6,'晚餐','7:30','9.30','2'),('MF007',1,7,'晚餐','7:30','9.30','2'),('MF008',2,8,'早餐','7:30','9.30','2'),
       ('MF009',3,9,'晚餐','7:30','9.30','2'),('MF010',1,10,'早餐','7:30','9.30','2'),('MF011',2,11,'晚餐','7:30','9.30','2'),('MF0012',3,12,'早餐','7:30','9.30','2'),
       ('MF013',1,1,'早餐','7:30','9:30','2'),('MF014',2,2,'晚餐','9:30','11.30','2'),('MF015',3,3,'早餐','6:30','9.30','3'),('MF016',1,4,'晚餐','7:30','9.30','2'),
       ('MF017',2,5,'早餐','7:30','9.30','2'),('MF018',3,6,'晚餐','7:30','9.30','2'),('MF019',1,7,'晚餐','7:30','9.30','2'),('MF020',2,8,'早餐','7:30','9.30','2'),
       ('MF021',3,9,'晚餐','7:30','9.30','2'),('MF022',1,10,'早餐','7:30','9.30','2'),('MF023',2,11,'早餐','7:30','9.30','2'),('MF0024',3,12,'晚餐','7:30','9.30','2');
select * from tb_flights;



insert into tb_flight (flight_id, flights_id, flight_date, flight_state, flight_info, pre_upTime, pre_downTime, act_upTime, act_downTime)
values ('1','MF001','2019-01-01','计划','因暴风雨延误','21:10','23:10','21:30','1:30'),
       ('2','MF002','2019-01-02','计划','因暴风雨延误','21:10','23:10','21:30','1:30'),
       ('3','MF003','2019-01-03','计划','因暴风雨延误','21:10','23:10','21:30','1:30'),
       ('4','MF013','2019-01-01','计划','因暴风雨延误','21:10','23:10','21:30','1:30'),
       ('5','MF017','2019-01-01','计划','因暴风雨延误','21:10','23:10','21:30','1:30'),
       ('6','MF014','2019-01-02','计划','因暴风雨延误','21:10','23:10','21:30','1:30'),
       ('7','MF015','2019-01-01','计划','因暴风雨延误','21:10','23:10','21:30','1:30'),
       ('8','MF018','2019-01-01','计划','因暴风雨延误','21:10','23:10','21:30','1:30'),
       ('9','MF001','2019-01-01','计划','因暴风雨延误','21:10','23:10','21:30','1:30'),
       ('10','MF001','2019-01-01','计划','因暴风雨延误','21:10','23:10','21:30','1:30'),
       ('11','MF002','2019-01-01','计划','因暴风雨延误','21:10','23:10','21:30','1:30');
select * from tb_flight;



insert into tb_tickets (tickets_id, space_id, flight_id, tickets_price, tickets_nums)
values ('TK1','X','1',100,20),('TK9','X','2',100,20),('TK17','Y','9',100,20),
       ('TK2','Y','1',100,20),('TK10','X','2',100,20),('TK18','X','11',100,20),
       ('TK3','X','1',100,20),('TK11','Z','3',100,20),('TK19','X','2',100,20),
       ('TK4','X','1',100,20),('TK12','X','4',100,20),('TK20','Z','3',100,20),
       ('TK5','Y','1',100,20),('TK13','X','5',100,20),('TK21','X','4',100,20),
       ('TK6','Y','1',100,20),('TK14','Z','6',100,20),('TK22','Z','5',100,20),
       ('TK7','X','1',100,20),('TK15','X','7',100,20),('TK23','X','6',100,20),
       ('TK8','X','1',100,20),('TK16','Y','8',100,20),('TK24','X','7',100,20);
select * from tb_tickets;

select * from v_airroute_airport_city;




select tf.flight_id,tf.flights_id,flight_date,model_name,model_speed,flights_meals,airroute_length,
       airportUpName,airportDownName,cityStartName,cityEndName,pre_upTime,pre_downTime,
       plan_time,tickets_id,tr.space_id,space_Name,tickets_price,tickets_nums,nums
from v_airroute_airport_city left join tb_flights on v_airroute_airport_city.airroute_id = tb_flights.airroute_id
                             left join tb_flight tf on tb_flights.flights_id = tf.flights_id
                             left join tb_tickets tt on tf.flight_id = tt.flight_id
                             left join tb_space ts on tt.space_id = ts.space_id
                             left join tb_rule tr on ts.space_id = tr.space_id
                             left join tb_mdsp tm on ts.space_id = tm.space_id
                             left join tb_model t on tb_flights.model_id = t.model_id
where cityStartName = '北京'
  and cityEndName = '上海'
  and flight_date = '2019-01-01';


