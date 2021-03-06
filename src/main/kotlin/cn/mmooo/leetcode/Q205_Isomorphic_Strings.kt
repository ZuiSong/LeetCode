package cn.mmooo.leetcode


fun main(args: Array<String>) {
    isIsomorphic("ad", "aa")
            .let { println(it) }
}

/**
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while
preserving the order of characters. No two characters may map to the same
character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
 */
fun isIsomorphic(s: String, t: String): Boolean {

    val charMap = HashMap<Char, Char>()

    s.forEachIndexed { i, c ->
        if (charMap.contains(c)) {
            if (charMap[c] != t[i]) {
                return false
            }
        } else {
            charMap[c] = t[i]
            if (t[i] in t.slice(0 until i)) {
                return false
            }
        }
    }

    return true
}