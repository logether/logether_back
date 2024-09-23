package com.logether.raid.service;

import com.logether.raid.domain.Raid;
import com.logether.raid.mapper.RaidMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RaidServiceImpl implements RaidService {

    private final RaidMapper raidMapper;

    @Override
    public void raidAdd(Raid raid) {
        String raidPage = UUID.randomUUID().toString();
        raid.setRaidPage(raidPage);

        raidMapper.raidAdd(raid);
    }

    @Override
    public Optional<Raid> findByRaidPage(String raidPage) {
        return raidMapper.findByRaidPage(raidPage);
    }
}
