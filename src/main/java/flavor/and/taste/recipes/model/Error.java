package flavor.and.taste.recipes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Error {

    String requestId;
    String message;
    int code;
    String status;
    String reason;
}
