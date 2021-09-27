package utp.taller.apirest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import utp.taller.apirest.entities.Task;

public interface ITaskRepository extends JpaRepository<Task,Integer>{
    
}
