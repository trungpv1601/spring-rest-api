package com.trungpv.springrestapi.controller;

import com.trungpv.springrestapi.payload.response.UserIdentityAvailabilityResponse;
import com.trungpv.springrestapi.payload.response.UserProfileResponse;
import com.trungpv.springrestapi.payload.response.UserSummaryResponse;
import com.trungpv.springrestapi.exception.ResourceNotFoundException;
import com.trungpv.springrestapi.model.User;
import com.trungpv.springrestapi.repository.UserRepository;
import com.trungpv.springrestapi.security.UserPrincipal;
import com.trungpv.springrestapi.security.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author trungpv
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummaryResponse getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummaryResponse userSummary = new UserSummaryResponse(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailabilityResponse checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailabilityResponse(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailabilityResponse checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailabilityResponse(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfileResponse getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfileResponse userProfile = new UserProfileResponse(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt());

        return userProfile;
    }

}
