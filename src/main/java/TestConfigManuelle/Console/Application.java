package TestConfigManuelle.Console;

import TestConfigManuelle.Config.Config;
import TestConfigManuelle.Entities.Client;
import TestConfigManuelle.Repository.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Config.class); //Config !!
        ClientRepository repository = context.getBean(ClientRepository.class);

        // save a couple of Clients
        repository.save(new Client("bauer", "chris"));
        repository.save(new Client("Chloe", "O'Brian"));
        repository.save(new Client("Kim", "mm"));
        repository.save(new Client("bauer", "Palmer"));
        repository.save(new Client("Michelle", "Dessler"));
        //fetch all Clients
        Iterable<Client> Clients = repository.findAll();
        System.out.println("Clients trouvés avec la méthode findAll():");
        System.out.println("-------------------------------");
        for (Client Client : Clients) {
            System.out.println(Client);
        }
        System.out.println();
        // fetch an individual Client by ID
        Client Client = repository.findOne(1L);
        System.out.println("Client trouvés avc la méthode findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(Client);
        System.out.println();
        // fetch Clients by last name
        List<Client> bauers = repository.findByNom("bauer");
        System.out.println("Client trouvés avec la méthode findByNom('bauer'):");
        System.out.println("--------------------------------------------");
        for (Client bauer : bauers) {
            System.out.println(bauer);}
        context.close();

    }}





