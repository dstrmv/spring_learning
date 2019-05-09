import { Comment } from './comment.model';

export class Task {

  public active = true;
  public id: number;
  _links: {
    self: {
      href: string;
    }
  };

  constructor(public name: string,
              public description: string,
              public expires: Date,
              public comments: Comment[]) {

  }
}

