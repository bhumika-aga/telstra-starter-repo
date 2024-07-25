package au.com.telstra.simcardactivator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import au.com.telstra.simcardactivator.model.ActuationResult;
import au.com.telstra.simcardactivator.model.SimCard;

@Entity
public class SimCardDetails {

    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String iccId;

    @Column(nullable = false)
    private String customerEmail;

    @Column(nullable = false)
    private boolean active;

    protected SimCardDetails() {
    }

    public SimCardDetails(SimCard simCard, ActuationResult actuationResult) {
        this.iccId = simCard.getIccId();
        this.customerEmail = simCard.getCustomerEmail();
        this.active = actuationResult.getSuccess();
    }

    public long getId() {
        return id;
    }

    public String getIccId() {
        return iccId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public boolean getActive() {
        return active;
    }

    @Override
    public String toString() {
        return "SimCardDetails [id=" + id + ", iccId=" + iccId + ", customerEmail=" + customerEmail + ", active="
                + active + "]";
    }

}