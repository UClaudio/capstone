import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { GenCrudService } from './gencrud.service';

@Injectable({
  providedIn: 'root'
})
export class UserService extends GenCrudService <User> {

  constructor(private httpC:HttpClient) {
    super(httpC, 'http://localhost:3000/users');
  }
  apiUsers:string= 'http://localhost:3000/users'

  getUserById(id:number | undefined){
    return this.httpC.get<User[]>(this.apiUsers+ '/?id='+ id)
  }
}
