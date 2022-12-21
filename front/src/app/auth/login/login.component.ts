import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: [
    './login.component.scss',
    '../../app.component.scss'
  ]
})
export class LoginComponent implements OnInit {

  form!: FormGroup

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      username: new FormControl(),
      password: new FormControl()
    })
  }

  login(e: Event){
    e.preventDefault()
    this.auth.login(this.form.value)
    .subscribe(res => {
      this.auth.saveAuthToLocal(res)
      this.router.navigate(['/home'])
    })
  }

}
