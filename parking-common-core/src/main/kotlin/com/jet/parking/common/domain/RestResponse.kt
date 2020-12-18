package com.jet.parking.common.domain

data class RestResponse<T>(
  val code: Int,
  val msg: String?,
  val result: T?
) {
  constructor(
    result: T?
  ) : this(200, "ok", result)
}