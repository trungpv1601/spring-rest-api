package com.trungpv.springrestapi.payload.response;

/**
 *
 * @author trungpv
 */
public class UserIdentityAvailabilityResponse {

    private Boolean available;

    public UserIdentityAvailabilityResponse(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
