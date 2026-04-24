# Yareal Digital Pet 🐶💕

## Overview
Console-based Java app simulating a digital pet named **Yareal** with **feeding, drinking (thirst), happiness, and aging** mechanics.

## How to Run
1. Open terminal/command prompt.
2. Navigate: `cd "C:/Users/brian/Desktop/YarealDigitalPet"`
3. Compile: `javac *.java`
4. Run: `java Main`

## Controls
- **1: Feed** - Reduces hunger, boosts happiness.
- **2: Drink** - Reduces thirst, boosts happiness.
- **3: Play** - Boosts happiness, slight hunger/thirst cost.
- **4: Wait** - Pass turn (decay happens).
- **0: Quit**

## Mechanics
- **Hunger/Thirst**: Decay per turn; <=0 → death.
- **Happiness**: Decays over time/age; actions boost it; <=0 → death.
- **Aging**: Every 10 turns, age +1 day (extra happiness decay).
- Goal: Maximize lifespan!

No dependencies. Pure Java. Have fun caring for Yareal! 
