package au.com.telstra.simcardactivator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.simcardactivator.model.SimCard;

@RestController
public class SimCardController {

    private final DatabaseConduit databaseConduit;
    private final ResponseHandler responseHandler;

    public SimCardController(DatabaseConduit databaseConduit, ResponseHandler responseHandler) {
        this.databaseConduit = databaseConduit;
        this.responseHandler = responseHandler;
    }

    @PostMapping(value = "/activate")
    public void handleActivationRequest(@RequestBody SimCard simCard) {
        var actuationResult = responseHandler.actuate(simCard);
        databaseConduit.save(simCard, actuationResult);
    }

    @GetMapping(value = "/query")
    public SimCard handleActivationRequest(@RequestParam Long simCardId) {
        return databaseConduit.querySimCard(simCardId);
    }
}