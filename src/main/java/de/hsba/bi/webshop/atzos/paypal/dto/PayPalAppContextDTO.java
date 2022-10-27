package de.hsba.bi.webshop.atzos.paypal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PayPalAppContextDTO {
    @JsonProperty("Atzos Love")
    private String brandName;
    @JsonProperty("LOGIN")
    private PaymentLandingPage landingPage;
    @JsonProperty("return=representation")
    private String returnUrl;
    @JsonProperty("/user/myBoughtProducts")
    private String cancelUrl;
}
