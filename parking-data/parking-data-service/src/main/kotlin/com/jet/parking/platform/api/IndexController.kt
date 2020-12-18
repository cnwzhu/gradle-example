package com.jet.parking.platform.api

import com.jet.parking.common.domain.RestResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/index")
@Tag(name = "index", description = "设备状态检查")
class IndexController {

  @GetMapping(consumes = ["*"])
  @Operation(summary = "index", description = "设备检查接口", tags = ["index"])
  @ApiResponses(
    ApiResponse(
      responseCode = "200", description = "设备健康",
      content = [Content(
        mediaType = "application/json",
        schema = Schema(implementation = String::class)
      )]
    ),
    ApiResponse(
      responseCode = "500", description = "设备故障",
      content = [Content(
        mediaType = "application/json",
        schema = Schema(implementation = String::class)
      )]
    )
  )
  fun index(): RestResponse<String> {
    return RestResponse("ok")
  }

  data class A(
    @Schema(description = "名称")
    @field:NotNull(message = "名称为空")
    @field:NotBlank(message = "名称为空")
    val name: String?,
    @Schema(description = "id")
    val id: String?
  ) {
    constructor() : this(null, null)
  }

  @PostMapping("/test", consumes = ["application/json"])
  @Operation(summary = "index", description = "测试", tags = ["index"])
  @ApiResponses(
    ApiResponse(
      responseCode = "200", description = "测试",
      content = [Content(
        mediaType = "application/json",
        schema = Schema(implementation = A::class)
      )]
    ),
  )
  fun test(@Valid @RequestBody @Parameter(name = "名称", required = true) a: A): A {
    return a
  }

}