package flavor.and.taste.recipes.web.api;

import flavor.and.taste.recipes.model.Category;
import flavor.and.taste.recipes.model.CategoryDto;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

import static flavor.and.taste.recipes.model.HttpRequestHeaders.X_REQUEST_ID;

public interface CategoryController {

    @Operation(summary = "Create a new Category")
    @PostMapping("/create/category")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Successfully created a new Category",
                    content = @Content(
                            schema = @Schema(implementation = Category.class),
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
    default ResponseEntity<Void> createCategory(
            @RequestId @RequestHeader(name = X_REQUEST_ID) String requestId,
            @Validated @RequestBody CategoryDto category) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Get all Categories")
    @GetMapping("/get/allCategories")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful",
                    content = @Content(
                            schema = @Schema(implementation = CategoryDto.class),
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
    default ResponseEntity<List<CategoryDto>> getAllCategories(@RequestId @RequestHeader(name = X_REQUEST_ID) String requestId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
