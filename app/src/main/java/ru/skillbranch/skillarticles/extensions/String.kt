package ru.skillbranch.skillarticles.extensions


fun String?.indexesOf(query: String, ignoreCase: Boolean = true): List<Int> {
    this ?: return emptyList()
    if (query == "") return emptyList()
    val result = mutableListOf<Int>()
    var index = indexOf(query, 0, ignoreCase)
    while (index >= 0) {
        result.add(index)
        index = indexOf(query, index + query.length, ignoreCase)
    }
    return result.toList()
}