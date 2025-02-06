package flavor.and.taste.recipes.web.api;

import flavor.and.taste.recipes.model.LoginDetails;
import flavor.and.taste.recipes.model.UserDetails;
import flavor.and.taste.recipes.web.headers.RequestId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.String;

import static flavor.and.taste.recipes.model.HttpRequestHeaders.X_REQUEST_ID;

@RequestMapping("/auth")
public interface AuthController {

    @Operation(summary = "Login")
    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Successfully logged in",
                    content = @Content(
                            schema = @Schema(implementation = LoginDetails.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = @Content(
                            schema = @Schema(implementation = Error.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = Error.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE)),
    })
    default ResponseEntity<LoginDetails> authenticate(
            @RequestId @RequestHeader(name = X_REQUEST_ID) String requestId,
            @Validated @RequestBody UserDetails registerRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Register")
    @PostMapping("/register")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Successfully registered",
                    content = @Content(
                            schema = @Schema(implementation = UserDetails.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = @Content(
                            schema = @Schema(implementation = Error.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = Error.class),
                            mediaType = MediaType.APPLICATION_JSON_VALUE)),
    })
    default ResponseEntity<Void> register(
            @RequestId @RequestHeader(name = X_REQUEST_ID) String requestId,
            @Validated @RequestBody UserDetails registerRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
