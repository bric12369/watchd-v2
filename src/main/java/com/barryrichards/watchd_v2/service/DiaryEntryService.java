package com.barryrichards.watchd_v2.service;

import org.springframework.stereotype.Service;

import com.barryrichards.watchd_v2.dto.DiaryEntryRequest;
import com.barryrichards.watchd_v2.model.Account;
import com.barryrichards.watchd_v2.model.DiaryEntry;
import com.barryrichards.watchd_v2.model.Film;
import com.barryrichards.watchd_v2.repository.DiaryEntryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DiaryEntryService {
    
    private DiaryEntryRepository diaryEntryRepository;
    private AccountService accountService;
    private FilmService filmService;

    public DiaryEntry postDiaryEntry(DiaryEntryRequest diaryEntryRequest) {
        Account account = accountService.findById(diaryEntryRequest.accountId());
        Film film = filmService.findOrCreateByTmdbId(diaryEntryRequest.tmdbId());
        DiaryEntry entry = new DiaryEntry(account, film, diaryEntryRequest.rating());
        if (!diaryEntryRequest.reviewText().equals(null)) {
            entry.setReviewText(diaryEntryRequest.reviewText());
        }
        return diaryEntryRepository.save(entry);
    }
}
