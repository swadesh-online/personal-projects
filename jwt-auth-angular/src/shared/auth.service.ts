import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { User } from 'src/shared/user';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


    constructor(private httpClient : HttpClient, private router : Router , private cookieService : CookieService){

    }

  authUrl = 'http://localhost:9900';

  public login(user: User) : Observable<any> {

    return this.httpClient.post<any>(this.authUrl+"/authenticate", user).pipe(map(
      userData => {
       this.cookieService.set('username',user.username ,{
        path: '/',
        sameSite: 'Strict'
     });
       let tokenStr= userData.jwtToken;
       this.cookieService.set('token', tokenStr ,{
        path: '/',
        sameSite: 'Strict'
     });
       return userData;
      }
    )

   );
 };



   getAuthStatus(){
    let user =  this.cookieService.get('username')

    return !(user === null || user === '')
   }

   getMessage() : Observable<string>{

    return this.httpClient.get(this.authUrl+"/hello", {responseType : 'text'});
   }

  public logOut() {
    this.cookieService.deleteAll();
    this.router.navigateByUrl('/login');
  }


  getLoggedInUser() : Observable<any> {

    return this.httpClient.get<User>(this.authUrl.concat('/user/loggedIn'))
    }


    createUser(user : any): Observable<any>{

      return this.httpClient.post(this.authUrl+'/user/create', user);
    }
}
