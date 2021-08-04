package com.project.catalog.service;

import com.project.catalog.model.Subject;
import com.project.catalog.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    //service classes contain most of the business logic;

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubject(Long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);

        if (optionalSubject.isPresent()) {
            return optionalSubject.get();
        } else {
            throw new RuntimeException("Subject not found!");
        }
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isPresent()) {
            subjectRepository.delete(subject.get());
        } else {
            throw new RuntimeException("Subject not found!");
        }
    }

    public Subject updateSubject(Long id, Subject subjectUpdated) {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);

        if (subjectOptional.isPresent()) {
            subjectUpdated.setId(id);
            return subjectRepository.save(subjectUpdated);
        } else {
            throw new RuntimeException("Subject not found!");
        }
    }

    public Subject updatePartialSubject(Long id, Subject subjectUpdated) {
        Optional<Subject> subjectOptional = subjectRepository.findById(id);

        if (subjectOptional.isPresent()) {
            subjectUpdated.setId(id);
            subjectUpdated.setName(subjectUpdated.getName() == null ? subjectOptional.get().getName() : subjectUpdated.getName());
            subjectUpdated.setOptional(subjectUpdated.getOptional() == null ? subjectOptional.get().getOptional() : subjectUpdated.getOptional());
            subjectUpdated.setCreditPoints(subjectUpdated.getCreditPoints() == null ? subjectOptional.get().getCreditPoints() : subjectUpdated.getCreditPoints());
            subjectUpdated.setCoursePercent(subjectUpdated.getCoursePercent() == null ? subjectOptional.get().getCoursePercent() : subjectUpdated.getCoursePercent());
            subjectUpdated.setSeminaryPercent(subjectUpdated.getSeminaryPercent() == null ? subjectOptional.get().getSeminaryPercent() : subjectUpdated.getSeminaryPercent());
            return subjectRepository.save(subjectUpdated);
        } else {
            throw new RuntimeException("Subject not found!");
        }
    }

//    public void deleteSubject(Long id)  {
//       subjectRepository.deleteById(id);
//    }
}
