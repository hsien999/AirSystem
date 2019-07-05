/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/7/2 18:05:26                            */
/*==============================================================*/
use air_system;

drop table if exists tb_airport;

drop table if exists tb_airroute;

drop table if exists tb_city;

drop table if exists tb_flight;

drop table if exists tb_flights;

drop table if exists tb_mdsp;

drop table if exists tb_model;

drop table if exists tb_order;

drop table if exists tb_passenger;

drop table if exists tb_rule;

drop table if exists tb_space;

drop table if exists tb_ticket;

drop table if exists tb_tickets;

drop table if exists tb_user;

drop table if exists tb_userpass;

/*==============================================================*/
/* Table: tb_airport                                            */
/*==============================================================*/
create table tb_airport
(
   airport_id           bigint auto_increment not null comment '机场编号',
   city_id              bigint comment '城市编号',
   airport_name         varchar(10) comment '机场名称',
   primary key (airport_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_airport comment '机场';

/*==============================================================*/
/* Table: tb_airroute                                           */
/*==============================================================*/
create table tb_airroute
(
   airroute_id          bigint auto_increment not null comment '航线编号',
   airport_up           bigint comment '起飞机场',
   airport_down         bigint comment '终点机场',
   airroute_length      smallint comment '航线长度（公里）',
   primary key (airroute_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_airroute comment '航线';

/*==============================================================*/
/* Table: tb_city                                               */
/*==============================================================*/
create table tb_city
(
   city_id              bigint auto_increment not null comment '城市编号',
   city_name            varchar(10) comment '城市名称',
   primary key (city_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_city comment '城市';

/*==============================================================*/
/* Table: tb_flight                                             */
/*==============================================================*/
create table tb_flight
(
   flight_id            varchar(15) not null comment '执飞航班编号',
   flights_id           char(6) comment '航班号',
   flight_date          date comment '执飞日期',
   flight_state         char(3) comment '航班状态',
   flight_info          varchar(20) comment '航班信息',
   pre_upTime           time comment '预计起飞时间',
   pre_downTime         time comment '预计到达时间',
   act_upTime           time comment '实际起飞时间',
   act_downTime         time comment '实际到达时间',
   primary key (flight_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_flight comment '执飞航班';

/*==============================================================*/
/* Table: tb_flights                                            */
/*==============================================================*/
create table tb_flights
(
   flights_id           char(6) not null comment '航班号',
   model_id             bigint comment '机型',
   airroute_id          bigint comment '航线',
   flights_meals        char(5) comment '餐食',
   plan_upTime          time comment '计划起飞时间',
   plan_downTime        time comment '计划到达时间',
   plan_time            smallint comment '计划花费时间',
   primary key (flights_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_flights comment '航班';

/*==============================================================*/
/* Table: tb_mdsp                                               */
/*==============================================================*/
create table tb_mdsp
(
   model_id             bigint not null comment '机型',
   space_id             char(1) not null comment '舱位',
   nums                 smallint comment '数量',
   primary key (model_id, space_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_mdsp comment '机型-舱位';

/*==============================================================*/
/* Table: tb_model                                              */
/*==============================================================*/
create table tb_model
(
   model_id             bigint auto_increment not null comment '机型编号',
   model_name           varchar(8) comment '机型名称',
   model_speed          smallint comment '速度（公里/小时）',
   primary key (model_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_model comment '机型';

/*==============================================================*/
/* Table: tb_order                                              */
/*==============================================================*/
create table tb_order
(
   order_id             varchar(20) not null comment '订单编号', 
   user_id              bigint comment '用户编号',
   order_price          smallint comment '价格',
   order_sureTime       datetime comment '确认时间',
   order_payTime		datetime comment '支付时间',
   order_payType		varchar(10) comment '支付方式',
   order_nums           smallint comment '乘客人数量',
   order_state          varchar(5) comment '订单状态',
   order_contactName    varchar(10) comment '联系人姓名',
   order_contactTel     varchar(20) comment '联系人手机号',
   order_contactEmail   varchar(20) comment '联系人邮箱',
   primary key (order_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_order comment '订单';

/*==============================================================*/
/* Table: tb_passenger                                          */
/*==============================================================*/
create table tb_passenger
(
   passenger_id         bigint auto_increment not null comment '乘客人编号',
   ticket_id            varchar(20) comment '机票编号',
   passenger_name       varchar(10) comment '乘客人姓名',
   passenger_cerid      varchar(30) comment '证件号',
   passenger_certype    varchar(10) comment '证件类型',
   passenger_tel        varchar(20) comment '乘客人手机号码',
   passenger_type       char(5) comment '乘客类型',
   primary key (passenger_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_passenger comment '乘机人信息';

/*==============================================================*/
/* Table: tb_rule                                               */
/*==============================================================*/
create table tb_rule
(
   space_id             char(1) not null comment '舱位编号',
   rule_type            char(1) not null comment '退改类型',
   rule_refund          smallint comment '退票手续费率',
   rule_change          smallint comment '改票手续费率',
   primary key (space_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_rule comment '退改规则';

/*==============================================================*/
/* Table: tb_space                                              */
/*==============================================================*/
create table tb_space
(
   space_id             char(1) not null comment '舱位编号',
   space_name           varchar(8) comment '舱位名称',
   baggage_allowance    smallint comment '行李限额',
   primary key (space_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_space comment '舱位';

/*==============================================================*/
/* Table: tb_ticket                                             */
/*==============================================================*/
create table tb_ticket
(
   ticket_id            varchar(20) not null comment '机票编号',
   tickets_id           varchar(20) comment '售票编号',
   order_id             varchar(20) comment '订单编号',
   ticket_price         smallint comment '票价',
   fuel_surcharge       smallint comment '机场建设费',
   airport_fee          smallint comment '航空保险费',
   primary key (ticket_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_ticket comment '机票';

/*==============================================================*/
/* Table: tb_tickets                                            */
/*==============================================================*/
create table tb_tickets
(
   tickets_id           varchar(20) not null comment '售票编号', 
   space_id             char(1) comment '舱位编号',
   flight_id            varchar(15) comment '执飞航班编号',
   tickets_price        smallint comment '票价',
   tickets_nums         smallint comment '余票数',
   primary key (tickets_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_tickets comment '航班售票';

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   user_id              bigint auto_increment not null comment '用户编号',
   user_tel 			varchar(20) not null unique comment '手机号',
   user_cerid           varchar(30) not null unique comment '证件号',
   user_certype         varchar(10) comment '证件类型',
   user_chname          varchar(10) comment '中文名',
   user_enname          varchar(30) comment '英文名',
   user_salt            varchar(100) comment '盐值',
   user_pass            varchar(100) comment '密码',
   primary key (user_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_user comment '用户';

/*==============================================================*/
/* Table: tb_userpass                                           */
/*==============================================================*/
create table tb_userpass
(
   userpass_id          bigint auto_increment not null comment '常用乘机人编号',
   user_id              bigint comment '用户编号',
   userpass_name        varchar(10) comment '乘机人姓名', 
   userpass_cerid       varchar(30) comment '乘机人证件号',
   userpass_certype     varchar(10) comment '乘机人证件类型',
   userpass_tel         varchar(20) comment '乘机人手机号',
   userpass_type        char(5) comment '乘机人类型',
   primary key (userpass_id)
)CHARSET=utf8 ENGINE=InnoDB;

alter table tb_userpass comment '常用乘机人';

alter table tb_airport add constraint FK_Relationship_1 foreign key (city_id)
      references tb_city (city_id) on delete restrict on update restrict;

alter table tb_airroute add constraint FK_Relationship_2 foreign key (airport_down)
      references tb_airport (airport_id) on delete restrict on update restrict;

alter table tb_airroute add constraint FK_Relationship_3 foreign key (airport_up)
      references tb_airport (airport_id) on delete restrict on update restrict;

alter table tb_flight add constraint FK_Relationship_5 foreign key (flights_id)
      references tb_flights (flights_id) on delete restrict on update restrict;

alter table tb_flights add constraint FK_Relationship_4 foreign key (airroute_id)
      references tb_airroute (airroute_id) on delete restrict on update restrict;

alter table tb_flights add constraint FK_Relationship_6 foreign key (model_id)
      references tb_model (model_id) on delete restrict on update restrict;

alter table tb_mdsp add constraint FK_tb_mdsp foreign key (model_id)
      references tb_model (model_id) on delete restrict on update restrict;

alter table tb_mdsp add constraint FK_tb_mdsp2 foreign key (space_id)
      references tb_space (space_id) on delete restrict on update restrict;

alter table tb_order add constraint FK_Relationship_10 foreign key (user_id)
      references tb_user (user_id) on delete restrict on update restrict;

alter table tb_passenger add constraint FK_Relationship_12 foreign key (ticket_id)
      references tb_ticket (ticket_id) on delete restrict on update restrict;

alter table tb_rule add constraint FK_Relationship_7 foreign key (space_id)
      references tb_space (space_id) on delete restrict on update restrict;

alter table tb_ticket add constraint FK_Relationship_11 foreign key (tickets_id)
      references tb_tickets (tickets_id) on delete restrict on update restrict;

alter table tb_ticket add constraint FK_Relationship_14 foreign key (order_id)
      references tb_order (order_id) on delete restrict on update restrict;

alter table tb_tickets add constraint FK_Relationship_8 foreign key (flight_id)
      references tb_flight (flight_id) on delete restrict on update restrict;

alter table tb_tickets add constraint FK_Relationship_9 foreign key (space_id)
      references tb_space (space_id) on delete restrict on update restrict;

alter table tb_userpass add constraint FK_Relationship_13 foreign key (user_id)
      references tb_user (user_id) on delete restrict on update restrict;

create view v_airroute_airport_city(airroute_id,airportUpName,airportDownName,cityStartName,cityEndName,airroute_length)
as
select airroute_id ,x.airport_name,y.airport_name,a.city_name,b.city_name,airroute_length
from tb_airport x,tb_airport y,tb_city a,tb_city b ,tb_airroute
where tb_airroute.airport_up = x.airport_id
and tb_airroute.airport_down = y.airport_id
and x.city_id = a.city_id
and y.city_id = b.city_id  ;

select * from v_airroute_airport_city;

alter table tb_city
    add  column city_alp char(1) not null ;/*添加城市首字母*/

alter table tb_city
    add  constraint  unique_name unique(city_name);

alter table tb_ticket
    add column ticket_seat int;/*添加座位号*/

alter table tb_passenger
    modify column passenger_certype varchar(20) ;

alter table tb_user
    modify column user_certype varchar(20) ;

alter table tb_userpass
    modify column userpass_certype varchar(20) ;