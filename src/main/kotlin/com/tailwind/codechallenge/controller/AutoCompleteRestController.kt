package com.tailwind.codechallenge.controller

import com.tailwind.codechallenge.util.CodeChallengeUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("autocomplete")
class AutoCompleteRestController {

    private final val scrabbles = CodeChallengeUtil.readTextFileToList(AUTOCOMPLETE_FILE_NAME)

    companion object {
        const val AUTOCOMPLETE_FILE_NAME = "scrabble.txt"
        const val SUGGESTIONS_COUNT = 10
    }

    @GetMapping("/{partialWord}")
    fun getAutoCompletion(@PathVariable partialWord: String): ResponseEntity<List<String>> {
        val suggestions = scrabbles.prefixMap(partialWord)
            .keys
            .take(SUGGESTIONS_COUNT)
            .toList()

        return if (suggestions.isNotEmpty()) {
            ResponseEntity.ok(suggestions)
        } else {
            ResponseEntity
                .status(418)
                .build()
        }
    }
}