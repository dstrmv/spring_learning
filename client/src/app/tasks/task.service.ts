import { Injectable } from '@angular/core';
import { Task } from '../model/task.model';
import { Subject } from 'rxjs';
import { Comment } from '../model/comment.model';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  tasksChanged = new Subject();

  private tasks: Task[] = [
    new Task('First Task', 'Test task', new Date(), []),
    new Task('Second Task', 'One more test task', new Date(), [new Comment('comment')]),
  ];

  constructor() {
  }

  getTasks() {
    return this.tasks.slice(); // array copy
  }

  getTask(id: number) {
    return this.tasks.slice()[id];
  }

  addTask(task: Task) {
    this.tasks.push(task);
    this.tasksChanged.next(this.tasks.slice());
  }

  updateTask(id: number, task: Task) {
    this.tasks[id] = task;
    this.tasksChanged.next(this.tasks.slice());
  }

  deleteTask(id: number) {
    this.tasks.splice(id, 1);
    this.tasksChanged.next(this.tasks.slice());
  }
}
