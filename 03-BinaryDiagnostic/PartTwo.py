def bit_counter(array, index):
    zeroes, ones = 0, 0
    for line in array:
        if line[index] == "0":
            zeroes += 1
        if line[index] == "1":
            ones += 1
    return zeroes, ones

def most(zeroes, ones):
    if ones >= zeroes:
        return '1'
    else:
        return '0'

def least(zeroes, ones):
    if ones >= zeroes:
        return '0'
    else:
        return '1'

def recursive_search(array, index, mode):
    if len(array) == 1:
        return array[0]
    else:
        zeroes, ones = bit_counter(array, index)
        if mode == 'most':
            current_column = most(zeroes, ones)
        elif mode == 'least':
            current_column = least(zeroes, ones)
        new_array = []
        for item in array:
            if item[index] == current_column:
                new_array.append(item)
        index += 1
        return recursive_search(new_array, index, mode)

string_array = []
with open(r'/Users/mactom/Code/Advent-of-Code-2021/03-BinaryDiagnostic/src/main/resources/03input.txt', 'r+') as in_file:
    for line in in_file:
        string_array.append(line.strip('\n'))
print(int(recursive_search(string_array,0, 'most'), 2) * int(recursive_search(string_array,0, 'least'), 2))
