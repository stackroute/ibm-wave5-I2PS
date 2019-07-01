import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './user-login/user-login.component';
// import { ServiceProviderComponent } from './service-provider-registration/serice-provider.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { InnovatorProfileComponent } from './innovator-profile-registration/innovator-profile.component';
import { SignupmodalComponent } from './signupmodal/signupmodal.component';
import { SericeProviderComponent } from './service-provider-registration/serice-provider.component';
import { IntelligentServiceComponent } from './intelligent-service/intelligent-service.component';



const routes: Routes = [  
  { path: 'login', component:UserLoginComponent },
  {path: 'serviceprovider',component:SericeProviderComponent},
  { path: 'landingpage',component:LandingPageComponent},
  {path: 'innovatorprofile',component:InnovatorProfileComponent},
  {path: 'signupmodal',component:SignupmodalComponent},
  {path: 'intelligent-service',component:IntelligentServiceComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
