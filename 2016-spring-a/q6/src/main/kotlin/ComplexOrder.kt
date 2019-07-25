class ComplexOrder<T>
private constructor(
        private val cmp: Comparator<T>,
        private val next: ComplexOrder<T>?
)
: Comparator<T>
{
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     *
     *
     *
     * In the foregoing description, the notation
     * <tt>sgn(</tt>*expression*<tt>)</tt> designates the mathematical
     * *signum* function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * *expression* is negative, zero or positive.
     *
     *
     *
     * The implementor must ensure that <tt>sgn(compare(x, y)) ==
     * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>compare(x, y)</tt> must throw an exception if and only
     * if <tt>compare(y, x)</tt> throws an exception.)
     *
     *
     *
     * The implementor must also ensure that the relation is transitive:
     * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
     * <tt>compare(x, z)&gt;0</tt>.
     *
     *
     *
     * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
     * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
     * <tt>z</tt>.
     *
     *
     *
     * It is generally the case, but *not* strictly required that
     * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
     * any comparator that violates this condition should clearly indicate
     * this fact.  The recommended language is "Note: this comparator
     * imposes orderings that are inconsistent with equals."
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     * comparator does not permit null arguments
     * @throws ClassCastException if the arguments' types prevent them from
     * being compared by this comparator.
     */
    override fun compare(o1: T, o2: T): Int {
        val current = next?.compare(o1, o2) ?: 0

        return if (0 == current) cmp.compare(o1, o2) else current
    }

    fun and(c: Comparator<T>): ComplexOrder<T> =
            ComplexOrder(c, this)

    fun reverse(): ComplexOrder<T> {
        return ComplexOrder(Comparator{ o1, o2 -> -this@ComplexOrder.compare(o1, o2) }, null)
    }

        companion object {
        fun <T> using(c: Comparator<T>): ComplexOrder<T> = ComplexOrder(c, null)
    }
}