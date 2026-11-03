package Arell.Andre.model.data

import android.content.Context
import Arell.Andre.model.domain.User
import Arell.Andre.model.preferences.UserPreferences

class Users(context: Context) {
    val users = listOf(
        User("andre@gmail.com", "123456", "Andre"),
        User("ash@gmail.com", "pikachu", "Ash"),
        User("misty@gmail.com", "staryu", "Misty")
    )

    private val shared = context.getSharedPreferences(UserPreferences.ARCHIVO, Context.MODE_PRIVATE)

    fun getUserByMail(mail: String): User? =
        users.firstOrNull { it.email.equals(mail.trim(), ignoreCase = true) }

    fun loginService(email: String, password: String): User? {
        val user = getUserByMail(email)
        return if (user != null && user.password == password) {
            saveUser(user)
            user
        } else null
    }

    fun saveUser(user: User) {
        shared.edit()
            .putString(UserPreferences.USER, user.email)
            .putString(UserPreferences.USERNAME, user.name)
            .apply()
    }

    fun isLoggedIn(): Boolean =
        !shared.getString(UserPreferences.USER, null).isNullOrBlank() &&
            !shared.getString(UserPreferences.USERNAME, null).isNullOrBlank()

    fun logout() {
        shared.edit()
            .remove(UserPreferences.USER)
            .remove(UserPreferences.USERNAME)
            .apply()
    }

    fun isGridDisplay(): Boolean =
        shared.getBoolean(UserPreferences.POKEMON_DISPLAY, false)

    fun savePokemonDisplay(grid: Boolean) {
        shared.edit().putBoolean(UserPreferences.POKEMON_DISPLAY, grid).apply()
    }
}
