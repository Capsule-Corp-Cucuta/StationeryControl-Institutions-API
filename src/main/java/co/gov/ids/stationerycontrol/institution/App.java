package co.gov.ids.stationerycontrol.institution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Spring-Boot Application for manage Institutions and Townships of stationery control of live births and deaths.
 *
 * @author Sergio Rodriguez
 * @version 0.0.1
 * @since 2020
 */
@EnableDiscoveryClient
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}