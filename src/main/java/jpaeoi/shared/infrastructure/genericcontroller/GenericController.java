package jpaeoi.gandening.infrastructure.controller;

import jakarta.servlet.http.HttpServletRequest;
import jpaeoi.gandening.application.exception.DataDeleteException;
import jpaeoi.gandening.infrastructure.config.BinderService;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Controller
public class GenericController {

    private final ApplicationContext applicationContext;
    private final BinderService binderService;

    public GenericController(ApplicationContext applicationContext, BinderService binderService) {
        this.applicationContext = applicationContext;
        this.binderService = binderService;
    }

    @GetMapping("{entity}")
    public <T, R> String showClients(
            Model model,
            @PathVariable(name = "entity") String entity,
            @RequestParam(value = "id", required = false) Optional<String> id
    ) {
        @SuppressWarnings("unchecked")
        GenericControllerConfig<T, R> controllerConfig = applicationContext.getBean(
                entity + "ControllerConfig",
                GenericControllerConfig.class
        );

        List<R> dtos = id
                .map(existId -> controllerConfig.findDomainById(existId).stream())
                .orElseGet(() -> controllerConfig.findDomainAll().stream())
                .map(controllerConfig.mapper()::fromDomain)
                .toList();

        model.addAttribute("table", controllerConfig.getTable(dtos));
        model.addAttribute("formUrl", "/form/" + entity);
        model.addAttribute("deleteUrl", entity);
        return "index-generic";
    }

    @GetMapping("form/{entity}")
    public <T, R> String showFormCliente(
            Model model,
            @RequestParam(value = "id", required = false) Optional<String> id,
            @PathVariable(name = "entity") String entity
    ) {
        @SuppressWarnings("unchecked")
        GenericControllerConfig<T, R> controllerConfig = applicationContext.getBean(
                entity + "ControllerConfig",
                GenericControllerConfig.class
        );

        R dto = controllerConfig.mapper().emptyDto();
        if (id.isPresent()) {
            dto = controllerConfig.findDomainById(id.get())
                    .map(controllerConfig.mapper()::fromDomain)
                    .orElseThrow();
        }

        model.addAttribute("formEntity", dto);
        model.addAttribute("id", id);
        return "form-" + entity;
    }

    @PostMapping("form/{entity}")
    public <T, R> String processFormCliente(
            @RequestParam(value = "id", required = false) Optional<Integer> id,
            @PathVariable("entity") String entity,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes
    ) throws IllegalAccessException {
        @SuppressWarnings("unchecked")
        GenericControllerConfig<T, R> controllerConfig = applicationContext.getBean(
                entity + "ControllerConfig",
                GenericControllerConfig.class
        );

        R dto = controllerConfig.mapper().emptyDto();
        binderService.bind(dto, request);

        if (id.isPresent()) {
            controllerConfig.updateDomain(controllerConfig.mapper().toDomain(dto));
            redirectAttributes.addFlashAttribute("successMessage", entity + "actualizado con exito -> ");
        } else {
            controllerConfig.saveDomain(controllerConfig.mapper().toDomain(dto));
            redirectAttributes.addFlashAttribute("successMessage", entity + " creado con exito -> ");
        }

        redirectAttributes.addFlashAttribute("id", getFirstFieldValue(dto));
        redirectAttributes.addFlashAttribute("successLink",
                String.format("/%s?id=%s", entity, getFirstFieldValue(dto)));
        return "redirect:/form/" + entity;
    }

    @SuppressWarnings({"java:S3011", "java:S1751"})
    public Object getFirstFieldValue(Object dto) throws IllegalAccessException {
        for (Field field : dto.getClass().getDeclaredFields()) {
            field.setAccessible(true); // permite acceder a campos privados
            return field.get(dto); // devuelve el valor del primer campo
        }
        return null; // si no tiene campos
    }

    @DeleteMapping("{entity}")
    public <T, R> ResponseEntity<String> deleteClient(
            @RequestParam(value = "id", required = true) String id,
            @PathVariable(name = "entity") String entity
    ) {
        @SuppressWarnings("unchecked")
        GenericControllerConfig<T, R> controllerConfig = applicationContext.getBean(
                entity + "ControllerConfig",
                GenericControllerConfig.class
        );
        
        try {
            controllerConfig.deleteDomainById(id);
            return ResponseEntity.ok("Client deleted successfully");
        } catch (DataDeleteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
