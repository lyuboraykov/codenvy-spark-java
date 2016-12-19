export default class Todo {
    constructor(label, isDone=false) {
        this.label = label;
        this.isDone = isDone;
    }

    complete() {
        this.isDone = true;
    }
}
