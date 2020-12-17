package com.jet.parking.dto

data class TestDTO(
  var id: Long?,
  var name: String?
) {
  constructor() : this(null, null)
}
