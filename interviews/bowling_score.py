# 1. Implement the BowlingGame class so that it returns the correct
# score according to the rules of ten-pin bowling.
#
# 2. Add more methods to the BowlingGameTest to account for additional
# test cases.
#
# 3. Refactor the BowlingGameTest methods to reduce
# repetitive code without changing their meaning.

import unittest

class BowlingGame(object):
    '''Ten-Pin Bowling Game Scoring
http://en.wikipedia.org/wiki/Ten-pin_bowling

In the game of bowling, each player rolls a ball down a lane trying to
knock down as many pins as possible. The game consists of 10 "frames."
In each frame the player has two chances to knock down 10 pins.

The score for each frame is the total number of pins knocked down,
plus bonuses for strikes and spares. The total score for a game is the
sum of the scores of all 10 frames.

A "strike" is when the player knocks down all 10 pins on the first
try. The bonus for that frame is the value of the next two rolls.

A "spare" is when the player knocks down all 10 pins in two tries. The
bonus for that frame is the number of pins knocked down by the next
roll.

In the tenth frame a player who rolls a spare or strike is allowed to
roll extra balls to complete the frame. No more than three balls can
be rolled in tenth frame.

    '''
    def __init__(self):
        self.rolls = []
    
    def roll(self, pins):
        '''Updates the player's scorecard with a number of pins knocked down'''
        self.rolls.append(pins)

    def score(self):
        '''Returns the player's current total score'''
        # this logic also works for the last frame
        score = 0
        roll_id = 0
        for frame_id in range(10):
            if self._is_strike(roll_id):
               score += self._strike_score(roll_id)
               roll_id += 1

            elif self._is_sparse(roll_id):
                score += self._sparse_score(roll_id)
                roll_id += 2

            else:
                score += self.rolls[roll_id] + self.rolls[roll_id + 1]
                roll_id += 2
        return score
    
    def _is_strike(self, roll_id):
        # check if nth roll is a strike
        return self.rolls[roll_id] == 10

    def _strike_score(self, roll_id):
        return self.rolls[roll_id + 1] + self.rolls[roll_id + 2] + 10

    def _is_sparse(self, roll_id):
        #check if this frame a sparse
        return self.rolls[roll_id] + self.rolls[roll_id + 1] == 10
                              
    def _sparse_score(self, roll_id):
        return self.rolls[roll_id + 2] + 10

class BowlingGameTest(unittest.TestCase):
    
    def _multi_rolls(self, pins, num_rolls):
        for i in range(num_rolls):
            self.game.roll(pins)
    
    def _sparse_rolls(self):
        self.game.roll(5)
        self.game.roll(5)
    
    def setUp(self):
        self.game = BowlingGame()
    
    def test_all_zeros(self):
        self._multi_rolls(0, 20)
        print "test_all_zeros"
        self.assertEquals(0, self.game.score())
    
    def test_all_ones(self):
        #game = BowlingGame()
        self._multi_rolls(1, 20)
        print "test_all_ones"
        self.assertEquals(20, self.game.score())

    def test_one_sparse(self):
        self._sparse_rolls()
        self.game.roll(8)
        self._multi_rolls(0, 17)
        print "test_one_sparse"
        self.assertEquals(26, self.game.score())

    def test_one_strike(self):
        self.game.roll(10)
        self.game.roll(2)
        self.game.roll(7)
        self._multi_rolls(0, 16)
        print "test one strike"
        self.assertEquals(28, self.game.score())

    def test_case_a(self):
        pins_list = [9, 1, 0, 10, 10, 10, 6, 2, 7, 3, 8, 2, 10, 9, 0, 9, 1, 10]
        for pins in pins_list:
            self.game.roll(pins)
        print "test case A"
        self.assertEquals(168, self.game.score())

    def test_case_perfect_game(self):
        pins_list = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
        for pins in pins_list:
            self.game.roll(pins)
        print "test perfect game"
        self.assertEquals(300, self.game.score())


if __name__ == '__main__':
    unittest.main()
