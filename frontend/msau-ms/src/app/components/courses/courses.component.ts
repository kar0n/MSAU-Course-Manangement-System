import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Course } from 'src/app/models/Course';
import { User } from 'src/app/models/User';
import { CourseService } from 'src/app/services/courseService/course.service';
import { UserService } from 'src/app/services/userService/user.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  userId!: number;
  user: any;
  creator: any;
  searchKey!: string;
  courses: Course[] = [];
  dataSource!: MatTableDataSource<Course>;
  creators: User[] = [];
  headers: string[] = ['courseId','name','description','skills','prerequisites','location', 'creatorId', 'createdOn'];
  // headers: string[] = ['courseId','name','description','skills','prerequisites','location', 'creatorId','createdOn', 'actions'];


  constructor(
    private userService: UserService,
    private courseService: CourseService,
    private router:Router,
    ) { }
  
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngOnInit(): void {
    this.userId = +sessionStorage.getItem('userId')!;

    this.courseService.getAllCourses().subscribe(res=>{
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

    this.userService.getCreators().subscribe((res)=>{
      this.creators = res;
    })
  }


  creatorName(id: number): any{
    for(let creator of this.creators)
      if(creator.userId === id)
        return creator.name;
  }



  add(course: Course): void {
    if (!course) { return; }
    this.courseService.addCourse(course);
  } 

  manageCourse(){
    this.router.navigate(['/manage-courses']);
  }

  applyFilter(){
    this.dataSource.filter = this.searchKey.trim().toLowerCase();
  }

  onClear(){
    this.searchKey = "";
    this.applyFilter();
  }

}
