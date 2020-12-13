/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ems.response;

/**
 *
 * @author Aman
 */
public class AppConfigDetails {
    
    String configName;
    String configValue;

    public AppConfigDetails(){}
    
    public AppConfigDetails(String configName, String configValue) {
        this.configName = configName;
        this.configValue = configValue;
    }
    
    
    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    @Override
    public String toString() {
        return "AppConfigDetails{" + "configName=" + configName + ", configValue=" + configValue + '}';
    }
    
}
