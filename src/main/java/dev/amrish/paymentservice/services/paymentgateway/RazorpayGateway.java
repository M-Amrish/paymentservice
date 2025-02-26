package dev.amrish.paymentservice.services.paymentgateway;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;

import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorpayGateway implements PaymentGateway {
    @Override
    public String generatePaymentLink() {
        RazorpayClient razorpay =
                null;
        try {
            razorpay = new RazorpayClient("rzp_test_z2yANeI4FB8qzH", "wYuYkAbxfEM5DZ2kjj10tWal");


            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", 1000);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", false);
//        paymentLinkRequest.put("first_min_partial_amount",100);


            paymentLinkRequest.put("expire_by", 1740739408);//epoch time
            paymentLinkRequest.put("reference_id", "TS1989789");
            paymentLinkRequest.put("description", "Payment for policy no #23456");

            JSONObject customer = new JSONObject();
            customer.put("name", "+919000090000");
            customer.put("contact", "Amrish M");
            customer.put("email", "amrish1363@gmail.com");
            paymentLinkRequest.put("customer", customer);

            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("reminder_enable", true);

            JSONObject notes = new JSONObject();
            notes.put("policy_name", "Jeevan Bima");
            paymentLinkRequest.put("notes", notes);
            paymentLinkRequest.put("callback_url", "https://google.com/");
            paymentLinkRequest.put("callback_method", "get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
            return payment.toString();
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }

    }}
