import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
public class TicketApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		
		//menu--
		System.out.println("What do you wish to do?");
		System.out.println("Enter 1 to book the ticket");
		System.out.println("Enter 2 for train enquiry");
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		
		if(input==1)
		{
			System.out.println("Enter Train Number");
			int code=sc.nextInt();
			System.out.println("Enter Travel Date");
			int y=sc.nextInt();
			int m=sc.nextInt();
			int d=sc.nextInt();
			LocalDate date2=LocalDate.of(y, m, d);
			System.out.println("Enter Number of Passengers");
			int num=sc.nextInt();
			Train train=TrainDAO.findTrain(code);
			if(train==null) {
				System.out.print("Train with given number does not exist");
				System.exit(1);
			}
			Ticket ticket=new Ticket(date2, train);
			for(int i=0;i<num;i++) {
				System.out.println("Enter the name of passenger");
				String name=sc.next();
				System.out.println("Enter the age of passenger");
				int age=sc.nextInt();
				System.out.println("Enter the gender of passenger");
				String gender=sc.next();
				ticket.addPassenger(name, age, gender);		
			}
			ticket.writeTicket();
			System.out.println(ticket.countTickets(LocalDate.now()));
		}
		if(input==2) {
			System.out.println("Enter source");
			String src=sc.next();
			Train tr=TrainDAO.findDestination(src);
			if(tr==null) {
				System.out.println("No trains found");
			}
		}
		sc.close();
	}

}
