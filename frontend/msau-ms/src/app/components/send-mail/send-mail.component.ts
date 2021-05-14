import { Component, Inject, OnInit, Optional } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { Course } from 'src/app/models/Course';
import { CourseService } from 'src/app/services/courseService/course.service';
import { TrainingService } from 'src/app/services/trainingService/training.service';

@Component({
  selector: 'app-send-mail',
  templateUrl: './send-mail.component.html',
  styleUrls: ['./send-mail.component.css']
})
export class SendMailComponent implements OnInit {

  course: Course;

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  constructor(
    private snackBar: MatSnackBar,
    private courseService: CourseService,
    public dialogRef: MatDialogRef<SendMailComponent>,
    public trainingService: TrainingService,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit() {
    this.dialogRef.updateSize('35%', '50%');
    this.courseService.getCourseById(this.data.courseId).subscribe((res)=>{
      this.course = res;
    });
  }

  sendMail() {
    const emailId = this.emailFormControl.value;
    this.trainingService.sendMail(this.course, emailId, this.data.datetime).subscribe();
    this.success('Training Added Successfully!!', 'OK');
    this.onClose();
  }

  onClose() {
    this.dialogRef.close();
  }

  success(message: string, action: string){
    const config: MatSnackBarConfig = {
      duration: 4000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['notification', 'success'],
    }
    this.snackBar.open(message, action, config);
  }

}
