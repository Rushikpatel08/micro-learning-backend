package com.microlearning.api.service;

import com.microlearning.api.model.Student;
import com.microlearning.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> DisplayStudent()
    {
        return studentRepository.findAll();
    }
    public List<Student> DisplaybyCollege(String college)
    {
        return studentRepository.findByCollege(college);
    }
    public Student InsertStudent(Student student)
    {
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id)
    {
        if(!studentRepository.existsById(id))
        {
            throw new RuntimeException("Not Found");
        }
        studentRepository.deleteById(id);
    }

    public Student UpdateStudent(Student newStudent, Long id)
    {
        Student existingStudent = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        existingStudent.setFirstname(newStudent.getFirstname());
        existingStudent.setLastname(newStudent.getLastname());
        existingStudent.setEmail(newStudent.getEmail());
        existingStudent.setCollege(newStudent.getCollege());
        existingStudent.setProgram(newStudent.getProgram());
        return studentRepository.save(existingStudent);
    }
}
