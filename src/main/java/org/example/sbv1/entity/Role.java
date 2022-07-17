/**
 * @Autor GapSerg
 * @Create 2022-07-14.07.2022 20:04
 **/

package org.example.sbv1.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}