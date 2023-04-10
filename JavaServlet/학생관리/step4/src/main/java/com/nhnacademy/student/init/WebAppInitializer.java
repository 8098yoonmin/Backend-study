package com.nhnacademy.student.init;

import com.nhnacademy.student.controller.StudentListController;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@HandlesTypes(value={
        com.nhnacademy.student.controller.Command.class
})
public class WebAppInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
//        Map<String, Object> map = new HashMap<>();
//        String key="GET/student/list.do";
//
//        map.put(key, new StudentListController());
//        servletContext.setAttribute("map",map);

        ControllerFactory controllerFactory = new ControllerFactory();
        controllerFactory.init(c);

        ctx.setAttribute("controllerFactory", controllerFactory);
    }
}
