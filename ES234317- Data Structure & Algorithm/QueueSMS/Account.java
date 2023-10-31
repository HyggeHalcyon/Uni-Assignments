import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Account {
    private String name, phoneNumber;
    private Queue<Message> messages = new LinkedList<>();

    Account(String n, String pN){
        this.name = n;
        this.phoneNumber = pN;
    }

    public void sendMessage(Account dest, String msg){
        if(msg.equals("")){
            System.out.printf("%s", "Message can't be empty");
            return;
        }

        dest.receiveMessage(this, msg);
    }

    public void receiveMessage(Account src, String msg){
        if(msg.equals("")){
            System.out.printf("%s", "Message can't be empty");
            return;
        }

        messages.add(new Message(src.getName(), msg));
    }

    public String viewNotification(){
        try{
            Message msg = messages.peek();
            return msg.toString();
        } catch (NullPointerException e){
            return "No Incoming Message";
        }
    }

    public String accountInformation(){
        return "Name: " + this.name
                + "\nPhone Number: " + this.phoneNumber
                + "\nUnread Messages: " + this.messages.size();
    }

    public Message readMessage(){
        try{
            return messages.poll();
        } catch (NullPointerException e){
            System.out.printf("%s", "No New Messages");
            return null;
        }
    }

    public Message[] readAllMessages(){
        Message msg[] = new Message[messages.size()];
        try{
            for(int i = 0; i < messages.size(); i++){
                msg[i] = messages.poll();
            }
            return msg;
        } catch (NullPointerException e){
            System.out.printf("%s", "Your Messages is empty");
            return null;
        }
    }

    public String getName(){
        return this.name;
    }
}
