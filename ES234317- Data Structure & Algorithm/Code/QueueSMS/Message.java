public class Message {
    public String message;
    public String sender;

    Message(String s, String m){
        this.message = m;
        this.sender = s;
    }

    public String toString(){
        return "Incoming Message: " + this.message
                + "\nFrom: " + this.sender;
    }
}
