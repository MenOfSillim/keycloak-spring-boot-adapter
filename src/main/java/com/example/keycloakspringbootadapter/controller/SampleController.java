package com.example.keycloakspringbootadapter.controller;

import com.example.keycloakspringbootadapter.entity.dto.KeycloakAccessTokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Keycloak!!";
    }

    @GetMapping("/app1")
    public String tracingTest() {
        return "This is permitAll";
    }

    @GetMapping("/tester/test")
    public String tester() {
        return "This is tester permit";
    }

    @GetMapping("/user/test")
    public String user() {
        return "This is user permit";
    }

    @GetMapping("/manager/test")
    public String manager() {
        log.info("manager router connect");
        return "This is manager permit";
    }

    @GetMapping("/userinfo")
    public String userInfoController(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        KeycloakPrincipal principal = (KeycloakPrincipal) auth.getPrincipal();

        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();
        KeycloakAccessTokenDTO keycloakAccessTokenDTO = KeycloakAccessTokenDTO.builder()
                .userName(accessToken.getPreferredUsername())
                .emailId(accessToken.getEmail())
                .lastName(accessToken.getFamilyName())
                .firstName(accessToken.getGivenName())
                .realmName(accessToken.getIssuer())
                .access(accessToken.getRealmAccess())
                .build();
        log.info(">> access token = {{}}", keycloakAccessTokenDTO);

        return "page";
    }
}
