package RequestHandling;

import java.util.*;
import java.util.concurrent.TimeUnit;

class Request implements Comparable <Request>{

    String request;
    int priority;

    public Request()
    {
        request="N/A";
        priority=0;

    }

    public Request(String request, int priority)
    {
        this.request=request;
        this.priority=priority;
    }

    public String getRequest() {
        return request;
    }

    public int getPriority() {
        return priority;
    }



    @Override
    public int compareTo(Request request) {
        if(this.priority > request.priority)
            return -1;
        else if (this.priority<request.priority)
            return 1;
        else
            return 0;
    }
}

class Requests {

    private ArrayList<Request> requestQueue= new ArrayList<>();

    private ArrayDeque<Request> lastFiveRequest = new ArrayDeque<>();


    public void Requests()
    {

    }

    public void addRequest(String requestText, int priority)
    {

        if(priority>5)
            priority=5;
        else if(priority<0)
            priority=0;

        requestQueue.add(new Request(requestText,priority));
        Collections.sort(requestQueue);

    }

    public void executeRequest()
    {
        Iterator<Request> iterate = requestQueue.iterator();
        if(lastFiveRequest.size()==5)
        {
            lastFiveRequest.removeLast();
        }

        if(iterate.hasNext()) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            lastFiveRequest.addFirst(iterate.next());
            System.out.println(lastFiveRequest.getFirst().getRequest()+" Executed\n");
            requestQueue.remove(0);
        }

        else
        {
            System.out.println("Nothing to execute...");
        }
    }


    public void displayAllRequests()
    {
        Iterator<Request> iterate= requestQueue.iterator();

        System.out.println("Requests\tPriorities\n");
        while(iterate.hasNext())
        {
            Request temp= iterate.next();
            System.out.println(temp.getRequest()+"\t\t\t"+temp.getPriority());

        }
    }

    public void showLastFiveRequests()
    {

        Iterator<Request> iterate= lastFiveRequest.iterator();

        System.out.println("\n\nLast Five Executed Requests\n");
        System.out.println("Requests\tPriorities\n");
        while(iterate.hasNext())
        {
            Request temp= iterate.next();
            System.out.println(temp.getRequest()+"\t\t\t"+temp.getPriority());

        }

    }
}
