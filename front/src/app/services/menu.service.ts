import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Menu } from '../models/menu';
import { GenCrudService } from './gencrud.service';

@Injectable({
  providedIn: 'root'
})
export class MenuService extends GenCrudService<Menu>{

  constructor(private httpC:HttpClient) {
    super(httpC, 'http://localhost:8080/api/menus')
  }

  

}
