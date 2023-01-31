package creatures.util

import Constants.maxHealth


class Damage(
    private val minDamage: Int,
    private val maxDamage: Int
) {
    init {
        if (minDamage < 0 || maxDamage < minDamage || maxDamage > maxHealth) {
            throw IllegalArgumentException()
        }
    }

    fun getRandomDamage() = (minDamage..maxDamage).random()
}