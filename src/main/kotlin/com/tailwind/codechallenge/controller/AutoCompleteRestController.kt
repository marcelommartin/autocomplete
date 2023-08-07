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

    var scrabbleList = emptyList<String>()

    companion object {
        const val AUTOCOMPLETE_FILE_NAME = "scrabble.txt"
    }

    init {
        scrabbleList = CodeChallengeUtil.readTextFileToList(AUTOCOMPLETE_FILE_NAME)
    }

    @GetMapping("/{partialWord}")
    fun getAutoCompletion(@PathVariable partialWord: String): ResponseEntity<List<String>> {
        val suggestions = scrabbleList
            .filter { it.startsWith(partialWord, true) }
            .sorted()
            .take(10)

        return if (suggestions.isNotEmpty()) {
            ResponseEntity.ok(suggestions)
        } else {
            ResponseEntity
                .status(418)
                .build()
        }
    }
}