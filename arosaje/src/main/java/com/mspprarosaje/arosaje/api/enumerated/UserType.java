package com.mspprarosaje.arosaje.api.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.mspprarosaje.arosaje.api.enumerated.Permission.*;

@RequiredArgsConstructor
public enum UserType {
    USER(Collections.emptySet()),
    BOTANIST(
            Set.of(
                    BOTANIST_READ,
                    BOTANIST_CREATE,
                    BOTANIST_DELETE,
                    BOTANIST_UPDATE
            )
    );

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
