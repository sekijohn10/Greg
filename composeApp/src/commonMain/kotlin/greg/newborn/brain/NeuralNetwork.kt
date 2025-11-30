package greg.newborn.brain


class NeuralNetwork(private val numberOfLayers: Int, private val numberOfInputs: Int = 2, private val numberOfOutputs : Int = 1) {
    private val learningRate = 0.5
    private val bias = 1.5
    private val weights: ArrayList<Double> = ArrayList(numberOfInputs + 1)

    private fun trainLoop(inputs : ArrayList<Double>, expectedOutputs : ArrayList<Double>): Boolean {
        if (numberOfInputs / numberOfOutputs != inputs.size / expectedOutputs.size)
            return false
        var inp = 0
        var exOut = 0
        val inArr: ArrayList<Double> = ArrayList(numberOfInputs)
        val expOuArr: ArrayList<Double> = ArrayList(numberOfOutputs)
        while (inp < inputs.size && exOut < expectedOutputs.size){
            do {
                inArr[inp%numberOfInputs] = inputs[inp]
            } while (numberOfInputs > inp++ % numberOfInputs + 1)
            do {
                expOuArr[exOut%numberOfOutputs] = expectedOutputs[exOut]
            } while (numberOfOutputs > exOut++ % numberOfOutputs + 1)
            train(inArr, expOuArr)
        }
        return true
    }

    //Will address outputs not being dynamic at a later time in the training function
    private fun train(inputs: ArrayList<Double>, expectedOutputs: ArrayList<Double>) {
        val outputGs: ArrayList<Double> = ArrayList(numberOfOutputs)
        var i = 0
        //while(i < numberOfOutputs) {
        outputGs[i] = 0.0
            //i++
        //}
        //i = 0
        while(i < numberOfInputs) {
            outputGs[0] += Functions().sigmoid(inputs[i]) * weights[i]
            i++
        }
        outputGs[0] += Functions().sigmoid(bias * weights[i])
        val error = expectedOutputs[0] - outputGs[0]
        i = 0
        while (i < numberOfInputs) {
            weights[i] += error * inputs[i] * learningRate
            i++
        }
        weights[i] += error * bias * learningRate
    }


}
