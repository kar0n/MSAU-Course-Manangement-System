import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Material } from 'src/app/models/Material';

@Injectable({
  providedIn: 'root'
})
export class MaterialService {
  private materialUrl = "/api/trainingmaterial/";
  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // To send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  // Material for Student
  getMaterialForTraining(id: number): Observable<Material>{
    return this.http.get<Material>(this.materialUrl + 'training-files/' + id).pipe(
      catchError(this.handleError<Material>(`getMaterialForTraining = ${id}`))
    );
  }

  addMaterial(fileList: any, trainingId: any): Observable<any>{
    const formData: FormData = new FormData();
    for (const obj of fileList) { formData.append('files', obj);}
    formData.append('trainingId', trainingId);
    formData.append('fileType', '');
    return this.http.post<any>(this.materialUrl + 'add/', formData).pipe(
      catchError(this.handleError<any>('addMaterial'))
    );
  }

  deleteMaterial(id: number): Observable<Material>{
    return this.http.delete<Material>(this.materialUrl + 'delete/' + id, this.httpOptions).pipe(
      catchError(this.handleError<Material>('deleteMaterial'))
    );
  }

  // Materials of Trainer
  getMaterialVersions(id: number): Observable<Material[]>{
    return this.http.get<Material[]>(this.materialUrl + 'training-files/versions/' + id).pipe(
      catchError(this.handleError<Material[]>('getMaterialVersions'))
    )
  }
}
