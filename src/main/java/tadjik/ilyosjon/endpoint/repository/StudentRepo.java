package tadjik.ilyosjon.endpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.endpoint.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
