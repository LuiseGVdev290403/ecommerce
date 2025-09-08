import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../../core/services/products.service';
import { Product } from '../../core/class/product';
import { CategoryComponent } from "../category/category.component";

@Component({
  selector: 'app-product',
  imports: [CategoryComponent],
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
          },
          error: (err) => {
            console.error("Error al obtener productos", err);
          }
        }
      )
  }
  getProductsByIdCategory(products2:Product[]){
    console.log("Adadad", products2);
    return this.products = products2;
  }
  
}
