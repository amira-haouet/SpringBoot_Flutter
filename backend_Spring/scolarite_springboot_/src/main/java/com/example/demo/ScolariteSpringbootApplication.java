package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.entities.Classe;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Formation;
import com.example.demo.entities.User;
import com.example.demo.repos.ClasseRepository;
import com.example.demo.repos.EtudiantRepository;
import com.example.demo.repos.FormationRepository;
import com.example.demo.repos.UserRepository;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
@SpringBootApplication
public class ScolariteSpringbootApplication {
	@Autowired
	private FormationRepository formationRepository;

	@Autowired
	private ClasseRepository classeRepository;

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ScolariteSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Etudiant et = new Etudiant(null, "Ali", "Ben Ali", new Date());
		// etudiantRepository.save(et);
		// ou
		Formation f1 = formationRepository.save(new Formation(null, "Oracle", 100, null));
		Formation f2 = formationRepository.save(new Formation(null, "J2EE", 10, null));
		Formation f3 = formationRepository.save(new Formation(null, "Angular", 120, null));

		Classe c1 = classeRepository.save(new Classe(null, "DSI23", 27, null));
		Classe c2 = classeRepository.save(new Classe(null, "DSI22", 25, null));
		Classe c3 = classeRepository.save(new Classe(null, "DSI21", 20, null));

		User u1 = userRepository.save(new User(null, "admin@gmail.com", "admin"));

		etudiantRepository.save(new Etudiant(null, "Ali", "Ben Ali", new Date(), f1, c1));
		etudiantRepository.save(new Etudiant(null, "Mohamed", "Ben Mohamed", new Date(), f1, c1));
		etudiantRepository.save(new Etudiant(null, "Amin", "Ben Mahmoud", new Date(), f2, c1));
		etudiantRepository.save(new Etudiant(null, "Samia", "Ben Ahmed", new Date(), f3, c1));
		etudiantRepository.save(new Etudiant(null, "Foulen", "Ben Foulen1", new Date(), f3, c2));
		etudiantRepository.save(new Etudiant(null, "Foulen", "Ben Foulen2", new Date(), f3, c3));
	}
}
