package com.prisonManagementSystem.enums;

import java.io.Serializable;

public enum Authority {
    ROLE_ADMIN,
    ROLE_GUEST,
    ROLE_OFFICER,
    ROLE_SECTION_ADMIN,
    ANONYMOUS;

    public String getAuthority(){return this.name();}

}
