import kotlin.reflect.KClass

class Main {
    private val nameSizes = mutableListOf<NameSize>()

    val count: Int
        get() = nameSizes.size

    interface Node {
        val firstChild: Node?
        val nodeName: String
        val nextSibling: Node?
    }

    abstract class Generator(val node: Node) {
        abstract fun generateOutputs(): List<Any>
    }

    enum class Factory {
        INSTANCE;

        // This is a singleton.
        private val generatorByName = mutableMapOf<String, KClass<*>>()

        fun register(name: String, klass: KClass<*>): String {
            val normalizedName = normalize(name)

            generatorByName.put(normalizedName, klass)

            return normalizedName
        }

        private fun normalize(name: String): String {
            return name.toLowerCase()
        }


        fun getClassFromName(name: String): KClass<*>? {
            return generatorByName.get(name)
        }

        fun create(child: Node, name: String): Generator?  {
            val cls = Factory.INSTANCE.getClassFromName(name)
            return cls?.java?.getConstructor(Node::class.java)?.newInstance(child) as Generator?
        }
    }

    class GeneratorA(node: Node) : Generator(node) {
        @Override
        override fun generateOutputs(): List<Any> {
            return listOf("value_a_1", "value_a_2")
        }
    }

    class GeneratorB(node: Node) : Generator(node) {
        @Override
        override fun generateOutputs(): List<Any> {
            return listOf("value_b_1")
        }
    }

    fun compute(root: Node): List<Any> {
        val result = mutableListOf<Any>()
        var child: Node? = root.firstChild
        while (child != null) {
            val name = child.nodeName
            val generator = Factory.INSTANCE.create(child, name)

            if (null != generator) {
                val output = generator.generateOutputs()
                result.addAll(output)
                nameSizes.add(NameSize(name, output.size))
            }

            child = child.nextSibling
        }
        return result
    }

    fun getSummaryAt(index: Int): String {
        return nameSizes[index].summary
    }

    fun getNameAt(index: Int): String {
        return nameSizes[index].name
    }

    fun getOutputSizeAt(index: Int): Int {
        return nameSizes[index].size
    }

    companion object {
        val A = Factory.INSTANCE.register("NAME_A", GeneratorA::class)
        val B = Factory.INSTANCE.register("NAME_B", GeneratorB::class)

        private data class NameSize(
                val name: String,
                val size: Int
        ) {
            val summary: String = "$name:$size";
        }
    }
}