package creatures

import Constants.maxAttackOrDefense
import Constants.maxHeals
import Constants.minAttackOrDefense
import creatures.util.Damage
import creatures.util.damage_calculator.DamageCalculator
import creatures.util.damage_calculator.DamageCalculatorImpl

abstract class Creature (
    val defense: Int,
    val attack: Int,
    val damage: Damage,
    health: Int,
){
    private val maxHealth = health

    var health = health
        private set
    var amountOfHeals = maxHeals
        private set
    var isAlive: Boolean = true
        private set


    init {
        if ( argumentsAreCorrect() ) {
            throw IllegalArgumentException()
        }
    }


    open fun heal() {
        if (amountOfHeals > 0 && isAlive) {
            amountOfHeals--

            health += (maxHealth/2)

            if (health > maxHealth) {
                health = maxHealth
            }
        }
    }



    open fun attack(
        opponent: Creature,
        damageCalculator: DamageCalculator = DamageCalculatorImpl()
    ) {
        val damage = damageCalculator.calculateDamage(this, opponent)

        if (damage != null) {
            println("Attack is successful! $damage damage was dealt!")
            opponent.recieveDamage(damage)

            return
        }

        println("Attack was unsuccessful!")

    }

    open fun recieveDamage(damage: Int) {
        health-=damage
        if (health <=0) {
            health = 0

            isAlive = false
        }
    }


    private fun argumentsAreCorrect(): Boolean {
        return (attack < minAttackOrDefense || attack > maxAttackOrDefense) ||
               (defense < minAttackOrDefense || defense > maxAttackOrDefense) ||
               (health < 0 || health > Constants.maxHealth)
    }





}