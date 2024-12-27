fun html(block: HTMLBuilder.() -> Unit): String {

    val builder = HTMLBuilder()
    builder.block()
    return builder.build()
}

class
HTMLBuilder
{
    private var heading: String = ""

    private var paragraph: String = ""

    fun heading(text: String) { heading = text }

    fun paragraph(text: String) { paragraph = text }

    fun build() : String = "<html><head></head><body><h1>$heading</h1><p>$paragraph</p></body></html>"
}

fun main() {

    val myPage = html {

        heading("Welcome to DSL in Kotlin")

        paragraph("This is an example of an internal DSL for creating simple HTML pages.")

    }

    println(myPage)

}