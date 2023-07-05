package tech.kbtg.fullcrudrestapiwithhibernatejpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table ( name = "todo_items" )
public class TodoItem
{
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "id" )
	private int id;

	@Column ( name = "task" )
	private String task;

	@Column ( name = "is_finished" )
	private boolean isFinished;

	@Column ( name = "due_date" )
	private Date dueDate;

	public TodoItem()
	{
	}

	public TodoItem( String task , boolean isFinished , Date dueDate )
	{
		this.task = task;
		this.isFinished = isFinished;
		this.dueDate = dueDate;
	}

	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public String getTask()
	{
		return task;
	}

	public void setTask( String task )
	{
		this.task = task;
	}

	public boolean getIsFinished()
	{
		return isFinished;
	}

	public void setIsFinished( boolean finished )
	{
		isFinished = finished;
	}

	public Date getDueDate()
	{
		return dueDate;
	}

	public void setDueDate( Date dueDate )
	{
		this.dueDate = dueDate;
	}

	@Override
	public String toString()
	{
		return "TodoItem{" + "id=" + id + ", task='" + task + '\'' + ", isFinished=" + isFinished + ", dueDate=" + dueDate + '}';
	}
}
