package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CheckoutData {
    @JsonProperty("LoginAccount")
    public LoginData loginAccount;

    @JsonProperty("Products")
    public List<ProductData> products;

    @JsonProperty("ShippingInfo")
    public ShippingInfo shippingInfo;

    @JsonProperty("BillingInfo")
    public BillingInfo billingInfo;
}
