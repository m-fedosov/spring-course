public class Supplier {
    public static void main(String[] args) {
        String sensorName = "testSensor";
        String url = "http://localhost:8080";

        registerSensor(sensorName);
    }

    private static void registerSensor(String sensorName, String url) {
        String endpoint = url + "/sensors/register";

    }
}
