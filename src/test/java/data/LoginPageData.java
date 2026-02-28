package data;

import enums.Platform;

import java.util.Map;

public class LoginPageData {
    public static final Map<Platform, String> USERNAME_ERROR_MSG = Map.of(
            Platform.ANDROID, "Username is required",
            Platform.IOS, "Username is required"
    );

    public static final Map<Platform, String> PASSWORD_ERROR_MSG = Map.of(
            Platform.ANDROID, "Enter Password",
            Platform.IOS, "Username is required"
    );
}
