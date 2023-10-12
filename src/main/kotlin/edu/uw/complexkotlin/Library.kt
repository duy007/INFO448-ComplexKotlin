/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package edu.uw.complexkotlin

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15).
// use map() to return a list with "", "FIZZ" (for 3s) or "BUZZ" (for 5s).
// use fold() to compress the array of strings down into a single string.
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ for 0..15.
// store this lambda into 'fizzbuzz' so that the tests can call it
//
val fizzbuzz : (IntRange) -> String = {
    it.map {
        var result = ""
        if (it % 3 == 0) result += "FIZZ"
        if (it % 5 == 0) result += "BUZZ"
        result
    }.fold("", fun (sum: String, element: String): String {
        return sum + element
    })
}

val fizzbuzzdoh : (IntRange) -> String = {
    it.map {
        var result = ""
        if (it % 3 == 0) result += "FIZZ"
        if (it % 5 == 0) result += "BUZZ"
        if (it % 7 == 0) result += "DOH!"
        result
    }.fold("", fun (sum: String, element: String): String {
        return sum + element
    })
}

fun fizzbuzzgen(divisors: Map<Int, String>) : (IntRange) -> String {
    return {
        it.map {
            var result = ""
            divisors.forEach { (t, u) ->
                if (it % t == 0) result += u
            }
            result
        }.fold("") {
            sum, element ->
            val result = sum + element
            result
        }
    }
}

// Example usage
/*
if (fizzbuzz(0..1) == "")
    println("Success!")
if (fizzbuzz(0..3) == "FIZZ")
    println("Success!")
if (fizzbuzz(0..5) == "BUZZ")
    println("Success!")
*/

// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit) {
    for (it in 1..this) {
        block()
    }
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}
// Create r1 as a lambda that calls process() with message "FOO" 
// and a block that returns "BAR"
val r1 = {
    process("FOO") {
        "BAR"
    }
}

// Create r2 as a lambda that calls process() with message "FOO" 
// and a block that upper-cases r2_message, and repeats it three 
// times with no spaces: "WOOGAWOOGAWOOGA"
val r2_message = "wooga"
val r2 = {
    process("FOO") {
        r2_message.repeat(3).toUpperCase()
    }
}


// write an enum-based state machine between talking and thinking

/*
    Seneca the Younger is an ancient greek philosopher is known for his moral essays,
    letters, and plays, which are tragedies. Seneca the Younger's works is most often
    associated with Stoicism.

    Stoicism is the philosophy that believes that living a virtuous life
    will achieve fulfillment and happiness.
 */
enum class Philosopher {

    THINKING {
        override fun signal():Philosopher {
            return TALKING
        }
        override fun toString(): String {
            return "Deep thoughts...."
        }
    },
    TALKING {
        override fun signal():Philosopher {
            return THINKING
        }
        override fun toString(): String {
            return "Allow me to suggest an idea..."
        }
    };

    abstract fun signal() : Philosopher
}

// create an class "Command" that can be used as a function 
// (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when invoked, the Command object should return a String c
// ontaining the prompt and then the message.
// Example: Command(": ")("Hello!") should print ": Hello!"
class Command(val prompt: String) {
    operator fun invoke(message: String) : String {
        return prompt+message
    }
}
