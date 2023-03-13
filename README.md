# Maze Solver

This is a Java project that generates a random maze with a specified percentage of obstacles and then uses the A* algorithm to find a path from the start to the end of the maze.

## Installation and Usage

To run this program, you will need to have Java installed on your computer. You can download and install Java from the [Java website](https://www.java.com/en/download/).

Once you have Java installed, you can clone this repository to your local machine using Git:

```
git clone https://github.com/ivanlpc/AStar-maze
```

To run the program, navigate to the `src` directory and run the following command:

```bash
javac laberinto/Main.java
java laberinto/Main
```

This will generate a maze and display the maze with the path marked using a specified path character (by default, the path character is `+`). If no path is found, it will display the original maze and print a message indicating that no path was found.

# Example output

```
__________________________________________________________________________________________________________________________
| █       █        ██         █ █   █  █   █ █ █     █  █ ██  ██ ██   █  █      █ █  █    █   █ ███ █    █           ██  |
|  █   ██    ███  █    █     █         █   ██ █  █  ███              ███        █   █ █        █   ███   █ █    █ ███    |
|    █   █   █  ██████           ███   █     █      █    ████         █        █ █    █  █  █   █            ███   █ █   |
|  █       █      █   █    ██    ██ ██  █    █      █  ███      ███ █       █  ██       █    █      █          ██     ██ |
| █ █  █   █     █  █   █   █   █        █  █  ██  █              ██      █    █   █ █        █   █  █ ██     ██  █  █ █ |
|  ████ █         ██  █      ██   █  █   ███ ██  █    ██ ███ ██   ██ █  █   █ █   ██   █       ██ █ █   █     ██ ███     |
|  █  ██   █           █ ██    █  █   █  █  ██ █  ████ +++█   █    █  █ ██    █  █           ██  █  █   █         █    █ |
| █  █     █ ██    █   █ ██  █  █  █    █   █ █   █+++++█++█  █  █  ██     █  █   █    ██ █    ████  ██ █ █  ██  G  █ ██ |
|       █   █    █   ███ ████  ████ ███ ██ ██ █  +++  █ █ ++██      ██  █  █ ██ █  █   █  ██ █       █   █    █+++█      |
| ██ ██████    █   █   █  █      █     █ █ █   +++    █    +++++++█    ███    █     ██ █    █ █  █   █   █  █ ++█████ █ █|
|  █  █     █    █ █  █    █  ██        ██  █ ++    ██  █       █++ █  █  █     ██ ██   █   █     █ █  █   █  +█    █ ██ |
|   ██  █   █   █ █ ██ ██   █     █  ███ █ █ ++  █    ██   █ ███  +++++++█    █        ███   █ █ █ █  █       +  █       |
|█ █    █  ██ █ █     ██  █ █     █  █    █ I+██     ███ █    ██  █ █ █ +█     █  ███ █           █ █  ██ █   +          |
|█  █   █      █   █    █            █   █   █ █ █   █     █ █  █  ████ +++++  █     █ █    █  █  █        █+++ █   █  ██|
| ██ █    █   █     ██  █    █    █     ██   █     █    █ ██     █   █  ██  +██ █++++++█  █ ██   █   █ ++++++  ██      █ |
|    ██   █   █ █ █  █   ██     ███   █ ██   █    █ █  █  █ █ ██ ██       ██++++++    ++++++++++++++++++█     ██  █  █   |
|  █  █ █  ██    ██      ██     █ ███   █         ███ █    █ █   █ █ █ █ █           █ ███ █ ██   █ ██    █  █ ███ ██ ██ |
|    ██    █ █   █    █ █ █    ████   █    ███  █      ██     █    █   ███     █           █  █ ███  █         ██ ███    |
|  █ ██ █    ██            ██     █  █ █      █   █  █ █           ███  █   █      █ █ █        ██████ █    █      █     |
|█        █    █ ██  ███    ██████  ███   ██ ██ █      ███ ███   █  ██ █      █   █  ████ █      █   █ █ █   ██    █   ██|
¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
```
