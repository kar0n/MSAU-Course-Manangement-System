import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { CourseService } from 'src/app/services/courseService/course.service';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  locations=['Mumbai','Banglore','Hyderabad','Delhi','Chennai'];

  userId!: number;
  courseForm: FormGroup = this.courseService.courseForm;

  constructor(
    private courseService: CourseService,
    private snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<AddCourseComponent>,
    ) { }

  ngOnInit(): void {
    this.userId = +sessionStorage.getItem('userId')!;
    this.courseForm.patchValue({
      creatorId: this.userId
    });
  }

  addCourse(): void {
    if(this.courseForm.valid){
      if(!this.courseForm.get('courseId')?.value){
        this.courseService.addCourse(this.courseForm.value).subscribe((res)=>{
          this.success('Course Added Successfully!!', 'OK');
          this.courseForm.reset();
          this.onClose();
          window.location.reload();
        });
      }else{
        this.courseService.updateCourse(this.courseForm.value).subscribe((res)=>{
          this.update('Course Updated!!', 'OK');
          this.courseForm.reset();
          this.onClose();
          window.location.reload();
        });
      }
    }    
  }

  onClose() {
    this.courseForm.reset();
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

  update(message: string, action: string){
    const config: MatSnackBarConfig = {
      duration: 4000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['notification', 'update'],
    }
    this.snackBar.open(message, action, config);
  }

}