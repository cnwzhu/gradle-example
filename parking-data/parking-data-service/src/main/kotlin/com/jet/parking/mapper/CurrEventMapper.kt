package com.jet.parking.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.jet.parking.model.CurrEvent
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select

@Mapper
interface CurrEventMapper : BaseMapper<CurrEvent> {

  @Select(
    """
          select nickname from user_info_tb 
    """
  )
  @Results(
    Result(column = "nickname", property = "name")
  )
  fun test()

}