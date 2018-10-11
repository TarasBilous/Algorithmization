def selection_sort(list):
    for i in range(0, list.__len__()):
        for j in range(i + 1, list.__len__()):
            min_index = i
            if list[j] < list[min_index]:
                min_index = j
                list[i], list[min_index] = list[min_index], list[i]


def tuple_simplification(list):
    left_el = 0
    right_el = 1
    list_len = list.__len__()
    is_done = False

    while not is_done:
        is_done = True
        i = 0
        while i < list_len - 1:
            if list[i][right_el] >= list[i + 1][right_el]:
                # delete excessive tuple
                list.pop(i+1)
                list_len -=1
                is_done = False
            elif list[i][right_el] >= list[i + 1][left_el]:
                # merge neighboring tuples
                merged_element = (list[i][left_el], list[i+1][right_el])
                list[i] = merged_element
                list.pop(i+1)
                list_len -= 1
                is_done = False
            i += 1
    return list


LIST = [(11, 12), (8, 9), (2, 3), (9, 12), (12, 23), (9,13), (12, 15), (4,13), (18, 23)]
print(LIST)
selection_sort(LIST)
tuple_simplification(LIST)
print(LIST)
