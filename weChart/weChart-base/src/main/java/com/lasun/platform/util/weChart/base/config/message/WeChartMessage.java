package com.lasun.platform.util.weChart.base.config.message;

import com.lasun.platform.util.weChart.base.config.enums.WeChartMessageFormat;
import com.lasun.platform.util.weChart.base.config.enums.WeChartMessageRequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 微信消息配置
 *
 * @author Irving.Zhao
 * @version 1.0
 * @since 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WeChartMessage {
    boolean isSecurity() default false;

    WeChartMessageRequestMethod requestMethod() default WeChartMessageRequestMethod.GET;

    WeChartMessageFormat requestType() default WeChartMessageFormat.FORM;

    WeChartMessageFormat responseType() default WeChartMessageFormat.JSON;
}
