package creatures.util



class Damage(
    private val minDamage: Int,
    private val maxDamage: Int
) {
    fun getRandomDamage() = (minDamage..maxDamage).random()
}