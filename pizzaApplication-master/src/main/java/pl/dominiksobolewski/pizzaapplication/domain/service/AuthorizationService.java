package pl.dominiksobolewski.pizzaapplication.domain.service;

import pl.dominiksobolewski.pizzaapplication.domain.exception.UnauthorizedException;

public class AuthorizationService {
    public static void checkToken(String token){
        if(token == null || !token.equals("")){
            throw new UnauthorizedException("Błędny token");
        }
    }
}
