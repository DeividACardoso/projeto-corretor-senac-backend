package br.sc.senac.tcs.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.service.ClienteService;

@Service
public class ImportadorPlanilha {

	@Autowired
	ClienteService clienteService = new ClienteService();

	public void importar(InputStream fis) throws CampoInvalidoException {
		try {
			try (HSSFWorkbook planilha = new HSSFWorkbook(fis)) {
				HSSFSheet abaPlanilha = planilha.getSheetAt(0);

				Iterator<Row> iteradorLinha = abaPlanilha.iterator();

				iteradorLinha.next();

				while (iteradorLinha.hasNext()) {
					Row linhaAtual = iteradorLinha.next();

					Cliente cliente = criarCliente(linhaAtual);

					if (cliente != null) {

						clienteService.create(cliente);
					}
				}
			}
		} catch (FileNotFoundException e) {
			throw new CampoInvalidoException("Arquivo não encontrado ou sem permissão de acesso.");
		} catch (IOException e) {
			throw new CampoInvalidoException("Erro ao fazer upload de arquivo.");
		}

	}

	private Cliente criarCliente(Row linhaAtual) {
		Cliente c = null;
		
		if (linhaAtual.getCell(0) != null && linhaAtual.getCell(1) != null) {
			//NOME
			Cell celulaNome = linhaAtual.getCell(0);
			//CPF
			Cell celulaCpf = linhaAtual.getCell(1);
			//DT_NASCIMENTO
			Cell celulaDtNascimento = linhaAtual.getCell(2);
			//E-MAIL
			Cell celulaEmail = linhaAtual.getCell(3);
			//TELEFONE
			Cell celulaTelefone = linhaAtual.getCell(4);
			//CNH
			Cell celulaCnh = linhaAtual.getCell(5);
			//ESTADO_CIVIL
			Cell celulaEstadoCivil = linhaAtual.getCell(6);
			//GENERO
			Cell celulaGenero = linhaAtual.getCell(7);
			//CEP
			Cell celulaCep = linhaAtual.getCell(7);
			//RUA
			Cell celulaRua = linhaAtual.getCell(8);
			//BAIRRO
			Cell celulaBairro = linhaAtual.getCell(9);
			//NUMERO
			Cell celulaNumero = linhaAtual.getCell(10);
			//COMPLEMENTO
			Cell celulaComplemento = linhaAtual.getCell(11);
			//CIDADE
			Cell celulaCidade = linhaAtual.getCell(12);
			//UF
			Cell celulaUf = linhaAtual.getCell(13);

			System.out.println(celulaDtNascimento);

			// LocalDate dtNascimento = LocalDate.parse(celulaDtNascimento.toString(),
			// DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			c = new Cliente();
			c.setNome(celulaNome.toString());
			c.setCpf(celulaCpf.toString());
			// c.setDtNascimento(celulaDtNascimento);
			c.setEmail(celulaEmail.toString());
			c.setTelefone(celulaTelefone.toString());
			c.setCep(celulaCep.toString());
			c.setRua(celulaRua.toString());
			c.setBairro(celulaBairro.toString());
			c.setNumero(celulaNumero.toString());
			c.setComplemento(celulaComplemento.toString());
			c.setCidade(celulaCidade.toString());
			c.setUf(celulaUf.toString());
			c.setCnh(celulaCnh.toString());
			c.setEstadoCivil(celulaEstadoCivil.toString());
			c.setGenero(celulaGenero.toString());
		}
		return c;
	}

}