import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  private apiUrl = "http://localhost:8080/api/product";

  constructor(private http:HttpClient) { }
  
  getProduct (): Observable<any> {
    return this.http.get(this.apiUrl); // return json from backend
  }
}
