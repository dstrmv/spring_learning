import { Component, OnInit } from '@angular/core';
import { Journal } from '../journal.model';
import { JournalService } from '../journal.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-journal-list',
  templateUrl: './journal-list.component.html',
  styleUrls: ['./journal-list.component.css']
})
export class JournalListComponent implements OnInit {

  journals: Journal[];

  constructor(private journalService: JournalService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.journals = this.journalService.getJournals();
  }

  onNewJournal() {
    this.router
      .navigate(['new'], {relativeTo: this.route});
  }
}
