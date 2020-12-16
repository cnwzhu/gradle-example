package com.jet.parking.convert

import com.jet.parking.dto.TestDTO
import com.jet.parking.model.TestM


interface TestMConvert {

  fun testToTestDTO(model: TestM): TestDTO;

}