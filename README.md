# JavaChess
## JavaChess with Tim and Drico

In this project Tim and I have created a chess game that outputs the move to the console in the JAVA language.
We decided that a chess game would be appropriate since it is a cool game to play and we know how it works.
How we worked:
We have seperatly thought of solutions and projects we can do, this was before we decided on the chess game.
After a day we came together to discuss and compare our finding and find a good solution, which was a chess game.
then we used the idea that we had and searched for more on the internet and

## Class Diagram overview of the project.
![Class Diagram](JavaChess.drawio.png)

## The Factory Design Pattern
In our chess game Tim worked on implementing this design pattern through the 'Piece Factory' class. This class builds the pieces from the Piece classes and creates different chess pieces.
Every method is responsible for creating an instance of a specific chess piece. Each method needs a symbol parameter to initialize the chess piece with the appropriate symbol. For example
The pawn piece is created through the createPawn method and gets an input of P to indicate the chess piece.

The Factory is called in the ChessGame file and uses the factory methods to initialize the chess game.

## Strategy Design Pattern
Tim continued to work on writing the logic of the chess pieces and used a Strategy design pattern to define the family of classes that all use the Piece.java interface. This interface acts
as the strategy interface, and concrete chess pieces classes (e.g., 'Pawn Rook','Rook', etc.) implementing this interface with their specific behaviours. The Piece interface defines two methods, isValidMove and getSymbol represent the common behaviors expected from all chess pieces.

The ChessPiece class is a common class and serves as a context for all chess pieces.

## Facade Structure Pattern
the Facade pattern is implemented in a file "ChessGameFacade" which is an interface and is used in the GameLogic class. Game logic as the class states is a JavaScript that has all the Game logic of the Chess game written.
Chessgame is the class that iniates most of the game but the logic is stored in the gamelogic class thus. Chessgame interacts a lot of with the Gamelogic that inherits it from the "ChessGameFacade" interface where high level
methods are stored.

## Singleton Design Pattern
On the other hand, Drico was working on a Singleton Design Pattern. He has made the ChessboardManager, which is designed to manage the chessboard by a singleton pattern. It is a singleton pattern because it has only one intance of itself in the application.
It provides access to a method that lets you retrieve a ChessComponent from the chessboard based on the row and columns.


## Command Design Pattern
The next thing he worked on was the Command design Pattern, its use is to make operation available to be called as objects. These operations are defined in the command interface.
The three commands so far, start, end and MakeMove provide enough veriation and can be called


Start, End and Make move are all operation that can be called as objects
command interface, defining interface for the operations
the three command classes provide variations as needed and are specific

## Composistion Design pattern

