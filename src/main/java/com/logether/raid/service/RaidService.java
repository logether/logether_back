package com.logether.raid.service;

import com.logether.raid.domain.Raid;

import java.util.Optional;

public interface RaidService {

    void raidAdd(Raid raid);

    Optional<Raid> findByRaidPage(String raidPage);
}
