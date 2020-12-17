package com.jet.parking.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.jet.parking.model.TestM
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select

@Mapper
interface TestDao : BaseMapper<TestM> {

  @Select(
    """
          select nickname from user_info_tb where id = #{id} and nickname = #{name}
    """
  )
  @Results(
    Result(column = "nickname", property = "name")
  )
  fun test(id: Long, name: String): TestM

}