# FIT2099 Assignment (November 2022) - Pokemon!

## FIT2099_Lab01Team17
Team members:

25348914 Zecan Liu zliu0207@student.monash.edu

31893902 Jordan Nathanael jnat0012@student.monash.edu

Link to contribution logs spreadsheet: [https://docs.google.com/spreadsheets/d/1QeySXoTWwXk9gglpJQzY4sfR8xn8tGG2epjmaYE85BM/edit?usp=sharing]

## Design Rationale

### REQ 1
![alt text](./assets/UMLDiagram_REQ1.png)

### REQ 2
![alt text](./assets/UMLDiagram_REQ2.png)

The diagram represents an object-oriented system for part of the pokemon game that focuses only for Pokemon criteria only. This diagram has three concrete classes that represent pokemon that exist inside the game.

All three types of pokemons extended the abstract Pokemon class. To avoid repetitions (DRY) and since they share some common attributes (Element and PlayerInteraction) and methods, it is logical that it is an abstract class.

Each pokemon acts in the same way of numeral types of behaviors and to implement Open-Closed Principle, Pokemon abstract class has an association towards Behavior interface.

One of the behaviors that inherits this interface is AttackBehavior class. Each pokemon is designed to have two ways of attacking other pokemon which are using intrinsicWeapon or WeaponItem. Because everytime the game runs, the pokemon need to check its own stepped ground, so we introduced new behavior called ToggleWeaponBehavior just to check every turn whether the pokemon will use intrinsicWeapon or backupWeapon. This approach aligns with Single Responsibility Principle.

SpecialWeapon inherits from WeaponItem abstract class which also inherits from Item abstract class. This way of design ensures the robustness of polymorphism which aligns with the Liskov Substitution Principle.

### REQ 3
![alt text](./assets/UMLDiagram_REQ3.png)

NOTE: please add this statement into your Design Rationale @Vivian

Each GeneralBall will have dependency with CatchAction and SummonAction because we will use GeneralBall whenever there are pokemons near the Player to catch it. However, because of the limitation of code of the engine, this CatchAction can't be used in the first turn. 

Another alternative to do this is by using design pattern so later the catchAction will not be hindered like this.

### REQ 4
![alt text](./assets/UMLDiagram_REQ4.png)

The diagram represents an object-oriented system for interactions within the game. This diagram focuses on game.action and game.affection package.

Inside game.action package, there are 5 concrete class that inherit from Action abstract class because those five classes have the same functionality as already given inside the Action class. Those five classes will have their own role which aligns with the Single Responsibility Principle.

Specifically for ChestPounding, Singing, and Dancing concrete class, they inherit from AttractionAction first because those three have the same functionality which are related with action that the another Actor can interact with the PokemonBase. This way of design ensures that we can add more attractionActions without modifying the class itself which is related to Open-Closed Principle.

CatchAction and SummonAction has an association with GeneralBall abstract class because both of them have a really close relation with the GeneralBall which the ball will be used to stored the captured pokemon inside it and summon the captured pokemon from it. Even though both actions are related with pokemon indirectly, SummonAction doesn't need an association with Actor like CatchAction because SummonAction can retrieve the pokemon from the GeneralBall while CatchAction will not get any pokemon when we try to retrieve it.

AffectionManager applies a singleton design pattern because it will make things easier for other class who want to get the AffectionPoint from the pokemon by its ability to be called anywhere.

AffectionManager have a dependency towards AffectionLevelPoint because it will manage the pokemon whether it is categorised into which Affection Level Point.

### REQ 5
![alt text](./assets/UMLDiagram_REQ5.png)

### REQ 6
![alt text](./assets/UMLDiagram_REQ6.png)