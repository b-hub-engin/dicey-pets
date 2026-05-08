# Dicey Pets 🎲🐾
*By Thomas Andrew Gatchi*

## Overview
A console-based Java digital pet game where your pets are **living dice**. Keep your chosen die fed, hydrated, and happy for as long as possible. Each die has unique stats that change how the game plays. Play minigames to boost happiness and survive as long as you can!

## The Dice
| Pet | Die | Personality |
|---|---|---|
| **Yareal** | d6 | Balanced — a good starting die |
| **Onion Emberwind** | d20 | High hunger/thirst but low happiness cap — hard to keep cheerful |
| **The Crawler** | d8 | Slow decay, forgiving — easier to manage |
| **Speedy & Simon** | d100 & d10 | Two dice in one — double the needs, double the chaos |

## How to Run

### Local
1. Open terminal and navigate to the project folder
2. Compile: `javac pets/*.java games/*.java Main.java`
3. Run: `java Main`

### GitHub Codespaces (browser)
1. Open the repo on GitHub
2. Click **Code → Codespaces → Create codespace on main**
3. The game compiles and launches automatically in your browser

## Controls
| Key | Action |
|---|---|
| `1` | Feed — restores hunger, boosts happiness |
| `2` | Drink — restores thirst, boosts happiness |
| `3` | Play a minigame |
| `4` | Wait — pass the turn (decay still happens) |
| `0` | Quit |

## Minigames
- **Blackjack** — wins give your die happiness boosts
- **Cup & Ball** — guess the right cup for a happiness boost
- **Battleship** — sink ships to keep your die happy

## Mechanics
- **Hunger / Thirst / Happiness** all decay each turn — hit 0 on any and your die dies
- Decay accelerates with age, making the game harder the longer you survive
- **Overfeeding or overdrinking** when already above 85% penalises happiness
- **Aging** — every 10 turns your die ages up, increasing decay rate slightly
- Each die has unique multipliers that affect how fast stats decay and how much actions restore

## Goal
Keep your die alive as long as possible. How many days can you survive?

---
No dependencies. Pure Java.