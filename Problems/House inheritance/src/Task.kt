fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()
    val house = House.create(rooms, price)
    println(totalPrice(house))
}

fun totalPrice(house: House) = (house.price * house.coeff).toInt()

open class House(rooms: Int, val price: Int) {
    open val coeff: Float = 1f

    companion object {
        fun create(rooms: Int, basePrice: Int): House {
            val rooms = if (rooms < 1) 1 else rooms
            val basePrice = when {
                basePrice < 0 -> 0
                basePrice > 1_000_000 -> 1_000_000
                else -> basePrice
            }
            return when (rooms) {
                1 -> Cabin(rooms, basePrice)
                2, 3 -> Bungalow(rooms, basePrice)
                4 -> Cottage(rooms, basePrice)
                in 5..7 -> Mansion(rooms, basePrice)
                else -> Palace(rooms, basePrice)
            }
        }
    }
}

class Cabin(rooms: Int, price: Int, override val coeff: Float = 1f) : House(rooms, price)
class Bungalow(rooms: Int, price: Int, override val coeff: Float = 1.2f) : House(rooms, price)
class Cottage(rooms: Int, price: Int, override val coeff: Float = 1.25f) : House(rooms, price)
class Mansion(rooms: Int, price: Int, override val coeff: Float = 1.4f) : House(rooms, price)
class Palace(rooms: Int, price: Int, override val coeff: Float = 1.6f) : House(rooms, price)