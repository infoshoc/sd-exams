import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals

class DiscountGiverTest {
    @Test
    fun test() {
        val accounts = arrayOf(Account(), GoldAccount(), SuperGoldAccount())
        val `$` = DiscountGiver()
        assertEquals(DiscountGiver.ACCOUNT_DISCOUNT, `$`.getDiscount(accounts[0]))
        assertEquals(DiscountGiver.GOLD_DISCOUNT, `$`.getDiscount(accounts[1]))
        assertEquals(DiscountGiver.SUPER_DISCOUNT, `$`.getDiscount(accounts[2]))
    }
}