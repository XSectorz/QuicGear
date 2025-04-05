import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private baseURL = "http://localhost:8080/api/v1/users"
  constructor(private httpClient: HttpClient) { }

  getUserList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}`);
  }


  createUser(user: User): Observable<any>{
    return this.httpClient.post(`${this.baseURL}`, user);
  }

}
