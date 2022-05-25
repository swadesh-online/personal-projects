import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { User } from 'src/shared/user';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

    constructor(private httpClient : HttpClient, private router : Router){

    }

  authUrl = 'http://localhost:9900';

  public login(user: User) : Observable<any> {

    return this.httpClient.post<any>(this.authUrl+"/authenticate", user).pipe(map(
      userData => {
       sessionStorage.setItem('username',user.username);
       let tokenStr= userData.jwtToken;
       sessionStorage.setItem('token', tokenStr);
       return userData;
      }
    )

   );
 };



   getAuthStatus(){
    let user = sessionStorage.getItem('username')

    return !(user === null)
   }

   getMessage() : Observable<string>{

    return this.httpClient.get(this.authUrl+"/hello", {responseType : 'text'});
   }

  public logOut() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');
    this.router.navigateByUrl('/login');
  }


  getLoggedInUser() : Observable<any> {

    return this.httpClient.get<User>(this.authUrl.concat('/user/loggedIn'))
    }


    createUser(user : any): Observable<any>{

      return this.httpClient.post(this.authUrl+'/user/create', user);
    }
}
