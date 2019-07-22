fun <A, B> combine(rga: RandomGenerator<A>, rgb: RandomGenerator<B>): RandomGenerator<Pair<A, B>> {
    return rga.flatMap { a -> rgb.map { b -> Pair(a, b) } }
}

fun <A, B, C> combine(rga: RandomGenerator<A>, rgb: RandomGenerator<B>, rgc: RandomGenerator<C>) : RandomGenerator<Triple<A, B, C>> {
    return combine(rga, rgb).flatMap { (a, b) -> rgc.map { c -> Triple(a, b, c) } }
}
