package com.project.catalog.service;

import com.project.catalog.dto.SubjectDto;
import com.project.catalog.dto.SubjectScoringDto;
import com.project.catalog.dto.TeacherDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class TeacherService {

    public TeacherDto getDemoTeacher() {
        TeacherDto teacher = new TeacherDto();
        teacher.setId(1L);
        teacher.setFirstName("Ionel");
        teacher.setLastName("Popescu");
        teacher.setBirthDate(LocalDate.now().minusYears(35));
        teacher.setEmploymentDate(LocalDate.now().minusYears(3));
        teacher.setSubjects(getDemoSubjects());

        return teacher;
    }

    private List<SubjectDto> getDemoSubjects() {
        SubjectDto subject = new SubjectDto();
        subject.setId(1L);
        subject.setName("OOP");
        subject.setCreditPoints(5);
        subject.setSubjectScoring(new SubjectScoringDto(50, 50));
        subject.setOptional(false);

        return Arrays.asList(subject, subject);
    }
}
