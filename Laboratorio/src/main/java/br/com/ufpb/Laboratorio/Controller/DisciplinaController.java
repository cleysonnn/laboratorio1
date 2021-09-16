package br.com.ufpb.Laboratorio.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufpb.Laboratorio.Entity.Disciplinas;
import br.com.ufpb.Laboratorio.Service.DiciplinasService;

@RestController
@RequestMapping("/v1/api")
public class DisciplinaController {

	@Autowired
	public DiciplinasService service;

	@PostMapping("/disciplinas")
	public ResponseEntity<Disciplinas> adionarDisciplina(@RequestBody Disciplinas disciplina) {
		return new ResponseEntity<Disciplinas>(service.addDisciplinas(disciplina), HttpStatus.CREATED);

	}

	@GetMapping("/disciplinas")
	public ResponseEntity<List<Disciplinas>> getAll() {
		return ResponseEntity.ok().body(service.getListaDasDisciplinas());

	}

	@GetMapping("/disciplinas/{id}")
	public ResponseEntity<Disciplinas> getAll(@PathVariable int id) {
		try {
			return ResponseEntity.ok().body(service.getByid(id));
		} catch (Exception e) {

			return new ResponseEntity<Disciplinas>(new Disciplinas(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/disciplinas/{id}/nome")
	public ResponseEntity<Disciplinas> atualizarnome(@PathVariable int id, @RequestBody Disciplinas disciplina) {
		try {
		return ResponseEntity.ok().body(service.setNome(id, disciplina));
		} catch (Exception e) {

			return new ResponseEntity<Disciplinas>(new Disciplinas(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/disciplinas/{id}/nota")
	public ResponseEntity<Disciplinas> atualizanota(@PathVariable int id, @RequestBody Disciplinas disciplina) {
		try {
		return ResponseEntity.ok().body(service.setNota(id, disciplina));
		} catch (Exception e) {

			return new ResponseEntity<Disciplinas>(new Disciplinas(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/disciplinas/{id}")
	public ResponseEntity<Disciplinas> deleteDisciplina(@PathVariable int id) {
		try {
			return ResponseEntity.ok().body(service.deleteDisciplinas(id));
		} catch (Exception e) {

			return new ResponseEntity<Disciplinas>(new Disciplinas(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/disciplinas/ranking")
	public ResponseEntity<List<Disciplinas>> getDisciplinasordanadasByLikes() {
		return ResponseEntity.ok().body(service.getListaDasDisciplinasOrdenadas());
	}

	@GetMapping("/oi")
	public void oi() {
		System.out.println("oi");
	}

}
