package com.jet.parking.convert

import com.jet.parking.dto.CurrEventDTO
import com.jet.parking.model.CurrEvent
import org.mapstruct.Mapper
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy
import org.mapstruct.factory.Mappers


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface CurrEventMDConvert {

  companion object {
    val INSTANCE: CurrEventMDConvert = Mappers.getMapper(CurrEventMDConvert::class.java)
  }

  @Mappings(

  )
  fun currEventDTOToModel(currEventDTO: CurrEventDTO): CurrEvent

  @Mappings(

  )
  fun currEventModelToDTO(currEvent: CurrEvent): CurrEventDTO

}