package br.sc.senac.tcs.util;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.service.ClienteService;

@Service
public class ImportadorPlanilha {

	@Autowired
	ClienteService clienteService = new ClienteService();

public void importar(InputStream fis) throws CampoInvalidoException, IOException {
    try {
        Workbook workbook = WorkbookFactory.create(fis);
        
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iteradorLinha = sheet.iterator();
        
        iteradorLinha.next(); // Skip header row
        
        while (iteradorLinha.hasNext()) {
            Row linhaAtual = iteradorLinha.next();
            
            Cliente cliente = criarCliente(linhaAtual);
            
            if (cliente != null) {
                clienteService.create(cliente);
            }
        }
        
        workbook.close(); // Close the workbook
    } catch (IOException e) {
        throw new IOException(e.getMessage());
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
			// //TELEFONE
			Cell celulaTelefone = linhaAtual.getCell(4);
			// //CNH
			Cell celulaCnh = linhaAtual.getCell(5);
			// //ESTADO_CIVIL
			Cell celulaEstadoCivil = linhaAtual.getCell(6);
			// //GENERO
			Cell celulaGenero = linhaAtual.getCell(7);
			// //CEP
			Cell celulaCep = linhaAtual.getCell(7);
			// //RUA
			Cell celulaRua = linhaAtual.getCell(8);
			// //BAIRRO
			Cell celulaBairro = linhaAtual.getCell(9);
			// //NUMERO
			Cell celulaNumero = linhaAtual.getCell(10);
			// //COMPLEMENTO
			Cell celulaComplemento = linhaAtual.getCell(11);
			// //CIDADE
			Cell celulaCidade = linhaAtual.getCell(12);
			// //UF
			Cell celulaUf = linhaAtual.getCell(13);

			Date date = celulaDtNascimento.getDateCellValue();
			LocalDate dateString = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			c = new Cliente();
			c.setNome(celulaNome.toString());
			c.setCpf(celulaCpf.toString());
			c.setDtNascimento(dateString);
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