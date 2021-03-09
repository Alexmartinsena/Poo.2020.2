import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


class Tweet{
    int id;
    String username;
    String msg;
    TreeSet<String> likes;
    
    public Tweet(int id, String username, String msg){
        this.id = id;
        this.username = username;
        this.msg = msg;
        this.likes = new TreeSet<String>();
    }
    
    public void Givelike(String username){
        for(String user : likes)
            if(user.equals(username))
                return;
        likes.add(username);
    }
    
    public String toString(){
        String saida = "";
        saida += this.id + ":" + this.username + "( " + this.msg + ")";
        if(likes.size() > 0){
            saida += "[ ";
            for(String user : this.likes)
                saida += user + " ";
            saida += "]";
        }
        return saida;
    }
}

class User{
    String username;
    ArrayList<Tweet> timeline; 
    TreeMap<String, User> followers;
    TreeMap<String, User> following;
    int unreadCount;

    public User(String id){
        this.username = id;
        unreadCount = 0;
        timeline  = new ArrayList<Tweet>();
        followers = new TreeMap<String, User>();
        following = new TreeMap<String, User>();
        
    }

    public void follow(User other){
        if(following.containsKey(other.username)){
            return;
        }
        this.following.put(other.username, other);
        other.followers.put(this.username, this);
    }

    public void unfollow(String username){
        if(!following.containsKey(username))
            return;
        User other = following.get(username);
        this.following.remove(username);
        other.followers.remove(this.username);
    }

    public Tweet getTweet(int id){
        for(Tweet twt : timeline){
            if(twt.id == id)
                return twt;
        }
        throw new RuntimeException("fail: Esse tweet nao existe");
    }

    public void sendTweet(Tweet twt){
        this.timeline.add(twt);
        for(User user : followers.values()){
            user.timeline.add(twt);
            user.unreadCount += 1;
        }
    }

    public String getTimeline(){
        String saida = "";
        for(Tweet twt : this.timeline)
            saida += twt;
        return saida;
    }

    public String getUnread(){
        String saida = "";
        for(int i = timeline.size() - unreadCount; i < timeline.size(); i++)
            saida += timeline.get(i);
        unreadCount = 0;
        return saida;
    }

    public String toString(){
        return this.username;
    }
}

class Controller{
    TreeMap<String, User> users;
    TreeMap<Integer, Tweet> tweets;
    int nextTwTId = 0;

    public Controller(){
        users = new TreeMap<String, User>();
    }

    public void sendTweet(String username, String msg){
        User user = this.getUser(username);
        Tweet twt = new Tweet(nextTwTId++, username, msg);
        user.sendTweet(twt);
    }

    public void addUser(String username){
        User user = users.get(username);
        if(user == null){
            users.put(username, new User(username));
        }
    }

    public User getUser(String username){
        User user = users.get(username);
        if(user == null)
            throw new RuntimeException("fail: O usuario nao foi encontrado");
        return user;
    }

    public String toString(){
        String saida = "";
        for(User user : users.values())
            saida += user;
        return saida;
    }
}

public class Twitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller sistem = new Controller();
        
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            try {
                if (ui[0].equals("end"))
                    break;
                else if (ui[0].equals("addUser")) {
                    sistem.addUser(ui[1]);
                }
                else if (ui[0].equals("show")) {
                    System.out.print(sistem);
                } 
                else if (ui[0].equals("follow")) {
                    User x = sistem.getUser(ui[1]);
                    User y = sistem.getUser(ui[2]);
                    x.follow(y);
                }
                else if (ui[0].equals("twittar")) {
                    String username = ui[1];
                    String msg = "";
                    for(int i = 2; i < ui.length; i++)
                        msg += ui[i] + " ";
                    sistem.sendTweet(username, msg);
                }
                else if (ui[0].equals("timeline")) {
                    User user = sistem.getUser(ui[1]);
                    System.out.print(user.getTimeline());
                }
                else if (ui[0].equals("like")) {
                    User user = sistem.getUser(ui[1]);
                    Tweet twt = user.getTweet(Integer.parseInt(ui[2]));
                    twt.Givelike(ui[1]);
                }
                else if (ui[0].equals("unfollow")) {
                    User user = sistem.getUser(ui[1]);
                    user.unfollow(ui[2]);
                }
                else{
                    System.out.println("fail: comando invalido");
                }
            }
            catch(RuntimeException rt){
                System.out.println(rt.getMessage());
            }
        }
        scanner.close();
    }

}
