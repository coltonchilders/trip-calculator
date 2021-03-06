# trip-calculator
The project goals are simple: We require a program that calculates the expenses for a group of students who like to go on road trips.

The group agrees in advance to share expenses equally, but it is not practical to share every expense as it occurs. Thus individuals in the group pay for particular things, such as meals, hotels, taxi rides, and plane tickets. After the trip, each student's expenses are tallied and money is exchanged so that the net cost to each is the same, to within one cent. In the past, this money exchange has been tedious and time consuming. Your job is to compute, from a list of students and their personal expenses from the trip, the minimum amount of money that must change hands in order to equalize (within one cent) all the students' costs.

So, for example, Louis, Carter, and David took a trip together; Louis incurred expenses of $5.75, $35.00, and $12.79, Carter paid out $12.00, $15.00, and $23.23, and David covered $10.00, $20.00, $38.41, and $45.00. Louis' total was $53.54, Carter's was $50.23, and David shelled out $113.41. The total cost of the trip was thus $217.18, and thus equal shares would be $72.39 1/3 cents. Therefore, Louis owes David $18.85, and Carter owes David $22.16.

The output should include each student's name, and how much each student needs to pay out to any others. For simplicity's sake, it is safe to assume three students, two of which pay much less than the third; however, if you want to make it a general-purpose solver to work with any number of students, please feel free.

Start the application with one of the following commands (if you're using an IDE like Eclipse, just run the class `com.pusher.ShoppingCartApplication`):

    ```
    mvn spring-boot:run
    ```
    
    Or
    
    ```
    mvn package -DskipTests
    java -jar target/shopping-cart-0.0.1-SNAPSHOT.jar 
    ```
    
Go to `http://localhost:8080` and start playing with the app

### Prerequisites

- [A Pusher account](https://pusher.com/)
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org/download.cgi)

## Built With

* [Pusher](https://pusher.com/) - APIs to enable devs building realtime features
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://projects.spring.io/spring-boot/) - To create the Spring application
