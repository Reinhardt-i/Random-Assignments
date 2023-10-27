from typing import List, Union

def list_to_string(items: List[Union[str, int]]) -> str:
    
    if not items:
        return ""
    if len(items) == 1:
        return str(items[0])
    return ', '.join(str(item) for item in items[:-1]) + ', and ' + str(items[-1])


def list_to_string1(items):

    if not items:
        return ""

    if len(items) == 1:
        return str(items[0])

    # Convert all items in the list to strings, except for the last one
    items_str = ', '.join(str(item) for item in items[:-1])

    # Add the word 'and' before the last item
    items_str += ', and ' + str(items[-1])

    return items_str


if __name__ == '__main__':

    spam = ['apples', 'bananas', 'tofu', 'cats']
    print(list_to_string(spam))

    spam = ['apples', 'bananas', 'tofu']
    print(list_to_string(spam))

    spam = ['apples']
    print(list_to_string(spam))

    spam = []
    print(list_to_string(spam))

