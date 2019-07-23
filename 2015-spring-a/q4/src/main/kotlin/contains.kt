fun <T> contains(list: Future<List<T>>, x: T): Future<Boolean> {
    return list.map { it.contains(x) }
}

fun or(f1: Future<Boolean>, f2: Future<Boolean>): Future<Boolean> {
    return f1.flatMap { if (it) f1 else f2 }
}
