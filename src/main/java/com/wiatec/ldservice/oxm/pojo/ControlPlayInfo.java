package com.wiatec.ldservice.oxm.pojo;

/**
 * @author patrick
 */
public class ControlPlayInfo {

    private int id;
    private String mac;
    private String url;
    private boolean isPlay;
    private int duration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPlay() {
        return isPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ControlPlayInfo{" +
                "id=" + id +
                ", mac='" + mac + '\'' +
                ", url='" + url + '\'' +
                ", isPlay=" + isPlay +
                ", duration=" + duration +
                '}';
    }
}
