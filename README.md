# Rock-Paper-Scissors with Machine Learning 

A Java-based Rock-Paper-Scissors game that implements both a random strategy and a simple machine learning algorithm to predict user behavior.

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
