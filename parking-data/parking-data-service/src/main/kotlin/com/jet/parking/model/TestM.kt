package com.jet.parking.model

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName

@TableName(schema = "public", value = "user_info_tb")
data class TestM(
  var id: Long?,
  @TableField(value = "nickname") var name: String?
) {
  constructor() : this(null, null)
}
