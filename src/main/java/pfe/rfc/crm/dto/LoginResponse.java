package pfe.rfc.crm.dto;

import lombok.Builder;
import org.springframework.security.core.userdetails.UserDetails;

@Builder

public class LoginResponse {
    private  String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public LoginResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}