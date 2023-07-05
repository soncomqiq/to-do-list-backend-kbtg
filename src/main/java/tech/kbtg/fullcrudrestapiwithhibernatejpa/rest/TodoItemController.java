package tech.kbtg.fullcrudrestapiwithhibernatejpa.rest;

import tech.kbtg.fullcrudrestapiwithhibernatejpa.entity.TodoItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.kbtg.fullcrudrestapiwithhibernatejpa.service.TodoItemService;

import java.util.List;

@RestController
@RequestMapping("/todo-items")
public class TodoItemController
{
	private TodoItemService todoItemService;

	public TodoItemController( TodoItemService todoItemService )
	{
		this.todoItemService = todoItemService;
	}

	@GetMapping("/")
	public List<TodoItem> getAllTodoItems() {
		return todoItemService.getAllTodoItem();
	}
	
	@GetMapping("/{id}")
	public TodoItem getTodoItemById(@PathVariable(name = "id") int todoId ) {
		return todoItemService.getTodoItemById( todoId );
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTodoItemById(@PathVariable(name = "id") int todoId) {
		todoItemService.deleteItemById( todoId );
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/")
	public ResponseEntity<?> createNewTodoItem(@RequestBody TodoItem item ) {
		TodoItem newTodoItem = todoItemService.createNewTodoItem( item );
		return ResponseEntity.status( HttpStatus.OK ).body( newTodoItem );
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateTodoItem(@RequestBody TodoItem item) {
		TodoItem updatedTodoItem = todoItemService.updateTodoItem( item );
		return ResponseEntity.status( HttpStatus.OK ).body( updatedTodoItem );
	}
}
