import java.util.Random;
/**
 * The driver class takes the customer and the queueLinkedList class and simulates customers waiting in 
 * line at a grocery store. Simulates 60 minutes of activity at the store and adds new customers to the 
 * queue based off of a 25% chance that they are added. The program also removes customers from the queue
 * if their service time is up. The program outputs when a new customer is added and the queue length, when 
 * customers are service and removed and also the queue length then, total number of customers service, and 
 * maximum line length during the simulation.
 * 
 * @author (Michael Blackley) 
 * @version (2/26/2015)
 */
public class Driver
{
    public static Customer first, last;
    public static void main(String[] args)
    {
        QueueLinkedList line = new QueueLinkedList();    //makes a new queue
        int time;
        int random;
        int count = 0;
        int timeRemaining;
        int maximumLength = 0;
        int customersServiced = 0;
        int customerNumber = 0;
        

        for(int i = 0; i < 60; i++)
        {
            random = new Random().nextInt(4) + 1;  //sets up random variable between 1 and 4
            Customer p = new Customer();           //creates new customer
            time = p.getServiceTime();             //calls customer class and gets a service time
            timeRemaining = time;                  //sets timeremaining equal to time

            if(random == 1) //25% chance that a new customer is added
            {
                count++;
                customerNumber++;
                line.enqueue(p);                   //add new customer to queue

                System.out.println("New Customer Added!");
                System.out.println("Customers service time: " + time + " minutes");
                System.out.println("Queue length is now " + count);


      
            }
            
            if(count > maximumLength)
            {
                maximumLength = count;           //calculates the maximum length of the queue
            }


                if(line.checkTime() == 0 && count > 0) 
                {   
                    count--;
                    customersServiced++;
                    line.dequeue();       //removes customers from the list when their service time equals 0       
                    System.out.println("Customer serviced and removed from the queue.  Queue length is now " + count); 
                    p.getServiceTime();

                }
                
                  if(line.checkTime() != 0)
                {
                  line.customerTimeDecrement();     //decrements time from customers when their time is not equal to 0
                }
                System.out.println("-------------------------------------------");
        }
        
        System.out.println(customersServiced + " customers were serviced");
        System.out.println("Maximum line length: " + maximumLength);
    }
}

