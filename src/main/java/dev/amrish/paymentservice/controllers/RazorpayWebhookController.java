package dev.amrish.paymentservice.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorpayWebhookController {

    @PostMapping("/razorpayWebhook")
    public void paymentDone(@RequestBody Object object) {
        System.out.println(object);

        // Update the payment db table here
    }
}