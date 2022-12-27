package prog.config;

import jakarta.servlet.ServletContext;
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

//    public void onStartup(ServletContext servletContext){
//        servletContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter())
//                .addMappingForUrlPatterns(null,true,"/*");
//    }
}
