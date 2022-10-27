package br.com.alura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {

//    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

//    List<Funcionario> findByNomeLike(String nome);
                          //String nome = "%maria%";

//    List<Funcionario> findByNomeEndingWith(String nome)
//    List<Funcionario> findByNomeStartingWith(String nome)

//    List<Funcionario> findByNomeIsNull()
//    List<Funcionario> findByNomeIsNotNull()

//    List<Funcionario> findByNomeOrderByNomeAsc(String nome);

}
