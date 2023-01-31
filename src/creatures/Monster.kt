package creatures

import creatures.util.Damage
import creatures.util.damage_calculator.DamageCalculator

class Monster(
    defense: Int,
    attack: Int,
    damage: Damage,
    health: Int
): Creature(
    defense = defense,
    attack = attack,
    damage = damage,
    health = health,
) {
    init {
        println("A Monster was created!")
    }

    override fun heal() {
        super.heal()
        println("Monster was healed to $health!")
    }

    override fun attack(
        opponent: Creature,
        damageCalculator: DamageCalculator
    ) {
        println("Monster tries to attack!")
        super.attack(opponent, damageCalculator)
    }

    override fun recieveDamage(damage: Int) {
        println("Monster recieves $damage damage!")
        super.recieveDamage(damage)

        if (this.health == 0) {
            println("Monster died!")
        }
    }
}