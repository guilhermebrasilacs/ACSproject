package com.ACS.ACSproject.controller;

import com.ACS.ACSproject.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList(){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Eduardo");
        userDTO.setCpf("123");
        userDTO.setEndereco("Rua A");
        userDTO.setEmail("eduardo@gmail.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(LocalDateTime.now());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setEndereco("Rua B");
        userDTO2.setEmail("luiz@gmail.com");
        userDTO2.setTelefone("3234-6878");
        userDTO2.setDataCadastro(LocalDateTime.now());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Bruna");
        userDTO3.setCpf("789");
        userDTO3.setEndereco("Rua C");
        userDTO3.setEmail("bruna@gmail.com");
        userDTO3.setTelefone("2987-9076");
        userDTO3.setDataCadastro(LocalDateTime.now());

        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }

    @GetMapping
    public List<UserDTO> getUsers(){
        return usuarios;
    }

    @GetMapping("/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf){
        return usuarios
                .stream()
                .filter(userDTO -> userDTO.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO inserir(@RequestBody @Valid UserDTO userDTO){
        userDTO.setDataCadastro(LocalDateTime.now());
        usuarios.add(userDTO);
        return userDTO;
    }
}
