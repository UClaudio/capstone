import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Order } from '../models/order';
import { GenCrudService } from './gencrud.service';

@Injectable({
  providedIn: 'root'
})
export class OrderService extends GenCrudService <Order> {

  constructor(private httpC:HttpClient) {
    super(httpC, 'http://localhost:3000/users')
  }
}
