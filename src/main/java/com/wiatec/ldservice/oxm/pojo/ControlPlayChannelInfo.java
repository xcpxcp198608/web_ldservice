package com.wiatec.ldservice.oxm.pojo;

/**
 * @author patrick
 */
public class ControlPlayChannelInfo {

    private int channelId;
    private String name;

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ControlPlayChannelInfo{" +
                "channelId=" + channelId +
                ", name='" + name + '\'' +
                '}';
    }
}
