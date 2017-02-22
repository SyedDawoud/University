import unittest
arr=[[1,2], [3,4,5]]

class Matrix:
    def __init__(self):
        self.rows=None
        self.cols=None
        self.data=None

    def specifySize(self,row,col):
        self.rows=row
        self.cols=col
        self.data = [[0 for x in xrange(self.rows)] for y in xrange(self.cols)]

    def showMatrix(self):
        print self.data
        print "\n"

    def getData(self):
        for a in range(0,self.rows):
            for b in range(0,self.cols):
                s=raw_input("Inp")
                self.data[a][b]=int(s)

    def setData(self,a):
        self.data=a





def matrixMul(A,B):
    if(A==None or B==None):
        return False
    rowsA=len(A)
    if rowsA==1:
        colsA=len(A)
    else:
        colsA = len(A[1])

    rowsB=len(B)
    if rowsB==1:
        colsB=len(B)
    else:
        colsB = len(B[1])


    if(colsA!=rowsB):
        return False
    else:
        C=[[0 for x in xrange(rowsA)] for y in xrange(colsB)]



        for a in range(0,rowsA):
            for b in range(0,colsB):
                res=0

                for c in range(0,colsA):
                    res+=A[a][c]* B[c][b]
                C[a][b]=res

        return C



# class Test(unittest.TestCase):
#
#     def test_isCorrect(self):
#         self.assertFalse(matrixMul(None,None))
#         self.assertFalse(matrixMul([[1,2],[3]], [[1,2],[3,4]]))

print matrixMul([[1,2],[3,4]], [[1,2],[3,4]])

print matrixMul([[5]],[[2]])
print matrixMul([[1,2],[3,4]], [[1,0],[0,1]])
print matrixMul([[1,2,3],[4,5,6],[7,8,9]], [[1,0,0],[0,1,0],[0,0,1]])


M=Matrix()
M.specifySize(2,2)
M.setData([[1,2],[3,4]])
M.showMatrix()