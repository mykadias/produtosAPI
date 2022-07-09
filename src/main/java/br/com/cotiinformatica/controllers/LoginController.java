package br.com.cotiinformatica.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import antlr.Token;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.helpers.MD5Helper;
import br.com.cotiinformatica.repositories.IUsuarioRepository;
import br.com.cotiinformatica.requests.LoginPostRequest;
import br.com.cotiinformatica.security.TokenSecurity;

@Controller
@Transactional
public class LoginController {

	@Autowired
	private IUsuarioRepository usuarioRepository;	
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody LoginPostRequest request) {

		try {

			Usuario usuario = usuarioRepository.findByEmailAndSenha(request.getEmail(),
					MD5Helper.encrypt(request.getSenha()));

			if (usuario == null)
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso negado. Usuário inválido.");

			return ResponseEntity.status(HttpStatus.OK).body(TokenSecurity.generateToken(usuario.getEmail())); 
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

}
