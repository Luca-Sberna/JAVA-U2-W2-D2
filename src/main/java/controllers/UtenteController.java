package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import entities.Utente;
import services.UtenteService;

@RestController
@RequestMapping("/users")
public class UtenteController {
	@Autowired
	UtenteService usersService;

	// 1. - GET http://localhost:3001/users (+opzionalmente query params) <-- READ
	@GetMapping("")
	public List<Utente> getUsers() {
		return usersService.getUsers();
	}

	// 2. - POST http://localhost:3001/users (+ req.body) <-- CREATE
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // <-- 201 CREATED
	public Utente saveUser(@RequestBody Utente body) {
		Utente createdUser = usersService.saveNewUser(body);
		return createdUser;
	}

	// 3. - GET http://localhost:3001/users/:userId <-- READ
	@GetMapping("/{userId}")
	public Utente findById(@PathVariable int userId) throws Exception {
		return usersService.findUserById(userId).orElseThrow(() -> new Exception("Utente non trovato"));
	}

	// 4. - PUT http://localhost:3001/users/:userId (+ req.body) <-- UPDATE
	@PutMapping("/{userId}")
	public Utente findByIdAndUpdate(@PathVariable int userId, @RequestBody Utente body) throws Exception {
		return usersService.findUserByIdAndUpdate(userId, body).orElseThrow(() -> new Exception("Utente non trovato"));
	}

	// 5. - DELETE http://localhost:3001/users/:userId <-- DELETE
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
	public void findByIdAndDelete(@PathVariable int userId) throws Exception {
		usersService.findUserByIdAndDelete(userId).orElseThrow(() -> new Exception("Utente non trovato"));
	}

}
