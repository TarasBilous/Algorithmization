import unittest
import Lab2


class Lab2Test(unittest.TestCase):

    def test_algo(self):
        test_lists = [
            [(2, 4), (3, 6), (5, 9), (11, 14), (3, 4)],
            [(0, 1), (3, 4), (9, 10), (0, 5), (6, 8)],
            [(10, 12), (2, 9), (4, 5), (11, 12)],
            [(1, 2), (4, 7), (10, 12), (1, 9)]
        ]
        test_results = [
            [(2, 9), (11, 14)],
            [(0, 5), (6, 8), (9, 10)],
            [(2, 9), (10, 12)],
            [(1, 9), (10, 12)]
        ]

        for i in range(test_lists.__len__()):
            self.assertEqual(Lab2.calendar_algo(test_lists[i]), test_results[i])