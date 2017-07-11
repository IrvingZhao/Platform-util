package cn.irving.zhao.util.weChart.mp.message.send.menu.entity;

import com.dianpu.platform.tools.base.serial.custom.CustomEnumValue;

/**
 * 终端操作系统平台枚举
 */
public enum PlatformType implements CustomEnumValue<PlatformType, Integer> {
    IOS(1), Android(2), Other(3);
    private int code;

    PlatformType(int code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public PlatformType[] getValues() {
        return PlatformType.values();
    }
}