import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductComponentComponent } from './product-component/product-component.component'

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ProductComponentComponent],
  templateUrl: './app.component.html', 
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
