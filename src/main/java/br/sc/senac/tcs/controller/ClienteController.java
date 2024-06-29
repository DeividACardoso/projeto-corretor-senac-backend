package br.sc.senac.tcs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Cliente;
import br.sc.senac.tcs.service.ClienteService;
import br.sc.senac.tcs.util.ImportadorPlanilha;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ImportadorPlanilha importadorPlanilha;

    @GetMapping(path = "/todos")
    public Iterable<Cliente> list() {
        return clienteService.findAll();
    }

    @GetMapping("{id}")
    public Cliente listarPorId(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    @PostMapping("/novo")
    public Cliente create(@RequestBody Cliente cliente) throws CampoInvalidoException {
        return clienteService.create(cliente);
    }

    @PutMapping
    public Cliente update(@RequestBody Cliente cliente) {
        return clienteService.update(cliente);
    }

    @DeleteMapping("/delete-id/{id}")
    public boolean delete(@PathVariable Integer id) throws CampoInvalidoException {
        clienteService.delete(id);
        return true;
    }

    @GetMapping("/verificar-seg/{idCliente}")
    public boolean verificarSeguros(@PathVariable Integer idCliente) {
        return clienteService.verificarSeguros(idCliente);
    }

    @PostMapping("/importar")
    public void importarPlanilha(@RequestParam("file") MultipartFile planilha) throws CampoInvalidoException {
        System.out.println(planilha);
        try {
            importadorPlanilha.importar(planilha.getInputStream());
        } catch (CampoInvalidoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
