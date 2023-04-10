package com.nhnacademy.student.init;

import com.nhnacademy.student.controller.Command;
import com.nhnacademy.student.controller.StudentListController;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedArrayType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
public class ControllerFactory {
    private final Map<String, Object> beanMap = new HashMap<>();
    public void init(Set<Class<?>> c) {
        //c에 클래스가 담겨잇음?
        for(Class<?> clazz : c) {
            log.info("controller-class:{}", clazz.getName());
            Annotation[] annotations = clazz.getAnnotations();
            if(annotations.length>0) {
                String annotation = annotations[0].toString();
                log.info("annotation:{}", annotation);
                //annotation:@com.nhnacademy.student.init.RequestMapping(method=GET, value="/student/view.do")
                if(isController(annotation)) {
                    String method = getMethod(annotation);
                    String path = getPath(annotation);
                    String key = getKey(method, path);

                    //method:GET
                    log.info("method:{}", method);

                    //path:/student/update.do
                    log.info("path:{}", path);

                    //key:GET-/student/update.do
                    log.info("key:{}", key);

                    try{
                        Object command = clazz.getDeclaredConstructor().newInstance();
                        //Command cmd = new StudentListController();
                        beanMap.put(key, command);

                    } catch(Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public Object getBean(String method, String path) {
        String key = getKey(method, path);
        if(!beanMap.containsKey(key)) {
            throw new RuntimeException("Controller not found");
        }
        return beanMap.get(key);

    }

    private boolean isController(String annotation) {
        return annotation.contains("RequestMapping");
    }

    private String getMethod(String annotaion) {
        int start = annotaion.indexOf("method=")+7;
        int end = annotaion.indexOf(",");
        return annotaion.substring(start, end);
    }

    private String getPath(String annotation) {
        int start = annotation.indexOf("value=")+7;
        int end= annotation.length()-2;
        return annotation.substring(start,end);
    }

    private String getKey(String method, String path) {
        //GET-/student/list.do

        return method +"-"+ path;
    }
}
