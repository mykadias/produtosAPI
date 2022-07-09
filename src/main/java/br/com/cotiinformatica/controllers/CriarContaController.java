package br.com.cotiinformatica.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.helpers.MD5Helper;
import br.com.cotiinformatica.repositories.IUsuarioRepository;
import br.com.cotiinformatica.requests.CriarContaPostRequest;

@Controller
@Transactional
public class CriarContaController {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@RequestMapping(value = "/api/criar-conta", method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody CriarContaPostRequest request) {

		try {

			if (usuarioRepository.findByEmail(request.getEmail()) != null) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email informado ja esta sendo utilizado.");
			}

			Usuario usuario = new Usuario();

			usuario.setNome(request.getNome());
			usuario.setEmail(request.getEmail());
			usuario.setSenha(MD5Helper.encrypt(request.getSenha()));

			usuarioRepository.save(usuario);

			return ResponseEntity.status(HttpStatus.CREATED).body("Usuario foi cadastrado!");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

}
