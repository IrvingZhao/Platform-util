package cn.irving.zhao.util.weChart.mp.message.send.menu.create;

import com.dianpu.platform.tools.wechart.mp.message.send.BaseMpSendOutputMessage;
import com.dianpu.platform.tools.wechart.mp.message.send.menu.entity.Button;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建菜单输出消息
 */
public class CreateMenuOutputMessage extends BaseMpSendOutputMessage<CreateMenuInputMessage> {

    private List<Button> button;

    public CreateMenuOutputMessage(String token) {
        super(token);
    }

    public CreateMenuOutputMessage addButton(Button button) {
        if (this.button == null) {
            synchronized (this) {
                if (this.button == null) {
                    this.button = new ArrayList<>();
                }
            }
        }
        this.button.add(button);
        return this;
    }

    @Override
    public Class<CreateMenuInputMessage> getInputMessageClass() {
        return CreateMenuInputMessage.class;
    }

    @Override
    public String getUrl() {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
        return String.format(url, accessToken);
    }

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }
}