package com.project.catalog.controller;

import com.project.catalog.dto.TeacherDto;
import com.project.catalog.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
    @RestController annotation means that this class will be a Bean (managed by spring) and will contain endpoints
    (an endpoint is a method that handles HTTP requests end returns a HTTP response)
    @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
 */

//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    /*
        the controllers usually shouldn't have much logic in them
        they should call services to retrieve needed data, perform validations
        most of the logic should be in the services
     */

    @Value("${test.value}")
    private String value;

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/")
    public TeacherDto getDemoTeacher() {
        return teacherService.getDemoTeacher();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello() {
        return "Greetings from my first Spring Boot application! :)";
    }

    @GetMapping("/bye")
    public String bye() {
        return value;
    }
}
