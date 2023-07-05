package tech.kbtg.fullcrudrestapiwithhibernatejpa.service;

import tech.kbtg.fullcrudrestapiwithhibernatejpa.entity.TodoItem;

import java.util.List;

public interface TodoItemService
{
	List < TodoItem > getAllTodoItem();

	TodoItem getTodoItemById( Integer id );

	void deleteItemById( Integer id );

	TodoItem createNewTodoItem( TodoItem item );
	
	TodoItem updateTodoItem( TodoItem updatedItem );
}
