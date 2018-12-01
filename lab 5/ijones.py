def read_from_file(filename):
    data = []
    lines = [line.rstrip('\n') for line in open(filename)]

    for line in lines:
        pair = line.split(",")
        data.append(pair)

    return data


def create_zero_matrix(wid, hei):
    matrix = [[0 for i in range(wid)] for i in range(hei)]
    for i in range(hei):
        matrix[i][0] = 1
    return matrix


def ijones_algo(letter, row, column, data_matrix, letter_matrix):
    routes_count = 0
    for j in range(column):
        for i in range(len(letter_matrix)):
            current_letter = letter_matrix[i][j]
            if current_letter == letter:

                routes_count = calculate_route_algo(data_matrix, i, j, letter, letter_matrix, routes_count)

            elif i == row and j == column - 1:
                new_letter = letter_matrix[i][column - 1]
                if new_letter == letter:
                    routes_count -= 1

                routes_count = calculate_route_algo(data_matrix, i, j, new_letter, letter_matrix, routes_count)

    return routes_count


def calculate_route_algo(data_matrix, i, j, letter, letter_matrix, sum):
    if data_matrix[i][j] != 0:
        sum += data_matrix[i][j]
    else:
        routes = ijones_algo(letter, i, j, data_matrix, letter_matrix)
        data_matrix[i][j] = routes
        sum += routes
    return sum


if __name__ == '__main__':
    input_data = read_from_file('D://in.txt')
    width = int(input_data[0][0])
    height = int(input_data[0][1])
    input_data.pop(0)

    up_letter = input_data[0][width - 1]
    down_letter = input_data[height - 1][width - 1]

    empty_matrix = create_zero_matrix(width, height)
    part1 = ijones_algo(up_letter, 0, width - 1, empty_matrix, input_data)
    part2 = ijones_algo(down_letter, height - 1, width - 1, empty_matrix, input_data)
    print('Answer: ' + str(part1 + part2))
