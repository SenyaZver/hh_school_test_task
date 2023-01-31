package creatures.util.damage_calculator

import Constants.chanceCutOff
import creatures.Creature

class DamageCalculatorImpl: DamageCalculator {

    override fun calculateDamage(attacker: Creature, defender: Creature): Int? {

        val attackModifier = attacker.attack - defender.defense + 1

        for (i in 0 until attackModifier) {
            val chance = (1..6).random()

            if (chance >= chanceCutOff) {
                return attacker.damage.getRandomDamage()
            }
        }

        return null
    }

}