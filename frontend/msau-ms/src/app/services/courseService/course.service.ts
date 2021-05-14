import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Course } from 'src/app/models/Course';
import { catchError } from 'rxjs/operators';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  
  private courseUrl = "/api/course/";
  private creatorUrl = this.courseUrl + 'creator/';
  private trainerUrl = this.courseUrl + 'trainer/'; 
  

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private http: HttpClient,
    ) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // To send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  getAllCourses(): Observable<Course[]>{
    return this.http.get<Course[]>(this.courseUrl + 'all').pipe(
      catchError(this.handleError<Course[]>('getCourses', []))
    );
  }

  getCourseById(id: number): Observable<Course>{
    return this.http.get<Course>(this.courseUrl + id).pipe(
      catchError(this.handleError<Course>(`getCourseById = ${id}`))
    );
  }

  getCourseofCreator(id: number): Observable<Course[]>{
    return this.http.get<Course[]>(this.creatorUrl + id).pipe(
      catchError(this.handleError<Course[]>(`getCourseOfCreator = ${id}`, []))
    );
  }

  addCourse(course: Course): Observable<Course>{
    return this.http.post<Course>(this.courseUrl + 'add/', course, this.httpOptions).pipe(
      catchError(this.handleError<Course>('addCourse'))
    );
  }

  updateCourse(course: Course): Observable<Course>{
    return this.http.post<Course>(this.courseUrl + 'update/', course, this.httpOptions).pipe(
      catchError(this.handleError<Course>('updateCourse'))
    );
  }

  deleteCourse(id: number): Observable<Course>{
    return this.http.delete<Course>(this.courseUrl + 'delete/' + id, this.httpOptions).pipe(
      catchError(this.handleError<Course>('deleteCourse'))
    );
  }

  countLocation(): Observable<any>{
    return this.http.get<any>(this.courseUrl + 'trends/location', this.httpOptions).pipe(
      catchError(this.handleError<Course>('trendLocaton'))
    );
  }

  countSkills(): Observable<any>{
    return this.http.get<any>(this.courseUrl + 'trends/skills', this.httpOptions).pipe(
      catchError(this.handleError<Course>('trendLocaton'))
    );
  }

  courseForm: FormGroup = new FormGroup({
    courseId: new FormControl(''),
    name: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]),
    description: new FormControl(''),
    skills: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]),
    prerequisites: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]),
    location: new FormControl('', Validators.required),
    creatorId: new FormControl('', Validators.required),
  });

  populateForm(course: Course){
    this.courseForm.setValue({
      courseId: course.courseId,
      name: course.name,
      description: course.description,
      skills: course.skills,
      prerequisites: course.prerequisites,
      location: course.location,
      creatorId: course.courseId,
    });
    console.log('populating');
  }

}
