package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Classe;
import com.example.demo.entities.Etudiant;

/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/

@RepositoryRestResource
public interface ClasseRepository extends JpaRepository<Classe, Long> {
	@Query("select p from Etudiant e where e.nom like :x")
	public List<Etudiant> Chercher(@Param("x")String nom);
	//ou d'ecrire 
}