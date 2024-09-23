package com.logether.raid.controller;

import com.logether.raid.domain.Raid;
import com.logether.raid.service.RaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/raid")
public class RaidController {

    private final RaidService raidService;

    @PostMapping("/raidAdd")
    public ResponseEntity<String> raidAdd(@RequestBody Raid raid) {
        raidService.raidAdd(raid);
        return new ResponseEntity<>("raid page: " + raid.getRaidPage(), HttpStatus.CREATED);
    }

    @GetMapping("/page/{raidPage}")
    public ResponseEntity<String> getRaidPage(@PathVariable String raidPage) {
        Optional<Raid> raidOptional = raidService.findByRaidPage(raidPage);

        if (raidOptional.isPresent()) {
            Raid raid = raidOptional.get();
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
