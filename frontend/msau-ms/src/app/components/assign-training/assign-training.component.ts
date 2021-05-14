import { Component, Inject, OnInit, Optional } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { User } from 'src/app/models/User';
import { TrainingService } from 'src/app/services/trainingService/training.service';
import { UserService } from 'src/app/services/userService/user.service';

@Component({
  selector: 'app-assign-training',
  templateUrl: './assign-training.component.html',
  styleUrls: ['./assign-training.component.css']
})
export class AssignTrainingComponent implements OnInit {

  userId!: number;
  trainers: User[]=[];
  trainingForm: FormGroup = this.trainingService.trainingForm;

  constructor(
    private userService: UserService,
    private trainingService: TrainingService,
    private snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<AssignTrainingComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: number
    ) { }

  ngOnInit(): void {
    this.userId = +sessionStorage.getItem('userId')!;
    this.userService.getTrainers().subscribe( (res)=>{
      this.trainers = res;
      console.log("Trainers", res);
    });
    this.trainingForm.patchValue({
      courseId: this.data
    });
  }

  addTraining(): void{
    if(this.trainingForm.valid){
      console.log(this.trainingForm.value);
      this.trainingService.addTraining(this.trainingForm.value).subscribe((res)=>{
        console.log(res);
      });
      this.success('Training Added Successfully!!', 'OK');
      this.onClose();
    }    
  }

  onClose() {
    this.trainingForm.reset();
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
