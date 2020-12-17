package com.jet.parking.common.domain

class BusinessException constructor(val errorCode: ErrorCode) : RuntimeException()