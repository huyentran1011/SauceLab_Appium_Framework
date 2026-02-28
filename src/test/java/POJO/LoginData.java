package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginData {
    @JsonProperty("username")
    public String username;

    @JsonProperty("password")
    public String password;
}
