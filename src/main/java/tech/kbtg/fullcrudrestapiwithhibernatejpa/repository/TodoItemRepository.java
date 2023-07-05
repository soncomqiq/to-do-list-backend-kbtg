package tech.kbtg.fullcrudrestapiwithhibernatejpa.repository;

import tech.kbtg.fullcrudrestapiwithhibernatejpa.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository < TodoItem, Integer >
{
}
