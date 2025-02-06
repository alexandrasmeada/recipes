package flavor.and.taste.recipes.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginDetails {
    private String token;
    private long expiresIn;
}
