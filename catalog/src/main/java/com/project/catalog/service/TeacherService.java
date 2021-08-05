package com.project.catalog.service;

import com.project.catalog.exception.NotFoundException;
import com.project.catalog.model.Teacher;
import com.project.catalog.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacher(Long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        return optionalTeacher.orElseThrow(() -> new NotFoundException("Teacher not found", "teacher.not.found"));
    }

//    public TeacherDto getDemoTeacher() {
//        TeacherDto teacher = new TeacherDto();
//        teacher.setId(1L);
//        teacher.setFirstName("Ionel");
//        teacher.setLastName("Popescu");
//        teacher.setBirthDate(LocalDate.now().minusYears(35));
//        teacher.setEmploymentDate(LocalDate.now().minusYears(3));
//        teacher.setSubjects(getDemoSubjects());
//
//        return teacher;
//    }
//
//    private List<SubjectDto> getDemoSubjects() {
//        SubjectDto subject = new SubjectDto();
//        subject.setId(1L);
//        subject.setName("OOP");
//        subject.setCreditPoints(5);
//        subject.setSubjectScoring(new SubjectScoringDto(50, 50));
//        subject.setOptional(false);
//
//        return Arrays.asList(subject, subject);
//    }
}
