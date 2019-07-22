import java.util.function.Supplier

interface ItemVisitor {
    fun visit(i: AddItem)
    fun visit(i: RemoveItem)
    fun visit(i: MissingItem)
}

interface WarehouseOrder {
    fun accept(v: ItemVisitor)
}

class AddItem : WarehouseOrder {
    override fun accept(v: ItemVisitor) {
        v.visit(this)
    }
}

class RemoveItem : WarehouseOrder {
    override fun accept(v: ItemVisitor) {
        v.visit(this)
    }
}

class MissingItem : WarehouseOrder {
    override fun accept(v: ItemVisitor) {
        v.visit(this)
    }

}

internal class Warehouse {
    fun listenTo(s: Supplier<WarehouseOrder>) {
        while (true) {
            val order = s.get()
            // Warehouse logic to handle orders ...
        }
    }
}

class LogOrder {
    fun logItemAdded(ai: AddItem ) { /*...*/ }
    fun logItemRemove(ri: RemoveItem) { /*...*/ }
    fun logMissingItem(mi: MissingItem ) { /*...*/ }
}

class LogItemVisitor(private val lo: LogOrder = LogOrder()): ItemVisitor {
    override fun visit(i: AddItem) {
        lo.logItemAdded(i)
    }
    override fun visit(i: RemoveItem) {
        lo.logItemRemove(i)
    }
    override fun visit(i: MissingItem) {
        lo.logMissingItem(i)
    }
}

class WarehouseOrderSupplierProxy(
        private val s: Supplier<WarehouseOrder>,
        private val v: ItemVisitor
): Supplier<WarehouseOrder> by s {
    override fun get(): WarehouseOrder {
        val o = s.get()
        o.accept(v)

        return o
    }
}
