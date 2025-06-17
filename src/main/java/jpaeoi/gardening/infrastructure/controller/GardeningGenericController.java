package jpaeoi.gardening.infrastructure.controller;

import jpaeoi.shared.infrastructure.genericcontroller.BinderService;
import jpaeoi.shared.infrastructure.genericcontroller.GenericController;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("gardening")
public class GardeningGenericController extends GenericController {

    public GardeningGenericController(ApplicationContext applicationContext, BinderService binderService) {
        super(applicationContext, binderService);
    }

}
