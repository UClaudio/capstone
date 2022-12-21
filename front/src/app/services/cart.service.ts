import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Icart } from '../interfaces/icart';
import { Cart } from '../models/cart';
import { User } from '../models/user';
import { AuthService } from './auth.service';
import { GenCrudService } from './gencrud.service';

@Injectable({
  providedIn: 'root'
})
export class CartService extends GenCrudService<Icart> {

  constructor(private httpC: HttpClient,
    private auth: AuthService) {
    super(httpC, 'http://localhost:8080/api/cart')
  }

  addProductToCart(productId: number) {
    let user = this.auth.getLogged()
    if(user instanceof Object) {
      return this.httpC.put<Icart>(this.apiUrl + "/" + user.id + "/addProduct", productId)
    }

    return null
  }

  deleteProductFromCart(productId: number) {
    return this.httpC.post<Icart>(this.apiUrl + "/" + productId + "/addProduct", productId)
  }

}
