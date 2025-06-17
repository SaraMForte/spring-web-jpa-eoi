package jpaeoi.shared.infrastructure.genericcontroller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;

@Component
public class BinderService {

    private final ConversionService conversionService;

    public BinderService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public <T> void bind(T instance, HttpServletRequest request) {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(instance);
        binder.setConversionService(conversionService);
        binder.bind(new ServletRequestParameterPropertyValues(request));
    }
}
