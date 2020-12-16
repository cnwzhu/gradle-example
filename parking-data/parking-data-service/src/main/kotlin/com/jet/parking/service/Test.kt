package com.jet.parking.service

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.jet.parking.dao.TestDao
import com.jet.parking.model.TestM
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Test {

  @Autowired
  private lateinit var _testDao: TestDao

  @GetMapping("/")
  fun test(): TestM? {
    val selectOne = _testDao.selectOne(KtQueryWrapper(TestM::class.java).eq(TestM::name, "联合测试"))
    return selectOne
  }

}