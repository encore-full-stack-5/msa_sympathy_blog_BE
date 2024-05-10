package com.example.user.service;

import com.example.user.dto.request.TeamRequest;

public interface TokenService {
    Boolean isAuthenticatedTeam(TeamRequest request);
}