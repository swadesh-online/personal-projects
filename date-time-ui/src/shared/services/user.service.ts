import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserDTO } from '../UserDTO';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient : HttpClient) { }


  getUserObj(user : UserDTO): Observable<any>{

    return this.httpClient.post("http://localhost:8080/user/", user);
  }
}
