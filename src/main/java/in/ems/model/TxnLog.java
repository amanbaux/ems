/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ems.model;

/**
 *
 * @author Aman
 */
public class TxnLog {
    
    private String userId;
    private String txnType;
    private String incReq;
    private String response;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getIncReq() {
        return incReq;
    }

    public void setIncReq(String incReq) {
        this.incReq = incReq;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "TxnLog{" + "userId=" + userId + ", txnType=" + txnType + ", incReq=" + incReq + ", response=" + response + '}';
    }
    
}
