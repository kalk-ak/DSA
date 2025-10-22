# ra

# def most_common_char(word):
#     num = word.count(word[0])
#     letter = word[0]
#     for i in range(1, len(word)):    
#         if word.count(word[i]) >= num:
#             num = word.count(word[i])
#             letter = word[i]
    
#     return f'"{letter}", {num}'


# print(most_common_char(test_word))



test_word = input()


#3333333333333333333
def check_palindrom(word):
    if len(word) == 0 or len(word) == 1:
        return True
    
    if word[0] == word[-1]:
        return check_palindrom(word[1:-1])
    else:
        return False



print(check_palindrom(test_word))




class Circle:
    def __init__(self, radius):
        self.radius = radius

    def get_radius(self):
        return self.radius
    
    def set_radius(self, radius):
        self.radius = radius

    def get_area(self):
        import math
        area = math.pi * self.radius * self.radius
        return area
    
    def get_diameter(self):
        return self.radius * 2
    
    def get_circumfrance(self):
        import math
        return math.pi * self.get_diameter()

    def __eq__(self, other):
        if self.radius == other.radius:
            return True
        else:
            return False



