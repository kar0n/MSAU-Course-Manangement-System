import { Component, Inject, OnInit, Optional } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { MaterialService } from 'src/app/services/materialService/material.service';

@Component({
  selector: 'app-add-materials',
  templateUrl: './add-materials.component.html',
  styleUrls: ['./add-materials.component.css']
})
export class AddMaterialsComponent implements OnInit {

  files: any = [];
  trainingId!: number;
  constructor(
    private materialService: MaterialService,
    private snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<AddMaterialsComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: number
  ) { }

  ngOnInit(): void {
    this.dialogRef.updateSize('60%', '75%');
    
  }

  uploadFile(event: any) {
      for (const index of event) { 
        this.files.push(index);
      }
  }

  removeAttachment(index: number) {
    this.files.splice(index, 1);
  }

  addFiles() {
    this.materialService.addMaterial(this.files, this.data).subscribe((res)=>{
      console.log(res);
      console.log(this.files);
      console.log(this.files[0].type);
      // sessionStorage.setItem("fileType", this.files[0].type);
      this.success('Files Uploaded Successfully!!', 'OK');
      this.onClose();
      this.files = [];
      // window.location.reload();
    });
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
