# JavaChess
## JavaChess with Tim and Drico

In this project, Tim and I have separately thought of solutions and projects we can do. This was before we decided on the chess game. After a day, we came together to discuss and compare our findings and find a good solution, which was a chess game. Then we used the ideas that we had and searched for more on the internet.

## Class Diagram overview of the project.
![Class Diagram](JavaChess.drawio.png)

## The Factory Design Pattern
In our chess game, Tim worked on implementing this design pattern through the 'Piece Factory' class.
This class builds the pieces from the Piece classes and creates different chess pieces.
Every method is responsible for creating an instance of a specific chess piece.
Each method needs a symbol parameter to initialize the chess piece with the appropriate symbol.
For example, the pawn piece is created through the createPawn method and gets an input of P to indicate the chess piece.

The Factory is called in the ChessGame file and uses the factory methods to initialize the chess game.

## Strategy Design Pattern
Tim continued to work on writing the logic of the chess pieces and used a Strategy design pattern to define the family of classes that all use the Piece.java interface.
This interface acts as the strategy interface, and concrete chess pieces classes (e.g., 'Pawn Rook','Rook', etc.) implementing this interface with their specific behaviors. 
The Piece interface defines two methods, isValidMove and getSymbol, representing the common behaviors expected from all chess pieces.

The ChessPiece class is a common class and serves as a context for all chess pieces.

## Facade Structure Pattern
The Facade pattern is implemented in a file "ChessGameFacade," which is an interface and is used in the GameLogic class.
Game logic, as the class states, is a JavaScript that has all the Game logic of the Chess game written.
Chessgame initiates most of the game, but the logic is stored in the gamelogic class.
Chessgame interacts a lot with the Gamelogic that inherits it from the "ChessGameFacade" interface where high-level methods are stored.

## Singleton Design Pattern
On the other hand, Drico was working on a Singleton Design Pattern.
He has made the ChessboardManager, which is designed to manage the chessboard by a singleton pattern.
It is a singleton pattern because it has only one instance of itself in the application.
It provides access to a method that lets you retrieve a ChessComponent from the chessboard based on the row and columns.
It is implemented because it gives the application global access to certain functions and although it isn't used often.
The scalability of it shouldn't be underestimated. 
Its use is now that it simplifies the control of the management and manipulation of the chessboard within the Chess Game.
Any part of the system can obtain the reference to the same ChessboardManager instance, promoting consistency and avoiding unnecessary duplication.

## Command Design Pattern
The next thing he worked on was the Command design Pattern, its use is to make operations available to be called as objects.
These operations are defined in the command interface.
The three commands so far, start, end, and MakeMove provide accessible and repeatable operations for the application. 
Some benefits are added flexibility and Decoupling, where the concerns between the sender and receiver are separated.
In this instance of use, it sets it up to execute various commands.
When a player makes a move, the Chess Game creates a corresponding MoveCommand and associates it with the invoker.
The invoker then triggers the execution of the command, resulting in the desired action (e.g., updating the game board).

## Composite Design pattern
In this application, the composition design pattern is also used. 
It has the function of representing complex structures as simpler objects.
This pattern allows individual objects (components) to be combined into larger structures (composites), forming a tree-like hierarchy.
In the context of the Chess Game, composition is applied to represent the chessboard, pieces, and their relationships.
It has the benefits of adding more flexibility and scalability, since the components can easily be added or removed without affecting the structure.
In this usage, it achieves a modular and flexible structure.
The chessboard can be easily expanded or modified by adding new types of squares or pieces.
The hierarchical composition allows for a clear representation of the game elements without making the system overly complex.
