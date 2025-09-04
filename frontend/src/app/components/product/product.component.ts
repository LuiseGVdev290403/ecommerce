import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../../core/services/products.service';
import { Product } from '../../core/class/product';

@Component({
  selector: 'app-product',
  imports: [],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit{

  constructor(private productServices: ProductsService){}
  products:Product[] = [];
  
  ngOnInit(): void {
      this.productServices.getProduct().subscribe(
        {
          next: (data) => {
            this.products = data;
            this.products.forEach((e) => {
              console.log(e.productName)
            })
          },
          error: (err) => {
            console.error("Error al obtener productos", err);
          }
        }
      )
  }
}
