package br.com.itau.integrador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "dados")
@Data
public class Dados {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "tipo_documento")
	private String tipoDocumento;

}
