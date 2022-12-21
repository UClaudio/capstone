import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Restaurant } from '../models/restaurant';
import { GenCrudService } from './gencrud.service';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService extends GenCrudService<Restaurant>{

  constructor(private httpC: HttpClient) {
    super(httpC, 'http://localhost:8080/api/restaurants/getAll')
  }
}
