package com.example.user.service;
import com.example.user.dto.request.TeamRequest;
import com.example.user.global.domain.entity.Team;
import com.example.user.global.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService{

    private final TeamRepository teamRepository;

    @Override
    public Boolean isAuthenticatedTeam(TeamRequest request) {
        Optional<Team> byLeaderAndSecret = teamRepository.findByLeaderAndSecret(request.secret(), request.leader());
        byLeaderAndSecret.orElseThrow(IllegalArgumentException::new);

        return true;
    }
}