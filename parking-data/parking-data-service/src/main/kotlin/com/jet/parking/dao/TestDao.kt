package com.jet.parking.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.jet.parking.model.TestM
import org.apache.ibatis.annotations.Mapper

@Mapper
interface TestDao : BaseMapper<TestM> {
}