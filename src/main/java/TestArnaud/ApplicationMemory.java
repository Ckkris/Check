package TestArnaud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
/*indique que la classe sert à configurer Spring. Les versions récentes de Spring peuvent en effet être configurées en Java plutôt
        qu'en XML. Les deux méthodes peuvent être utilisées simultanément. Dans le code d'une classe ayant l'annotation
        [Configuration] on trouve normalement des beans Spring, ç-à-d des définitions de classe à instancier.
        Lorsqu'on travaille avec un SGBD, divers beans Spring doivent être définis :
        ◦ un [EntityManagerFactory] qui définit l'implémentation JPA à utiliser ;
        ◦ un [DataSource] qui définit la source de données à utiliser ;
        ◦ un [TransactionManager] qui définit le gestionnaire de transactions à utiliser ;*/

@EnableAutoConfiguration
/*l'annotation [EnableAutoConfiguration] est une annotation provenant du projet [Spring Boot]
        Cette annotation demande à Spring Boot via la classe [SpringApplication]
        de configurer l'application en fonction des bibliothèques trouvées dans son Classpath.
        Parce que les bibliothèques Hibernate sont dans le Classpath, le bean [entityManagerFactory] sera implémenté avec Hibernate.
        Parce que la bibliothèque du SGBD H2 est dans le Classpath, le bean [dataSource] sera implémenté avec H2.
        Dans le bean [dataSource], on doit définir également l'utilisateur et son mot de passe.
        Ici Spring Boot utilisera l'administrateur par défaut de H2, sa sans mot de passe.
        Parce que la bibliothèque [spring-tx] est dans le Classpath, c'est le gestionnaire de transactions de Spring qui sera utilisé.
        Par ailleurs, le dossier dans lequel se trouve la classe [Application] va être scanné à la recherche de beans implicitement
        reconnus par Spring ou définis explicitement par des annotations Spring. Ainsi les classes [Customer] et [CustomerRepository]
        vont-elles être inspectées. Parce que la première a l'annotation [@Entity] elle sera cataloguée comme entité à gérer par
        Hibernate. Parce que la seconde étend l'interface [CrudRepository] elle sera enregistrée comme bean Spring.*/

/*Par ailleurs, le dossier dans lequel se trouve la classe [ApplicationMemory] va être scanné à la recherche de beans implicitement
        reconnus par Spring ou définis explicitement par des annotations Spring. Ainsi les classes [Customer] et [CustomerRepository]
        vont-elles être inspectées. Parce que la première a l'annotation [@Entity] elle sera cataloguée comme entité à gérer par
        Hibernate. Parce que la seconde étend l'interface [CrudRepository] elle sera enregistrée comme bean Spring.*/

public class ApplicationMemory {

/*    @Autowired
    ClientRepository repository;*/

    public static void main(String[] args) {

//A : Sans implements CommandLineRunner
        // A SpringApplication.run(TestArnaudApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(ApplicationMemory.class);
        ClientRepository repository = context.getBean(ClientRepository.class);
    /*}
       /* @Override
        public void run(String... strings) throws Exception {*/
        // save a couple of Clients
        repository.save(new Client("Bauer", "chris"));
        repository.save(new Client("Chloe", "O'Brian"));
        repository.save(new Client("Kim", "Bauer"));
        repository.save(new Client("Bauer", "Palmer"));
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
        System.out.println("Client trouvés avec la méthode findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(Client);
        System.out.println();
        // fetch Clients by last name
        List<Client> bauers = repository.findByNom("Bauer");
        System.out.println("Client trouvés avec la méthode findByNom('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Client bauer : bauers) {
            System.out.println(bauer);}
        context.close();

    }}





