import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export abstract class GenCrudService<T> {

  constructor(private http:HttpClient, @Inject(String) protected apiUrl : string) { }

  getAll():Observable<T[]> {
    return this.http.get<T[]>(this.apiUrl)
  }

  getById(id: number): Observable<T> {
    return this.http.get<T>(this.apiUrl+'/?id='+id)
  }

  add(x: T): Observable<T> {
    return this.http.post<T>(this.apiUrl+"/add",x)
  }

  edit(x: T, id : number | undefined): Observable<T> {
    return this.http.patch<T>(this.apiUrl+'/'+id,x)
  }

  delete(id: number | undefined): Observable<T> {
    return this.http.delete<T>(this.apiUrl+'/'+id)
  }
}
