insert into tb_city (city_name,city_alp) values ('北京','B'),('上海','S'),('厦门','X') ;
select * from tb_city ;
delete from tb_city where 1=1;
update tb_city set city_alp = 'B' where city_name = '北京';
update tb_city set city_alp = 'S' where city_name = '上海';
update tb_city set city_alp = 'X' where city_name = '厦门';


insert into tb_airport(city_id, airport_name) values (3,'北京机场T1'),(4,'上海机场T1'),(5,'厦门机场T2'),(3,'北京机场T2') ;
select * from tb_airport;


insert into tb_airroute(airport_up, airport_down, airroute_length)
values (1,2,1000),(1,3,2000),(1,4,3000),(2,1,1000),(2,3,4000),(2,4,5000),(3,1,2000),(3,2,4000),(3,4,6000),(4,1,3000),(4,2,5000),(4,3,6000);
select * from tb_airroute;

insert into tb_model ( model_name, model_speed)
values ('空客747',500),('波音110',550),('D919',600);
select * from tb_model;


insert into tb_space (space_id, space_name, baggage_allowance)
values ('X','头等舱',60),('K','商务舱',30),('Z','经济舱',15);
select * from tb_model;
select * from tb_space;


insert into tb_mdsp (model_id, space_id, nums)
values (1,'X',10),(2,'X',15),(3,'X',20),(2,'K',20),(3,'K',25),(1,'Z',120),(2,'Z',110),(3,'Z',100);
select * from tb_mdsp;


insert into tb_rule (space_id, rule_type, rule_refund, rule_change)
values ('X','1',90,90),('K','1',80,80),('K','1',85,85) ;
select * from tb_rule;


insert into tb_flights (flights_id, model_id, airroute_id, flights_meals, plan_upTime, plan_downTime, plan_time)
values ('MF001',1,1,'晚餐','7:30','9:30','2'),('MF002',2,2,'晚餐','9:30','11.30','2'),('MF003',3,3,'早餐','6:30','9:30','3'),('MF004',1,4,'晚餐','7:30','9:30','2'),
       ('MF005',2,5,'早餐','7:30','9:30','2'),('MF006',3,6,'晚餐','7:30','9:30','2'),('MF007',1,7,'晚餐','7:30','9:30','2'),('MF008',2,8,'早餐','7:30','9:30','2'),
       ('MF009',3,9,'晚餐','7:30','9:30','2'),('MF010',1,10,'早餐','7:30','9:30','2'),('MF011',2,11,'晚餐','7:30','9:30','2'),('MF0012',3,12,'早餐','7:30','9:30','2'),
       ('MF013',1,1,'早餐','7:30','9:30','2'),('MF014',2,2,'晚餐','9:30','11:30','2'),('MF015',3,3,'早餐','6:30','9:30','3'),('MF016',1,4,'晚餐','7:30','9:30','2'),
       ('MF017',2,4,'早餐','7:30','9:30','2'),('MF018',3,5,'晚餐','7:30','9:30','2'),('MF019',1,6,'晚餐','7:30','9:30','2'),('MF020',2,8,'早餐','7:30','9:30','2'),
       ('MF021',3,9,'晚餐','7:30','9:30','2'),('MF022',1,10,'早餐','7:30','9:30','2'),('MF023',2,11,'早餐','7:30','9:30','2'),('MF0024',3,12,'晚餐','7:30','9:30','2');
select * from tb_flights;

delete from tb_flights where 1= 1;


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
values ('TK1','X','1',100,20),('TK9','X','2',100,20),('TK17','K','9',100,20),
       ('TK2','K','1',100,20),('TK10','X','2',100,20),('TK18','X','11',100,20),
       ('TK3','X','1',100,20),('TK11','Z','3',100,20),('TK19','X','2',100,20),
       ('TK4','X','1',100,20),('TK12','X','4',100,20),('TK20','Z','3',100,20),
       ('TK5','K','1',100,20),('TK13','X','5',100,20),('TK21','X','4',100,20),
       ('TK6','K','1',100,20),('TK14','Z','6',100,20),('TK22','Z','5',100,20),
       ('TK7','X','1',100,20),('TK15','X','7',100,20),('TK23','X','6',100,20),
       ('TK8','X','1',100,20),('TK16','K','8',100,20),('TK24','X','7',100,20);
select * from tb_tickets;
select * from v_airroute_airport_city;




insert into tb_user (user_tel, user_cerid, user_certype, user_chname, user_enname, user_salt, user_pass)
values ('18106932995','360600000000000000','居民身份证','蔡志涛','CZT','ssssssss','********'),
       ('18107017785','360600000000000001','居民身份证','王永贤','WYX','ssssssss','********');
select * from tb_user;




insert into tb_order (order_id, user_id, order_price, order_sureTime, order_payTime, order_payType, order_nums, order_state, order_contactName, order_contactTel, order_contactEmail)
values ('o1',1,100,'2019-01-01 12:00','2019-01-01 13:00','支付宝',2,'出票','蔡志涛','18106932995','100@qq.com'),
       ('o2',2,100,'2019-01-01 12:00','2019-01-01 13:00','微信',2,'出票','王永贤','18107017785','101@qq.com');
select * from tb_order;




insert into tb_ticket (ticket_id, tickets_id, order_id, ticket_price, fuel_surcharge, airport_fee, ticket_seat)
values ('ticket1','TK1','o1',50,20,20,25),
       ('ticket2','TK2','o1',50,20,20,26),
       ('ticket3','TK1','o2',50,20,20,28),
       ('ticket4','TK2','o2',50,20,20,27);
select * from tb_ticket;


insert into tb_passenger (ticket_id, passenger_name, passenger_cerid, passenger_certype, passenger_tel, passenger_type)
values ('ticket1','蔡志涛','居民身份证','360600000000000000','18106932995','成人'),
       ('ticket2','王永贤','居民身份证','360600000000000001','18107017785','成人'),
       ('ticket3','蔡志涛','居民身份证','360600000000000000','18106932995','成人'),
       ('ticket4','王永贤','居民身份证','360600000000000001','18107017785','成人');
select * from tb_passenger;


select airport_up,airport_down,airroute_id,airroute_length
from tb_airroute
         left join tb_airport ta on tb_airroute.airport_up = ta.airport_id
         left join tb_airport tb on tb_airroute.airport_down = tb.airport_id
where ta.airport_name = '北京机场'and tb.airport_name = '上海机场';


insert into tb_number values (0,0);

drop database air_system;

create database air_system;
delete from tb_airroute where 1=1;

update tb_space set space_discount = 1
where space_id  = 'Z';