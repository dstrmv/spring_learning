import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TasksComponent } from './tasks/tasks.component';
import { TaskStartComponent } from './tasks/task-start/task-start.component';
import { TaskDetailComponent } from './tasks/task-detail/task-detail.component';
import { TaskEditComponent } from './tasks/task-edit/task-edit.component';
import { SignupComponent } from "./auth/signup/signup.component";
import { SigninComponent } from "./auth/signin/signin.component";

const appRoutes: Routes = [
  {path: '', redirectTo: '/tasks', pathMatch: 'full'},
  {
    path: 'tasks', component: TasksComponent, children: [
      {path: '', component: TaskStartComponent},
      {path: 'new', component: TaskEditComponent},
      {path: ':id', component: TaskDetailComponent},
      {path: ':id/edit', component: TaskEditComponent}
    ]
  },
  {path: 'signup', component: SignupComponent},
  {path: 'signin', component: SigninComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
