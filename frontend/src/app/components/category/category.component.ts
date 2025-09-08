import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CategoryService } from '../../core/services/category.service';
import { Category } from '../../core/class/category';
import { Product } from '../../core/class/product';

@Component({
  selector: 'app-category',
  imports: [],
  templateUrl: './category.component.html',
  styleUrl: './category.component.css'
})
export class CategoryComponent implements OnInit {
  categories:Category[] = [];
  products: Product[]= [];

  // event that will send the product data
  @Output() sendProduct = new EventEmitter<Product[]>(); 

  constructor(private category:CategoryService){}

  ngOnInit(): void {
      this.category.getCategory().subscribe(
        {
          next: (data) => {
            this.categories = data;
            this.categories.forEach((e) => {
              console.log(e.nameCategory)
            })
          },
          error: (err) => {
            console.error("Error al obtener categorias", err);
          }
        }
      ) 
  }
  sendProducts(id:any):any{
    console.log(id.target.value)
    this.category.getPoductByCategoryId(id.target.value).subscribe(
    {
      next: (data) => {
        this.products = data;
        console.log(data);
        this.sendProduct.emit(data);
      },
        
      error: (err) => {
        console.log("Error :", err);
      }
    },
    );
  }

}
