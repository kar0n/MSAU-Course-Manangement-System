import { Component, Inject, OnInit, Optional } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { MaterialService } from 'src/app/services/materialService/material.service';

@Component({
  selector: 'app-training-materials',
  templateUrl: './training-materials.component.html',
  styleUrls: ['./training-materials.component.css']
})
export class TrainingMaterialsComponent implements OnInit {

  files = [];
  constructor(
    private materialService: MaterialService,
    private snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<TrainingMaterialsComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: number,

    ) { }

  ngOnInit(): void {
      this.materialService.getMaterialVersions(this.data).subscribe((res)=>{
        this.files = res;
        console.log(res);
      }
      )
  }

  onClose() {
    this.dialogRef.close();
  }

  base64ToArrayBuffer(base64) {
    const binary_string = window.atob(base64);
    const len = binary_string.length;
    const bytes = new Uint8Array(len);
    for (let i = 0; i < len; i++) {
        bytes[i] = binary_string.charCodeAt(i);
    }
    return bytes.buffer;
  }


  downloadFile(data, fileType){
    const byteArray = this.base64ToArrayBuffer(data);
    const blob = new Blob([byteArray], { type: fileType });
    const url = window.URL.createObjectURL(blob);
    window.open(url);
  }

  deleteFile(materialId: number){
    if(confirm("Confirm Delete?")){
      this.materialService.deleteMaterial(materialId).subscribe((res)=>{
        console.log('deleted', res);
        this.warn('File Deleted Successfully!!', 'OK');
        window.location.reload();
      })
    }
  }

  warn(message: string, action: string){
    const config: MatSnackBarConfig = {
      duration: 4000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['notification', 'warn'],
    }
    this.snackBar.open(message, action, config);
  }

}
