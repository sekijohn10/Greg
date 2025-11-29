package greg.newborn.neuralNetwork

//class can only do OR gate logic currently
class NeuralNetwork(private val numberOfLayers: Int, private val numberOfInputs: Int = 2, private val numberOfOutputs : Int = 1) {
    private val learningRate = 0.5
    private val bias = 1.5
    private var weights: ArrayList<Double> = ArrayList(numberOfInputs + 1)

    private fun trainLoop(inputs : ArrayList<Double>, expectedOutputs : ArrayList<Double>): Boolean {
        if (numberOfInputs / numberOfOutputs != inputs.size / expectedOutputs.size)
            return false
        var i = 0
        while (i < expectedOutputs.size/numberOfOutputs){
            //Need to work on this to be more dynamic
            train(inputs[i * numberOfInputs], inputs[i * numberOfInputs + 1], expectedOutputs[i])
            i++
        }
        return true
    }

    //Need to make more dynamic and plan to utilize sigmoid functions and RELU functions
    private fun train(input1: Double, input2: Double, expectedOutput: Double) {
        var outputGuess = (input1*weights[0] + input2*weights[1] + bias*weights[2]).toInt()
        if (outputGuess > 0)
            outputGuess = 1
        else
            outputGuess = 0
        val error = expectedOutput - outputGuess
        weights[0] += error * input1 * learningRate
        weights[1] += error * input2 * learningRate
        weights[2] += error * bias * learningRate
    }


}
