import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PruebaService {
  private apiUrl = 'http://localhost:8080/api/product';

  constructor(private http: HttpClient) { }
  
  getProducts(): Observable<any> {
    return this.http.get(this.apiUrl);
  }
}
