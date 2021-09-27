package utp.taller.apirest.services;

import java.util.List;

import utp.taller.apirest.entities.Task;

public interface ITaskService {
    public List<Task> findAllTask();
    public Task saveTask(Task task);
    public Task findById(Integer id);
    public Boolean deleteTaskById(Integer id);
}
