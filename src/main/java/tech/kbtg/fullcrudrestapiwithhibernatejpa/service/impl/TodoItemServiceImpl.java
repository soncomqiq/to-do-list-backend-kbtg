package tech.kbtg.fullcrudrestapiwithhibernatejpa.service.impl;

import org.springframework.stereotype.Service;
import tech.kbtg.fullcrudrestapiwithhibernatejpa.entity.TodoItem;
import tech.kbtg.fullcrudrestapiwithhibernatejpa.exception.NotFoundResourceException;
import tech.kbtg.fullcrudrestapiwithhibernatejpa.repository.TodoItemRepository;
import tech.kbtg.fullcrudrestapiwithhibernatejpa.service.TodoItemService;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoItemService
{
	private TodoItemRepository todoItemRepository;

	public TodoItemServiceImpl( TodoItemRepository todoItemRepository )
	{
		this.todoItemRepository = todoItemRepository;
	}

	@Override
	public List < TodoItem > getAllTodoItem()
	{
		return todoItemRepository.findAll();
	}

	@Override
	public TodoItem getTodoItemById( Integer id )
	{
		Optional < TodoItem > todoItem = todoItemRepository.findById( id );
		if ( todoItem.isPresent() )
		{
			return todoItem.get();
		}
		throw new NotFoundResourceException( "TodoItem not found ID: " + id );
	}

	@Override
	public void deleteItemById( Integer id )
	{
		Optional < TodoItem > todoItem = todoItemRepository.findById( id );
		if ( todoItem.isEmpty() )
		{
			throw new NotFoundResourceException( "TodoItem not found ID: " + id );
		}
		todoItemRepository.delete( todoItem.get() );
	}

	@Override
	public TodoItem createNewTodoItem( TodoItem item )
	{
		return todoItemRepository.save( item );
	}

	@Override
	public TodoItem updateTodoItem( TodoItem updatedItem )
	{
		return todoItemRepository.save( updatedItem );
	}
}
