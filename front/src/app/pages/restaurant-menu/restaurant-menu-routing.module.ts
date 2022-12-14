import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RestaurantMenuComponent } from './restaurant-menu.component';

const routes: Routes = [
  { path: 'restaurants/menu/:id', component: RestaurantMenuComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RestaurantMenuRoutingModule { }
