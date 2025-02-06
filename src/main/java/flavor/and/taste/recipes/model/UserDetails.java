package flavor.and.taste.recipes.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetails {

    private final String username;
    private final String password;
}
