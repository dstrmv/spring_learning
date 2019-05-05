import { EventEmitter, Injectable } from '@angular/core';
import { Journal } from './journal.model';
import { Task } from '../tasks/task.model';

@Injectable({
  providedIn: 'root'
})
export class JournalService {

  journalSelected = new EventEmitter<Journal>();

  private journals: Journal[] = [
    new Journal('Test Journal', 'This is a test journal',
      [new Task('Task of journal 1', 'just task', new Date().toLocaleString()),
        new Task('Second task of journal 1', 'just task=)))', new Date().toLocaleString())]),
    new Journal('Second Journal', 'One more journal', [])
  ];

  constructor() {
  }

  getJournals() {
    return this.journals.slice(); // array copy
  }

  getJournal(id: number) {
    return this.journals.slice()[id];
  }
}
