fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = Product(productType, price)
    println(totalPrice(product))
}

fun totalPrice(product: Product): Int {
    val tax: Float = when (product.productType){
        "headphones" -> 0.11F
        "smartphone" -> 0.15F
        "tv" -> 0.17F
        else -> 0.19F
    }
    return (product.price + (product.price * tax)).toInt()
}

data class Product(val productType: String, val price: Int)