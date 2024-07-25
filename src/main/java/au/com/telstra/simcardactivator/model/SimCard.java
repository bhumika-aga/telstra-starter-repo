package au.com.telstra.simcardactivator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import au.com.telstra.simcardactivator.entity.SimCardDetails;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimCard {
    private String iccId;
    private String customerEmail;
    private boolean active;

    public SimCard() {
    }

    public SimCard(String iccId, String customerEmail, boolean active) {
        this.iccId = iccId;
        this.customerEmail = customerEmail;
        this.active = active;
    }

    public SimCard(SimCardDetails simCardDetails) {
        this.iccId = simCardDetails.getIccId();
        this.customerEmail = simCardDetails.getCustomerEmail();
        this.active = simCardDetails.getActive();
    }

    public String getIccId() {
        return iccId;
    }

    public void setIccId(String iccId) {
        this.iccId = iccId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "SimCard [iccId=" + iccId + ", customerEmail=" + customerEmail + ", active=" + active + "]";
    }
}