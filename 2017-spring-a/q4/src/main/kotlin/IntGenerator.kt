import kotlin.random.Random

class IntGenerator: RandomGenerator<Int> {
    override fun get(): Int =Random.nextInt()
}