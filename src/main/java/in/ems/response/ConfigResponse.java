/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ems.response;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Aman
 */
public class ConfigResponse {
    
    private List<AppConfigDetails> config;

    public List<AppConfigDetails> getConfig() {
        return config;
    }

    public void setConfig(List<AppConfigDetails> config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "ConfigResponse{" + "config=" + config + '}';
    }

  
    
}
