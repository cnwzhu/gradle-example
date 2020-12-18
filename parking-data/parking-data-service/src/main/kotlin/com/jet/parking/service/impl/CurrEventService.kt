package com.jet.parking.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.jet.parking.convert.CurrEventMDConvert
import com.jet.parking.dto.CurrEventDTO
import com.jet.parking.mapper.CurrEventMapper
import com.jet.parking.model.CurrEvent
import com.jet.parking.service.ICurrEventService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CurrEventService : ICurrEventService, ServiceImpl<CurrEventMapper, CurrEvent>() {

  @Transactional
  override fun add(eventDTO: CurrEventDTO): Int {
    val currEvent = CurrEventMDConvert.INSTANCE.currEventDTOToModel(eventDTO)
    return this.baseMapper.insert(currEvent)
  }

}