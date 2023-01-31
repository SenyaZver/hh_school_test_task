package creatures.util.damage_calculator

import Constants.chanceCutOff
import creatures.Creature

class DamageCalculatorImpl: DamageCalculator {

    override fun calculateDamage(attacker: Creature, defender: Creature): Int? {

        val attackModifier = attacker.attack - defender.defense + 1
        println("Attack Modifier is $attackModifier")

        val amountOfRolls = 1.coerceAtLeast(attackModifier)

        for (i in 0 until amountOfRolls) {
            val chance = (1..6).random()

            if (chance >= chanceCutOff) {
                return attacker.damage.getRandomDamage()
            }
        }

        return null
    }

}