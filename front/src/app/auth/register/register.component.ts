import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Role } from 'src/app/models/role';
import { User } from 'src/app/models/user';
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
      fullName: new FormControl(null, [Validators.required]),
      username: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required])
    })
  }

  register(e: Event) {
    e.preventDefault()
    let user = new User(
      this.form.get('username')?.value,
      this.form.get('password')?.value,
      true,
      this.form.get('fullName')?.value,
      this.form.get('email')?.value,
      []
    )

    this.auth.register(user)
    .subscribe(res => {
      this.auth.saveAuthToLocal(res)
      this.router.navigate(['/home'])
    })
  }

}
