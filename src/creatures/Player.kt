package creatures

import creatures.util.Damage
import creatures.util.damage_calculator.DamageCalculator

class Player(
    defense: Int,
    attack: Int,
    damage: Damage,
    health: Int
): Creature(
    defense = defense,
    attack = attack,
    damage = damage,
    health = health
) {
    init {
        println("A Player was created!")
    }

    override fun heal() {
        super.heal()
        println("Player was healed to $health!")
    }

    override fun attack(
        opponent: Creature,
        damageCalculator: DamageCalculator
    ) {
        println("Player tries to attack!")
        super.attack(opponent, damageCalculator)
    }

    override fun recieveDamage(damage: Int) {
        println("Player recieves $damage damage!")
        super.recieveDamage(damage)

        if (this.health == 0) {
            println("Player died!")
        }
    }
}