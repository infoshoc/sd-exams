class PersonBuilder {
    private var firstName: String? = null
    private var lastName: String? = null
    private var address: String? = null
    fun setFirstName(firstName: String): PersonBuilder {
        this.firstName = firstName
        return this
    }

    fun setLastName(lastName: String): PersonBuilder {
        this.lastName = lastName
        return this
    }

    fun setAddress(address: String): PersonBuilder {
        this.address = address
        return this
    }

    fun build(): Person {
        return Person(firstName, lastName, address)
    }
}