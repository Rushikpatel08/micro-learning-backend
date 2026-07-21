package com.microlearning.api.controller;

import com.microlearning.api.model.Student;
import com.microlearning.api.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
@Tag(name = "Student Controller", description = "APIs for managing student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudent")
    public List<Student> GetStudent()
    {
        return studentService.DisplayStudent();
    }

    @GetMapping("/displaybycollege/{college}")
    public List<Student> GetallStudentByCollege(@PathVariable String college)
    {
        return studentService.DisplaybyCollege(college);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/Addstudent")
    public Student AddStudent(@RequestBody Student student)
    {
        return studentService.InsertStudent(student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/DeleteStudent/{student_id}")
    public void DeleteStudent(@PathVariable Long student_id)
    {
        studentService.deleteStudent(student_id);
        System.out.println("Deleted Successfully");
    }

    @Operation(
            summary = "Update Student profile",
            description = "Update student profile information"
    )
    @PutMapping("/updateStudent/{Student_id}")
    public Student UpdateMobile(@RequestBody Student newStudent,@PathVariable Long student_id)
    {
        return studentService.UpdateStudent(newStudent,student_id);
    }
}
