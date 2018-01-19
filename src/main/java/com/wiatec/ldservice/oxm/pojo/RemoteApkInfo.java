package com.wiatec.ldservice.oxm.pojo;

/**
 * Created by xuchengpeng on 25/07/2017.
 */
public class RemoteApkInfo {

    private int id;
    private String name;
    private String packageName;
    private String url;
    private int code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RemoteApkInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", packageName='" + packageName + '\'' +
                ", url='" + url + '\'' +
                ", code=" + code +
                '}';
    }
}
