/**
 * 
 */
package com.hehua.user.model;

import java.util.Date;

/**
 * @author zhihua
 *
 */
public class Client {

    private int id;

    private String clientid;

    private String deviceid;

    private String os;

    private String appversion;

    private String channel;

    private String dm;

    private Date cts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    public Date getCts() {
        return cts;
    }

    public void setCts(Date cts) {
        this.cts = cts;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", clientid=" + clientid + ", deviceid=" + deviceid + ", os="
                + os + ", appversion=" + appversion + ", channel=" + channel + ", dm=" + dm
                + ", cts=" + cts + "]";
    }

}
