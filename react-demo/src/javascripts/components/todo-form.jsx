import React from 'react';

import Todo from '../lib/todo';

export default class TodoForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      label: ''
    };
  }

  render() {
    return (
      <form onSubmit={this.addTodo.bind(this)}>
        <input type='text'
               placeholder='Настрой пианото'
               onChange={this.changeLabel.bind(this)}
               value={this.state.label} />
        <input type='submit' value='Добави' />
      </form>
    );
  }

  changeLabel(e) {
    this.setState({
      label: e.target.value
    });
  }

  addTodo(e) {
    e.preventDefault();
    const todo = new Todo(this.state.label);
    this.props.onAddTodo(todo);
    this.setState({
      label: ''
    });
  }
}

TodoForm.propTypes = {
  onAddTodo: React.PropTypes.func
};
