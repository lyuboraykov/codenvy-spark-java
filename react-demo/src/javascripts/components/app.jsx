import React from 'react';

import Todo from '../lib/todo';
import TodoForm from './todo-form.jsx';
import TodoItem from './todo-item.jsx';

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      todos: [
        new Todo('Полей папрата'),
        new Todo('Напиши си домашното')
      ]
    };
  }

  render() {
    return (
      <div>
        <h2>Тудута</h2>
        <TodoForm onAddTodo={this.addTodo.bind(this)} />
        <div>
          {this.state.todos.map(todo => {
            return <TodoItem onCompleteTodo={this.completeTodo.bind(this)}
                             todo={todo}
                             key={todo.label} />;
          })}
        </div>
      </div>
    );
  }

  addTodo(todo) {
    const todos = this.state.todos;
    todos.push(todo);
    this.setState({
      todos: todos
    });
  }

  completeTodo(todo) {
    todo.complete();
    this.setState({
      todos: this.state.todos
    });
  }
}
