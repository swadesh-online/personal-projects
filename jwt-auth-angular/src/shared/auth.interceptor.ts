import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private router : Router,
    private authService : AuthService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    console.log('intercepting')
    const token = sessionStorage.getItem('token');
    if (token) {
      const cloned = request.clone({
          headers: request.headers.set("Authorization",
              "Bearer " + token )
      });


      return next.handle(cloned).pipe(
        catchError((error) => {
          if(error.status == 401){
            this.authService.logOut();
            this.router.navigateByUrl('/login');
          }
          return throwError(error.message);
        })
      )
  }
  else {
      return next.handle(request);
  }
  }
}
