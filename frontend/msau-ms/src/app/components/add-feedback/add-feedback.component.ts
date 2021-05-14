import { Component, Inject, OnInit, Optional } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { TrainingService } from 'src/app/services/trainingService/training.service';

@Component({
  selector: 'app-add-feedback',
  templateUrl: './add-feedback.component.html',
  styleUrls: ['./add-feedback.component.css']
})
export class AddFeedbackComponent implements OnInit {

  userId!: number;
  feedbackForm: FormGroup = this.trainingService.feedbackForm;


  constructor(
    private trainingService: TrainingService,
    private snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<AddFeedbackComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: number
    ) { 
    { }
  }

  ngOnInit(): void {
    this.userId = +sessionStorage.getItem('userId')!;
    this.feedbackForm.patchValue({
      trainingId: this.data
    });
  }

  giveFeedback(){
    if(this.feedbackForm.valid){
      this.trainingService.addFeedback(this.feedbackForm.value).subscribe(()=>{
        this.update('Feedback Sent!!', 'OK');
        this.onClose();
      });
    }    
  }

  onClose() {
    this.feedbackForm.reset();
    this.dialogRef.close();
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
