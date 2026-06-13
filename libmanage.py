class user:
    def __init__(self,name):
        self.name = name
    
class student(user):
    def __init__(self,rollno,section,name):
        super().__init__(name)
        self.rollno = rollno
        self.section = section

    def display(self):
        print(self.rollno)
        print(self.name)
        print(self.section)

class faculty(user):
    def __init__(self,id,dept,name):
        super().__init__(name)
        self.id = id
        self.dept = dept

    def displayf(self):
        print(self.id)
        print(self.name)
        print(self.dept)

class books:
    def __init__(self,bookid,title,author):
        self.bookid = bookid
        self.title = title
        self.author = author
        self.map_num = {}
        self.cntbooks = []  
    
    def addbook(self,name_of_book):
        self.cntbooks.append(name_of_book)

        if name_of_book not in self.map_num:
            self.map_num[name_of_book] = 0

        self.map_num[name_of_book] += 1

class return_and_issue(books):
 
    def issue(self,name_of_book,bookid):
        if name_of_book in self.map_num and self.map_num[name_of_book] > 0:
            self.map_num[name_of_book] -= 1
            print("book issued")
        else:
            print("currently the book is not avialable")        
        
    def retur(self,name_of_book,bookid):

        if name_of_book not in self.map_num:
            self.map_num[name_of_book] = 0

        self.map_num[name_of_book] += 1
        print("book returned sucessfully")    
            
r1 = return_and_issue(10,"Harry potter","Rudyard Kipling")
r1.addbook("Harry potter")
r1.addbook("Harry potter")
r1.addbook("Harry potter")
r1.addbook("Harry potter")

r1.issue("Harry potter",10)
r1.issue("Harry potter",10)
r1.issue("Harry potter",10)

r1.retur("Harry potter",10)

print(r1.map_num)
