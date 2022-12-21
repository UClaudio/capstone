import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RestaurantMenuRoutingModule } from './restaurant-menu-routing.module';
import { RestaurantMenuComponent } from './restaurant-menu.component';
import { NgbNavModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    RestaurantMenuComponent
  ],
  imports: [
    CommonModule,
    RestaurantMenuRoutingModule,
    NgbNavModule
  ]
})
export class RestaurantMenuModule { }
