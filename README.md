# JetsProject

<a title="Maximo Betman, CC BY-SA 4.0 &lt;https://creativecommons.org/licenses/by-sa/4.0&gt;, via Wikimedia Commons" href="https://commons.wikimedia.org/wiki/File:Mesa-blackjack-casino-ciudad-de-mexico-25-04-2023.jpg"><img width="512" alt="Mesa-blackjack-casino-ciudad-de-mexico-25-04-2023" src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/Mesa-blackjack-casino-ciudad-de-mexico-25-04-2023.jpg/512px-Mesa-blackjack-casino-ciudad-de-mexico-25-04-2023.jpg"></a>

# Description

The Blackjack project is a command-line-based implementation of the classic blackjack card game. This simulation allows users to experience a blackjack session involving a variable number of players competing against the dealer.

# Usage

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/danielriggi/BlackjackProject.git
    cd BlackjackProject
    ```

2. **Compile and Run:**
    ```
    javac -d bin -cp src src/com/skilldistillery/blackjack/app/*.java src/com/skilldistillery/blackjack/entities/*.java
    java -cp bin com.skilldistillery.blackjack.app.BlackjackGame
    ```
    Follow the on-screen instructions to play a blackjack game against the dealer. 

# Tech Used
- **Programming Languages:**
    - Java 8 (version 1.8.0_391)
- **IDEs:**
    - Eclipse 2023-09 (https://www.eclipse.org/)
    - Visual Studio Code 1.84.2 (https://code.visualstudio.com/)
- **Version Control:**
    - Git 2.32.1 (https://git-scm.com/)

# Lessons Learned

This project served as a valuable lesson in designing complex applications, emphasizing the orchestration of communication between various classes. A key highlight was the practical use of enums to represent card ranks and suits, fostering efficient data organization. The experience deepened our understanding of class design principles, encapsulation, and the significance of establishing clear communication pathways within a software project. Overall, this project enhanced our skills in crafting modular and maintainable code.


