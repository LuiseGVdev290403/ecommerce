import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CategoryService {
  private apiUrl = "http://localhost:8080/api/category";

  constructor(private http:HttpClient) {}
  getCategory (): Observable<any> {
    return this.http.get(this.apiUrl); // return json from backend
  }
  
  getPoductByCategoryId(id: number): Observable<any> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get(url);
  }
}
