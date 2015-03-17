package TestArnaud;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableAutoConfiguration
public class TestArnaudApplication {

    public static void main(String[] args) {
        //SpringApplication.run(TestArnaudApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        ClientRepository repository = context.getBean(ClientRepository.class);
        // save a couple of Clients
        repository.save(new Client("Jack", "Bauer"));
        repository.save(new Client("Chloe", "O'Brian"));
        repository.save(new Client("Kim", "Bauer"));
        repository.save(new Client("David", "Palmer"));
        repository.save(new Client("Michelle", "Dessler"));
        //fetch all Clients
        Iterable<Client> Clients = repository.findAll();
        System.out.println("Clients found with findAll():");
        System.out.println("-------------------------------");
        for (Client Client : Clients) {
            System.out.println(Client);
        }
        System.out.println();
        // fetch an individual Client by ID
        Client Client = repository.findOne(1L);
        System.out.println("Client found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(Client);
        System.out.println();
        // fetch Clients by last name
        List<Client> bauers = repository.findByNom("Bauer");
        System.out.println("Client found with findByNom('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Client bauer : bauers) {
            System.out.println(bauer);}
        context.close();
    }


    }

