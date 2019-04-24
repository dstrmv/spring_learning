import { Component, OnInit } from '@angular/core';
import { Journal } from "../journal.model";
import { Task } from "../../tasks/task.model";

@Component({
  selector: 'app-journal-list',
  templateUrl: './journal-list.component.html',
  styleUrls: ['./journal-list.component.css']
})
export class JournalListComponent implements OnInit {

  journals: Journal[] = [
    new Journal('Test Journal', 'This is a test journal',
      [new Task('Task of journal 1', 'just task', new Date().toLocaleString()),
        new Task('Second task of journal 1', 'just task=)))', new Date().toLocaleString())]),
    new Journal('Second Journal', 'One more journal', [])
  ];

  constructor() { }

  ngOnInit() {
  }

}
