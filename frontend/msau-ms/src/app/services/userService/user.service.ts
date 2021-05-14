import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SocialUser } from 'angularx-social-login';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { User } from 'src/app/models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = "/api/user/";
  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) { }

  setCurrentUser(user: SocialUser){
    this.getUserByEmail(user.email).subscribe((res: User) => {
      sessionStorage.setItem('userId', (res.userId).toString());
      console.log(sessionStorage.getItem('userId'), typeof(sessionStorage.getItem('userId')));
      console.log(sessionStorage.getItem('userData'));
    })
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // To send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  getUserByEmail(email: string): Observable<User>{
    return this.http.get<User>(this.userUrl + 'email/' + email).pipe(
      catchError(this.handleError<User>(`getUserByEmail = ${email}`))
    );
  }

  getTrainers(): Observable<User[]>{
    return this.http.get<User[]>(this.userUrl + 'trainers').pipe(
      catchError(this.handleError<User[]>('getTrainers', []))
    );
  }

  getCreators(): Observable<User[]>{
    return this.http.get<User[]>(this.userUrl + 'creators').pipe(
      catchError(this.handleError<User[]>('getCreators', []))
    );
  }
}
