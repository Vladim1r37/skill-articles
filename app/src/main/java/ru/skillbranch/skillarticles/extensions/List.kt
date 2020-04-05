package ru.skillbranch.skillarticles.extensions

fun List<Pair<Int, Int>>.groupByBounds(bounds: List<Pair<Int, Int>>): List<List<Pair<Int, Int>>> {
    val result = mutableListOf<List<Pair<Int, Int>>>()
    val searchResult = this.toMutableList()
    bounds.forEach {
        val iter = searchResult.listIterator()
        val acc = mutableListOf<Pair<Int, Int>>()
        while (iter.hasNext()) {
            val srItem = iter.next()
            if (srItem.first in it.first..it.second) {
                if (srItem.second in it.first..it.second) {
                    acc.add(srItem)
                    iter.remove()
                } else {
                    acc.add(srItem.first to it.second)
                    iter.set(it.second to srItem.second)
                    break
                }
            } else break
        }
        result.add(acc)
    }
    return result
}