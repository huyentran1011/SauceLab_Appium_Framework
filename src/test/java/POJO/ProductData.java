package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductData {
    @JsonProperty("productName")
    public String productName;

    @JsonProperty("variations")
    public List<ProductVariation> variations;
}
