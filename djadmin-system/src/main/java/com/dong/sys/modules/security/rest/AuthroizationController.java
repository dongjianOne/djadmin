package com.dong.sys.modules.security.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "系统：系统授权接口")
public class AuthroizationController {

    @ApiOperation("获取验证码")
    @GetMapping("/code")
    public ResponseEntity<Object> getCode() {
        return ResponseEntity.ok(null);
    }
}
