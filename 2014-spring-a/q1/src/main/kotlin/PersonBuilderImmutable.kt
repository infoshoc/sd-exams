class PersonBuilderImmutable
private constructor(
    private var firstName: String?,
    private var lastName: String?,
    private var address: String?
)
{
    fun setFirstName(firstName: String): PersonBuilderImmutable {
        return PersonBuilderImmutable(firstName, lastName, address)
    }

    fun setLastName(lastName: String): PersonBuilderImmutable {
        this.lastName = lastName
        return PersonBuilderImmutable(firstName, lastName, address)
    }

    fun setAddress(address: String): PersonBuilderImmutable {
        this.address = address
        return PersonBuilderImmutable(firstName, lastName, address)
    }

    fun build(): Person {
        return Person(firstName, lastName, address)
    }

    constructor():this(firstName = null, lastName = null, address = null)
}