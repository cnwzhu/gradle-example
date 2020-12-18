package com.jet.parking.service

import com.jet.parking.dto.CurrEventDTO

interface ICurrEventService {

  fun add(eventDTO: CurrEventDTO): Int

}