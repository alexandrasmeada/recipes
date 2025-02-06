package flavor.and.taste.recipes.web.controller;

import flavor.and.taste.recipes.model.LoginDetails;
import flavor.and.taste.recipes.model.UserDetails;
import flavor.and.taste.recipes.service.AuthService;
import flavor.and.taste.recipes.web.api.AuthController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller
@Slf4j
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    @Override
    public ResponseEntity<LoginDetails> authenticate(String requestId, UserDetails registerRequest) {
        return ResponseEntity.ok(authService.authenticate(registerRequest));
    }

    @Override
    public ResponseEntity<Void> register(String requestId, UserDetails registerRequest) {
        authService.register(registerRequest);
        return ResponseEntity.ok().build();
    }
}
