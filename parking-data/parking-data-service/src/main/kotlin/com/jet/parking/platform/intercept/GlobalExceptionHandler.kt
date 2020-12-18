package com.jet.parking.platform.intercept

import com.jet.parking.common.domain.BusinessException
import com.jet.parking.common.domain.CommonErrorCode
import com.jet.parking.common.domain.ErrorCode
import com.jet.parking.common.domain.RestErrorResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*
import java.util.function.Consumer
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RestControllerAdvice
class GlobalExceptionHandler {

  companion object {
    val log: Logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(
    MethodArgumentNotValidException::class
  )
  fun handleValidationExceptions(
    ex: MethodArgumentNotValidException
  ): RestErrorResponse? {
    val errors: MutableMap<String, String?> = HashMap()
    ex.bindingResult.allErrors.forEach(Consumer { error: ObjectError ->
      val fieldName = (error as FieldError).field
      val errorMessage = error.getDefaultMessage()
      errors[fieldName] = errorMessage
    })
    return RestErrorResponse(
      CommonErrorCode.E_100101.desc,
      errors.toString()
    )
  }

  //捕获Exception异常
  @ExceptionHandler(value = [Exception::class])
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  fun processException(
    request: HttpServletRequest?,
    response: HttpServletResponse?,
    e: Exception
  ): RestErrorResponse? {
    //解析异常信息
    //如果是系统自定义异常，直接取出errCode和errMessage
    if (e is BusinessException) {
      log.info(e.message, e)
      //解析系统自定义异常信息
      val businessException: BusinessException = e
      val errorCode: ErrorCode = businessException.errorCode
      //错误代码
      val code: Int = errorCode.getCode()
      //错误信息
      val desc: String? = errorCode.getDesc()
      return desc?.let { RestErrorResponse(code.toString(), it) }
    }
    log.error("系统异常：", e)
    //统一定义为99999系统未知错误
    return RestErrorResponse(
      java.lang.String.valueOf(CommonErrorCode.UNKNOWN.code),
      CommonErrorCode.UNKNOWN.desc
    )
  }

}