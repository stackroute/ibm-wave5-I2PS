import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './user-login/user-login.component';
import { InnovatorProfileComponent } from './innovator-profile-registration/innovator-profile.component';



const routes: Routes = [  
  { path: 'login', component:UserLoginComponent },
  { path: 'service-provider', component:UserLoginComponent },
  { path: 'innovator-profile', component:InnovatorProfileComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
