import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';

const routes: Routes = [
  { 
    path: '',
    loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule) 
  },
  {
    path: 'auth/login',
    component: LoginComponent
  },
  {
    path: 'auth/register',
    component: RegisterComponent
  },
  { 
    path: 'pages',
     loadChildren: () => import('./pages/restaurant-menu/restaurant-menu.module').then(m => m.RestaurantMenuModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
