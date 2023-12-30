import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Application> apps = new ArrayList<Application>();
    public static int focus = -1;
    public static void main(String[] args) {
        String command;
        Scanner type = new Scanner(System.in);
        do {
            command = type.nextLine();
            String[] fullCommand = command.split(" ");
            if (fullCommand[0].equals("createApp")) {
                createApp(fullCommand);
            } 
            else if (fullCommand[0].equals("removeApp")) {
                try {
                    removeApp(Integer.parseInt(fullCommand[1]));
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong index for app");
                } catch (IndexOutOfBoundsException ioobe) {
                    System.out.println("Not enough parameters for app");
                }
            } else if (fullCommand[0].equals("focusApp")) {
                try {
                    if (Integer.parseInt(fullCommand[1]) < apps.size()) {
                        focus = Integer.parseInt(fullCommand[1]);
                    }
                    else {
                        System.out.println("Index is out of bounds");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong index for app");
                } catch (IndexOutOfBoundsException ioobe) {
                    System.out.println("Not enough parameters for app");
                }
            } else if (fullCommand[0].equals("countApps")) {
                int[] classCount = {0, 0, 0, 0};
                for (Application app : apps) {
                    switch (app.getClass().toString()) {
                        case "class SocialNetwork" -> classCount[0]++;
                        case "class Weather" -> classCount[1]++;
                        case "class Game" -> classCount[2]++;
                        case "class RolePlayingGame" -> classCount[3]++;
                    }
                }
                System.out.println("SocialNetwork - " + classCount[0]);
                System.out.println("Weather - " + classCount[1]);
                System.out.println("Game - " + classCount[2]);
                System.out.println("RolePlayingGame - " + classCount[3]);
            }
        } while (!command.equals("exit"));
    }

    public static void createApp(String[] appData) {
        switch (appData[1]) {
            case "SocialNetwork" -> {
                try {
                    apps.add(new SocialNetwork(Double.parseDouble(appData[2]), Double.parseDouble(appData[3]), appData[4], appData[5]));
                    focus = apps.size()-1;
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong numbers for app size");
                } catch (IndexOutOfBoundsException ioobe) {
                    System.out.println("Not enough parameters for app");
                }
            }
            case "Weather" -> {
                try {
                    apps.add(new Weather(Double.parseDouble(appData[2]), Double.parseDouble(appData[3]), appData[4], appData[5], Integer.parseInt(appData[6])));
                    focus = apps.size()-1;
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong numbers for app size or temperature");
                } catch (IndexOutOfBoundsException ioobe) {
                    try {
                        apps.add(new Weather(Double.parseDouble(appData[2]), Double.parseDouble(appData[3]), appData[4]));
                        focus = apps.size()-1;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Wrong numbers for app size");
                    } catch (IndexOutOfBoundsException ioobe1) {
                        System.out.println("Not enough parameters for app");
                    }
                }
            }
            case "Game" -> {
                try {
                    apps.add(new Game(Double.parseDouble(appData[2]), Double.parseDouble(appData[3]), appData[4], Integer.parseInt(appData[5]), Integer.parseInt(appData[6]), Integer.parseInt(appData[7])));
                    focus = apps.size()-1;
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong numbers for app size or temperature");
                } catch (IndexOutOfBoundsException ioobe) {
                    try {
                        apps.add(new Game(Double.parseDouble(appData[2]), Double.parseDouble(appData[3]), appData[4], Integer.parseInt(appData[5])));
                        focus = apps.size()-1;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Wrong numbers for app size");
                    } catch (IndexOutOfBoundsException ioobe1) {
                        System.out.println("Not enough parameters for app");
                    }
                }
            }
            case "RPG" -> {
                try {
                    apps.add(new RolePlayingGame(Double.parseDouble(appData[2]), Double.parseDouble(appData[3]), appData[4], Integer.parseInt(appData[5]), 
                        Integer.parseInt(appData[6]), Integer.parseInt(appData[7]), Integer.parseInt(appData[8])));
                    focus = apps.size()-1;
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong numbers for app size or temperature");
                } catch (IndexOutOfBoundsException ioobe) {
                    try {
                        apps.add(new RolePlayingGame(Double.parseDouble(appData[2]), Double.parseDouble(appData[3]), appData[4], Integer.parseInt(appData[5]), 
                        Integer.parseInt(appData[6])));
                        focus = apps.size()-1;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Wrong numbers for app size");
                    } catch (IndexOutOfBoundsException ioobe1) {
                        System.out.println("Not enough parameters for app");
                    }
                }
            }
            default -> System.out.println("No app");
        }
        System.out.println(apps.get(apps.size()-1).getClass().toString());
    }

    public static void removeApp(int index) {
        apps.remove(index);
    }
}
