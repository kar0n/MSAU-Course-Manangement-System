import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Course } from 'src/app/models/Course';
import { Training } from 'src/app/models/Training';
import { CourseService } from 'src/app/services/courseService/course.service';
import { TrainingService } from 'src/app/services/trainingService/training.service';
import { AddFeedbackComponent } from '../add-feedback/add-feedback.component';
import { StudentsMaterialComponent } from '../students-material/students-material.component';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  userId!: number;
  user: any;
  courses: Course[] = [];
  searchKey!: string;
  trainings: Training[] = [];
  dataSource!: MatTableDataSource<Training>;
  headers: string[] = ['trainingId','courseId','datetime','actions'];

  constructor(
    private trainingService: TrainingService,
    private dialog: MatDialog,
    private courseService: CourseService,
    ) { }

    @ViewChild(MatSort) sort!: MatSort;
    @ViewChild(MatPaginator) paginator!: MatPaginator;
  
  ngOnInit(): void {
    this.userId = +sessionStorage.getItem('userId')!;
    this.trainingService.getTrainingForStudent(this.userId).subscribe(res=>{
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

  giveFeedback(trainingId: number){
    console.log(trainingId);
    // this.trainingService.setTrainingId(trainingId);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "50%";
    dialogConfig.height = "40%";
    dialogConfig.data = trainingId;
    this.dialog.open(AddFeedbackComponent, dialogConfig);
  }

  getFile(trainingId: number){
    console.log(trainingId)
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";
    dialogConfig.height = "40%";
    dialogConfig.data = trainingId;
    this.dialog.open(StudentsMaterialComponent, dialogConfig);
  }

  applyFilter(){
    this.dataSource.filter = this.searchKey.trim().toLowerCase();
  }

  onClear(){
    this.searchKey = "";
    this.applyFilter();
  }

}
