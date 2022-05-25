import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../../shared/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loggedInUser!: string;
  constructor(private authService : AuthService,
    private router : Router,
    private toasterService : ToastrService) { }

  ngOnInit(): void {

  this.loggedInUser = '';
  }


getMessage() : void {

  this.authService.getMessage().subscribe(resp=>{


    this.toasterService.success(resp);
  });

}

getUser() : void {

  this.authService.getLoggedInUser().subscribe(resp=>{

      this.loggedInUser = JSON.stringify(resp);

      console.log("logged in user", this.loggedInUser)
  })
}



  logout(){

    this.authService.logOut();
  }
}
