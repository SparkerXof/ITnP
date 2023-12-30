import java.util.ArrayList;

public class SocialNetwork extends Application {
    private String username;
    private ArrayList<String> friendsList = new ArrayList<String>();
    private ArrayList<Message> messages = new ArrayList<Message>();

    public SocialNetwork() {
        super();
        username = "JohnDoe";
    }

    public SocialNetwork(double w, double h, String name, String user, String[] friends) {
        super(w, h, name);
        username = user;
        friendsList = new ArrayList<String>();
        for (String friend : friends) {
            friendsList.add(friend);
        }
    }

    public SocialNetwork(double w, double h, String name, String user) {
        super(w, h, name);
        username = user;
    }

    @Override
    public void runCommand(String command) {
        super.runCommand(command);
        String[] fullCommand = command.split(" ");
        switch (fullCommand[0]) {
            case "newMessage" -> {
                if (fullCommand.length >= 3) {
                    String msg = "";
                    for (int i = 2; i < fullCommand.length; i++) {
                        msg = fullCommand[i] + (i == fullCommand.length-1 ? "" : " ");
                    }
                    newMessage(new Message(fullCommand[1], msg));
                } else {
                    System.out.println("Not enough parameters to " + fullCommand[0]);
                }
            }
            case "getMessages" -> {
                try {
                    ArrayList<String> userMessages = getMessagesByUser(fullCommand[1]);
                    for (String message : userMessages) {
                        System.out.println(message);
                    }
                } catch (IndexOutOfBoundsException ioobe) {
                    System.out.println("No user printed");
                }
            }
            case "setUsername" -> {
                try {
                    setUsername(fullCommand[1]);
                } catch (IndexOutOfBoundsException ioobe) {
                    System.out.println("Not enough parameters to " + fullCommand[0]);
                }
            }
            case "getUsername" -> System.out.println(getUsername());
            case "addFriend" -> {
                try {
                    addFriend(fullCommand[1]);
                } catch (IndexOutOfBoundsException ioobe) {
                    System.out.println("Not enough parameters to " + fullCommand[0]);
                }
            }
            case "removeFriend" -> {
                try {
                    removeFriend(Integer.parseInt(fullCommand[1]));
                } catch (IndexOutOfBoundsException ioobe) {
                    System.out.println("Not enough parameters to " + fullCommand[0]);
                } catch (NumberFormatException nfe) {
                    removeFriend(fullCommand[1]);
                }
            }
        }
    }

    public void setUsername(String name) {
        username = name;
    }

    public String getUsername() {
        return username;
    }

    public void addFriend(String friend) {
        friendsList.add(friend);
    }

    public void removeFriend(String friend) {
        friendsList.remove(friend);
    }

    public void removeFriend(int index) {
        friendsList.remove(index);
    }

    public void newMessage(Message msg) {
        messages.add(msg);
    }

    public ArrayList<String> getMessagesByUser(String user) {
        ArrayList<String> userMessages = new ArrayList<String>();
        for (Message msg : messages) {
            if (msg.user.equals(user)) {
                userMessages.add(msg.message);
            }
        }
        return userMessages;
    }
}
