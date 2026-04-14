import java.util.*

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    var isIssued: Boolean = false
)

class LibraryManagementSystem {

    private val books = mutableListOf<Book>()

    fun addBook() {
        val scanner = Scanner(System.`in`)

        print("Enter Book ID: ")
        val id = scanner.nextInt()
        scanner.nextLine()

        print("Enter Book Title: ")
        val title = scanner.nextLine()

        print("Enter Author Name: ")
        val author = scanner.nextLine()

        books.add(Book(id, title, author))
        println("Book added successfully!")
    }

    fun viewBooks() {
        println("\n--- Book List ---")
        if (books.isEmpty()) {
            println("No books available.")
            return
        }

        books.forEach {
            println("ID: ${it.id}, Title: ${it.title}, Author: ${it.author}, Issued: ${it.isIssued}")
        }
    }

    fun issueBook() {
        val scanner = Scanner(System.`in`)
        print("Enter Book ID to issue: ")
        val id = scanner.nextInt()

        val book = books.find { it.id == id }

        if (book == null) {
            println("Book not found!")
        } else if (book.isIssued) {
            println("Book already issued!")
        } else {
            book.isIssued = true
            println("Book issued successfully!")
        }
    }

    fun returnBook() {
        val scanner = Scanner(System.`in`)
        print("Enter Book ID to return: ")
        val id = scanner.nextInt()

        val book = books.find { it.id == id }

        if (book == null) {
            println("Book not found!")
        } else if (!book.isIssued) {
            println("This book was not issued!")
        } else {
            book.isIssued = false
            println("Book returned successfully!")
        }
    }

    fun searchBook() {
        val scanner = Scanner(System.`in`)
        print("Enter Book Title to search: ")
        val title = scanner.nextLine()

        val foundBooks = books.filter { it.title.contains(title, ignoreCase = true) }

        if (foundBooks.isEmpty()) {
            println("No matching books found.")
        } else {
            println("\n--- Search Results ---")
            foundBooks.forEach {
                println("ID: ${it.id}, Title: ${it.title}, Author: ${it.author}, Issued: ${it.isIssued}")
            }
        }
    }
}

fun main() {
    val library = LibraryManagementSystem()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\n--- Library Management System ---")
        println("1. Add Book")
        println("2. View Books")
        println("3. Issue Book")
        println("4. Return Book")
        println("5. Search Book")
        println("6. Exit")
        print("Enter choice: ")

        when (scanner.nextInt()) {
            1 -> library.addBook()
            2 -> library.viewBooks()
            3 -> library.issueBook()
            4 -> library.returnBook()
            5 -> {
                scanner.nextLine() // clear buffer
                library.searchBook()
            }
            6 -> {
                println("Exiting...")
                break
            }
            else -> println("Invalid choice!")
        }
    }
}
