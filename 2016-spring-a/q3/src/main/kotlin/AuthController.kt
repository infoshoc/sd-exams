import com.google.inject.Inject

open class TokenFactory {
    companion object {
        private var token: AuthToken = AuthCenter.getNewToken()
    }

    fun get() = token

    fun getNewToken(): AuthToken {
        token = AuthCenter.getNewToken()

        return token
    }
}

class AuthController
@Inject
constructor(
        private val tokenFactory: TokenFactory
)
{
    private var t = tokenFactory.get()

    fun process(userId: String) {
        if (t.hasExpired())
            t = tokenFactory.getNewToken()
        // the rest of the function
    }
}

class AuthToken {
    fun hasExpired(): Boolean {
        return false
    }
}

class AuthCenter {
    companion object {
        fun getNewToken(): AuthToken {
            return AuthToken()
        }
    }
}
