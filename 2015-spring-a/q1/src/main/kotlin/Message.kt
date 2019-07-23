class Message {
    fun save(mp: MessagePersister = MessagePersister()) {
        mp.save(this)
    }

    fun load(mp: MessagePersister = MessagePersister()) {
        val loaded = mp.load()
        //
    }
}

class MessagePersister {
    var m: Message = Message()

    fun save(m: Message) {
        this.m = m
    }

    fun load(): Message {
        return m
    }
}