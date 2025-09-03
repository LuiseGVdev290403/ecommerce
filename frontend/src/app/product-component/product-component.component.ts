import { Component, OnInit } from '@angular/core';
import { PruebaService } from '../core/services/prueba.service';

@Component({
  selector: 'app-product-component',
  imports: [],
  templateUrl: './product-component.component.html',
  styleUrl: './product-component.component.css'
})
export class ProductComponentComponent implements OnInit{
  constructor(private pruebaService: PruebaService){}

  ngOnInit():void {
    this.pruebaService.getProducts().subscribe({
      next: (data) => {
        console.log('Productos visto: ', data);
      },
      error: (err) => {
        console.error('Error: ', err);
      }
    })
  }
}
