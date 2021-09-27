package utp.taller.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import utp.taller.apirest.entities.Task;
import utp.taller.apirest.repositories.ITaskRepository;
import utp.taller.apirest.services.ITaskService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    ITaskService taskService;
    
    @GetMapping(value="/")
    public ResponseEntity<List<Task>> buscarTodos() {
        return ResponseEntity.ok(taskService.findAllTask());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Task> buscarPorId(@PathVariable(value="id") Integer id) {
        return ResponseEntity.ok(taskService.findById(id));
    }
    
    @PostMapping(value="/")
    public ResponseEntity<Task> guardar(@RequestBody Task task) {
        task.setEstado(Boolean.TRUE);
        return ResponseEntity.ok(taskService.saveTask(task));
    }
    
    @DeleteMapping(value="/")
    public ResponseEntity<Boolean> borrarPorId(@RequestParam Integer id) {
        return ResponseEntity.ok(taskService.deleteTaskById(id));
    }


}
