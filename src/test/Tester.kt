package test

import creatures.Monster
import creatures.Player
import creatures.util.Damage
import creatures.util.damage_calculator.TestDamageCalculator


class Tester {


    fun executeTests() {
        `initialisation test`()
        println()

        attackTest()
        println()

        `attack test (creature is dead)`()
        println()

        healTest()
        println()

        damageTest()
        println()

    }

    fun `initialisation test`() {
        println("//Starting Initialisation test//")

        try {
            val monster = Monster(
                defense = -1,
                attack = 2,
                damage = Damage(1, 10),
                health = 100
            )
        } catch (e: Exception) {
            println("//Initialisation test passed//")
            return
        }

        println("//Initialisation test failed//")
    }


    fun attackTest() {
        println("//Starting Attack test//")

        val monster = Monster(
            defense = 4,
            attack = 2,
            damage = Damage(1, 10),
            health = 100
        )

        val player = Player(
            defense = 2,
            attack = 10,
            damage = Damage(1, 10),
            health = 100
        )
        try {
            player.attack(opponent = monster)
        } catch (e: Exception) {
            println("//Attack test failed//")
        }
        println("//Attack test passed//")
    }

    fun `attack test (creature is dead)`() {
        println("//Starting Attack test (creature is dead)//")

        val monster = Monster(
            defense = 4,
            attack = 2,
            damage = Damage(1, 10),
            health = 100
        )

        val player = Player(
            defense = 2,
            attack = 10,
            damage = Damage(1, 10),
            health = 10
        )

        println("Player has ${player.health} health!")

        monster.attack(
            opponent = player,
            damageCalculator = TestDamageCalculator(damageToDeal = 10)
        )

        if (player.isAlive) {
            println("//Attack test (creature is dead) failed//")
        } else {
            println("//Attack test (creature is dead) passed//")
        }


    }

    fun healTest() {
        println("//Starting heal test//")

        val player = Player(
            defense = 2,
            attack = 10,
            damage = Damage(1, 10),
            health = 100
        )

        println("Player has ${player.health} health!")

        player.recieveDamage(80)

        player.heal()

        if (player.health == 70) {
            println("//Heal test passed//")
        } else {
            println("//Heal test failed//")
        }

    }

    fun damageTest() {
        println("//Starting damage test//")

        val player = Player(
            defense = 2,
            attack = 10,
            damage = Damage(1, 10),
            health = 100
        )

        println("Player has ${player.health} health!")

        player.recieveDamage(80)

        if (player.health == 20) {
            println("//Damage test passed//")
        } else {
            println("//Damage test failed//")
        }
    }

}