package com.jet.parking.model

import java.time.LocalDateTime

/**
 * @author wz
 * @since 1.0.0
 * 终端推送当前未完成事件model
 * */
data class CurrEvent(

  val id: Long?,

  /**
   * 事件发生时间
   */
  val happenTime: LocalDateTime?,

  /**
   * 事件类型 evt.car.in evt.car.out evt.car.complete
   */
  val evt: Short?,

  /**
   * 事件唯一标识符
   */
  val evtGuid: String?,

  /**
   * happen_time 停车行为 id，同一次进出完成，将拥有同一个停车行为 id
   */
  val parkingActId: String?,

  /**
   * 车牌号码
   */
  val plateNumber: String?,

  /**
   * 车牌颜色
   */
  val plateColor: Short?,

  /**
   * 入场或出场鉴定图片，地址为图片绝对地址
   */
  val picUrl: String?,

  /**
   * 入场或出场鉴定图片集，地址为图片绝对地址
   */
  val picUrlArr: String?,

  /**
   * 车牌小图绝对地址
   */
  val picUrlHphm: String?,

  /**
   * 入场或出时间
   */
  val time: LocalDateTime?,

  /**
   * 停车点编码
   */
  val parkingCode: String?,

  /**
   * 停车点名称
   */
  val parkingName: String?,

  /**
   * 泊位号
   */
  val berthCode: Int?,

  /**
   * 设备编号
   */
  val deviceSn: String?,

  /**
   * 设备安装详细地址
   */
  val devicePlace: String?,

  /**
   * 车牌识别可信度
   */
  val plateCredible: Float?,

  /**
   * 出入行为可信度
   */
  val actionCredible: Float?,

  /**
   * 0：无异常；1：跨位；2：斜位；3：压线
   */
  val parkingAbnormalType: Short?,

  /**
   * 设备经纬度，不为空时，格式如下： “108.23 22.45”
   */
  val geo: String?,

  /**
   * 账户，审核人员唯一标识符（若是系统自动审核，则为 null）
   */
  val userCode: String?,

  ) {
  constructor() : this(
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
  )

}