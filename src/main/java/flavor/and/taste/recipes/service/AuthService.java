package flavor.and.taste.recipes.service;

import flavor.and.taste.recipes.dao.entity.UserEntity;
import flavor.and.taste.recipes.dao.repository.UserRepository;
import flavor.and.taste.recipes.model.LoginDetails;
import flavor.and.taste.recipes.model.UserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public LoginDetails authenticate(UserDetails registerRequest) {
        UserEntity user = userRepository.findByUsername(registerRequest.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        if (!passwordEncoder.matches(registerRequest.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        String jwtToken = jwtService.generateToken(user);

        return LoginDetails.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();

    }

    public void register(UserDetails registerRequest) {
        if (userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }
        userRepository.save(UserEntity.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build());
    }
}
