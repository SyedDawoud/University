import unittest
import numpy as np
arr=[[1,2], [3,4,5]]

# Just Matrix Related Class
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




def StrassanMul(A,B,n):
    if(n==1):
        return matrixMul(A,B)
    else:
        m=n/2
        #C = [[0 for x in xrange(m)] for y in xrange(m)]
        A11 = [[0 for x in xrange(m)] for y in xrange(m)]
        A12 = [[0 for x in xrange(m)] for y in xrange(m)]
        A21 = [[0 for x in xrange(m)] for y in xrange(m)]
        A22 = [[0 for x in xrange(m)] for y in xrange(m)]

        B11 = [[0 for x in xrange(m)] for y in xrange(m)]
        B12 = [[0 for x in xrange(m)] for y in xrange(m)]
        B21 = [[0 for x in xrange(m)] for y in xrange(m)]
        B22 = [[0 for x in xrange(m)] for y in xrange(m)]
        # Dividing the Matrix into 4 parts
        #A11=divideMatrix(A,0,n/2,0,n/2)
        A11=np.array(A)[0:n/2, 0:n/2]
        #A12=divideMatrix(A,0,n/2,m,n)
        A12=np.array(A)[0:n/2,n/2:n]
        #A21=divideMatrix(A,n/2, n, 0, n/2)
        A21=np.array(A)[n/2:n,0:n/2]
        #A22=divideMatrix(A,n/2,n,n/2,n)
        A22=np.array(A)[n/2:n,n/2:n]

        # B11 = divideMatrix(B, 0, n / 2, 0, n / 2)
        #
        # B12 = divideMatrix(B, 0, n / 2, n / 2, n)
        #
        # B21 = divideMatrix(B, n / 2, n, 0, n / 2)
        #
        # B22 = divideMatrix(B, n / 2, n, n / 2, n)

        B11 = np.array(B)[0:n / 2, 0:n / 2]
        # A12=divideMatrix(A,0,n/2,m,n)
        B12 = np.array(B)[0:n / 2, n / 2:n]
        # A21=divideMatrix(A,n/2, n, 0, n/2)
        B21 = np.array(B)[n / 2:n, 0:n / 2]
        # A22=divideMatrix(A,n/2,n,n/2,n)
        B22 = np.array(B)[n / 2:n, n / 2:n]

        M1 = [[0 for x in xrange(m)] for y in xrange(m)]
        M2 = [[0 for x in xrange(m)] for y in xrange(m)]
        M3 = [[0 for x in xrange(m)] for y in xrange(m)]
        M4 = [[0 for x in xrange(m)] for y in xrange(m)]
        M5 = [[0 for x in xrange(m)] for y in xrange(m)]
        M6 = [[0 for x in xrange(m)] for y in xrange(m)]
        M7 = [[0 for x in xrange(m)] for y in xrange(m)]

        C11 = [[0 for x in xrange(m)] for y in xrange(m)]
        C12 = [[0 for x in xrange(m)] for y in xrange(m)]
        C21 = [[0 for x in xrange(m)] for y in xrange(m)]
        C22 = [[0 for x in xrange(m)] for y in xrange(m)]

        M1=StrassanMul(MatrixAdd(A11,A22,m), MatrixAdd(B11,B22,m), n/2)
        M2=StrassanMul(MatrixAdd(A21,A22,m),B11,m)
        M3=StrassanMul(A11,MatrixSub(B12,B22,m),m)
        M4 = StrassanMul(A22, MatrixSub(B21, B11, m), m)
        M5 = StrassanMul(MatrixAdd(A11, A12, m), B22, m)
        M6=StrassanMul(MatrixSub(A21,A11,m), MatrixAdd(B11,B12,m),m)
        M7 = StrassanMul(MatrixSub(A12, A22, m), MatrixAdd(B21, B22, m), m)

        T1=MatrixAdd(M1,M4,m)
        T2=MatrixSub(T1,M5,m)
        C11=MatrixAdd(T2,M7,m)

        C12=MatrixAdd(M3,M5,m)
        C21=MatrixAdd(M2,M4,m)

        T3=MatrixSub(M1,M2,m)
        T4=MatrixAdd(T3,M3,m)

        C22=MatrixAdd(T4,M6,m)
        # C=[]
        #
        # C11+=(C12)
        # C22+=(C21)
        # C+=(C11)
        # C.append(C22)
        return combine(C11,C12,C21,C22,n)




# Divide Big Matrix Into Small Piece as We want it in Strassen
def divideMatrix(A,rowStart,rowEnd,colStart,colEnd):
    C = [[0 for x in xrange((rowEnd-rowStart)+1)] for y in xrange((colEnd-colStart)+1)]

    for a in range(rowStart,rowEnd+1):
        for b in range(colStart,colEnd+1):
            C[a-rowStart][b-colStart]=A[a][b]

    return C



# Adding the Matrices. This is also required by the Strassen Algorithm
def MatrixAdd(A,B,n):
    C = [[0 for x in xrange(n)] for y in xrange(n)]
    for a in range(0,n):
        for b in range(0,n):
            C[a][b]=A[a][b]+B[a][b]

    return  C
# Combining All the Arrays into 1 final Array
def combine(C11,C12,C21,C22, n):
    C = [[0 for x in xrange(n)] for y in xrange(n)]
    for a in range(0,n/2):
        for b in range(0,n/2):
            C[a][b]=C11[a][b]

    for a in range(0,n/2):
        for b in range(n/2,n):
            C[a][b]=C12[a][b-(n/2)]

    for a in range(n/2,n):
        for b in range(0,n/2):
            C[a][b]=C21[a-(n/2)][b]

    for a in range(n/2,n):
        for b in range(n/2,n):
            C[a][b]=C22[a-(n/2)][b-(n/2)]

    return C


def MatrixSub(A,B,n):
    C = [[0 for x in xrange(n)] for y in xrange(n)]
    for a in range(0,n):
        for b in range(0,n):
            C[a][b]=A[a][b]-B[a][b]

    return  C


# Iterative Method for the Multiplication
def matrixMul(A,B):
    if(A==None or B==None):         # Check None Matrix is NULL
        return False
    rowsA=len(A)
    if rowsA==1:                    # If only 1 row, Cols= number of Element
        colsA=len(A)
    else:
        colsA = len(A[1])            # Otherwise Add as per working

    rowsB=len(B)
    if rowsB==1:
        colsB=len(B)
    else:
        colsB = len(B[1])


    if(colsA!=rowsB):        # Check Cols(A) == Rows(B)
        return False
    else:                    # New Matrix with ORder (Rows of A)(Cols of B)
        C=[[0 for x in xrange(rowsA)] for y in xrange(colsB)]



        for a in range(0,rowsA):         # Traverse Rows of A
            for b in range(0,colsB):     # Traverse Cols of B
                res=0                    # Sum =0

                for c in range(0,colsA):       # Iterate each Row And Column Element of A & B
                    res+=A[a][c]* B[c][b]
                C[a][b]=res

        return C



class Test(unittest.TestCase):

    def test_isCorrect(self):
        self.assertFalse(matrixMul(None,None))
        self.assertFalse(matrixMul([[1,2],[3]], [[1,2],[3,4]]))
        self.assertEqual(matrixMul([[1,2],[3,4]], [[1,2],[3,4]]), StrassanMul([[1,2],[3,4]], [[1,2],[3,4]],2))
        self.assertEqual(matrixMul([[1, 2], [3, 4]], [[1, 0], [0, 1]]),
                         StrassanMul([[1, 2], [3, 4]], [[1, 0], [0, 1]], 2))

        self.assertNotEqual(matrixMul([[1, 2], [3, 4]], [[1, 0], [0, 1]]),
                         StrassanMul([[1, 2], [3, 4]], [[1, 1], [0, 1]], 2))

        self.assertNotEqual(matrixMul([[1, 2], [3, 4]], [[1, 0], [0, 1]]),
                            StrassanMul([[1, 2], [3, 4]], [[1, 1], [1, 1]], 2))

        self.assertNotEqual(matrixMul([[1, 2], [3, 4]], [[0, 0], [0, 1]]),
                            StrassanMul([[1, 2], [3, 4]], [[1, 1], [0, 1]], 2))




