
# Channel Class with Name/url and Next Pointer that will point to next node in the linked list
class Channel:
    def __init__(self):
        self.name=None
        self.id=None
        self.description=None
        self.next=None

class TVManager:
#Head is main pointer/reference of the linked list here
    def __init__(self,name):
        self.head=Channel()
        self.head=None
        self.linkedName=name


# Method to add channel to the linked list
    def addChannel(self,channelName,idChannel,desc):
        temp=self.head
        newNode=Channel()          # Create a new node
        newNode.name=channelName
        newNode.id=idChannel
        newNode.description=desc
        if temp==None:            # If initially list is empty, make first node as head node
            self.head=newNode
            self.head.next=None
        else:                   # If there is already something, move to end and add the node there
            while temp.next:
                temp=temp.next
            temp.next=newNode
            newNode.next=None

    # Method to Replace Channel
    def replaceChannel(self,current,new):
        temp=Channel()         # Get the Head of the linked list
        temp=self.head
        while temp.name!=current:        # Till we don't find the channel which is to be replaced, move ahead
            temp=temp.next
            if temp==None:               # If we reach the end, simply break out
                break
        if temp==None:                   # Print out Error that We can't replace
            print "No  Channel with url :" + current + " Found\n"
        elif temp.name==current:          # Else if it is there, replace it
            temp.name=new



# Mehtod that will print the list
    def printList(self):
        temp=Channel         # Create an instance of Node/Channel
        temp=self.head       # Assign it head
        while temp:          # For each value, print it and move to next value
            print str(temp.id) + ":" +temp.name +"\n Description : " + temp.description +"\n"
            temp=temp.next
# Method to delete the Node based on the ID
    def deleteChannel(self,channelID):
        temp1=Channel()
        temp2=Channel()
        temp1=self.head
        temp2=None
        while temp1 != None:        # Get to the node with the ID
            temp2 = temp1
            if temp1 != None:
                if temp1.id == channelID:
                    break
            temp1 = temp1.next

        if temp1 == None:           # If not found
            print "Can't find channel with ID : " + str(channelID) + "\n"
        elif temp1==self.head:      # If the node is head
            print " Deleting the Channel with ID : " + str(temp1.id) + "\n"
            self.head=self.head.next
            del temp1
            temp1=None
        else:                 # Else set the reference accordingly i.e. skip the node to delete
            print " Deleting the Channel with ID : " + str(temp1.id) + "\n"
            temp2 = temp1.next
            del temp1
            temp1= None




# Global Function to call the linked list functions
def mainFunction():
     tv=TVManager("Dawoud Manager")
     tv.printList()
     print "Here The names like Drake etc will be replaced by the URLs \n" 
     tv.addChannel("Drake",1 , " Hence it is ")
     tv.printList()
     tv.addChannel("Drake1",2, " You Are")
     tv.addChannel("Drake2",3, " I Love")
     tv.replaceChannel("Drake","Some New")
     tv.printList()
     tv.replaceChannel("Draked", "Some New")
     tv.printList()
     tv.deleteChannel(1)
     tv.printList()
     tv.deleteChannel(55)
     tv.deleteChannel(2)
     tv.printList()
     tv.deleteChannel(2)


mainFunction()


