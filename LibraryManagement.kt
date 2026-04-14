fun main() {

    // Store books with author
    val books = mutableListOf(
        "Wings of Fire - A.P.J Abdul Kalam",
        "Harry Potter - J.K Rowling",
        "The Alchemist - Paulo Coelho",
        "Rich Dad Poor Dad - Robert Kiyosaki",
        "Ikigai - Hector Garcia"
    )

    while (true) {
        println("\n--- Library Management System ---")
        println("1. Add Book")
        println("2. View Books")
        println("3. Remove Book")
        println("4. Exit")
        print("Enter your choice: ")

        val choice = readLine()?.toIntOrNull()

        when (choice) {

            1 -> {
                print("Enter book name: ")
                val name = readLine()

                print("Enter author name: ")
                val author = readLine()

                if (!name.isNullOrEmpty() && !author.isNullOrEmpty()) {
                    books.add("$name - $author")
                    println("Book added successfully.")
                } else {
                    println("Invalid input.")
                }
            }

            2 -> {
                println("\nList of Books:")
                if (books.isEmpty()) {
                    println("No books available.")
                } else {
                    for (i in books.indices) {
                        println("${i + 1}. ${books[i]}")
                    }
                }
            }

            3 -> {
                print("Enter book number to remove: ")
                val index = readLine()?.toIntOrNull()

                if (index != null && index > 0 && index <= books.size) {
                    val removed = books.removeAt(index - 1)
                    println("$removed removed successfully.")
                } else {
                    println("Invalid number.")
                }
            }

            4 -> {
                println("Exiting program...")
                break
            }

            else -> println("Invalid choice. Try again.")
        }
    }
}
