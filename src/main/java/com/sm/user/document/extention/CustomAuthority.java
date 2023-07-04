package com.sm.user.document.extention;

import org.springframework.security.core.GrantedAuthority;

public class CustomAuthority implements GrantedAuthority {

    private String key;
    private String value;
    private String authority;

    public CustomAuthority(String key, String value){
        authority= key+" : "+value;
    }
    @Override
    public String getAuthority() {
        return authority;
    }
}
