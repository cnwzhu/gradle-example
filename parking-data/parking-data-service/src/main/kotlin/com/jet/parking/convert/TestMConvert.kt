package com.jet.parking.convert

import com.jet.parking.dto.TestDTO
import com.jet.parking.model.TestM
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy
import org.mapstruct.factory.Mappers


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface TestMConvert {

  companion object {
    val INSTANCE: TestMConvert = Mappers.getMapper(TestMConvert::class.java)
  }

  @Mappings(
    Mapping(source = "name", target = "name"),
    Mapping(source = "id", target = "id")
  )

  fun testToTestDTO(model: TestM): TestDTO

}