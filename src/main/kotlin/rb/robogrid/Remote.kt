package rb.robogrid

object Remote {
    fun execute(robot: Robot,
                instructions: List<Instruction>,
                posProcessor: (Robot) -> Unit): Robot {
        var robotTemp = robot
        for(i in 0 until instructions.size) {
            robotTemp = robotTemp.apply(instructions[i])
            if(robotTemp.lost) return robotTemp
            posProcessor.invoke(robotTemp)
        }
        return robotTemp
    }
}

