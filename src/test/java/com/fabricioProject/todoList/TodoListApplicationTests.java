package com.fabricioProject.todoList;

import com.fabricioProject.todoList.Entity.TodoModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testeCreateTodoSucess() {

		var todo = new TodoModel("Todo 1","Desc Todo 1",1,false);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].name").isEqualTo(todo.getName())
				.jsonPath("$[0].description").isEqualTo(todo.getDescription())
				.jsonPath("$[0].realization").isEqualTo(todo.isRealization())
				.jsonPath("$[0].priority").isEqualTo(todo.getPriority());
	}
	@Test
	void testeCreateTodoFailure() {

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(
						new TodoModel("","",0,false)
				)
				.exchange()
				.expectStatus().isBadRequest()
				.expectBody();

	}
}
