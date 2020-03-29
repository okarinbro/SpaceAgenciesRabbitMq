import com.google.common.collect.ImmutableList;
import model.Shipper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeoutException;

public class ShipperRunner {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("type: ct, pt or st");
            System.out.print(">");
            String firstService = br.readLine();
            System.out.print(">");
            String secondService = br.readLine();
            if (firstService.equals(secondService)) {
                throw new IllegalArgumentException("Types of service have to be different");
            }
            Shipper shipper = new Shipper(ImmutableList.of(firstService, secondService), "exchange1", "adminExchange");
            shipper.init();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
