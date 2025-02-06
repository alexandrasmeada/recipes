package flavor.and.taste.recipes.web.headers;

import io.swagger.v3.oas.annotations.Parameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Parameter(
        name = "X-Request-ID",
        description = "Request ID",
        required = RequestId.REQUIRED)
@Target({ElementType.PARAMETER})
public @interface RequestId {

    boolean REQUIRED = true;
    String message() default "Request ID" + "is required";
}
