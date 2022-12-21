import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Menu } from 'src/app/models/menu';
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';
import { MenuService } from 'src/app/services/menu.service';

@Component({
  selector: 'app-restaurant-menu',
  templateUrl: './restaurant-menu.component.html',
  styleUrls: ['./restaurant-menu.component.scss']

})
export class RestaurantMenuComponent implements OnInit {

  constructor(
    private menuSvc: MenuService,
    private route: ActivatedRoute,
    private cartSvc: CartService) { }

  menu!: Menu
  products: Product[] = []
  ngOnInit(): void {
    this.route.params.subscribe((param: Params) => {
      this.menuSvc.getById(param['id'])
        .subscribe(res => this.menu = res)
    })
  }

  saveProduct(productId: number | undefined): void {
    if(productId != undefined) {
      console.log(this.cartSvc.addProductToCart(productId))
      this.cartSvc.addProductToCart(productId)?.subscribe(x => console.log(x))
    }
  }



}
