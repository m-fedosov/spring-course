import models.MeasurementDTO;
import models.SensorDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class Supplier {
    private static final RestClient restClient = RestClient.create();
    private static final String URI_BASE = "http://localhost:8080";

    public static void main(String[] args) {
        String sensorName = "Sensor name 2";
        try {
            registerSensor(sensorName);
            addMeasurement(sensorName);
            measurements();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registerSensor(String sensorName) {
        SensorDTO sensorDTO = new SensorDTO(sensorName);
        String request = restClient.post()
                .uri(URI_BASE + "/sensors/registration")
                .contentType(APPLICATION_JSON)
                .body(sensorDTO)
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        (req, response) -> {
                            throw new RuntimeException("register sensor error: " + response.getStatusText());
                        })
                .body(String.class);
        System.out.println("Successfully register sensor: " + request);
    }

    private static void addMeasurement(String sensorName) {
        SensorDTO sensorDTO = new SensorDTO(sensorName);
        Random random = new Random();
        double value;
        boolean raining;
        for (int i = 0; i < 1000; i++) {
            value = random.nextDouble() * 200 - 100;
            raining = random.nextBoolean();
            MeasurementDTO measurementDTO = new MeasurementDTO(value, raining, sensorDTO);
            restClient.post()
                    .uri(URI_BASE + "/measurements/add")
                    .contentType(APPLICATION_JSON)
                    .body(measurementDTO)
                    .retrieve()
                    .onStatus(
                            HttpStatusCode::isError,
                            (request, response) -> {
                                throw new RuntimeException("measurements add error: " + response.getStatusText());
                            })
                    .body(String.class);
        }
        System.out.println("Successfully add measurements");
    }

    private static void measurements() {
        List<MeasurementDTO> measurements = restClient.get()
                .uri(URI_BASE + "/measurements")
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        (request, response) -> {
                            throw new RuntimeException("measurements error: " + response.getStatusText());
                        })
                .body(new ParameterizedTypeReference<List<MeasurementDTO>>() {});

        System.out.println("Available measurements:");
        for (MeasurementDTO measurementDTO : measurements) {
            System.out.printf("%s: temperature=%f, raining=%b\n", measurementDTO.getSensor().getName(), measurementDTO.getValue(), measurementDTO.getRaining());
        }
    }

}
