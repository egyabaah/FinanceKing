///**
// * 
// */
//package com.egyabaah.FinanceKing.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * @author gyabe
// *
// */
//
//@Component
//public class UserAuthenticationProvider {
//    @Value("${security.jwt.token.secret-key:secret-key}")
//    private String secretKey;
//    
//    private final AuthenticationService authenticationService;
//
//    public UserAuthenticationProvider(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//
//    @PostConstruct
//    protected void init() {
//        // this is to avoid having the raw secret key available in the JVM
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }
//
//    public String createToken(String login) {
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + 3600000); // 1 hour
//
//        Algorithm algorithm = Algorithm.HMAC256(secretKey);
//        return JWT.create()
//                .withIssuer(login)
//                .withIssuedAt(now)
//                .withExpiresAt(validity)
//                .sign(algorithm);
//    }
//
//    public Authentication validateToken(String token) {
//        Algorithm algorithm = Algorithm.HMAC256(secretKey);
//
//        JWTVerifier verifier = JWT.require(algorithm)
//                .build();
//
//        DecodedJWT decoded = verifier.verify(token);
//
//        UserDto user = authenticationService.findByLogin(decoded.getIssuer());
//
//        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
//    }
//
//    public Authentication validateCredentials(CredentialsDto credentialsDto) {
//        UserDto user = authenticationService.authenticate(credentialsDto);
//        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
//    }
//}
