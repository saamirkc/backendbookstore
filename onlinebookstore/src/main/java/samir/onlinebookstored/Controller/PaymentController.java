package samir.onlinebookstored.Controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import samir.onlinebookstored.entity.VerificationRequest;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final String khaltiVerifyUrl = "https://khalti.com/api/v2/payment/verify/";
//    private final String khaltiSecretKey = "test_secret_key_305ba280c8da45b4838fa99110ab79bd"; // Replace with your actual secret key
private final String khaltiSecretKey = "live_secret_key_7dbd278df5cb4b9abb7a46e81c66c88f";
    @PostMapping("/verify")
    public ResponseEntity<String> verifyPayment(@RequestBody VerificationRequest verificationRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Key " + khaltiSecretKey);

        // Prepare payload for verification request
        HttpEntity<VerificationRequest> requestEntity = new HttpEntity<>(verificationRequest, headers);

        // Make a POST request to Khalti server for verification
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(khaltiVerifyUrl, requestEntity, String.class);

        // Handle the response accordingly
        if (response.getStatusCode().is2xxSuccessful()) {
            // Payment verification success
            return ResponseEntity.ok(response.getBody());
        } else {
            // Payment verification failed
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }
}
