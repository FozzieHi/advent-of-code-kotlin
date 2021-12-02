package `2015`

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src/2015", "$name.txt").readLines()

/**
 * Reads text from the given input txt file.
 */
fun readInputText(name: String) = File("src/2015", "$name.txt").readText()

/**
 * Converts string to `2015`.md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
