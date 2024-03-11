package com.mspprarosaje.arosaje.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mspprarosaje.arosaje.api.dto.user.UserMinimalDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    private UserMinimalDTO user;
}
