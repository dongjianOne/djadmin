package com.dong.sys.modules.security.config.bean;

import com.dong.sys.exception.BadConfigurationException;
import com.wf.captcha.*;
import com.wf.captcha.base.Captcha;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.Objects;

/**
 * @author DongJian
 * @date Created in 2020/11/30 17:44
 * Utils: Intellij Idea
 * @description: 配置文件获取
 * @version:1.0
 */
public class LoginProperties {

    /**
     *  单用户
     **/
    private boolean singlonLogin = false;
    /**
     * 验证码配置
     **/
    private LoginCode loginCode;
    /**
     * 用户登录信息缓存
     **/
    private boolean cacheEnable;


    public boolean isSinglonLogin() {
        return singlonLogin;
    }

    public boolean isCacheEnable() {
        return cacheEnable;
    }

    public Captcha getCaptcha() {
        if (Objects.isNull(loginCode)) {
            loginCode = new LoginCode();
            if(Objects.isNull(loginCode.getCodeType())){
                loginCode.setCodeType(LoginCodeEnum.arithmetic); // 算数类型
            }
        }
            return switchCaptcha(loginCode);
    }


    /**
     * 依据配置信息生产验证码
     *
     * @param loginCode 验证码配置信息
     * @return /
     */
    private Captcha switchCaptcha(LoginCode loginCode){
        Captcha captcha;
        synchronized (this) {
            switch (loginCode.getCodeType()) {
                case arithmetic:
                    // 算术类型 https://gitee.com/whvse/EasyCaptcha
                    captcha = new ArithmeticCaptcha(loginCode.getWidth(), loginCode.getHeight());
                    // 几位数运算，默认是两位
                    captcha.setLen(loginCode.getLength());
                    break;
                case chinese:
                    captcha = new ChineseCaptcha(loginCode.getWidth(), loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                case chinese_gif:
                    captcha = new ChineseGifCaptcha(loginCode.getWidth(), loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                case gif:
                    captcha = new GifCaptcha(loginCode.getWidth(), loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                case spec:
                    captcha = new SpecCaptcha(loginCode.getWidth(), loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                default:
                    throw new BadConfigurationException("验证码配置信息错误！正确配置查看 LoginCodeEnum ");
            }
        }
        if(StringUtils.isNotBlank(loginCode.getFontName())){
            captcha.setFont(new Font(loginCode.getFontName(), Font.PLAIN, loginCode.getFontSize()));
        }
        return captcha;
    }
}
