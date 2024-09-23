package com.logether.raid.mapper;

import com.logether.raid.domain.Raid;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface RaidMapper {

    void raidAdd(Raid raid);

    Optional<Raid> findByRaidPage(String raidPage);
}
