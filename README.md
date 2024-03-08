# JavaChess
## JavaChess with Tim and Drico

In this project, Tim and I have separately thought of solutions and projects we can do. This was before we decided on the chess game. After a day, we came together to discuss and compare our findings and find a good solution, which was a chess game. Then we used the ideas that we had and searched for more on the internet.

Participants:
- Drico
- Tim

repo link: https://github.com/Dricovw/JavaChess

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

## Facade Design Pattern
Tim began simplifying game interactions by consolidating subsystems and logic under a Facade. Players interacting with the facade delegate requests to underlying subsystem classes, reducing complexity.
The Facade pattern is implemented in a file called "ChessGameFacade," serving as an interface and used in the GameLogic class. The GameLogic class, written in JavaScript, contains all chess game logic. ChessGame initiates most of the game, with logic stored in the GameLogic class. ChessGame frequently interacts with GameLogic, inheriting from the "ChessGameFacade" interface where high-level methods are stored.

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
The next thing Drico worked on was the Command design Pattern, its use is to make operations available to be called as objects.
These operations are defined in the command interface.
There are two commands: start and end. The Start command announces that the game has started and the End command announces the winner if the king is taken from either side.
Some benefits are added flexibility and Decoupling, where the concerns between the sender and receiver are separated.
In this instance of use, it sets it up to execute various commands.
When a player makes a move, it checks if one of the kings is no longer on the board and if that is the case, it stops the game and check which one.
Then the winner will be declared.

## Adapter Design Pattern
Drico has also done the Adapter Design Pattern, it's main use is to take the function isValidMove that PieceMove uses to connect the position of the piece
to the specific rules the piece has to follow. For example: if you want to move a knight, it can only move if it's in a L shape and if you want to move the Queen,
you can move her in any straight direction. As these rules are different for each piece, the adapter will now automaticcly select which one you need and implement the rules. 