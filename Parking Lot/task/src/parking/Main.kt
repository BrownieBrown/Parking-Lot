package parking

data class Car(val regNum: String = "", val color: String)
val scanner = java.util.Scanner(System.`in`)

class ParkingLot(taille: Int) {
    private var parkingLot = Array<Car?>(0){null}
    init {
        if (taille > 0) {
            parkingLot = Array(taille){null}
            println("Created a parking lot with $taille spots.")
        }
    }

    private fun isCreated() = if (parkingLot.isEmpty()) {
        println("Sorry, a parking lot has not been created.")
        false
    } else { true}

    fun park (car: Car) {
        if(!isCreated()) {
            return
        }
        val emptySpot = parkingLot.indexOf(null)
        if (emptySpot == -1) {
            println("Sorry, the parking lot is full.")
        } else {
            parkingLot[emptySpot] = car
            println("${car.color} car parked in spot ${emptySpot + 1}.")
        }

    }

    fun leave(spot: Int) {
        if (!isCreated()) {
            return
        }
        if (parkingLot[spot - 1] == null) {
            println("There is no car in spot $spot.")
        } else {
            parkingLot[spot - 1] = null
            println("Spot $spot is free.")
        }
    }

    fun status() {
        if (!isCreated()){
            return
        }
        var count = 0
        for (i in parkingLot) {
            if (i != null) {
                println("${parkingLot.indexOf(i) + 1} ${i.regNum} ${i.color}")
                count++
            }
        }
        if (count == 0) println("Parking lot is empty.")
    }

    fun regByColor() {
        val colorInput = scanner.next()
        val list = parkingLot.filter { it?.color == colorInput.toLowerCase().capitalize()
                || it?.color == colorInput
                || it?.color == colorInput.toUpperCase() }
        val selectedCars = mutableListOf<String?>()
        if (!isCreated()){
            return
        }
        if (list.isEmpty()) println("No cars with color $colorInput were found.") else {
            list.forEach { car -> selectedCars.add((car?.regNum)) }
            println(selectedCars.joinToString())
        }
    }

    fun spotByColor() {
        val colorInput = scanner.next()
        val colorList = mutableListOf<String?>()
        val colorIndexList = mutableListOf<Int>()
        if (!isCreated()){
            return
        }
        if (parkingLot.none { it?.color == colorInput.toLowerCase().capitalize()
                        || it?.color == colorInput.toUpperCase()
                        || it?.color == colorInput}) println("No cars with color $colorInput were found.")
        else {
            parkingLot.forEach { car: Car? -> colorList.add(car?.color)  }
            for ((index, carColor) in colorList.withIndex()) {
                if (carColor == colorInput.toLowerCase().capitalize()
                        || carColor == colorInput
                        || carColor == colorInput.toUpperCase()) colorIndexList.add(index + 1)
            }
            println(colorIndexList.joinToString())
        }
    }

    fun spotByReg() {
        val regInput = scanner.next()
        val regList = mutableListOf<String?>()
        val regIndexList = mutableListOf<Int>()
        if (!isCreated()){
            return
        }
        if (parkingLot.none { it?.regNum == regInput }) println("No cars with registration number $regInput were found.")
        else {
            parkingLot.forEach { car -> regList.add(car?.regNum) }
            for ((index, regNum) in regList.withIndex()) {
                if (regNum == regInput) regIndexList.add(index + 1)
            }
            println(regIndexList.joinToString())
        }
    }
}
fun main() {
    var parkingLot = ParkingLot(0)

    while (true) {
        when (scanner.next()) {
            "create" -> parkingLot = ParkingLot(scanner.nextInt())
            "leave" -> parkingLot.leave(scanner.nextInt())
            "park" -> parkingLot.park(Car(scanner.next(),scanner.next()))
            "status" -> parkingLot.status()
            "reg_by_color" -> parkingLot.regByColor()
            "spot_by_color" -> parkingLot.spotByColor()
            "spot_by_reg" -> parkingLot.spotByReg()
            "exit" -> return
        }
    }


}

