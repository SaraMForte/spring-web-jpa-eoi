package jpaeoi.gardening.infrastructure.controller.model;

import jpaeoi.gardening.application.EmployeeService;
import jpaeoi.gardening.domain.Client;
import jpaeoi.shared.infrastructure.genericcontroller.DtoMapper;
import org.springframework.stereotype.Component;

@Component
public class ClienteDtoMapper implements DtoMapper<Client, ClienteDto> {

    EmployeeService employeeService;

    public Client toDomain(ClienteDto dto) {
        if (dto == null) {
            return emptyDomain();
        }


        Client client = new Client();
        client.setClientCode(dto.getCodigoCliente());
        client.setFirstName(dto.getNombreCliente());
        client.setContactName(dto.getNombreContacto());
        client.setContactLastName(dto.getApellidoContacto());
        client.setContactPhone(dto.getTelefono());
        client.setFax(dto.getFax());
        client.setAddressLine1(dto.getLineaDireccion1());
        client.setAddressLine2(dto.getLineaDireccion2());
        client.setCity(dto.getCiudad());
        client.setRegion(dto.getRegion());
        client.setCountry(dto.getPais());
        client.setPostalCode(dto.getCodigoPostal());
        client.setEmployeeSalesRepresentative(
                employeeService
                        .findById(dto.getCodigoEmpleadoRepVentas())
                        .orElseThrow()
        );
        client.setCreditLimit(dto.getLimiteCredito());
        return client;
    }

    public ClienteDto fromDomain(Client client) {
        if (client == null) {
            return emptyDto();
        }

        return new ClienteDto(
                client.clientCode(),
                client.firstName(),
                client.contactName(),
                client.contactLastName(),
                client.contactPhone(),
                client.fax(),
                client.addressLine1(),
                client.addressLine2(),
                client.city(),
                client.region(),
                client.country(),
                client.postalCode(),
                client.employeeSalesRepresentative().employeeCode(),
                client.creditLimit()
        );
    }

    @Override
    public Client emptyDomain() {
        return new Client();
    }

    @Override
    public ClienteDto emptyDto() {
        return new ClienteDto();
    }

}
