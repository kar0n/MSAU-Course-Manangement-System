import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { SocialAuthServiceConfig } from 'angularx-social-login';
import { SocialLoginModule, GoogleLoginProvider } from 'angularx-social-login';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CoursesComponent } from './components/courses/courses.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { ManageCoursesComponent } from './components/manage-courses/manage-courses.component';
import { TrainingMaterialsComponent } from './components/training-materials/training-materials.component';
import { AddCourseComponent } from './components/add-course/add-course.component';
import { TrainingsComponent } from './components/trainings/trainings.component';
import { StudentsComponent } from './components/students/students.component';
import { AddMaterialsComponent } from './components/add-materials/add-materials.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './angular-material/angular-material.module';
import { NavigationBarComponent } from './components/navigation-bar/navigation-bar.component';
import { AddFeedbackComponent } from './components/add-feedback/add-feedback.component';
import { AssignTrainingComponent } from './components/assign-training/assign-training.component';
import { AuthGuard } from './auth.guard';
import { SendMailComponent } from './components/send-mail/send-mail.component';
import { StudentsMaterialComponent } from './components/students-material/students-material.component';
import { NgxChartsModule } from '@swimlane/ngx-charts';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    CoursesComponent,
    PageNotFoundComponent,
    ManageCoursesComponent,
    TrainingMaterialsComponent,
    AddCourseComponent,
    TrainingsComponent,
    StudentsComponent,
    AddMaterialsComponent,
    NavigationBarComponent,
    AddFeedbackComponent,
    AssignTrainingComponent,
    SendMailComponent,
    StudentsMaterialComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularMaterialModule,
    SocialLoginModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    NgxChartsModule,
  ],
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers:[{
          id: GoogleLoginProvider.PROVIDER_ID,
          provider: new GoogleLoginProvider(
            '1022509750860-kqmqa2pqahl0jma09c3flde1gd1ialne.apps.googleusercontent.com'
          )
        }]
      } as SocialAuthServiceConfig,
    },
    AuthGuard,
  ],
  bootstrap: [AppComponent],
  entryComponents: [
    AddCourseComponent, 
    AssignTrainingComponent,
    AddFeedbackComponent,
    AddMaterialsComponent,
    TrainingMaterialsComponent,
    StudentsMaterialComponent,
    SendMailComponent,
  ],
})
export class AppModule { 
  
}
