import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Course } from 'src/app/models/Course';
import { CourseService } from 'src/app/services/courseService/course.service';
import { AddCourseComponent } from '../add-course/add-course.component';
import { AssignTrainingComponent } from '../assign-training/assign-training.component';

@Component({
  selector: 'app-manage-courses',
  templateUrl: './manage-courses.component.html',
  styleUrls: ['./manage-courses.component.css']
})
export class ManageCoursesComponent implements OnInit {

  userId!: number;
  searchKey!: string;
  user: any;
  courses: Course[] = [];
  dataSource!: MatTableDataSource<Course>;
  headers: string[] = ['courseId','name','description','skills','prerequisites','location','modifiedOn','actions'];
  // headers: string[] = ['courseId','name','description','skills','prerequisites','location', 'creatorId','createdOn', 'actions'];

  constructor(
    private courseService: CourseService,
    private snackBar: MatSnackBar,
    private dialog: MatDialog,
    ) { }

  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngOnInit(): void {
    this.userId = +sessionStorage.getItem('userId')!;
    this.courseService.getCourseofCreator(this.userId).subscribe(res=>{
        this.courses = res;
        this.dataSource = new MatTableDataSource(this.courses);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
        this.dataSource.filterPredicate = (data: any, filter) => {
        return this.headers.some(ele => {
          return ele != 'actions' && data[ele].toString().toLowerCase().indexOf(filter) != -1;
        });
      };
      });    
  }

  assignTrainer(courseId: number){
    console.log(courseId);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "50%";
    dialogConfig.height = "40%";
    dialogConfig.data = courseId;
    this.dialog.open(AssignTrainingComponent, dialogConfig);
  }

  addCourse(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "50%";
    dialogConfig.height = "90%";
    this.dialog.open(AddCourseComponent, dialogConfig);
  }

  onEdit(row: Course){
    console.log(row);
    this.courseService.populateForm(row);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "50%";
    dialogConfig.height = "90%";
    this.dialog.open(AddCourseComponent, dialogConfig);
  }

  onDelete(courseId: number){
    if(confirm("Confirm Delete?")){
      this.courseService.deleteCourse(courseId).subscribe(res=>{
        console.log('deleted', res);
        this.warn('Course Deleted Successfully!!', 'OK');
        window.location.reload();
      });
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

  applyFilter(){
    this.dataSource.filter = this.searchKey.trim().toLowerCase();
  }

  onClear(){
    this.searchKey = "";
    this.applyFilter();
  }


}
