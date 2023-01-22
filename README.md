# FIT2099 Assignment (November 2022) - Pokemon!

## FIT2099_Lab01Team17
Team members:

25348914 Zecan Liu zliu0207@student.monash.edu

31893902 Jordan Nathanael jnat0012@student.monash.edu

33243271 Aashlesha Gaur agau0008@student.monash.edu


Link to contribution logs spreadsheet: [https://docs.google.com/spreadsheets/d/1QeySXoTWwXk9gglpJQzY4sfR8xn8tGG2epjmaYE85BM/edit?usp=sharing]

Design Docs for A1 is under docs.DesignDocs.A1 Design Docs Directory which contains REQ 1&3&5 UMLs and design rationale (Author: Zecan Liu).

We were in different groups during A1. 

## Design Rationale - Assignment 3

### REQ 1
![alt text](./assets/UMLDiagram_REQ1_A3.png)

### REQ 2
![alt text](./assets/UMLDiagram_REQ2_A3.png)

### REQ 3 (Creative Mode)
![alt text](./assets/UMLDiagram_REQ3_A3.png)
The diagram represents an object-oriented system for a feature where evolution can be done if the player has a specific item to help the pokemon to evolve.

The new pokemons that have a restriction for the evolution process are Pikachu and Eevee. I created RestrictedEvolvedPokemonBase abstract class that inherits from EvolvedPokemonBase because to avoid repetitions (DRY) and to align with Single-Responsibility Principle where RestrictedEvolvedPokemonBase has a similarity where that need an attribute to save the name of the item for the evolution.

Certain Pokemon will have their unique BackupWeapon with their own unique weapon effect. Due to similarity for each WeaponEffect, there is abstract class WeaponEffectItem that will be inherited by Shock, Flood, and Barren. Those three WeaponEffect concrete class has dependency with Thunder, Surf, and SolarBeam respectively because those weapon will create those WeaponEffect on GameMap. This design also aligns with Open-Closed principle because it will be easy to be extended.

Related BackupWeapon's feedback from Assignment 2, there is another alternative that can be done instead of applying the current design where each PokemonBase will have an association with BackupWeapon as an ArrayList, we can still have an association with BackupWeapon but not as ArrayList, so that the BackupWeapon will store all the weapon for the pokemon. However, with the latter option, we will have issue with access modifier, so that's why I still keep the first approach to be implemented in this Assignment 3.

There is also a new abstract class named Stone that inherits Item that will be used to help RestrictedEvolvedPokemonBase to evolve. This aligns with the Open-Closed principle because we can add more stone based on the situation for the game. Everytime Player helps the evolution, EvolveAction will remove that related stone from the Player inventory, that's why we have dependency between EvolveAction and Item.

There is also a new concrete class that inherits from SpawningGround that will spawn Pikachu named ElectricField. This can be easily created because the original design has already meet the Open-Closed principle.



### REQ 4 (Creative Mode)
![alt text](./assets/UMLDiagram_REQ4_A3.png)

## Design Rationale - Assignment 2 

### REQ 1
![alt text](./assets/UMLDiagram_REQ1.png)
Based on A1 feedback, I have deleted the unnecessary relationships between abstract **SpawningGround** class and **Exit** class. Now **SpawningGround** class has a dependency relationship with **Location** class as **Waterfall** and **Tree** need to check surrounding locations in order to spawn Pokemons. 

Also I have corrected the relationship between **Crater** & **Waterfall** & **Tree** and Pokemon classes. Instead of having association relationship with **PokemonBase**, the actual spawning ground class is now having the dependency relationship with actual spawned Pokemon class. 



### REQ 2
![alt text](./assets/UMLDiagram_REQ2.png)

The diagram represents an object-oriented system for part of the pokemon game that focuses only for Pokemon criteria only. This diagram has three concrete classes that represent pokemon that exist inside the game.

All three types of pokemons extended the abstract Pokemon class. To avoid repetitions (DRY) and since they share some common attributes (Element and PlayerInteraction) and methods, it is logical that it is an abstract class.

Each pokemon acts in the same way of numeral types of behaviors and to implement Open-Closed Principle, Pokemon abstract class has an association towards Behavior interface.

One of the behaviors that inherits this interface is AttackBehavior class. Each pokemon is designed to have two ways of attacking other pokemon which are using intrinsicWeapon or WeaponItem. Because everytime the game runs, the pokemon need to check its own stepped ground, so we introduced new behavior called ToggleWeaponBehavior just to check every turn whether the pokemon will use intrinsicWeapon or backupWeapon. This approach aligns with Single Responsibility Principle.

SpecialWeapon inherits from WeaponItem abstract class which also inherits from Item abstract class. This way of design ensures the robustness of polymorphism which aligns with the Liskov Substitution Principle.

### REQ 3
![alt text](./assets/UMLDiagram_REQ3.png)

Based on A1 feedback I have corrected the multiplicity between **PokemonBase** and **Generalball** class.

This design is more comprehensive than A1 design. 

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
Compared to A1, this design is more comprehensive for ground classes in order to implement the logics of time. 

There are three different grounds and Pokemons will experience the pass of time. The logics for pokemons are relatively simple. 

**PokemonBase** class implement **TimePerception** interface and in each Pokemon's constructor, it will run the registerInstance method which added the object into timePerceptionList.

As for ground, I have created two new interfaces which contain default methods to implement the 'expand' and 'destroy' of grounds. This design follows the **Interface Segregation Principle** as **Tree** class does not need to destroy, therefore, a single Interface does not satisfy this requirement.

Moreover, the default methods inside these interfaces follows the DRY principle as the 'destroy' and 'expand' logics for different grounds are quite similar.

Similarly, these grounds classes also implement the **TimePerception** interface and run the registerInstance method in constructors.

Floor and Wall classes can't be coverted to another ground, therefore, I created an Enum status 'NONCONVERTIBLE' which used to distinguish these two grounds. 


### REQ 6
![alt text](docs/DesignDocs/UML_REQ6_AashleshaGaur.png)
- Compared to A1, I have made a few modifications to make the implementation less complex.
- Before, I had decided to include a 'ShopHelper' that would interact with the player's inventory. However, while implementing this code I realised this was not actually necessary because the ShopKeeper has an unlimited inventory which means I would not need the ShopHelper class to manage different inventories.
- ShopKeeper and ProfessorOak are both now singleton classes because it is practical for them to only have one instance of themselves because there can only be one ShopKeeper and ProfessorOak.
- The BuyAction class has been modified to be an abstract class because there can be multiple buy actions and the BuyAction class itself is not specfic. The BuyAction class does not need any objects created from it which is why it is made to be abstract.