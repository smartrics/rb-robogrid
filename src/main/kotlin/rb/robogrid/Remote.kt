package rb.robogrid

object Remote {
    fun execute(robot: Robot,
                instructions: List<Instruction>,
                posProcessor: (Robot) -> Unit) {
        var robotTemp = robot
        instructions.forEach {
            robotTemp = robotTemp.apply(it)
            posProcessor.invoke(robotTemp)
        }
    }
}

