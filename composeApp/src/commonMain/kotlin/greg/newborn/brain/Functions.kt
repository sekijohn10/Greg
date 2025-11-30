package greg.newborn.brain

import kotlin.math.exp

class Functions {
    fun sigmoid(input : Double) : Double {
        return 1/(1 + exp(-input))
    }
    fun relu(input : Double) : Double {
        if (input <= 0)
            return 0.0
        return input
    }

    companion object
}