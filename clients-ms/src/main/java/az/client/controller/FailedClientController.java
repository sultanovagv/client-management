package az.client.controller;

import az.client.model.FailedClientDto;
import az.client.service.FailedClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/failed-clients")
@RequiredArgsConstructor
public class FailedClientController {

    private final FailedClientService service;

    @GetMapping
    public List<FailedClientDto> getFailedClients() {
        return service.getFailedClients();
    }


    @PostMapping
    public void removeFailedClients(@RequestBody List<FailedClientDto> dtos) {
        service.removeFailedClients(dtos);
    }
}
