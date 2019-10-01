# OthelloBot
 A bot that plays Othello.

## Course: CSCI 312 Artificial Intelligence

### Project Objectives

 1. Students obtain experience representing knowledge.
 
 2. Students will experiment with heuristic development.
 
 3. Students will discover problems, benefits, and various methods of adversarial search.
 
 4. Students will have the experience of completing a fairly large scale project with a very short deadline.
 
### The Game of Othello

<details>
 <summary>Materials (and beings) required</summary>
 
  1. An 8x8 square board (64 squares).
 
  2. 64 bi-color disks (one side black, the other white).
  
  3. 2 players.
</details>

<details>
 <summary>Objective</summary>
 
  <p>To end the game with more of your disks on the board than your opponent.</p>
</details>

<details>
 <summary>Starting Game</summary>
 
  1. Players determine colors. Black moves first.
 
  2. White pieces on d4 and e5, Black pieces on d5 and e4.
</details>

<details>
 <summary>Legal Moves</summary>
 
  <p>Place a disk in a free square. At least one of your opponent's disks must lie in a horizontal, vertical, or diagonal line between on of your existing disks on board and the square to which you wish to move. Your opponent's disks that are "caught" between one of your existing disks and your newly placed disk are changed to your color.</p>
</details>

<details>
 <summary>Rules</summary>
 
  1. Board is 8x8; columns labeled a-h from (left to right); rows labeled 1-8 from (top to bottom); moves and cells are defined by column and row. Examples: d5, f8.
 
 2. If you can not make a legal move, you must pass.
 
 3. You can not pass if you have a legal move.
 
 4. When neither player can make a move, the game ends.
 
 5. Each player has 10 minutes of wall-clock time for entire game. If player takes more than allotted time, he/she forfeits the game.
 
 6. If a player attempts to make a wrong move, he/she forfeits the game.
 
 7. The player with the most disks on board wins.
</details>

### Requirements

*General Instructions: Write a Java program that will play Othello according to the above rules. Your program will be called by a referee program created by the instructor.*

 <details>
  <summary>Program Input</summary>
 
  * I B -- Inform program to initialize and play as BLACK
 
  * I W -- Inform program to initialize and play as WHITE
  
  * B c r -- Inform program that BLACK moves to column c and row r
  
  * B -- Inform program that BLACK passes
  
  * W c r -- Inform program that WHITE moves to column c and row r
  
  * W -- Inform program that WHITE passes
  
  * C string -- A comment has been made. The referee will ignore
  
  * n -- Other program claiming game end (n is # of black pieces on the board)
  
 </details>
 
 <details>
 
 <summary>Program Output</summary>
  
  * R B -- Indicates program is ready to play as BLACK
  
  * R W -- Indicates program is ready to play as WHITE
  
  * B c r -- BLACK moves to column c and row r
  
  * W c r -- WHITE moves to column c and row r
  
  * B -- BLACK passes
  
  * W -- WHITE passes
  
  * C string -- A comment has been made (ignore)
  
  * n -- Other program claiming end game
 
 </details>
