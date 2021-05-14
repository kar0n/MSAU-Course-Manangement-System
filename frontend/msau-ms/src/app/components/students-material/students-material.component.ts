import { Component, Inject, OnInit, Optional } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Material } from 'src/app/models/Material';
import { MaterialService } from 'src/app/services/materialService/material.service';

@Component({
  selector: 'app-students-material',
  templateUrl: './students-material.component.html',
  styleUrls: ['./students-material.component.css']
})
export class StudentsMaterialComponent implements OnInit {

  file: Material;
  constructor(
    private materialService: MaterialService,
    public dialogRef: MatDialogRef<StudentsMaterialComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: number
    )
    { }

  ngOnInit(): void {

      this.materialService.getMaterialForTraining(this.data).subscribe((res)=>{
        this.file = res;
        console.log(res);
      }
      );
  }

  onClose() {
    this.dialogRef.close();
  }

  base64ToArrayBuffer(base64: any) {
    const binary_string = window.atob(base64);
    const len = binary_string.length;
    const bytes = new Uint8Array(len);
    for (let i = 0; i < len; i++) {
        bytes[i] = binary_string.charCodeAt(i);
    }
    return bytes.buffer;
  }


  downloadFile(data: any){
    const byteArray = this.base64ToArrayBuffer(data);
    const fileType = 'image/jpeg';
    const blob = new Blob([byteArray], { type: fileType });
    const url = window.URL.createObjectURL(blob);
    window.open(url);
  }

}
