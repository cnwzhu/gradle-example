drop database if exists parking;
create database parking with
    owner postgres
    encoding 'utf8';
create schema if not exists public;

drop table if exists curr_event;
create table curr_event
(
    id                    bigserial                   not null,
    evt                   smallint                    not null,
    evt_guid              varchar(50)                 not null,
    parking_act_id        varchar(50)                 not null,
    happen_time           timestamp without time zone not null,
    plate_number          varchar(15)                 not null,
    plate_color           smallint                    not null,
    pic_url               varchar(200)                not null,
    pic_url_arr           varchar(200)[]              not null,
    pic_url_hphm          varchar(200),
    time                  timestamp                   not null,
    parking_code          varchar(20)                 not null,
    parking_name          varchar(30)                 not null,
    berth_code            int                         not null,
    device_sn             varchar(30)                 not null,
    device_place          varchar(100),
    plate_credible        real,
    action_credible       real,
    parking_abnormal_type smallint,
    geo                   varchar(20),
    user_code             varchar(20),
    constraint curr_event_pk primary key (id, happen_time)
);

comment on table curr_event is '终端推送当前未完成事件';
comment on column curr_event.evt is '事件类型 evt.car.in evt.car.out evt.car.complete';
comment on column curr_event.evt_guid is '事件唯一标识符';
comment on column curr_event.parking_act_id is 'happen_time 停车行为 id，同一次进出完成，将拥有同一个停车行为 id';
comment on column curr_event.happen_time is '事件发生时间';
comment on column curr_event.plate_number is '车牌号码';
comment on column curr_event.plate_color is '车牌颜色';
comment on column curr_event.pic_url is '入场或出场鉴定图片，地址为图片绝对地址';
comment on column curr_event.pic_url_arr is '入场或出场鉴定图片集，地址为图片绝对地址';
comment on column curr_event.pic_url_hphm is '车牌小图绝对地址';
comment on column curr_event.time is '入场或出时间';
comment on column curr_event.parking_code is '停车点编码';
comment on column curr_event.parking_name is '停车点名称';
comment on column curr_event.berth_code is '泊位号';
comment on column curr_event.device_sn is '设备编号';
comment on column curr_event.device_place is '设备安装详细地址';
comment on column curr_event.plate_credible is '车牌识别可信度';
comment on column curr_event.action_credible is '出入行为可信度';
comment on column curr_event.parking_abnormal_type is '0：无异常；1：跨位；2：斜位；3：压线';
comment on column curr_event.geo is '设备经纬度，不为空时，格式如下： “108.23 22.45”';
comment on column curr_event.user_code is '账户，审核人员唯一标识符（若是系统自动审核，则为 null）';

drop table if exists his_event;
create table his_event
(
    id                    bigserial                   not null,
    evt                   smallint                    not null,
    evt_guid              varchar(50)                 not null,
    parking_act_id        varchar(50)                 not null,
    happen_time           timestamp without time zone not null,
    plate_number          varchar(15)                 not null,
    plate_color           smallint                    not null,
    pic_url_in            varchar(200)                not null,
    pic_url_arr_in        varchar(200)[]              not null,
    time_in               timestamp                   not null,
    pic_url_out           varchar(200)                not null,
    pic_url_arr_out       varchar(200)[]              not null,
    time_out              timestamp                   not null,
    pic_url_hphm          varchar(200),
    parking_code          varchar(20)                 not null,
    parking_name          varchar(30)                 not null,
    berth_code            int                         not null,
    device_sn             varchar(30)                 not null,
    device_place          varchar(100),
    parking_abnormal_type smallint,
    geo                   varchar(20),
    constraint his_event_pk primary key (id, happen_time)
) partition by range (happen_time);

comment on table his_event is '终端推送历史完成时间事件';
comment on column his_event.evt is '事件类型 evt.car.in evt.car.out evt.car.complete';
comment on column his_event.evt_guid is '事件唯一标识符';
comment on column his_event.parking_act_id is 'happen_time 停车行为 id，同一次进出完成，将拥有同一个停车行为 id';
comment on column his_event.happen_time is '事件发生时间';
comment on column his_event.plate_number is '车牌号码';
comment on column his_event.plate_color is '车牌颜色';
comment on column his_event.pic_url_in is '入场鉴定图片，地址为图片绝对地址';
comment on column his_event.pic_url_arr_in is '入场鉴定图片集，地址为图片绝对地址';
comment on column his_event.pic_url_out is '出场鉴定图片，地址为图片绝对地址';
comment on column his_event.pic_url_arr_out is '出场鉴定图片集，地址为图片绝对地址';
comment on column his_event.pic_url_hphm is '车牌小图绝对地址';
comment on column his_event.time_in is '入场时间';
comment on column his_event.time_out is '出时间';
comment on column his_event.parking_code is '停车点编码';
comment on column his_event.parking_name is '停车点名称';
comment on column his_event.berth_code is '泊位号';
comment on column his_event.device_sn is '设备编号';
comment on column his_event.device_place is '设备安装详细地址';
comment on column his_event.parking_abnormal_type is '0：无异常；1：跨位；2：斜位；3：压线';
comment on column his_event.geo is '设备经纬度，不为空时，格式如下： “108.23 22.45”';

create index his_event_idx_act_id on his_event (plate_number);

create table his_event_y2020 partition of his_event
    for values from ('2020-01-01 00:00:00') to ('2021-01-01 00:00:00');
create table his_event_y2021 partition of his_event
    for values from ('2021-01-01 00:00:00' ) to ('2022-01-01 00:00:00' );
create table his_event_y2022 partition of his_event
    for values from ('2022-01-01 00:00:00' ) to ('2023-01-01 00:00:00' );
create table his_event_y2023 partition of his_event
    for values from ('2023-01-01 00:00:00' ) to ('2024-01-01 00:00:00' );
create table his_event_y2024 partition of his_event
    for values from ('2024-01-01 00:00:00' ) to ('2025-01-01 00:00:00' );
create table his_event_y2025 partition of his_event
    for values from ('2025-01-01 00:00:00' ) to ('2026-01-01 00:00:00' );
create table his_event_y2026 partition of his_event
    for values from ('2026-01-01 00:00:00' ) to ('2027-01-01 00:00:00' );
