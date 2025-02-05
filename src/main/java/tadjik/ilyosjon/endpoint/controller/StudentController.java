package tadjik.ilyosjon.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.endpoint.Dto.StudentDto;
import tadjik.ilyosjon.endpoint.model.Result;
import tadjik.ilyosjon.endpoint.model.Student;
import tadjik.ilyosjon.endpoint.service.StudentService;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public List<Student> allStudents() {
        return studentService.getAllStudents();
    }
    @PostMapping("/student")
    public Result addStudent(@RequestBody Student student) {

        Result result = studentService.create(student);
        return result;
    }
    @PutMapping("/student{id}")
    public Result editStudent(@PathVariable int id, @RequestBody StudentDto studentDto) {
        Result result = studentService.update(id, studentDto);
        return result;
    }
    @DeleteMapping("/student/{id}")
    public Result deleteStudent(@PathVariable int id) {
        Result result = studentService.delete(id);
        return result;
    }
}
