package com.barryrichards.watchd_v2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barryrichards.watchd_v2.dto.DiaryEntryRequest;
import com.barryrichards.watchd_v2.model.DiaryEntry;
import com.barryrichards.watchd_v2.service.DiaryEntryService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/diary-entry")
public class DiaryEntryController {
    
    private DiaryEntryService diaryEntryService;

    @PostMapping("")
    public DiaryEntry saveDiaryEntry(@Valid @RequestBody DiaryEntryRequest diaryEntryRequest) {
        return diaryEntryService.postDiaryEntry(diaryEntryRequest);
    }
}
