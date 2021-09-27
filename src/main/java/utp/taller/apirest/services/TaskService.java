package utp.taller.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utp.taller.apirest.entities.Task;
import utp.taller.apirest.repositories.ITaskRepository;

@Service(value = "taskService")
public class TaskService implements ITaskService{

    @Autowired
    ITaskRepository taskRepository;

    @Override
    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(Integer id) {
        Optional<Task> tarea = taskRepository.findById(id);
        return tarea.isPresent() ? tarea.get() : null;
    }

    @Override
    public Boolean deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
        return null == findById(id);
    }
    
}
