import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Course } from 'src/app/models/Course';
import { Training } from 'src/app/models/Training';
import { CourseService } from 'src/app/services/courseService/course.service';
import { TrainingService } from 'src/app/services/trainingService/training.service';
import { AddMaterialsComponent } from '../add-materials/add-materials.component';
import { SendMailComponent } from '../send-mail/send-mail.component';
import { TrainingMaterialsComponent } from '../training-materials/training-materials.component';

@Component({
  selector: 'app-trainings',
  templateUrl: './trainings.component.html',
  styleUrls: ['./trainings.component.css']
})
export class TrainingsComponent implements OnInit {

  userId!: number;
  searchKey!: string;
  trainings: Training[] = [];
  courses: Course[] = [];
  dataSource!: MatTableDataSource<Training>;
  headers: string[] = ['trainingId','courseId','datetime','feedback','actions'];

  constructor(
    private trainingService: TrainingService,
    private courseService: CourseService,
    private dialog: MatDialog,
    ) { }

  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngOnInit(): void {
    this.userId = +sessionStorage.getItem('userId')!;
    this.trainingService.getTrainingForTrainer(this.userId).subscribe(res=>{
      this.trainings = res;
      this.dataSource = new MatTableDataSource(this.trainings);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
      this.dataSource.filterPredicate = (data: any, filter) => {
      return this.headers.some(ele => {
        return ele != 'actions' && data[ele].toString().toLowerCase().indexOf(filter) != -1;
      });
      };
    });
    this.courseService.getAllCourses().subscribe((res)=>{
      this.courses = res;
    });    
  }

  courseName(courseId: number){
    for(let course of this.courses)
      if(course.courseId === courseId)
        return course.name;
  }

  mail(cId: number, date: string){
    console.log(cId)
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.width = "50%";
    dialogConfig.height = "90%";
    dialogConfig.data = { 
      courseId: cId,
      datetime: date
      };
    this.dialog.open(SendMailComponent, dialogConfig);
  }

  upload(trainingId: number){
    console.log(trainingId)
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "50%";
    dialogConfig.height = "90%";
    dialogConfig.data = trainingId;
    this.dialog.open(AddMaterialsComponent, dialogConfig);
  }

  getVersions(trainingId: number){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";
    dialogConfig.height = "50%";
    dialogConfig.data = trainingId;
    this.dialog.open(TrainingMaterialsComponent, dialogConfig);
  }

  applyFilter(){
    this.dataSource.filter = this.searchKey.trim().toLowerCase();
  }

  onClear(){
    this.searchKey = "";
    this.applyFilter();
  }

}
