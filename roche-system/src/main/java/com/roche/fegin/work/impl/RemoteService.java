package com.roche.fegin.work.impl;

import com.roche.manage.domain.SysGuide;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface RemoteService {

    @RequestLine("GET /metadata/list?name={name}")
    String getOwner(@Param(value = "name") String name);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestLine("POST /users/list")
    SysGuide getOwner(SysGuide user);
}
