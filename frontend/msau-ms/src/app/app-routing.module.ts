import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { CoursesComponent } from './components/courses/courses.component';
import { AddCourseComponent } from './components/add-course/add-course.component';
import { StudentsComponent } from './components/students/students.component';
import { ManageCoursesComponent } from './components/manage-courses/manage-courses.component';
import { TrainingsComponent } from './components/trainings/trainings.component';
import { AddFeedbackComponent } from './components/add-feedback/add-feedback.component';
import { AssignTrainingComponent } from './components/assign-training/assign-training.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full' },
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard]},
  {path: 'courses', component: CoursesComponent, canActivate: [AuthGuard]},
  {path: 'add-course', component: AddCourseComponent, canActivate: [AuthGuard]},
  {path: 'trainings', component: TrainingsComponent, canActivate: [AuthGuard]},
  {path: 'students', component: StudentsComponent, canActivate: [AuthGuard]},
  {path: 'manage-courses', component: ManageCoursesComponent, canActivate: [AuthGuard]},
  {path: 'feedback', component: AddFeedbackComponent, canActivate: [AuthGuard]},
  {path: 'assign-training', component: AssignTrainingComponent, canActivate: [AuthGuard]},

  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
