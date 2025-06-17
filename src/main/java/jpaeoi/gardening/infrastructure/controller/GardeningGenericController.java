package jpaeoi.gandening.infrastructure.controller;

import jpaeoi.gandening.infrastructure.config.BinderService;
import jpaeoi.shared.infrastructure.genericcontroller.GenericController;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
@
public class GardeningGenericController extends GenericController {

    public GardeningGenericController(ApplicationContext applicationContext, BinderService binderService) {
        super(applicationContext, binderService);
    }

}
