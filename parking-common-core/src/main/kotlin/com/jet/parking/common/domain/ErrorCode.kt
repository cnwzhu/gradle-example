package com.jet.parking.common.domain

interface ErrorCode {
  fun getCode(): Int
  fun getDesc(): String?
}