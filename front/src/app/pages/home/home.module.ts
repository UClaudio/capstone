import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RestaurantCardComponent } from './restaurant-card/restaurant-card.component';
import { GooglePlaceModule } from "ngx-google-places-autocomplete";
import { PaymentComponentsComponent } from 'src/app/payment-components/payment-components.component';


@NgModule({
  declarations: [
    HomeComponent,
    RestaurantCardComponent,
    PaymentComponentsComponent
    
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    GooglePlaceModule
  ]
})
export class HomeModule { }
