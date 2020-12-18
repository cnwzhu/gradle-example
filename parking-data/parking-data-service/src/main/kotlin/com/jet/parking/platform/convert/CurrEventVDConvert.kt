package com.jet.parking.platform.convert

import com.jet.parking.dto.CurrEventDTO
import com.jet.parking.platform.vo.CurrEventVo
import org.mapstruct.Mapper
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy
import org.mapstruct.factory.Mappers


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface CurrEventVDConvert {

  companion object {
    val INSTANCE: CurrEventVDConvert = Mappers.getMapper(CurrEventVDConvert::class.java)
  }

  @Mappings(

  )
  fun currEventDTOToVo(currEventDTO: CurrEventDTO): CurrEventVo

  @Mappings(

  )
  fun currEventVoToDTO(currEventVo: CurrEventVo): CurrEventDTO

}