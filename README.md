# Rock-Paper-Scissors with Machine Learning 

A command-line Java application implementing a strategy-based design with both random and machine learning algorithms for gameplay.

## Features
- Two modes:
  - Random (`-r`)
  - Machine Learning (`-m`)
- ML algorithm learns from past player moves
- Pattern-based prediction using sequence frequency
- Command-line interface
- Clean object-oriented design using interfaces

## How to Run

Compile:
javac *.java

Run (Random):
java Main -r

Run (Machine Learning):
java Main -m


## Design Highlights
- Strategy Pattern via `ChoiceAlgorithm` interface
- Low coupling and high cohesion
- Extendable architecture for new algorithms

## Author
Arhaam Azhari  
San Jose State University
(Built as part of CS151 - Object-Oriented Design)
