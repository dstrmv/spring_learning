import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { TaskService } from '../task.service';
import * as moment from 'moment';
import { Task } from "../../model/task.model";

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {

  id: number;
  editMode = false;
  taskForm: FormGroup;

  constructor(private route: ActivatedRoute,
              private taskService: TaskService,
              private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params.id;
        this.editMode = params.id != null;
        this.initForm();
      }
    );
  }

  private initForm() {

    let taskName = '';
    let taskDescription = '';
    let taskExpires = new Date();
    let taskComments = new FormArray([]);

    if (this.editMode) {
      const task = this.taskService.getTask(this.id);
      taskName = task.name;
      taskDescription = task.description;
      taskExpires = task.expires;
      if (task.comments) {
        for (let comment of task.comments) {
          taskComments.push(
            new FormGroup({
              content: new FormControl(comment.content, Validators.required)
            })
          );
        }
      }
    }

    this.taskForm = new FormGroup({
      name: new FormControl(taskName, Validators.required),
      description: new FormControl(taskDescription),
      expires: new FormControl(moment(taskExpires).format('DD.MM.YYYY, HH:mm:ss'), Validators.required),
      comments: taskComments
    });
  }

  onAddComment() {
    (this.taskForm.get('comments') as FormArray).push(
      new FormGroup({
        content: new FormControl(null, Validators.required)
      })
    );
  }

  onSubmit() {

    let task: Task = this.taskForm.value;
    console.log(task.expires);
    task.expires = moment.parseZone(this.taskForm.value.expires, 'DD.MM.YYYY, HH:mm:ss').toDate();
    console.log(task.expires);

    if (this.editMode) {
      this.taskService.updateTask(this.id, task);
    } else {
      this.taskService.addTask(task);
    }
    this.onCancel();
  }

  onCancel() {
    this.router.navigate(['../'], {relativeTo: this.route});
  }

  onDeleteComment(i: number) {
    (this.taskForm.get('comments') as FormArray).removeAt(i);
  }


}
