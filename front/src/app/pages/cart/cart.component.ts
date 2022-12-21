import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  constructor() { }
  public toggleCart: boolean = false

  products!: Product[]

  ngOnInit(): void {
    
  }

  cartToggler(e: Event): void {
    this.toggleCart = !this.toggleCart
  }

}
