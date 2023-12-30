public abstract class Application {
    protected double baseWidth;
    protected double width;
    protected double baseHeight;
    protected double height;
    protected String appName;
    protected boolean hidden;
    protected boolean fullscreen;
    
    public Application() {
        baseWidth = 800;
        width = 800;
        baseHeight = 600;
        height = 600;
        appName = "NewApp";
    }

    public Application(double w, double h, String name) {
        baseWidth = w;
        width = w;
        baseHeight = h;
        height = h;
        appName = name;
    }

    public void runCommand(String command) {
        String[] fullCommand = command.split(" ");
        switch (fullCommand[0]) {
            case "hide" -> hideApp();
            case "resize" -> {
                try {
                    resize(Double.parseDouble(fullCommand[1]), Double.parseDouble(fullCommand[2]));
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong numbers to " + fullCommand[0]);
                } catch (IndexOutOfBoundsException ioobe) {
                    System.out.println("Not enough parameters to " + fullCommand[0]);
                }
            }
            case "setWidth" -> {
                try {
                    setWidth(Double.parseDouble(fullCommand[1]));
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong numbers to " + fullCommand[0]);
                } catch (IndexOutOfBoundsException ioobe) {
                    System.out.println("Not enough parameters to " + fullCommand[0]);
                }
            }
            case "getWidth" -> System.out.println(getWidth());
            case "setHeight" -> {
                try {
                    setHeight(Double.parseDouble(fullCommand[1]));
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong numbers to " + fullCommand[0]);
                } catch (IndexOutOfBoundsException ioobe) {
                    System.out.println("Not enough parameters to " + fullCommand[0]);
                }
            }
            case "getHeight" -> System.out.println(getHeight());
            case "setName" -> {
                try {
                    setName(fullCommand[1]);
                } catch (IndexOutOfBoundsException ioobe) {
                    System.out.println("Not enough parameters to " + fullCommand[0]);
                }
            }
            case "getName" -> System.out.println(getName());
        }
    }

    protected void hideApp() {
        hidden = !hidden;
    }

    protected void resize(double screenW, double screenH) {
        if (fullscreen) {
            width = baseWidth;
            height = baseHeight;
        } 
        else {
            width = screenW;
            height = screenH;
        }
        fullscreen = !fullscreen;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double w) {
        baseWidth = w;
        if (!fullscreen) {
            width = w;
        }
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double h) {
        baseHeight = h;
        if (!fullscreen) {
            height = h;
        }
    }

    public String getName() {
        return appName;
    }
    public void setName(String name) {
        appName = name;
    }
}
