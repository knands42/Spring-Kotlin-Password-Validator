package com.itidigital.validator.service.validators

abstract class BaseValidators() {

    protected fun hasOneUpperCaseLetter(password: String): Boolean =
        """([A-Z])""".toRegex().containsMatchIn(password)

    protected fun hasMoreThanThreeUpperCaseLetter(password: String): Boolean =
        """(.*[A-Z]){3}""".toRegex().containsMatchIn(password)

    protected fun hasSpecialCharacterLetter(password: String): Boolean =
        """([!@#${'$'}%^&*()-+])""".toRegex().containsMatchIn(password)

    protected fun hasOneDigit(password: String): Boolean =
        """[0-9]""".toRegex().containsMatchIn(password)

    protected fun hasMoreThanOneDigit(password: String): Boolean =
        """(.*[0-9]){2}""".toRegex().containsMatchIn(password)

    protected fun hasOneLowerCaseLetter(password: String): Boolean = """([a-z])""".toRegex().containsMatchIn(password)

    protected fun hasMoreThanSixLowerCaseLetter(password: String): Boolean =
        """(.*[a-z]){6}""".toRegex().containsMatchIn(password)

    protected fun hasMoreThanNineCharacters(password: String): Boolean =
        """.{9}""".toRegex().containsMatchIn(password)

    protected fun hasNoSpaces(password: String): Boolean =
        """^\S*${'$'}""".toRegex().containsMatchIn(password)

    protected fun hasNoRepeatingCharacters(password: String): Boolean {
        val map = HashMap<Int, Char>()
        for ((index, value) in password.toCharArray().withIndex()) {
            if (map.values.contains(value)) {
                return false
            } else {
                map[index] = value
            }
        }

        return true
    }

}