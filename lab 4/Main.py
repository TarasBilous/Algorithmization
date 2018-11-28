import math


def read_from_file(filename):
    with open(filename) as file_obj:
        weights = file_obj.readline().split(',')
    weights = [int(value) for value in weights]
    return weights


def divide_data_to_lists(data):
    assertion_count = int(math.sqrt(len(data)))
    divided_data = [[0 for i in range(assertion_count)] for i in range(assertion_count)]

    for i in range(assertion_count):
        for j in range(assertion_count):
            if i != j:
                divided_data[i][j] = data[i * assertion_count + j]

    return divided_data


def find_max_difference_between_difficulties(data):
    input_set = set(data)
    input_set.remove(0)
    max_edge = max(input_set)
    min_edge = min(input_set)

    return max_edge - min_edge


def reverse_graph(graph_for_reverse, nodes_count):
    processed_graph = [[0 for i in range(nodes_count)] for i in range(nodes_count)]

    for i in range(nodes_count):
        for j in range(nodes_count):
            processed_graph[i][j] = graph_for_reverse[j][i]

    return processed_graph


def dfs_function(graph, start, start_weight, difference):
    edges = {start_weight}
    found_way = []

    def dfs(start):
        used.add(start)

        for index, node_weight in enumerate(graph[start]):

            if index not in used and index != start:
                edges.add(node_weight)

                if (max(edges) - min(edges)) <= difference:
                    found_way.append(node_weight)
                    dfs(index)
                else:
                    edges.remove(node_weight)

    used = set()
    dfs(start)

    return found_way


def profes_algo(graph, node_count, max_difference):
    is_done = False
    reversed_graph = reverse_graph(graph, node_count)

    for difference in range(max_difference):

        copy_graph = graph[0].copy()[1:]

        for start_weight in copy_graph:
            answer = dfs_function(graph, 0, start_weight, difference)

            if len(answer) + 1 == node_count:
                reverse_answer = dfs_function(reversed_graph, 0, start_weight, difference)

                if len(reverse_answer) + 1 == node_count:
                    # print("Route: " + str(answer))
                    # print("Rewerse route: " + str(reverse_answer))
                    print("Answer: " + str(difference))
                    is_done = True

            if is_done:
                break

        if is_done:
            break


if __name__ == '__main__':
    input_data = read_from_file('D://in.txt')
    graph = divide_data_to_lists(input_data)
    assertions_count = len(graph)

    max_difference = find_max_difference_between_difficulties(input_data)

    profes_algo(graph, assertions_count, max_difference)
