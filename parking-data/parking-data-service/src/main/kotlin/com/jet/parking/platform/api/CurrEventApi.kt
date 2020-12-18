package com.jet.parking.platform.api

import com.jet.parking.common.domain.RestResponse
import com.jet.parking.platform.vo.CurrEventVo
import com.jet.parking.service.ICurrEventService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/curr_event")
@Tag(name = "CurrEventController", description = "事件推送接口")
class CurrEventApi {

  @Autowired
  lateinit var currEventService: ICurrEventService

  @GetMapping(value = ["query"], consumes = ["*"])
  @Operation(summary = "查询", description = "根据条件查询未完成事件", tags = ["curr_event"])
  @ApiResponses(
    ApiResponse(
      responseCode = "200", description = "successful",
      content = [Content(
        mediaType = "application/json",
        schema = Schema(implementation = CurrEventVo::class)
      )]
    )
  )
  fun query(): RestResponse<CurrEventVo> {
    return RestResponse(CurrEventVo())
  }

}