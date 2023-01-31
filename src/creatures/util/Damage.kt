package creatures.util



class Damage(
    private val minDamage: Int,
    private val maxDamage: Int
) {
    init {
        if (minDamage < 0 || maxDamage < minDamage) {
            throw IllegalArgumentException()
        }
    }

    fun getRandomDamage() = (minDamage..maxDamage).random()
}