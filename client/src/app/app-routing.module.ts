import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { JournalsComponent } from './journals/journals.component';
import { JournalStartComponent } from './journals/journal-start/journal-start.component';
import { JournalDetailComponent } from './journals/journal-detail/journal-detail.component';
import { JournalEditComponent } from './journals/journal-edit/journal-edit.component';

const appRoutes: Routes = [
  {path: '', redirectTo: '/journals', pathMatch: 'full'},
  {
    path: 'journals', component: JournalsComponent, children: [
      {path: '', component: JournalStartComponent},
      {path: 'new', component: JournalEditComponent},
      {path: ':id', component: JournalDetailComponent},
      {path: ':id/edit', component: JournalEditComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
