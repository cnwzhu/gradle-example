package com.jet.parking.common.util

import com.sun.org.slf4j.internal.LoggerFactory
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.net.URLEncoder
import java.util.*

object EncryptUtil {

  private val logger = LoggerFactory.getLogger(
    EncryptUtil::class.java
  )

  /**
   * 将字节数组进行base64编码
   *
   * @param bytes
   * @return
   */
  fun encodeBase64(bytes: ByteArray?): String? {
    return Base64.getEncoder().encodeToString(bytes)
  }

  /**
   * 将字符串进行base64解码
   *
   * @param str
   * @return
   */
  fun decodeBase64(str: String?): ByteArray? {
    var bytes: ByteArray? = null
    bytes = Base64.getDecoder().decode(str)
    return bytes
  }

  /**
   * 将字符串str 先使用utf-8符集进行url编码 +转为%2B ?转为%3F 等防止传输过程中出问题，然后在进行base64编码
   *
   * @param str
   * @return
   */
  fun encodeUTF8StringBase64(str: String?): String? {
    var encoded: String? = null
    try {
      encoded = URLEncoder.encode(str, "utf-8")
      encoded = Base64.getEncoder().encodeToString(encoded.toByteArray(charset("utf-8")))
    } catch (e: UnsupportedEncodingException) {
      logger.warn("不支持的编码格式", e)
    }
    return encoded
  }

  /**
   * 将字符串str 先进行base64解码 然后在使用utf-8字符集进行url解码
   *
   * @param str
   * @return
   */
  fun decodeUTF8StringBase64(str: String?): String? {
    var decoded: String? = null
    val bytes = Base64.getDecoder().decode(str)
    try {
      decoded = String(bytes, Charsets.UTF_8)
      decoded = URLDecoder.decode(decoded, "utf-8")
    } catch (e: UnsupportedEncodingException) {
      logger.warn("不支持的编码格式", e)
    }
    return decoded
  }

}