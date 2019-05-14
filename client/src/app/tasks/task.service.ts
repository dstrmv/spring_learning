import { Injectable } from '@angular/core';
import { Task } from '../model/task.model';
import { Subject } from 'rxjs';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";

interface TasksResponse {

  _embedded: {
    tasks: Task[],
    _links: {
      href: string
    }
  }
}

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'text/uri-list'})
};

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private tasksUrl: string = 'http://localhost:8080/api/journals/1/tasks';
  private journalUrl: string = 'http://localhost:8080/api/journals/1';
  private taskPostUrl: string = 'http://localhost:8080/api/tasks';

  tasksChanged = new Subject();

  private tasks: Task[] = [];

  constructor(private http: HttpClient) {
  }

  getTasks() {
    this.http.get<TasksResponse>(this.tasksUrl).pipe(
      map(response => response._embedded.tasks)
    ).subscribe(
      tasks => {
        this.tasks = tasks;
        console.log(tasks);
        this.tasksChanged.next(this.tasks.slice());
      }
    );

    return this.tasks.slice(); // array copy
  }

  getTask(id: number) {
    return this.tasks.slice()[id];
  }

  addTask(task: Task) {

    let link: string;
    this.http.post<any>(this.taskPostUrl, task).subscribe(
      response => {
        task = response;
        this.http.post(this.tasksUrl, task._links.self.href, httpOptions).subscribe(
          response => {
            this.tasks.push(task);
            this.tasksChanged.next(this.tasks.slice());
          }
        );
      }
    );
  }


  updateTask(id: number, task: Task) {

    let link = this.tasks[id]._links.self.href;

    this.http.put<Task>(link, task).subscribe(
      task => {
        this.tasks[id] = task;
        this.tasksChanged.next(this.tasks.slice());
      }
    );

    //this.tasks[id] = task;
    //this.tasksChanged.next(this.tasks.slice());
  }

  deleteTask(id: number) {
    let task = this.tasks[id];

    this.http.delete(this.journalUrl + '/tasks/' + task.id).subscribe(
      resp => {
        this.tasks.splice(id, 1);
        this.tasksChanged.next(this.tasks.slice());
      }
    );
  }
}
