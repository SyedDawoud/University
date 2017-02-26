
def makePowerofTwo(a):
    k=1
    while(k-a <0):
        k=k*2
    a=k
    print a

def checkPowerofTwo(a):
    k=1
    cond=True

    while(k-a!=0):
        k=k*2
        if(k-a > 0):
            cond=False
            break

    return cond


makePowerofTwo(4)
makePowerofTwo(8)
makePowerofTwo(9)
makePowerofTwo(14)
makePowerofTwo(15)
makePowerofTwo(1)
print checkPowerofTwo(2)
print checkPowerofTwo(3)
print checkPowerofTwo(4)
print checkPowerofTwo(1)
print checkPowerofTwo(15)
print checkPowerofTwo(16)

    
