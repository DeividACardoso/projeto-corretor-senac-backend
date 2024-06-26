package br.sc.senac.tcs.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SeguroDTO {
    private Integer id;
    private String nomeCliente;
}
