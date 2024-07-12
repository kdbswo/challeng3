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

    Subscriber().start()
}

// singleton pattern
object Logger {
    fun log(message: String) {
        println(message)
    }
}

//strategy pattern
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

// Observer pattern
interface Observer {
    fun publication(count: Int)
}

class Newsletter(var observer: Observer) {
    fun emit() {
        for (i in 1..100) {
            if (i % 3 == 0) observer.publication(i)
        }
    }
}

class Subscriber() : Observer {
    override fun publication(count: Int) {
        println("뉴스 $count")
    }

    fun start() {
        val newsletter = Newsletter(this)
        newsletter.emit()
    }

}









