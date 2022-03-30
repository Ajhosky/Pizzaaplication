package pl.piotrkwiecien.pizzaapplication.domain.service;

import pl.piotrkwiecien.pizzaapplication.domain.exception.UnauthorizedException;

public class AuthorizationService {
    public static void checkToken(String token){
        if(token == null || !token.equals("")){
            throw new UnauthorizedException("Błędny token");
        }
    }
}
