import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { JournalsComponent } from './journals/journals.component';
import { JournalListComponent } from './journals/journal-list/journal-list.component';
import { JournalDetailComponent } from './journals/journal-detail/journal-detail.component';
import { JournalItemComponent } from './journals/journal-list/journal-item/journal-item.component';
import { DropdownDirective } from './directives/dropdown.directive';
import { AppRoutingModule } from './app-routing.module';
import { JournalStartComponent } from './journals/journal-start/journal-start.component';
import { JournalEditComponent } from './journals/journal-edit/journal-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    JournalsComponent,
    JournalListComponent,
    JournalDetailComponent,
    JournalItemComponent,
    DropdownDirective,
    JournalStartComponent,
    JournalEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
