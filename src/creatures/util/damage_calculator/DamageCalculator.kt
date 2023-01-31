package creatures.util.damage_calculator

import creatures.Creature


//implement this interface to change the way damage is calculated
//Example: TestDamageCalculator, which created to test Creature.attack(..) function
interface DamageCalculator {
    fun calculateDamage(attacker: Creature, defender: Creature): Int?
}