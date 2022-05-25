import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../shared/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  message : string | undefined;
  constructor(private authService : AuthService,
    private router : Router) { }

  ngOnInit(): void {
  this.message = '';
  }


getMessage() : void {

  this.authService.getMessage().subscribe(resp=>{
    console.log(resp);
    this.message = resp;
  });

}

  logout(){

    this.authService.logOut();
  }
}
