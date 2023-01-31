package creatures.util.damage_calculator

import creatures.Creature

class TestDamageCalculator(
    private val damageToDeal: Int
): DamageCalculator {
    override fun calculateDamage(attacker: Creature, defender: Creature): Int? {
        return damageToDeal
    }
}