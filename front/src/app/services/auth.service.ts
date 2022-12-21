import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ILogin } from '../interfaces/ilogin';
import { User } from '../models/user';

type AuthResponse = {
  accessToken: string,
  user: User
}

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  apiUrl: string = 'http://localhost:8080/auth';

  constructor(private http: HttpClient) {
    
   }

  saveAuthToLocal(access: AuthResponse) {
    localStorage.setItem('user-access', JSON.stringify(access))
  }

  saveAuthToSession(access: AuthResponse) {
    sessionStorage.setItem('user-access', JSON.stringify(access))
  }

  isUserLogged(): boolean {
    return localStorage.getItem('user-access') ? true : sessionStorage.getItem('user-access') != null
  }

  logOut() {
    localStorage.removeItem('user-access')
    sessionStorage.removeItem('user-access')
  }


  login(loginData: ILogin) {
    return this.http.post<AuthResponse>(this.apiUrl + '/login', loginData)
  }

  register(register: User) {
    return this.http.post<AuthResponse>(this.apiUrl + '/register', register)
  }

  getLogged(): User | string {

    let logged: string | null = localStorage.getItem('user-access')
    let logged2: string | null = sessionStorage.getItem('user-access')
    if(logged && logged != undefined){
      return JSON.parse(logged)
    }
    if(logged2 && logged2 != undefined){
      return JSON.parse(logged2)
    }
    return "no user logged"
  }
}


