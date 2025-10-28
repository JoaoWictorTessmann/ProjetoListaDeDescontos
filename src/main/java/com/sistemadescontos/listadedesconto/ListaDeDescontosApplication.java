package com.sistemadescontos.listadedesconto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListaDeDescontosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaDeDescontosApplication.class, args);
		System.out.println("Aplicação de Lista de Descontos iniciada com sucesso!");
		System.out.println("Visite http://localhost:8080 para acessar a aplicação.");
	}

}
