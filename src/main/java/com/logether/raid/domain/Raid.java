package com.logether.raid.domain;

import lombok.Data;

@Data
public class Raid {
    private int raidCode;
    private String userId;
    private String raidName;
    private String raidPage;
    private int raidCnt;
    private int raidEntry;
    private String raidPw;
}
