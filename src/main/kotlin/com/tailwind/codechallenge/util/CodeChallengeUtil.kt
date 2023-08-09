package com.tailwind.codechallenge.util

import org.apache.commons.collections4.trie.PatriciaTrie
import java.io.File
import kotlin.streams.asStream

class CodeChallengeUtil {

    companion object {

        fun readTextFileToList(filePath: String): PatriciaTrie<Boolean> {
            val file = File(filePath)
            if (!file.exists()) {
                throw IllegalArgumentException("File not found at path: $filePath")
            }

            val scrabblesTrie = PatriciaTrie<Boolean>()

            file.useLines { line ->
                line.asStream()
                .sorted()
                .forEachOrdered { scrabblesTrie[it] = true  }}

            return scrabblesTrie
        }
    }
}