
/**
 * The QueueLinkedList class is used to set up the Queue to simulate the customers going through 
 * this simulation. Methods include adding customers to the line, removing them, checking service time and 
 * decrementing time from the customer service time.
 * 
 * @author (Michael Blackley) 
 * @version (2/26/2015)
 */
public class QueueLinkedList
{
    private Customer first, last;
    
    /**
     * Constructor for objects of class QueueLinkedList
     */
    public QueueLinkedList()
    {
        first = null;  //assigning variables to null
        last = null;
        
    }
    
    public void enqueue(Customer newCustomer)
    {
        if( isEmpty() )
        {
            first = newCustomer;                //checks to see if queue is empty, if so assigns the new customer
        }
        else
        {
            last.setNext(newCustomer);          //if not it sets last to the next customer
        }
        
        last = newCustomer;
    }
    
    
    public int checkTime()
    {
     if(first != null)
     return first.getServiceTime();   //if the first customer does not point to null it returns the service time
     
     else
     return 0;                        //if the first customer does point to null then it returns 0
    }
    
    public void customerTimeDecrement()
    {
        first.decServiceTime();       //decrements time from the customer first in line
    }
    
    
    public void dequeue()
    {
      
       if(first == last)
      {
           last =  null;             //if the first customer is the last customer then point that customer to null
      }
        
        if (!isEmpty())
       {
           first = first.getNext(); //if the queue is not empty then the first customer is removed and the second is assigned first
       }

    }
    
    public boolean isEmpty()
    {
        return first == null;      //returns null when the line is empty
    }
}
        
    
