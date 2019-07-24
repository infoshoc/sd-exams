import com.authzee.kotlinguice4.getInstance
import com.google.inject.Guice
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class ShoppingCartTest {
    @Test
    fun example() {
        val item1 = Item(42.0)
        val item2 = Item(23.0)

        Guice.createInjector(ShoppingModule())
                .getInstance<ShoppingCart>()
                .addItem(item1)
                .addItem(item2)
    }

    @Test
    fun test() {
        val sc = mockk<ShipCalculator>()
        every { sc.isEntitled(1.0, 1) } returns false
        every { sc.isEntitled(2.0, 2) } returns true

        val ssc = ShoppingCart(sc)
        ssc.addItem(Item(1.0))
        assertThat(ssc.isEntitled(), equalTo(false))
        ssc.addItem(Item(1.0))
        assertThat(ssc.isEntitled(), equalTo(false))
    }
}