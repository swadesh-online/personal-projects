import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from '../shared/auth.guard';
import { ErrorComponent } from './error/error.component';
import { CreateUserComponent } from './create-user/create-user.component';

const routes: Routes = [
{ path : 'home',
component : HomeComponent,
canActivate: [AuthGuard]},
{ path : 'login',
component : LoginComponent},
{
  path : 'create',
  component : CreateUserComponent,
  canActivate: [AuthGuard]},
{ path : '**',
component : ErrorComponent
},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
