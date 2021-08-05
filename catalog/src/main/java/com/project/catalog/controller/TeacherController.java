package com.project.catalog.controller;

import com.project.catalog.converter.TeacherBasicInfoConverter;
import com.project.catalog.converter.TeacherConverter;
import com.project.catalog.dto.TeacherBasicInfoDto;
import com.project.catalog.dto.TeacherDto;
import com.project.catalog.model.Teacher;
import com.project.catalog.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

//    @Value("${test.value}")
//    private String value;

    private final TeacherService teacherService;
    private final TeacherConverter teacherConverter;
    private final TeacherBasicInfoConverter basicInfoConverter;

    @Autowired
    public TeacherController(TeacherService teacherService, TeacherConverter teacherConverter, TeacherBasicInfoConverter basicInfoConverter) {
        this.teacherService = teacherService;
        this.teacherConverter = teacherConverter;
        this.basicInfoConverter = basicInfoConverter;
    }

    @GetMapping("/")
    public List<TeacherDto> getAllTeachers()   {
        List<Teacher> teachers = teacherService.getAllTeachers();

        return teacherConverter.maptoDtos(teachers);
    }

    @GetMapping("/basic")
    public List<TeacherBasicInfoDto> getAllBasicTeachers()  {
        List<Teacher> teachers = teacherService.getAllTeachers();

        return basicInfoConverter.mapToDtos(teachers);
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacher(@PathVariable Long id)  {
        Teacher teacher = teacherService.getTeacher(id);

        return teacherConverter.maptoDto(teacher);
    }

    @GetMapping("/basic/{id}")
    public TeacherBasicInfoDto getBasicTeacher(@PathVariable Long id)    {
     Teacher teacher = teacherService.getTeacher(id);

     return basicInfoConverter.mapToDto(teacher);
    }


//    @GetMapping("/")
//    public TeacherDto getDemoTeacher() {
//        return teacherService.getDemoTeacher();
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/hello")
//    public String hello() {
//        return "Greetings from my first Spring Boot application! :)";
//    }
//
//    @GetMapping("/bye")
//    public String bye() {
//        return value;
//    }
}
