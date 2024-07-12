package com.loci.challeng3

fun main() {
    Logger.log("log1")
    Logger.log("log2")

    val str = "Hello! World"

    val editor = TextEditor(AlignLeft())
    println(editor.executeEditor(str))

    editor.setStrategy(AlignRight())
    println(editor.executeEditor(str))

    editor.setStrategy(AlignCenter())
    println(editor.executeEditor(str))
}

object Logger {
    fun log(message: String) {
        println(message)
    }
}

interface TextAlignmentStrategy {
    fun align(input: String): String


}

class AlignLeft : TextAlignmentStrategy {
    override fun align(input: String): String {
        return input
    }
}

class AlignRight : TextAlignmentStrategy {
    override fun align(input: String): String {
        return input.padStart(30)
    }
}

class AlignCenter : TextAlignmentStrategy {
    override fun align(input: String): String {
        val padding = (30 - input.length) / 2
        return input.padStart(padding + input.length).padEnd(30)
    }
}

class TextEditor(private var textAlignmentStrategy: TextAlignmentStrategy) {

    fun executeEditor(str: String): String {
        return textAlignmentStrategy.align(str)
    }

    fun setStrategy(textAlignmentStrategy: TextAlignmentStrategy) {
        this.textAlignmentStrategy = textAlignmentStrategy
    }

}