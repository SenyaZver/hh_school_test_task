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
        if (isAlive) {
            println("Player tries to attack!")
        }
        super.attack(opponent, damageCalculator)
    }

    override fun receiveDamage(damage: Int) {
        if (isAlive) {
            println("Player receives $damage damage!")
        }

        super.receiveDamage(damage)

        if (this.health == 0) {
            println("Player died!")
        }
    }
}