package com.tailwind.codechallenge.util

import java.io.File

class CodeChallengeUtil {

    companion object {

        fun readTextFileToList(filePath: String): List<String> {
            val file = File(filePath)
            if (!file.exists()) {
                throw IllegalArgumentException("File not found at path: $filePath")
            }

            return file.useLines { it.toList() }
        }
    }
}