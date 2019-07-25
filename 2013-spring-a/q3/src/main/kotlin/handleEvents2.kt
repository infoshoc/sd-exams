class Event(val valid: Boolean)
interface EventHandler {
    fun handle(e: Event)
}

fun handleEvents2(handlers: Iterable<EventHandler>, events: Iterable<Event>) {
    for ((ev, e) in combine(handlers, events)) {
        ev.handle(e)
    }
}

fun <T, S> combine(t: Iterable<T>, s: Iterable<S>): Iterable<Pair<T, S>> {
    val l = mutableListOf<Pair<T, S>>();

    for (tt in t) {
        for (ss in s) {
            l.add(Pair(tt, ss))
        }
    }

    return l
}

fun handleWhileValid2(handlers: Iterable<EventHandler>, events: Iterable<Event>) {
    for ((ev, e) in combine(handlers, takeWhile(events){it.valid})) {
        ev.handle(e)
    }
}

fun <T> takeWhile(t: Iterable<T>, p: (T) -> Boolean): Iterable<T> {
    val retrunValue = mutableListOf<T>()

    for (tt in t) {
        if (!p(tt)) {
            break
        }

        retrunValue.add(tt)
    }

    return retrunValue
}
