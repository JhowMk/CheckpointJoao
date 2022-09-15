package br.com.fiap.epictaskapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.TaskRepository;
import br.com.fiap.epictaskapi.repository.UserRepository;

@Configuration
@Profile("dev")
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        userRepository.saveAll(List.of(
            new User("Chris", "chrissytirocerto@gmail.com", passwordEncoder.encode("uvaprasempre15")),
            new User("Julius", "juliusrock@gmail.com", passwordEncoder.encode("estasenhacustou9centavos")),
            new User("Greg", "chrisegreg@gmail.com", passwordEncoder.encode("sucodefruta10")),
            new User("Isabela", "isabela@fiap.com.br", passwordEncoder.encode("123")),
            new User("lit", "lit@gmail.com", passwordEncoder.encode("litdeeio"))
        ));

        taskRepository.saveAll(List.of(
            new Task("Modelar BD", "modelar tabelas do banco", 150),
            new Task("Prototipo", "prototipar as telas", 20),
            new Task("Login", "prototipar as telas", 10),
            new Task("Deploy", "prototipar as telas", 50),
            new Task("Cadastro de usuário", "prototipar as telas", 30),
            new Task("Testes", "prototipar as telas", 25),
            new Task("Logout", "prototipar as telas", 12),
            new Task("Internacionalização", "prototipar as telas", 70),
            new Task("Bug", "corrigir erro da API", 50)
        ));
    }
    
}
