import kotlin.random.Random

class StringGenerator: RandomGenerator<String> {
    override fun get(): String = Random.nextBytes(10).contentToString()
}