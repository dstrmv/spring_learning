import { Task } from '../tasks/task.model';

export class Journal {


  public tasks: Task[];
  public name: string;
  public description: string;

  constructor(name: string, desc: string, tasks: Task[]) {
    this.name = name;
    this.description = desc;
    this.tasks = tasks;
  }

}
