package tadjik.ilyosjon.endpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.endpoint.Dto.StudentDto;
import tadjik.ilyosjon.endpoint.model.Result;
import tadjik.ilyosjon.endpoint.model.Student;
import tadjik.ilyosjon.endpoint.repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    //get all student

    public List<Student> getAllStudents() {
        List<Student> list = studentRepo.findAll();
        return list;
    }

    //get by id student
    public Student getbyid(Integer id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        return studentOptional.get();
    }
    //create
    public Result create(Student student) {
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setPhone(student.getPhone());
        student1.setStatus(student.getStatus());
        studentRepo.save(student);

        return new Result (true, "Saqlandi");
    }
    //update
    public Result update(Integer id, StudentDto studentDto){
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentDto.getName());
            student.setEmail(studentDto.getEmail());
            student.setPhone(studentDto.getPhone());
            student.setStatus(studentDto.getStatus());
            return new Result(true,"O`zgartirildi");

        }
        return new Result(false,"Not found");
    }
    //delete
    public Result delete(Integer id) {
        studentRepo.deleteById(id);
        return new Result(true,"Deleted");
    }


}
