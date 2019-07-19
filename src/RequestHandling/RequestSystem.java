package RequestHandling;

import java.util.Scanner;

public class RequestSystem {
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        Requests reqobj= new Requests();
        char conti= 'n';

        reqobj.addRequest("Request-1",1);
        reqobj.addRequest("Request-2",5);
        reqobj.addRequest("Request-3",0);
        reqobj.addRequest("Request-4",2);

        do{

            System.out.println("Request System....\n");
            System.out.println("1. Make Request.\n2. Execute Request.\n3. Display All Requests." +
                    "\n4. Display Last Five Executed Requests\n5. Exit");
            short choice= sc.nextShort();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("Enter the Request and its priority (Between 1-5)");

                    System.out.println("Request: ");
                    String request= sc.next();

                    System.out.println("Priority: ");
                    short priority= sc.nextShort();
                    reqobj.addRequest(request,priority);
                    break;

                }
                case 2:
                {
                    reqobj.executeRequest();
                    break;
                }
                case 3:
                {
                    reqobj.displayAllRequests();
                    break;
                }
                case 4:
                {
                    reqobj.showLastFiveRequests();
                    break;
                }
                case 5:
                {
                    System.exit(0);
                }
                default:
                {
                    System.out.println("Enter the valid choice...");
                    break;
                }

            }
            System.out.println("Continue (Y/N) ?");
            conti=sc.next().charAt(0);

        }while (conti=='y');

    }
}
