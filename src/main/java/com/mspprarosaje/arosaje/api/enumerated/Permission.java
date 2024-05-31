package com.mspprarosaje.arosaje.api.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    BOTANIST_READ("botanist:read"),
    BOTANIST_CREATE("botanist:create"),
    BOTANIST_DELETE("botanist:delete"),
    BOTANIST_UPDATE("botanist:update"),
    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    ADMIN_UPDATE("admin:update");

    @Getter
    private final String permission;

}
