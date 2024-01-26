package ObserverPattern;
// Purpose: Demonstrate the Observer Pattern

import java.util.ArrayList;
import java.util.List;

interface MessagePublisher{
    void addObserver(MessageSubscriber subscriber);
    void removeObserver(MessageSubscriber subscriber);
    void notifyObservers(String message);
}

interface MessageSubscriber{
    void update(String message);
}

class ChatRoom implements MessagePublisher{
    private List<MessageSubscriber> subscribers = new ArrayList<>();
    @Override
    public void addObserver(MessageSubscriber subscriber){
        subscribers.add(subscriber);
    }
    @Override
    public void removeObserver(MessageSubscriber subscriber){
        subscribers.remove(subscriber);
    }
    @Override
    public void notifyObservers(String message){
        for(MessageSubscriber subscriber : subscribers){
            subscriber.update(message);
        }
    }
}

class User implements MessageSubscriber{
    private String name;
    public User(String name){
        this.name = name;
    }
    @Override
    public void update(String message){
        System.out.println(name + " received message: " + message);
    }
}




public class ObserverPattern {
    public static void main(String[] args){
        ChatRoom chatRoom = new ChatRoom();
        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");
        chatRoom.addObserver(user1);
        chatRoom.addObserver(user2);
        chatRoom.addObserver(user3);
        chatRoom.notifyObservers("Hello World!");
        chatRoom.removeObserver(user2);
        chatRoom.notifyObservers("Hello World!");
        
    }
}
