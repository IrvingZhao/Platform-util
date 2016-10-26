package cn.irving.zhao.util.weChart.base.message.send;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cn.irving.zhao.util.weChart.base.message.BaseOutputMessage;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础发送消息-输出消息
 *
 * @author Irving.Zhao
 * @version 1.0
 * @since 1.0
 */
public abstract class BaseSendOutputMessage extends BaseOutputMessage {
    @JsonIgnore
    public abstract String getUrl();

    @JsonIgnore
    public abstract Class<? extends BaseSendInputMessage> getInputMessageClass();

    @JsonIgnore
    public Map<String, Object> getParamMap() {
        Map<String, Object> result = null;
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(this.getClass(), BaseSendOutputMessage.class);

            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            result = new HashMap<>(descriptors.length);
            for (PropertyDescriptor item : descriptors) {
                String name = item.getName();
                if (name.equals("url") || name.equals("inputMessageClass")) {
                    continue;
                }
                result.put(name, item.getReadMethod().invoke(this));
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}