package prog.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletConfig  extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    //Конфигурация инициализации ViewResolver
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ WebConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerHiddenFieldFilter(servletContext);
    }
    private void registerHiddenFieldFilter(ServletContext context){
        context.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter())
                .addMappingForUrlPatterns(null,true,"/*");
    }
}
