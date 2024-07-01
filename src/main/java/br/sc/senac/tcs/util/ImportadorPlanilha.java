package br.sc.senac.tcs.util;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
	ClienteService clienteService;

public void importar(InputStream fis) throws CampoInvalidoException, IOException {
    try {
        Workbook workbook = WorkbookFactory.create(fis);
        
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iteradorLinha = sheet.iterator();
        
        iteradorLinha.next();
        
        while (iteradorLinha.hasNext()) {
            Row linhaAtual = iteradorLinha.next();
            
            Cliente cliente = criarCliente(linhaAtual);
            
            if (cliente != null) {
                clienteService.create(cliente);
            }
        }
        
        workbook.close();
    } catch (IOException e) {
        throw new IOException(e.getMessage());
    }
}

	private Cliente criarCliente(Row linhaAtual) throws CampoInvalidoException {
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
			Cell celulaCep = linhaAtual.getCell(8);
			// //RUA
			Cell celulaRua = linhaAtual.getCell(9);
			// //BAIRRO
			Cell celulaBairro = linhaAtual.getCell(10);
			// //NUMERO
			Cell celulaNumero = linhaAtual.getCell(11);
			// //COMPLEMENTO
			Cell celulaComplemento = linhaAtual.getCell(12);
			// //CIDADE
			Cell celulaCidade = linhaAtual.getCell(13);
			// //UF
			Cell celulaUf = linhaAtual.getCell(14);

			Date date;
			if (celulaDtNascimento.getCellType() == CellType.NUMERIC) {
				date = celulaDtNascimento.getDateCellValue();
			} else {
				String dateString = celulaDtNascimento.getStringCellValue();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate localDate = LocalDate.parse(dateString, formatter);
				date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			}
			LocalDate dateString = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			String telefoneSemMascara = celulaTelefone.toString().replaceAll("[^0-9]", "");
			String cepSemMascara = celulaCep.toString().replaceAll("[^0-9]", "");
			
			
			c = new Cliente();
			try{
				c.setNome(celulaNome.getStringCellValue());
				c.setCpf(celulaCpf.getStringCellValue());
				c.setDtNascimento(dateString);
				c.setEmail(celulaEmail.getStringCellValue());
				c.setTelefone(telefoneSemMascara);
				c.setCep(cepSemMascara);
				c.setRua(celulaRua.getStringCellValue());
				c.setBairro(celulaBairro.getStringCellValue());
				c.setNumero(celulaNumero.getStringCellValue());
				if(celulaComplemento != null){
					c.setComplemento(celulaComplemento.getStringCellValue());
				} else {
					c.setComplemento("");
				}
				c.setCidade(celulaCidade.getStringCellValue());
				c.setUf(celulaUf.getStringCellValue());
				c.setCnh(celulaCnh.getStringCellValue());
				c.setEstadoCivil(celulaEstadoCivil.getStringCellValue());
				c.setGenero(celulaGenero.getStringCellValue());
			} catch (Exception e) {
				throw new CampoInvalidoException("Campo inválido");
			}
		}
		return c;
	}

}