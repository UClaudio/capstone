import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';

type AuthResponse = {

  accessToken: string,
  user:User

}

export interface ILogin {
  name: string,
  email: string,
  password: string
}

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  apiUrl: string = 'http://localhost:8080/api/users';

  constructor(private http:HttpClient) { }

  saveAuthToLocal(access:AuthResponse){
    localStorage.setItem('user-access',JSON.stringify(access))
  }

  saveAuthToSession(access:AuthResponse){
    sessionStorage.setItem('user-access',JSON.stringify(access))
  }

  isUserLogged(): boolean{

    let storage:boolean= localStorage.getItem('user-access') != null 
   let session:boolean = sessionStorage.getItem('user-access') != null
   if(storage == false){
     return session
     } else{
       return storage  
   }
  }

   logOut(){
    localStorage.removeItem('user-access')
    sessionStorage.removeItem('user-access')
  }


  login(loginData:ILogin){

    return this.http.post<AuthResponse>(this.apiUrl+'/login', loginData)

  }

  register(register:User){

    return this.http.post<AuthResponse>(this.apiUrl+'/register', register)

  }

  getLogged(){
    let exit = this.isUserLogged();
    let logged : string | null = localStorage.getItem('user-access')
    let logged2 : string | null = sessionStorage.getItem('user-access')

    if (exit) {
      if(logged){
        return logged ? JSON.parse(logged).user : null 
      } else{
        return logged2 ? JSON.parse(logged2).user : null
      }
    
    }
  }
}
