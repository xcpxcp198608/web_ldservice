package com.wiatec.ldservice.oxm.pojo;

/**
 * Created by xuchengpeng on 25/07/2017.
 */
public class RemoveApkInfo {

    private int id;
    private String packageName;
    private int code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RemoveApkInfo{" +
                "id=" + id +
                ", packageName='" + packageName + '\'' +
                ", code=" + code +
                '}';
    }
}
