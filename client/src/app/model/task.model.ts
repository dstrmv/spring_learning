import { Comment } from './comment.model';

export class Task {

  public active = true;

  constructor(public name: string,
              public description: string,
              public expires: Date,
              public comments: Comment[]) {

  }
}

