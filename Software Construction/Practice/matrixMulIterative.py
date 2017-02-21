import unittest
arr=[[1,2], [3,4,5]]



def matrixMul(A,B):
    if(A==None or B==None):
        return False
    rowsA=len(A)
    colsA=len(A[1])
    rowsB=len(B)
    colsB=len(B[1])

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



print matrixMul([[1,2],[3,4]], [[1,2],[3,4]])

class Test(unittest.TestCase):

    def test_isCorrect(self):
        self.assertFalse(matrixMul(None,None))
        self.assertFalse(matrixMul([[1,2],[3]], [[1,2],[3,4]]))