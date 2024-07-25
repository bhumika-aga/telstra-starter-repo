package au.com.telstra.simcardactivator.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.simcardactivator.entity.SimCard;

@RestController
public class SimCardController {
    private final ResponseHandler responseHandler;

    public SimCardController(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }

    @PostMapping("/activate")
    public void handleActivationRequest(@RequestBody SimCard simCard) {
        var actuationResult = responseHandler.actuate(simCard);
        System.out.println(actuationResult.getSuccess());
    }
}