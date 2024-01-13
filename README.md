# JavaChess
JavaChess with Tim and Drico

In this project Tim and I have created a chess game that outputs the move to the console in the JAVA language.
We decided that a chess game would be appropriate since it is a cool game to play and we know how it works.
How we worked:
We have seperatly thought of solutions and projects we can do, this was before we decided on the chess game.
After a day we came together to discuss and compare our finding and find a good solution, which was a chess game.
then we used the idea that we had and searched for more on the internet and 

2. Factory Method Pattern - Chess Piece Factory: - Creational - IMPLEMENTED
   In chess, each piece has its own factory (e.g., PawnFactory, RookFactory). Similarly, the Factory Method pattern defines an interface for creating an object but leaves the choice of its type to the subclasses, creating instances of classes derived from an interface.

5. Observer Pattern - Chess Clock Observer: - Behavioral Design Patterns:
   In chess, a clock is used to track time for each player. The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. - USE TIME

6. Command Pattern - Chess Move Command: - Behavioral Design Patterns:
   In chess, each move can be seen as a command. The Command pattern encapsulates a request as an object, thereby allowing for parameterization of clients with different requests, queuing of requests, and logging of the requests. - MOVE FUNCTION

3. Adapter Pattern - Chess Board Adapter:  STRUCTURAL
   Chess boards come in different shapes and sizes. The Adapter pattern allows the interface of an existing class to be used as another interface. In chess, an adapter could be used to adapt different types of chess boards.

4. Facade Pattern - ChessGameFacade  STRUCTURAL
   In a chess game, various components such as the board, pieces, rules, and player actions interact. The Facade pattern can be used to provide a simplified interface for starting and managing a chess game without exposing the internal complexities.