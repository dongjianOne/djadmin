package com.dong.sys.modules.security.config.bean;

import lombok.Data;

/**
 * @author DongJian
 * @date Created in 2020/11/30 17:32
 * Utils: Intellij Idea
 * @description:
 * @version:1.0
 */
@Data
public class LoginCode {

    /**
     * 验证码配置
     **/
    private LoginCodeEnum codeType;
    /**
     * 验证码有效期 分钟
     **/
    private Long expriation = 2L;

    /**
     * 验证码长度
     **/
    private int length = 2;
    /**
     * 验证码宽度
     **/
    private int width = 111;
    /**
     * 验证码高度
     **/
    private int height = 36;
    /**
     * 验证码字体
     **/
    private String fontName;
    /**
     * 字体大小
     **/
    private int fontSize = 25;

    public LoginCodeEnum getCodeType() {
        return codeType;
    }
}
