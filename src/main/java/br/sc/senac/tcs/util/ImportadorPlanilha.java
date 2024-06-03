package br.sc.senac.tcs.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.service.ClienteService;


@Service
public class ImportadorPlanilha {

	public void importar(InputStream fis) throws CampoInvalidoException {
		try {
			HSSFWorkbook planilha = new HSSFWorkbook(fis);

			HSSFSheet abaPlanilha = planilha.getSheetAt(0);

			Iterator<Row> iteradorLinha = abaPlanilha.iterator();

			iteradorLinha.next();

			while (iteradorLinha.hasNext()) {
				Row linhaAtual = iteradorLinha.next();

				Cliente cliente = criarCliente(linhaAtual);

				if (cliente != null) {

					ClienteService clienteService = new ClienteService();
					clienteService.create(cliente);
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
			Cell celulaNome = linhaAtual.getCell(0);
			Cell celulaCpf = linhaAtual.getCell(1);

			c = new Cliente();
			c.setNome(celulaNome.toString());
			c.setCpf(celulaCpf.toString());
		}

		return c;
	}
}
