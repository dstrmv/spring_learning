import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Params, Router } from '@angular/router';
import { Task } from 'src/app/model/task.model';
import { TaskService } from '../task.service';


@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html'
})
export class TaskDetailComponent implements OnInit {

  task: Task;
  id: number;

  constructor(private taskService: TaskService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params.id;
        this.task = this.taskService.getTask(this.id);
      }
    );
  }

  onEditTask() {
    this.router.navigate(['edit'], {relativeTo: this.route});
  }

  onDeleteTask() {
    this.taskService.deleteTask(this.id);
    this.router.navigate(['/tasks']);
  }

  isString() {
    return typeof this.task.expires == 'string';
  }
}
