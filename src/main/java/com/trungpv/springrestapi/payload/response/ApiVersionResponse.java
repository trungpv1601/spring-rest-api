package com.trungpv.springrestapi.payload.response;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author trungpv
 */
public class ApiVersionResponse {

    @Value("${app.appName}")
    private String appName;
    @Value("${app.apiVersion}")
    private String version;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
