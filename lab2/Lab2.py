def calendar_algo(list):
    left_el = 0
    right_el = 1
    list_len = list.__len__()

    # sorting algo
    for i in range(0, list_len):
        for j in range(i + 1, list_len):
            min_index = i
            if list[j] < list[min_index]:
                min_index = j
                list[i], list[min_index] = list[min_index], list[i]

    # algo
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


LIST = [(11, 12), (8, 9), (2, 3), (9, 12)]
print(LIST)
print(calendar_algo(LIST))
