import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: [
    './register.component.scss',
    '../../app.component.scss'
  ]
})
export class RegisterComponent implements OnInit {

  form!: FormGroup

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      username: new FormControl(null, [Validators.required]),
      fullName: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required])
    })
  }

  register(){
    this.auth.register(this.form.value)
    .subscribe(res => {
      this.auth.saveAuthToLocal(res)
      this.router.navigate(['/home'])
    })
  }

}
