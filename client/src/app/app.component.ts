import { Component, OnInit } from '@angular/core';
import { TaskService } from "./tasks/task.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
    this.taskService.getTasks();
  }

  title = 'client';
}
