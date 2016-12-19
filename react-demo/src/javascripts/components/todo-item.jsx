import React from 'react';

import Todo from '../lib/todo';

export default class TodoItem extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div>
        <h3 className={this.props.todo.isDone ? 'done' : ''}>
          {this.props.todo.label}
        </h3>
        <button onClick={this.completeTodo.bind(this)}
                className={this.props.todo.isDone ? 'hidden' : ''}>
          Приключи
        </button>
      </div>
    );
  }

  completeTodo() {
    this.props.onCompleteTodo(this.props.todo);
  }
}

TodoItem.propTypes = {
    todo: React.PropTypes.object,
    onCompleteTodo: React.PropTypes.func
};
