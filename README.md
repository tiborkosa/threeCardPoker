# threeCardPoker

Simple Three Card Poker hand evaluator

 Input Format
------------

The read over `stdin`. Some of the lines will contain collections of cards. These cards will be represented in the
format `<rank><Suit>`. rank will be one of:

* an integer from `2` to `9` for numbered cards less than ten
* `T` for ten
* `J` for jack
* `Q` for queen
* `K` for king
* `A` for ace

Suit will be one of:
* `h` for hearts
* `d` for diamonds
* `s` for spades
* `c` for clubs

Some example cards are `4d` for four of diamonds, `Ts` for ten of spades, and `Ah` for ace of hearts.

Input Data
----------
The first line of input will contain a single integer representing the number of players.

The following `n` lines, where `n` is the number of players, will contain a single integer representing the id of the player, followed by three 
space-separated cards representing a hand belonging to a player.

An example input is as follows:


    3
    0 2c As 4d
    1 Kd 5h 6c
    2 Jc Jd 9s
