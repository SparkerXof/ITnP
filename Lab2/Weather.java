public class Weather extends Application {
    private String[] weeklyWeather = new String[7];
    private int[] weeklyTemp = new int[7];
    private String[] weekDays = {"Monday", "Tuesday", "Wendsday", "Thursday", "Friday", "Saturday", "Sunday"};

    public Weather() {
        super();
    }

    public Weather(double w, double h, String name) {
        super(w, h, name);
    }

    public Weather(double w, double h, String name, String weatherToday, int temperatureToday) {
        super(w, h, name);
        weeklyWeather[0] = weatherToday;
        weeklyTemp[0] = temperatureToday;
    }

    @Override
    public void runCommand(String command) {
        super.runCommand(command);
    }

    public String[] getWeatherWeek() {
        return weeklyWeather;
    }
    public String getWeather(int index) {
        return weeklyWeather[index];
    }
    public void setWeather(int index, String weather) {
        weeklyWeather[index] = weather;
    }

    public int[] getTemperatureWeek() {
        return weeklyTemp;
    }
    public int getTemperature(int index) {
        return weeklyTemp[index];
    }
    public void setTemperature(int index, int temp) {
        weeklyTemp[index] = temp;
    }

    public void moveWeek(String weather, int temp) {
        String tmpDay = weekDays[0];
        for (int i = 1; i < 7; i++) {
            weeklyWeather[i-1] = weeklyWeather[i];
            weeklyTemp[i-1] = weeklyTemp[i];
            weekDays[i-1] = weekDays[i];
        }
        weeklyWeather[6] = weather;
        weeklyTemp[6] = temp;
        weekDays[6] = tmpDay;
    }
    public String showWeather(int index) {
        return (weekDays[index] + " " + weeklyWeather[index] + " " + weeklyTemp[index]);
    }
}
