package au.com.telstra.simcardactivator.controller;

import org.springframework.stereotype.Component;

import au.com.telstra.simcardactivator.entity.SimCardDetails;
import au.com.telstra.simcardactivator.model.ActuationResult;
import au.com.telstra.simcardactivator.model.SimCard;
import au.com.telstra.simcardactivator.repository.SimCardRepository;

@Component
public class DatabaseConduit {
    private final SimCardRepository simCardRepository;

    public DatabaseConduit(SimCardRepository simCardRepository) {
        this.simCardRepository = simCardRepository;
    }

    public void save(SimCard simCard, ActuationResult actuationResult) {
        SimCardDetails newRecord = new SimCardDetails(simCard, actuationResult);
        simCardRepository.save(newRecord);
    }

    public SimCard querySimCard(long simCardId) {
        var simCardRecord = simCardRepository.findById(simCardId).orElse(null);
        if (simCardRecord == null) {
            return null;
        }

        return new SimCard(simCardRecord);
    }
}