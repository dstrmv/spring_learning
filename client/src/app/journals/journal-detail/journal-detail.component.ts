import { Component, OnInit } from '@angular/core';
import { Journal } from '../journal.model';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { JournalService } from '../journal.service';

@Component({
  selector: 'app-journal-detail',
  templateUrl: './journal-detail.component.html',
  styleUrls: ['./journal-detail.component.css']
})
export class JournalDetailComponent implements OnInit {

  journal: Journal;
  id: number;

  constructor(private journalService: JournalService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params.id;
        this.journal = this.journalService.getJournal(this.id);
      }
    );
  }

  onEditJournal() {
    this.router.navigate(['edit'], {relativeTo: this.route});
  }
}
