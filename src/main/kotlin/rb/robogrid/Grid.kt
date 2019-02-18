package rb.robogrid

class Grid(w: Int, h: Int) {
    // may be over engineered for the initial req. but it's a simple
    // initialisation that sets up for future enhancements (risk of yagni!)

    val x_zero: Int = 0
    val y_zero: Int = 0
    val x_top = x_zero + w
    val y_top = y_zero + h


}