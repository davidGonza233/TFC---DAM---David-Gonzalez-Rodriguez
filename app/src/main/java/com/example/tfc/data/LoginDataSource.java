package com.example.tfc.data;

import com.example.tfc.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
//todo hacer comprobocciones de login
        try {
            if (username.equals("admin") && password.equals("123456")) {
                LoggedInUser user =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                "Administrador");
                return new Result.Success<>(user);
            } else {
                return new Result.Error(new IOException("Credenciales incorrectas"));
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }

    }

    public void logout() {
        // TODO: revoke authentication
    }
}